public interface Reservable {
    void reservar(Miembro miembro) throws CupoAgotadoException, MembresiaVencidaException;
    boolean cancelarReserva(Miembro miembro);
}
