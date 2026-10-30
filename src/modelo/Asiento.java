package modelo;

public class Asiento {

    private int IdAsiento;
    private Colectivo colectivo;
    private int numeroAsiento;
    private boolean estado;

    public Asiento() {
    }

    public Asiento(int IdAsiento, Colectivo colectivo, int numeroAsiento, boolean estado) {
        this.IdAsiento = IdAsiento;
        this.colectivo = colectivo;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
    }

    public Asiento(Colectivo colectivo, int numeroAsiento, boolean estado) {
        this.colectivo = colectivo;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
    }
    
    

    public int getIdAsiento() {
        return IdAsiento;
    }

    public void setIdAsiento(int IdAsiento) {
        this.IdAsiento = IdAsiento;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "IdAsiento=" + IdAsiento + ", colectivo=" + colectivo + ", numeroAsiento=" + numeroAsiento + '}';
    }

    
    
}
