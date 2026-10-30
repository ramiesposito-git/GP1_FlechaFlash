package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pasaje {
    
    private int idPasaje;
    private Pasaje pasajero;
    private Asiento asiento;
    private RutaViaje viaje;
    private LocalDate fechaVenta;
    private LocalTime HoraVenta;
    private double precio;
    private boolean estado;

    public Pasaje() {
    }

    public Pasaje(int idPasaje, Pasaje pasajero, Asiento asiento, RutaViaje viaje, LocalDate fechaVenta, LocalTime HoraVenta, double precio, boolean estado) {
        this.idPasaje = idPasaje;
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.viaje = viaje;
        this.fechaVenta = fechaVenta;
        this.HoraVenta = HoraVenta;
        this.precio = precio;
        this.estado = estado;
    }

    public Pasaje(Pasaje pasajero, Asiento asiento, RutaViaje viaje, LocalDate fechaVenta, LocalTime HoraVenta, double precio, boolean estado) {
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.viaje = viaje;
        this.fechaVenta = fechaVenta;
        this.HoraVenta = HoraVenta;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public Pasaje getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasaje pasajero) {
        this.pasajero = pasajero;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public RutaViaje getViaje() {
        return viaje;
    }

    public void setViaje(RutaViaje viaje) {
        this.viaje = viaje;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public LocalTime getHoraVenta() {
        return HoraVenta;
    }

    public void setHoraVenta(LocalTime HoraVenta) {
        this.HoraVenta = HoraVenta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    


    
}
