public class MembresiaMensual extends Membresia{

    public MembresiaMensual(String idMembresia, double costoBase, EstadoMembresia estado){
        super(idMembresia, costoBase, estado);
    }

    @Override
    public double calcularCostoClase(double costoClaseBase) {
        return costoClaseBase;
    }
}
