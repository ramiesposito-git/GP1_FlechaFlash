package persistencia;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.*;

public class PasajeData {

    Connection connection;
    private PasajeroData pjd;
    private AsientoData ad;
    private RutaViajeData rvd;

    public PasajeData(Conexion conexion) {
        this.connection = conexion.initConnection();
        this.pjd = new PasajeroData(conexion);
        this.ad = new AsientoData(conexion);
        this.rvd = new RutaViajeData(conexion);
    }

    public boolean crearPasaje(Pasaje pasaje) {

        if (vendido(pasaje)) {
            JOptionPane.showMessageDialog(null, "Pasaje vendido! Intente con otro asiento...");
            return false;
        }

        String SQL = "INSERT INTO `pasaje`(`idPasajero`, `ID_asiento`, `ID_ruta`, `fecha_venta`, `hora_venta`, `precio`, `estado`) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
            ps.setInt(2, pasaje.getAsiento().getIdAsiento());
            ps.setInt(3, pasaje.getViaje().getIdRuta());
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setTime(5, Time.valueOf(LocalTime.now()));
            ps.setDouble(6, pasaje.getPrecio());
            ps.setBoolean(7, pasaje.getEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                pasaje.setIdPasaje(id);

                return true;
            }

            ps.close();
            rs.close();

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        return false;
    }

