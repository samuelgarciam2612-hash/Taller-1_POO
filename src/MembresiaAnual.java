public class MembresiaAnual extends Membresia{

    public MembresiaAnual(String idMembresia, double costoBase, EstadoMembresia estado){
        super(idMembresia, costoBase, estado);
    }
    @Override
    public double calcularCostoClase(double costoClaseBase) {
        return 0.0;
    }
}
