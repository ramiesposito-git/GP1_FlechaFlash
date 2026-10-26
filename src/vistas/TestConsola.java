package vistas;

import Modelo.Conexion;
import Modelo.Pasajero;
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
            
            pasajeroData.buscarPasajeroPorId(1);
            pasajeroData.buscarPasajeroPorId(2);
            pasajeroData.buscarPasajeroPorId(3);
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
