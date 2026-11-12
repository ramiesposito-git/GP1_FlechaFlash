package persistencia;

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

    public void crearPasaje(Pasaje pasaje) {

        if (vendido(pasaje)) {
            JOptionPane.showMessageDialog(null, "Pasaje vendido! Intente con otro asiento...");
        }

        String SQL = "INSERT INTO `pasaje`(`idPasajero`, `ID_asiento`, `ID_ruta`, `fecha_venta`, `hora_venta`, `precio`, `estado`) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
            ps.setInt(2, pasaje.getAsiento().getIdAsiento());
            ps.setInt(3, pasaje.getViaje().getIdRuta());

            ps.setDate(4, Date.valueOf(pasaje.getFechaVenta()));
            ps.setTime(5, Time.valueOf(pasaje.getHoraVenta()));
            ps.setDouble(6, pasaje.getPrecio());
            ps.setBoolean(7, pasaje.getEstado());

            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                JOptionPane.showMessageDialog(null, "Pasaje creado! Id: " + id);
            }

            ps.close();
            rs.close();

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }

    }

    public void actualizarPasaje(Pasaje pasajeActualizado) {

        String SQL = "UPDATE `pasaje` SET `idPasajero`= ? ,`ID_asiento`= ? ,`ID_ruta`= ?, `fecha_venta`=? ,`hora_venta`=?, `precio`=?, `estado`=? WHERE ID_pasaje = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setInt(1, pasajeActualizado.getPasajero().getIdPasajero());
            ps.setInt(2, pasajeActualizado.getAsiento().getIdAsiento());
            ps.setInt(3, pasajeActualizado.getViaje().getIdRuta());
            ps.setDate(4, Date.valueOf(pasajeActualizado.getFechaVenta()));
            ps.setTime(5, Time.valueOf(pasajeActualizado.getHoraVenta()));
            ps.setDouble(6, pasajeActualizado.getPrecio());
            ps.setBoolean(7, pasajeActualizado.getEstado());

            ps.setInt(8, pasajeActualizado.getIdPasaje());

            int n = ps.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Pasaje actualizado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el pasaje!\nrevise los datos ingresados");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
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
        try{
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
            }else{
                JOptionPane.showMessageDialog(null, "No existe una pasaje con el id: " + id);
            }
            stm.close();
            rs.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al buscar el pasaje: " + ex.getMessage());
        }
        
        return pasaje;
    }
    
    public ArrayList<Pasaje> listarPasaje() {
        ArrayList<Pasaje> pasajes = new ArrayList<>();
        String sql = "SELECT * FROM pasaje";
        try{
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
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
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los pasajes: " + ex.getMessage());
        }
        return pasajes;
    }
    
    public void borrarPasaje(int id) {
        String sql = "DELETE FROM pasaje WHERE ID_pasaje=?";
        try{
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, id);
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pasaje borrado con exito de la base de datos");
            }else {
                JOptionPane.showMessageDialog(null, "No se encontro el pasaje para eliminar");
            }
            stm.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar el pasaje: " + ex.getMessage());
        }
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
