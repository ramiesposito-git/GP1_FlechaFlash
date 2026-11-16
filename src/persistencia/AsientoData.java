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

    public void crearAsiento(Asiento asiento) {

        if (!capacidadValida(asiento)) {
            return;
        }
        
        if (asientoExistente(asiento.getColectivo().getID_colectivo(), asiento.getNumeroAsiento())) {
            JOptionPane.showMessageDialog(null, "Ya existe el asiento " + asiento.getNumeroAsiento() + " en el colectivo ID " + asiento.getColectivo().getID_colectivo() + "\nintente con otro!");
            return;
        }

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
            System.out.println("Error al buscar asiento: " + ex.getMessage());
            return null;
        }

        return asiento;

    }

    public boolean actualizarAsiento(Asiento asiento) {
        if (!capacidadValida(asiento)) {
            return false;
        }

        if (asientoExistenteEditar(asiento)) {
            JOptionPane.showMessageDialog(null, "Ya existe el asiento " + asiento.getNumeroAsiento() + " en este colectivo!");
            return false;
        }
        
        String SQL = "UPDATE `asiento` SET `ID_colectivo`= ?,`numero_asiento`= ?,`estado`=? WHERE ID_asiento = ?";

        try {
            PreparedStatement stm = connexion.prepareStatement(SQL);
            stm.setInt(1, asiento.getColectivo().getID_colectivo());
            stm.setInt(2, asiento.getNumeroAsiento());
            stm.setBoolean(3, asiento.getEstado());
            stm.setInt(4, asiento.getIdAsiento());

            int a = stm.executeUpdate();

            if (a != 0) {
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar asiento: " + ex.getMessage());
        }
        return false;
    }

    public void altaAsiento(int idAsiento) {
        String SQL = "UPDATE asiento SET estado=1 WHERE ID_asiento = ?";

        try {
            PreparedStatement ps = connexion.prepareStatement(SQL);
            ps.setInt(1, idAsiento);

            int n = ps.executeUpdate();

            if (n == 1) {
                System.out.println("alta correcta de asiento");
            } else {
                System.out.println("no se le dio de alta al asiento, revisar el metodo 'AltaAsiento' de AsientoData");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void bajaAsiento(int idAsiento) {
        String SQL = "UPDATE `asiento` SET `estado`= 0 WHERE asiento.ID_asiento = ?";

        try {
            PreparedStatement ps = connexion.prepareStatement(SQL);
            ps.setInt(1, idAsiento);

            int n = ps.executeUpdate();

            if (n == 1) {
                System.out.println("asiento dado de baja");
            } else {
                System.out.println("no se dio de baja al asiento, revisar 'bajaAsiento' en 'AsientoData'");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public boolean eliminarAsiento(int idAsiento) {
        
        String SQL = "DELETE FROM `asiento` WHERE ID_asiento = ?";
        
        try {
            PreparedStatement psm = connexion.prepareStatement(SQL);
            psm.setInt(1, idAsiento);
            
            int a = psm.executeUpdate();
            
            if (a>0) {
                return true;
            }
            
        } catch (SQLException ex) {
            System.getLogger(AsientoData.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return false;
    }

    public ArrayList<Asiento> listarAsientos() {

        String SQL = "SELECT * FROM asiento";

        ArrayList<Asiento> asientos = new ArrayList<>();

        try {
            PreparedStatement ps = connexion.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("ID_asiento");
                int idColectivo = rs.getInt("ID_colectivo");
                int nro = rs.getInt("numero_asiento");
                boolean estado = rs.getBoolean("estado");

                Colectivo colectivo = cd.buscarColectivoPorId(idColectivo);
                asientos.add(new Asiento(id, colectivo, nro, estado));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return asientos;

    }

    
    public boolean asientoExistente (int idColectivo, int numeroAsiento) {

        String SQL = "SELECT * FROM `asiento` WHERE ID_colectivo = ? AND numero_asiento = ?";

        try {
            PreparedStatement ps = connexion.prepareStatement(SQL);
            ps.setInt(1, idColectivo);
            ps.setInt(2, numeroAsiento);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return false;
    }
    
    

    public ArrayList<Asiento> buscarAsientoPorColectivo(Colectivo colectivo) {

        String SQL = "SELECT * FROM asiento WHERE ID_colectivo = ?";
        ArrayList<Asiento> asientos = new ArrayList<>();

        try {
            PreparedStatement stm = connexion.prepareStatement(SQL);
            stm.setInt(1, colectivo.getID_colectivo());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("ID_asiento");
                int nroAsiento = rs.getInt("numero_asiento");
                boolean estado = rs.getBoolean("estado");

                Asiento asiento = new Asiento(id, colectivo, nroAsiento, estado);
                asientos.add(asiento);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }

        return asientos;
    }
    
    public boolean capacidadValida(Asiento asiento) {
        if (asiento == null || asiento.getColectivo() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un colectivo válido!");
            return false;
        }

        String sql = "SELECT capacidad FROM colectivos WHERE ID_colectivo = ?";

        try (PreparedStatement ps = connexion.prepareStatement(sql)) {
            
            ps.setInt(1, asiento.getColectivo().getID_colectivo());

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "El colectivo no existe!");
                    return false;
                }   

                int capacidad = rs.getInt("capacidad");
                int numero = asiento.getNumeroAsiento();

                if (numero <= 0 || numero > capacidad) {
                    JOptionPane.showMessageDialog(null, "El número de asiento debe estar entre 1 y " + capacidad);
                    return false;
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al validar la capacidad: " + ex.getMessage());
            return false;
        }

        return true;
    }
    
    public boolean asientoExistenteEditar(Asiento asiento) {
        String sql = "SELECT 1 FROM asiento WHERE ID_colectivo = ? AND numero_asiento = ? AND ID_asiento <> ?";

        try (PreparedStatement ps = connexion.prepareStatement(sql)) {

            ps.setInt(1, asiento.getColectivo().getID_colectivo());
            ps.setInt(2, asiento.getNumeroAsiento());
            ps.setInt(3, asiento.getIdAsiento());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al comprobar el asiento: " + ex.getMessage());
            return true;
        }
    }
}
