package vistas;

import modelo.Conexion;
import persistencia.AsientoData;
import modelo.Asiento;
import modelo.Colectivo;
import java.util.ArrayList;

public class test2 {

    public static void main(String[] args) {

        Colectivo colectivo = new Colectivo(1, "AA 123 SL", "Mercedes Benz", "M-500", 35, "Juan Lopez", true);
        Asiento a = new Asiento(colectivo, 26, true);

        AsientoData ad = new AsientoData(new Conexion("jdbc:mysql://localhost:3306/flechaflashdb", "root", ""));
        
        
        //guardar nuevo asiento (id generado por la BD)
        //ad.guardarAsiento(a);

        //buscar asiento por ID
        Asiento asiento = ad.buscarAsiento(5);
        System.out.println(asiento.toString() + asiento.getColectivo().getMarca() + "FUNCA!");

        //baja
        //ad.altaAsiento(2);

        //alta
        //ad.bajaAsiento(5);

        //listar asientos
        ArrayList<Asiento> asientos = ad.listarAsientos();
        
        for (Asiento asiento1 : asientos) {
            System.out.println(asiento1.getNumeroAsiento()+" "+asiento1.getIdAsiento());
        }
        System.out.println();
        
    }

}
