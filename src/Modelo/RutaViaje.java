package Modelo;

import java.time.LocalTime;


public class RutaViaje {
    private int idRuta;
    private String origen;
    private String destino;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private Colectivo colectivo;
    private double precio;
    private boolean estado;

    public RutaViaje() {
    }

    public RutaViaje(String origen, String destino, LocalTime horaSalida, LocalTime horaLlegada, Colectivo colectivo, double precio, boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.colectivo = colectivo;
        this.precio = precio;
        this.estado = estado;
    }

    public RutaViaje(int idRuta, String origen, String destino, LocalTime horaSalida, LocalTime horaLlegada, Colectivo colectivo, double precio, boolean estado) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.colectivo = colectivo;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
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
    
    @Override
    public String toString() {
        return "Ruta{" + "ID_ruta=" + idRuta + ", origen=" + origen + ", destino=" + destino + ", Hora_Salida="+ horaSalida + ", Hora_Llegada=" + ", Precio="+ precio + ", Estado=" + estado + colectivo + '}';
    }
}
