package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pasaje {
    
    private int idPasaje;
    private Pasajero pasajero;
    private Asiento asiento;
    private RutaViaje viaje;
    private LocalDate fechaVenta;
    private LocalTime horaVenta;
    private double precio;
    private boolean estado;

    public Pasaje() {
    }

    public Pasaje(int idPasaje, Pasajero pasajero, Asiento asiento, RutaViaje viaje, LocalDate fechaVenta, LocalTime horaVenta, double precio, boolean estado) {
        this.idPasaje = idPasaje;
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.viaje = viaje;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.precio = precio;
        this.estado = estado;
    }

    public Pasaje(Pasajero pasajero, Asiento asiento, RutaViaje viaje, LocalDate fechaVenta, LocalTime horaVenta, double precio, boolean estado) {
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.viaje = viaje;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.precio = precio;
        this.estado = estado;
    }

    
    
    
    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
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
        return horaVenta;
    }

    public void setHoraVenta(LocalTime horaVenta) {
        this.horaVenta = horaVenta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}
