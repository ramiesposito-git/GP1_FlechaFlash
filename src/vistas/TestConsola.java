package vistas;

import modelo.Conexion;
import modelo.Pasajero;
import persistencia.PasajeroData;


public class TestConsola {
    
    public static void main(String[] args) {
        try{
            Conexion conexion = new Conexion("jdbc:mysql://localhost:3306/flechaflashdb", "root", "");
            PasajeroData pasajeroData = new PasajeroData(conexion);

            Pasajero p1 = new Pasajero("25554533", "Enzo", "Fernandez", "enzfer@gmail.com", "2664000001", true);
            Pasajero p2 = new Pasajero("26454656", "Franco", "Colapinto", "franco@gmail.com", "2664000002", false);
            Pasajero p3 = new Pasajero("10056544", "Leonel", "Messi", "messileo@gmail.com", "2664000003", true);

            pasajeroData.guardarPasajero(p1);
            pasajeroData.guardarPasajero(p2);
            pasajeroData.guardarPasajero(p3);
            
            Pasajero pa1 = pasajeroData.buscarPasajeroPorId(1);
            if (pa1 != null) {
                System.out.println(pa1);
            }
            Pasajero pa2 = pasajeroData.buscarPasajeroPorId(2);
            if (pa2 != null) {
                System.out.println(pa2);
            }
            Pasajero pa3 = pasajeroData.buscarPasajeroPorId(3);
            if (pa3 != null) {
                System.out.println(pa3);
            }
            
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
