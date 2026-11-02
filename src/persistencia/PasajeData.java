package persistencia;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import modelo.*;

public class PasajeData {

    Connection connection;

    public PasajeData(Conexion conexion) {
        this.connection = conexion.initConnection();
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

            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setTime(5, Time.valueOf(LocalTime.now()));
            ps.setDouble(6, pasaje.getPrecio());
            ps.setBoolean(7, pasaje.getEstado());

            ResultSet rs = ps.executeQuery();

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

}