    public boolean actualizarPasaje(Pasaje pasajeActualizado) {
        String buscarAnterior = "SELECT ID_asiento FROM pasaje WHERE ID_pasaje=? FOR UPDATE";

        String bloquearAsientos = "SELECT ID_asiento, estado FROM asiento WHERE ID_asiento IN (?, ?) ORDER BY ID_asiento FOR UPDATE";

        String comprobarRuta = "SELECT 1 FROM asiento a INNER JOIN ruta_viaje r ON a.ID_colectivo = r.ID_colectivo WHERE a.ID_asiento=? AND r.ID_ruta=?";

        String comprobarOcupado = "SELECT 1 FROM pasaje WHERE ID_asiento=? AND estado=1 AND ID_pasaje<>? LIMIT 1";

        String actualizar = "UPDATE pasaje SET idPasajero=?, ID_asiento=?, ID_ruta=?, precio=?, estado=? WHERE ID_pasaje=?";

        String actualizarAsiento = "UPDATE asiento SET estado=? WHERE ID_asiento=?";

        try {
            //Desactiva el guardado automático para controlar la transaccion.
            connection.setAutoCommit(false);

            int idAnterior;

            //Busca y bloquea el pasaje para obtener su asiento anterior.
            try (PreparedStatement ps = connection.prepareStatement(buscarAnterior)) {
                ps.setInt(1, pasajeActualizado.getIdPasaje());

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "El pasaje no existe.");
                        //Deshace los cambios realizados si ocurre un error.
                        connection.rollback();
                        return false;
                    }
                    idAnterior = rs.getInt("ID_asiento");
                }
            }
            int idNuevo = pasajeActualizado.getAsiento().getIdAsiento();
            int idRuta = pasajeActualizado.getViaje().getIdRuta();
            boolean nuevoActivo = false;
            int encontrados = 0;

            //Bloquea los asientos involucrados para evitar modificaciones simultaneas.
            try (PreparedStatement ps = connection.prepareStatement(bloquearAsientos)) {
                ps.setInt(1, idAnterior);
                ps.setInt(2, idNuevo);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        encontrados++;
                        if (rs.getInt("ID_asiento") == idNuevo) {
                            nuevoActivo = rs.getBoolean("estado");
                        }
                    }
                }
            }
            int esperados = 2;

            if (idAnterior == idNuevo) {
                esperados = 1;
            }
            if (encontrados != esperados) {
                JOptionPane.showMessageDialog(null, "No se encontraron los asientos.");
                connection.rollback();
                return false;
            }

            //Verifica que el asiento nuevo pertenece al colectivo de la ruta.
            try (PreparedStatement ps = connection.prepareStatement(comprobarRuta)) {
                ps.setInt(1, idNuevo);
                ps.setInt(2, idRuta);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "El asiento no pertenece al colectivo de la ruta.");
                        connection.rollback();
                        return false;
                    }
                }
            }

            if (idAnterior != idNuevo && !nuevoActivo) {
                JOptionPane.showMessageDialog(null, "El asiento seleccionado no está disponible.");
                connection.rollback();
                return false;
            }

            //Comprueba que otro pasaje activo no ocupe el asiento en esa ruta.
            try (PreparedStatement ps = connection.prepareStatement(comprobarOcupado)) {
                ps.setInt(1, idNuevo);
                ps.setInt(2, pasajeActualizado.getIdPasaje());

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next() && pasajeActualizado.getEstado()) {
                        JOptionPane.showMessageDialog(null, "El asiento ya está ocupado por otro pasaje.");
                        connection.rollback();
                        return false;
                    }
                }
            }

            //Guarda los  nuevos datos del pasaje en la base de datos.
            try (PreparedStatement ps = connection.prepareStatement(actualizar)) {
                ps.setInt(1, pasajeActualizado.getPasajero().getIdPasajero());
                ps.setInt(2, idNuevo);
                ps.setInt(3, idRuta);
                ps.setDouble(4, pasajeActualizado.getPrecio());
                ps.setBoolean(5, pasajeActualizado.getEstado());
                ps.setInt(6, pasajeActualizado.getIdPasaje());

                int filas = ps.executeUpdate();

                if (filas == 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el pasaje.");
                    connection.rollback();
                    return false;
                }
            }

            //Liberar el asiento anterior si ya no tiene pasajes activos
            if (idAnterior != idNuevo) {
                boolean anteriorOcupado;

                //Comprueba si el asiento anterior sigue asociado a otro pasaje activo.
                try (PreparedStatement ps = connection.prepareStatement(comprobarOcupado)) {
                    ps.setInt(1, idAnterior);
                    ps.setInt(2, pasajeActualizado.getIdPasaje());

                    try (ResultSet rs = ps.executeQuery()) {
                        anteriorOcupado = rs.next();
                    }
                }

                //Actualiza el estado del asiento anterior despues del cambio.
                try (PreparedStatement ps = connection.prepareStatement(actualizarAsiento)) {
                    ps.setBoolean(1, !anteriorOcupado);
                    ps.setInt(2, idAnterior);
                    ps.executeUpdate();
                }
            }

            //Actualizar el estado del asiento seleccionado
            try (PreparedStatement ps = connection.prepareStatement(actualizarAsiento)) {
                ps.setBoolean(1, !pasajeActualizado.getEstado());
                ps.setInt(2, idNuevo);
                ps.executeUpdate();
            }

            //Confirma todos los cambios realizados en la base de datos.
            connection.commit();
            JOptionPane.showMessageDialog(null, "Pasaje actualizado con éxito!");
            return true;

        } catch (SQLException ex) {
            //Deshace la transaccion si ocurre un error en la base de datos.
            try {
                connection.rollback();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al revertir cambios: " + e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el pasaje: " + ex.getMessage());
            return false;

        } finally {
            //Restaura el guardado automatico de la conexion.
            try {

                //Vuelve a activar el guardado automatico de la conexion.
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al restaurar la conexión: " + ex.getMessage());
            }
        }
    }

    public boolean vendido(Pasaje pasaje) {

        String SQL = "SELECT * FROM `pasaje` WHERE pasaje.ID_asiento = ? AND pasaje.ID_ruta = ?";
        boolean vendido = false;

        try {
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, pasaje.getAsiento().getIdAsiento());
            ps.setInt(2, pasaje.getViaje().getIdRuta());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                vendido = true;
            }

        } catch (SQLException ex) {
            System.getLogger(PasajeData.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return vendido;

    }

    public Pasaje buscarPasajePorId(int id) {

        Pasaje pasaje = null;
        String sql = "SELECT * FROM pasaje WHERE ID_pasaje = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                pasaje = new Pasaje();
                pasaje.setIdPasaje(id);
                pasaje.setPasajero(pjd.buscarPasajeroPorId(rs.getInt("idPasajero")));
                pasaje.setAsiento(ad.buscarAsiento(rs.getInt("ID_asiento")));
                pasaje.setViaje(rvd.buscarRutaViajePorId(rs.getInt("ID_ruta")));
                pasaje.setFechaVenta(rs.getDate("fecha_venta").toLocalDate());
                pasaje.setHoraVenta(rs.getTime("hora_venta").toLocalTime());
                pasaje.setPrecio(rs.getDouble("precio"));
                pasaje.setEstado(rs.getBoolean("estado"));
            } else {
                return null;
            }

            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar Pasaje: " + ex.getMessage());
        }

        return pasaje;
    }

    public ArrayList<Pasaje> listarPasaje() {
        ArrayList<Pasaje> pasajes = new ArrayList<>();
        String sql = "SELECT * FROM pasaje";
        try {
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setIdPasaje(rs.getInt("ID_pasaje"));
                pasaje.setPasajero(pjd.buscarPasajeroPorId(rs.getInt("idPasajero")));
                pasaje.setAsiento(ad.buscarAsiento(rs.getInt("ID_asiento")));
                pasaje.setViaje(rvd.buscarRutaViajePorId(rs.getInt("ID_ruta")));
                pasaje.setFechaVenta(rs.getDate("fecha_venta").toLocalDate());
                pasaje.setHoraVenta(rs.getTime("hora_venta").toLocalTime());
                pasaje.setPrecio(rs.getDouble("precio"));
                pasaje.setEstado(rs.getBoolean("estado"));
                pasajes.add(pasaje);
            }
            stm.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los pasajes: " + ex.getMessage());
        }
        return pasajes;
    }

    public boolean borrarPasaje(Pasaje pasaje) {

        ad.altaAsiento(pasaje.getAsiento().getIdAsiento()); //primero le damos de alta al pasaje (vuelve a estar libre)

        String sql = "DELETE FROM pasaje WHERE ID_pasaje=?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, pasaje.getIdPasaje());

            int a = stm.executeUpdate();

            if (a != 0) {
                return true;
            }

            stm.close();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            return false;
        } catch (SQLException ex) {
            System.out.println("Error al borrar Pasaje: " + ex.getMessage());
            return false;
        }

        return false;
    }

    public void bajaLogicaPasaje(int id) {
        String sql = "UPDATE pasaje SET estado=0 WHERE ID_pasaje=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "se dio de baja el pasaje con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ningun pasaje para dar de baja");
            }
            stm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el pasaje: " + ex.getMessage());
        }
    }

    public void altaLogicaPasaje(int id) {
        String sql = "UPDATE pasaje SET estado=1 WHERE ID_pasaje=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "se dio de alta el pasaje con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ningun pasaje para dar de alta");
            }
            stm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta el pasaje: " + ex.getMessage());
        }
    }
}
