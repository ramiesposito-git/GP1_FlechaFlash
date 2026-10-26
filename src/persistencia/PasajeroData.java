package persistencia;

import Modelo.Conexion;
import Modelo.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class PasajeroData {

    private Connection connection = null;

    public PasajeroData(Conexion conexion) {
        this.connection = conexion.initConnection();
    }

    public void guardarPasajero(Pasajero pasajero) {
        String sql = "INSERT INTO Pasajero (dni, nombre, apellido, correo, telefono, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, pasajero.getDni());
            stm.setString(2, pasajero.getNombre());
            stm.setString(3, pasajero.getApellido());
            stm.setString(4, pasajero.getCorreo());
            stm.setString(5, pasajero.getTelefono());
            stm.setBoolean(6, pasajero.isEstado());

            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                pasajero.setIdPasajero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pasajero guardado exitosamente.");
            }
            stm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros: " + ex.getMessage());
        }
    }

    public Pasajero buscarPasajeroPorId(int id) {
        String sql = "SELECT dni, nombre, apellido, correo, telefono, estado FROM Pasajero WHERE idPasajero = ?";
        Pasajero pasajero = null;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setIdPasajero(id);
                pasajero.setDni(rs.getString("dni"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajero.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el pasajero con ID: " + id);
            }
            stm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar pasajero: " + ex.getMessage());
        }
        return pasajero;
    }
}
