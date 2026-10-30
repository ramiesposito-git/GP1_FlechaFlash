package persistencia;


import modelo.Conexion;
import modelo.RutaViaje;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Time;
import java.sql.ResultSet;
import java.util.ArrayList;


public class RutaViajeData {
    private Connection connection = null;
    private ColectivoData colectivoData;
    
    public RutaViajeData(Conexion conexion){
        this.connection = conexion.initConnection();
        this.colectivoData = new ColectivoData(conexion);
    }
    
    public void guardarRutaViaje(RutaViaje r){
        String sql = "INSERT INTO ruta_viaje (origen, destino, Hora_Salida, Hora_Llegada, ID_colectivo, precio, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, r.getOrigen());
            stm.setString(2, r.getDestino());
            stm.setTime(3, Time.valueOf(r.getHoraSalida()));
            stm.setTime(4, Time.valueOf(r.getHoraLlegada()));
            stm.setInt(5, r.getColectivo().getID_colectivo());
            stm.setDouble(6, r.getPrecio());
            stm.setBoolean(7, r.isEstado());
            
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                r.setIdRuta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se guardo correctamente la ruta.");
            }
            stm.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar ruta: " + ex.getMessage());
        } 
    }
    
    public void actualizarRutaViaje(RutaViaje r){
        String sql = "UPDATE ruta_viaje SET origen=?, destino=?, Hora_Salida=?, Hora_Llegada=?, ID_colectivo=?, precio=?, estado=? WHERE ID_ruta=?";
        try{
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, r.getOrigen());
            stm.setString(2, r.getDestino());
            stm.setTime(3, Time.valueOf(r.getHoraSalida()));
            stm.setTime(4, Time.valueOf(r.getHoraLlegada()));
            stm.setInt(5, r.getColectivo().getID_colectivo());
            stm.setDouble(6, r.getPrecio());
            stm.setBoolean(7, r.isEstado());
            stm.setInt(8, r.getIdRuta());
            
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ruta actualizado con exito");
            stm.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al actualizar ruta: " + ex.getMessage());
        }
    }
    
    public RutaViaje buscarRutaViajePorId(int id){
        RutaViaje ruta = null;
        String sql = "SELECT * FROM ruta_viaje WHERE ID_ruta=?";
        try{
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                ruta = new RutaViaje();
                ruta.setIdRuta(id);
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setHoraSalida(rs.getTime("Hora_Salida").toLocalTime());
                ruta.setHoraLlegada(rs.getTime("Hora_Llegada").toLocalTime());
                ruta.setColectivo(colectivoData.buscarColectivoPorId(rs.getInt("ID_colectivo")));
                ruta.setPrecio(rs.getDouble("precio"));
                ruta.setEstado(rs.getBoolean("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe una ruta con el id: " + id);
            }
            stm.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al buscar la ruta: " + ex.getMessage());
        }
        return ruta;
    }
    
    public List<RutaViaje> listarRutaViaje(){
        List<RutaViaje> rutas = new ArrayList<>();
        String sql = "SELECT * FROM ruta_viaje";
        try{
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                RutaViaje ruta = new RutaViaje();
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setHoraSalida(rs.getTime("Hora_Salida").toLocalTime());
                ruta.setHoraLlegada(rs.getTime("Hora_Llegada").toLocalTime());
                ruta.setColectivo(colectivoData.buscarColectivoPorId(rs.getInt("ID_colectivo")));
                ruta.setPrecio(rs.getDouble("precio"));
                ruta.setEstado(rs.getBoolean("estado"));
                rutas.add(ruta);
            }
            stm.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las rutas: " + ex.getMessage());
        }
        return rutas;
    }
    
    public void bajaRutaViaje(int id){
        String sql = "UPDATE ruta_viaje SET estado=0 WHERE ID_ruta=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "se dio de baja la ruta con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna ruta para dar de baja");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja la ruta: " + ex.getMessage());
        }
    }
    
    public void altaRutaViaje(int id){
        String sql = "UPDATE ruta_viaje SET estado=1 WHERE ID_ruta=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "se dio de alta la ruta con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna ruta para dar de alta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta la ruta: " + ex.getMessage());
        }
    }
    
    public void borrarRutaViaje(int id){
        String sql = "DELETE FROM ruta_viaje WHERE ID_ruta=?";
        try{
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, id);
            int exito = stm.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ruta borrado con exito de la base de datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la ruta para eliminar");
            }
            stm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar la ruta: " + ex.getMessage());
        }
    }
}
