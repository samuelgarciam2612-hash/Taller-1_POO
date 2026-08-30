public class MaquinaNoDisponibleException extends Exception {
    // Creamos la excepcion que hereda de Exception de Java
    public MaquinaNoDisponibleException(String mensaje) {
        super(mensaje);
        // como hereda de Exception usamos super
    }
}
