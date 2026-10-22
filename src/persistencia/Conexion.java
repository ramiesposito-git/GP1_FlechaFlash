/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ramir
 */
public class Conexion {
    private String URL;
    private String user;
    private String password;
    private static Connection connection = null;

    public Conexion(String URL, String user, String password) {
        this.URL = URL;
        this.user = user;
        this.password = password;
    }
    
    public Connection initConnection() {
        if (connection == null) {

            try {
                
                Class.forName("com.mysql.jdbc.Driver");
                
                connection = DriverManager.getConnection(URL, user, password); 

            } catch (SQLException ex) { 
                JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion " + ex); 
                
            } catch (ClassNotFoundException ex) { 
                JOptionPane.showMessageDialog(null, "No se pudo cargar el Driver de conexion");
            }       
        }
        return connection;
    }
}
