public abstract class Membresia {
    protected double costoBase;
    protected EstadoMembresia estado;
    private String idMembresia;

    public Membresia(String idMembresia, double costoBase, EstadoMembresia estado){
        this.idMembresia = idMembresia;
        this.costoBase = costoBase;
        this.estado = estado;
    }

    public abstract double calcularCostoClase(double costoClaseBase);

    public boolean estaActiva (){
        return estado == EstadoMembresia.ACTIVA;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public EstadoMembresia getEstado() {
        return estado;
    }

    public String getIdMembresia() {
        return idMembresia;
    }

    public void setEstado(EstadoMembresia estado) {
        this.estado = estado;
    }
}
