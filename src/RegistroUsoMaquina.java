public final class RegistroUsoMaquina {
    //Necesitamos que sea final para que no se pueda editar el registro ni usando polimorfismo
    // heredando de ella, junto con sus atributos privados y finales para que, una vez mas,
    // el registro no se pueda editar
    private final String idRegistro;
    private final String idMiembro;
    private final String fecha;
    private final Integer minutosUso;

    // ahora creamos el constructor
    public RegistroUsoMaquina(String idRegistro, String idMiembro, String fecha, Integer minutosUso) {
        this.idRegistro = idRegistro;
        this.idMiembro = idMiembro;
        this.fecha = fecha;
        this.minutosUso = minutosUso;
    }

    //Ahora necesitamos los getters
    public String getIdRegistro() {
        return idRegistro;
    }
    public String getIdMiembro() {
        return idMiembro;
    }
    public String getFecha() {
        return fecha;
    }
    public Integer getMinutosUso() {
        return minutosUso;
    }
}