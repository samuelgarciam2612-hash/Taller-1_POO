import java.util.Objects;

public class Miembro {
    static int ContadorMiembros;
    private String idMiembro;
    private String nombre;
    private Membresia membresia;

    public Miembro(String idMiembro, String nombre, Membresia membresia) {
        this.idMiembro = idMiembro;
        this.nombre = nombre;
        this.membresia = membresia;
        ContadorMiembros++;
    }

    public Miembro(String idMiembro, String nombre) {
        this.idMiembro = idMiembro;
        this.nombre = nombre;
    }

    public static int getContadorMiembros() {
        return ContadorMiembros;
    }

    public boolean MembresiaValida() {
        return this.membresia != null && this.membresia.estaActiva();
    }
    // El metodo valida dos cosas, si tiene membresia que no sea null y si esta activa o no

    public boolean ValidarNombre(String nombreIngresado) {
        return Objects.equals(this.nombre, nombreIngresado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Miembro miembros = (Miembro) o;
        return Objects.equals(idMiembro, miembros.idMiembro) && Objects.equals(nombre, miembros.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMiembro, nombre);
    }

    public String getIdMiembro() {
        return idMiembro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void setContadorMiembros(int contadorMiembros) {
        ContadorMiembros = contadorMiembros;
    }

    @Override
    public String toString() {
        return "{" +
                "\n  idMiembro = '" + idMiembro + '\'' +
                ",\n  nombre = '" + nombre + '\'' +
                ",\n  membresia = " + membresia +
                "\n}";
    }
}
