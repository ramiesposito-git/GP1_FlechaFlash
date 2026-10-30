package persistencia;

import modelo.Colectivo;
import modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ColectivoData {

    private Connection connection = null;

    public ColectivoData(Conexion conexion) {
        this.connection = conexion.initConnection();
    }

    public void guardarColectivo(Colectivo colectivo) {
        String sql = "INSERT INTO Colectivo (matricula,marca,modelo,capacidad,chofer,estado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, colectivo.getMatricula());
            stm.setString(2, colectivo.getMarca());
            stm.setString(3, colectivo.getModelo());
            stm.setInt(4, colectivo.getCapacidad());
            stm.setString(5, colectivo.getChofer());
            stm.setBoolean(6, colectivo.isEstado());

            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                colectivo.setID_colectivo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Colectivo guardado exitosamente.");
            }
            stm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla colectivo: " + ex.getMessage());
        }
    }

    public Colectivo buscarColectivoPorId(int id) {
        Colectivo colectivo = null;
        String sql = "SELECT `ID_colectivo`, `matricula`, `marca`, `modelo`, `capacidad`, `chofer`, `estado` FROM `colectivos`  WHERE ID_colectivo = ? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                colectivo = new Colectivo();
                colectivo.setID_colectivo(rs.getInt("ID_colectivo"));
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
                colectivo.setChofer(rs.getString("chofer"));
                colectivo.setEstado(rs.getBoolean("estado"));
            } 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR POR ID: " + ex.getMessage());
        }
        return colectivo;
    }

    public void actualizarColectivo(Colectivo colectivo) {
        String sql = "UPDATE Colectivo SET matricula=?,marca=?,modelo=?,capacidad=?,chofer=?,estado=? WHERE id_colectivo=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, colectivo.getMatricula());
            stm.setString(2, colectivo.getMarca());
            stm.setString(3, colectivo.getModelo());
            stm.setInt(4, colectivo.getCapacidad());
            stm.setString(5, colectivo.getChofer());
            stm.setBoolean(6, colectivo.isEstado());
            stm.setInt(7, colectivo.getID_colectivo());
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Colectivo actualizado con exito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar colectivo" + ex.getMessage());
        }
    }

    public void altaColectivo(int id) {
        String sql = "UPDATE Colectivo SET estado=1 WHERE id_colectivo=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alta de colectivo con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ningun colectivo para dar de alta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta el colectivo" + ex.getMessage());
        }
    }

    public void bajaColectivo(int id) {
        String sql = "UPDATE Colectivo SET estado=0 WHERE id_colectivo=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Baja de colectivo con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ningun colectivo para dar de baja");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el colectivo" + ex.getMessage());
        }
    }

    public void borrarColectivo(int id) {
        String sql = "DELETE FROM Colectivo WHERE id_colectivo=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, " Colectivo borrado con exito de la base de datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro colectivo para eliminar");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar el colectivo" + ex.getMessage());
        }
    }

    public List<Colectivo> listarColectivo() {
        List<Colectivo> colectivos = new ArrayList<>();
        String sql = "SELECT id_colectivo,matricula,marca,modelo,capacidad,chofer,estado FROM colectivo";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Colectivo colectivo = new Colectivo();
                colectivo.setID_colectivo(rs.getInt("id_colectivo"));
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
                colectivo.setChofer(rs.getString("chofer"));
                colectivo.setEstado(rs.getBoolean("estado"));
                colectivos.add(colectivo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar colectivos" + ex.getMessage());
        }
        return colectivos;
    }
}
