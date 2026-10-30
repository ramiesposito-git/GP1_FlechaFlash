package persistencia;

import modelo.Asiento;
import modelo.Colectivo;
import modelo.Conexion;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AsientoData {

    private Connection connexion;
    private ColectivoData cd;

    public AsientoData(Conexion conexion) {
        connexion = conexion.initConnection();
        cd = new ColectivoData(conexion);
    }

    public void guardarAsiento(Asiento asiento) {

        String SQL = "INSERT INTO `asiento` (`ID_colectivo`, `numero_asiento`, `estado`) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = connexion.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, asiento.getColectivo().getID_colectivo());
            ps.setInt(2, asiento.getNumeroAsiento());
            ps.setBoolean(3, asiento.getEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
                JOptionPane.showMessageDialog(null, "Asiento guardado! ID asignado: " + id);
                asiento.setIdAsiento(id);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar asiento: " + ex.getMessage());
        }

    }

    public Asiento buscarAsiento(int idAsiento) {

        String SQL = "SELECT * FROM asiento WHERE ID_asiento = ?";
        Asiento asiento = null;

        try {
            PreparedStatement stm = connexion.prepareStatement(SQL);
            stm.setInt(1, idAsiento);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("ID_asiento");
                int idColectivo = rs.getInt("ID_colectivo");
                int nroAsiento = rs.getInt("numero_asiento");
                boolean estado = rs.getBoolean("estado");

                Colectivo colectivo = cd.buscarColectivoPorId(idColectivo);

                asiento = new Asiento(id, colectivo, nroAsiento, estado);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro el asiento con el ID indicado!" + ex.getMessage());
            return null;
        }

        return asiento;

    }

    public void altaAsiento(int idAsiento) {
        String SQL = "UPDATE asiento SET estado=1 WHERE ID_asiento = ?";

        try {
            PreparedStatement ps = connexion.prepareStatement(SQL);
            ps.setInt(1, idAsiento);

            int n = ps.executeUpdate();

            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Asiento dado de alta correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de alta el asiento, corrobore ID");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void bajaAsiento(int idAsiento) {
        String SQL = "UPDATE asiento SET estado=0 WHERE ID_asiento = ?";

        try {
            PreparedStatement ps = connexion.prepareStatement(SQL);
            ps.setInt(1, idAsiento);

            int n = ps.executeUpdate();

            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Asiento dado de baja correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de baja el asiento, corrobore ID");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ArrayList<Asiento> listarAsientos() {

        String SQL = "SELECT * FROM asiento";
        
        ArrayList<Asiento> asientos = new ArrayList<>();

        try {
            PreparedStatement ps = connexion.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("ID_asiento");
                int idColectivo = rs.getInt("ID_colectivo");
                int nro = rs.getInt("numero_asiento");
                boolean estado = rs.getBoolean("estado");
                
                Colectivo colectivo = cd.buscarColectivoPorId(idColectivo);
                asientos.add(new Asiento(id,colectivo,nro,estado));
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return asientos;
        
    }

}
