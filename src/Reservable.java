public interface Reservable {
    void reservar(Miembro miembro) throws CupoAgotadoException, MembresiaVencidaException, MembresiaVencidaException;
    boolean cancelarReserva(Miembro miembro);
}
