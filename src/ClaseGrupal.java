public class ClaseGrupal implements Reservable {
    private String idClase;
    private String nombre;
    private Entrenador entrenador;
    private int cupoMaximo;
    private Miembro[] inscritos;
    private int contadorInscritos;

    public ClaseGrupal(String idClase, String nombre, Entrenador entrenador, int cupoMaximo) {
        this.idClase = idClase;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.cupoMaximo = cupoMaximo;
        this.inscritos = new Miembro[cupoMaximo];
        this.contadorInscritos = 0;
    }
    public int getContadorInscritos() {
        return contadorInscritos;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void reservar(Miembro miembro) throws CupoAgotadoException, MembresiaVencidaException {
        if (!miembro.MembresiaValida()) { //para el booleano
            throw new MembresiaVencidaException("Tienes la membresia vencida, " + miembro.getNombre());
        }

        if (contadorInscritos >= cupoMaximo) {
            throw new CupoAgotadoException("Lo siento, cupo agotado en la clase:" + nombre);
        }

        inscritos[contadorInscritos] = miembro;
        contadorInscritos++; //añadiendo al arreglo
    }

    public boolean cancelarReserva(String idMiembro) {
        for (int i = 0; i < contadorInscritos; i++) { //for normal para recorrer el array
            if (inscritos[i] != null && inscritos[i].getIdMiembro().equals(idMiembro)) //buscar miembro y compararlo con .equals()
            {
                for (int j = i; j < contadorInscritos - 1; j++) {
                    inscritos[j] = inscritos[j + 1];
                }
                inscritos[contadorInscritos - 1] = null;
                contadorInscritos--;
                return true;
            } //proceso para reorganizar el array cuando borramos a alguien
        }
        return false;
    }

    public boolean cancelarReserva(Miembro miembro) { //aca ocurre la sobrecarga de metodos
        if (miembro == null) {
            return false; //si es null el miembro no lo permite
        }
        return cancelarReserva(miembro.getIdMiembro()); //nos evita escribir todo lo de arriba de nuevo, lo ejecuta de nuevo automaticamente con IdMiembro
    }

}