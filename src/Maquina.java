
public class Maquina {
    // Atributos privados
    private String idMaquina;
    private String nombre;
    private EstadoMaquina estado;

    // Arreglo de objetos
    private RegistroUsoMaquina[] historialUso;

    // Arreglo de primitivos
    private int[] tiempoUsoMinutos;

    // Contador de usos
    private int contadorUso;

    // Ahora creamos el constructor
    public Maquina(String nombre, String idMaquina, int capacidadRegistro) {
        this.nombre = nombre;
        this.idMaquina = idMaquina;
        // El estado por default es DISPONIBLE
        this.estado = EstadoMaquina.DISPONIBLE;

        // Los dos arreglos se crean con el MISMO tamano porque son paralelos:
        this.historialUso = new RegistroUsoMaquina[capacidadRegistro];
        this.tiempoUsoMinutos = new int[capacidadRegistro];
        this.contadorUso = 0;
        // Obvio comienza en cero uso la maquina
    }

    //Ahora registrar vamos a registrar su uso, teniendo en cuenta las
    // excepciones de cuando no se podria
    public void registrarUso(RegistroUsoMaquina registro, int duracion)
            throws MaquinaNoDisponibleException, HistorialUsoLlenoException {

        // Validacion 1: la maquina debe estar disponible
        if (this.estado != EstadoMaquina.DISPONIBLE) {
            throw new MaquinaNoDisponibleException(
                    "La maquina " + nombre + " no esta disponible. Estado actual: " + estado);
        }
        // Validacion 2: debe caber un registro mas
        if (this.contadorUso >= historialUso.length) {
            throw new HistorialUsoLlenoException(
                    "La maquina " + nombre + " tiene el registro lleno");
        }
        // Si pasa, guardamos en los dos arreglos
        historialUso[contadorUso] = registro;
        tiempoUsoMinutos[contadorUso] = duracion;
        contadorUso++;
    }
    //Calculadora de tiempo de uso acumulador
    public int calcularTiempoTotalUso() {
        int total = 0;                    // comenzamos con 0 minutos de uso aka sin usar

        for (int i = 0; i < contadorUso; i++) {
            // inicio ; condicion para seguir ; paso
            // Usamos ContadorUso en lugar de historialUso.length para no recorrer todo el array
            // Pa contar es irrelevante, pero si se quiere hacer operaciones despues es util
            total += tiempoUsoMinutos[i]; //agregamos los minutos de uso al total
        }

        return total; // recuperamos el total despues de sumar los usos
    }

    // Ahora los getters
    public String getIdMaquina() {
        return idMaquina;
    }
    public String getNombre() {
        return nombre;
    }
    public EstadoMaquina getEstado() {
        return estado;
    }
    public RegistroUsoMaquina[] getHistorialUso() {
        return historialUso;
    }

    // Sobrescribimos toString porque el heredado de Object imprime el nombre
    // de la clase y la direccion en memoria que obviamente no le sirve a nadie
    @Override
    public String toString() {
        return "Maquina{" +
                "idMaquina='" + idMaquina + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", usosRegistrados=" + contadorUso +
                ", tiempoTotalMinutos=" + calcularTiempoTotalUso() +
                '}';
    }
}