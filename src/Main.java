public class Main {
    public static void main(String[] args) {
        Membresia m1 = new MembresiaAnual("1002", 750000.0, EstadoMembresia.ACTIVA);
        Membresia m2 = new MembresiaMensual("1236", 105000.0, EstadoMembresia.CANCELADA);
        Membresia m3 = new MembresiaAnual("5432", 950000.0, EstadoMembresia.CANCELADA);
        Membresia m4 = new MembresiaMensual("2367", 75000.0, EstadoMembresia.ACTIVA);

        Miembro P1 = new Miembro("103316", "Samuel G", m1);
        Miembro P2 = new Miembro("0434", "Sofia");
        Miembro P3 = new Miembro("103318", "Camilo", m2);
        Miembro P4 = new Miembro("103318", "Camilo", m4);

        Entrenador E1 = new Entrenador("Y-1478", "Juan", "Yoga");
        Entrenador E2 = new Entrenador("S-0345", "Luis", "Spinning");
        Entrenador E3 = new Entrenador("P-3406", "Alejandra", "Pilates");
        Entrenador E4 = new Entrenador("R-0987", "Mena", "Rumba");

        ClaseGrupal C1 = new ClaseGrupal("Y-0110", "Yoga", E1, 30);
        ClaseGrupal C2 = new ClaseGrupal("P-5467", "Pilates", E3, 25);
        ClaseGrupal C3 = new ClaseGrupal("R-8676", "Rumba", E4, 35);
        ClaseGrupal C4 = new ClaseGrupal("S-0999", "Spinning", E2, 15);

        Maquina caminadora = new Maquina("Caminadora", "C-0012", 2);
        RegistroUsoMaquina reg1 = new RegistroUsoMaquina("R-001", P1.getIdMiembro(),"2026/08/30", 45);
        RegistroUsoMaquina reg2 = new RegistroUsoMaquina("R-002", P3.getIdMiembro(), "2026/08/30", 60);
        Maquina pressBanca = new Maquina("Press Banca", "PB-0032", 2);
        RegistroUsoMaquina reg3 = new RegistroUsoMaquina("R-003", P4.getIdMiembro(), "2026/09/01", 30);


        System.out.println(Miembro.getContadorMiembros());

        System.out.println("Costo con Membresía Anual: " + m1.calcularCostoClase(25000.0));
        System.out.println("Costo con Membresía Mensual: " + m4.calcularCostoClase(25000.0));

        System.out.println("----- Recorrido Polimórfico e Instanceof (Req 5) -----");
        // guardar instancias hijas en el arreglo de la clase padre
        Membresia[] arregloMembresias = {m1, m2, m3, m4};
        for (Membresia mem : arregloMembresias) {
            System.out.println("Membresia ID: " + mem.getIdMembresia() + " Costo por clase: " + mem.calcularCostoClase(25000.0));

            if (mem instanceof MembresiaAnual) {
                // pasamos el tipo padre a su tipo real hijo
                MembresiaAnual membresiaAnual = (MembresiaAnual) mem;

                // Al saber que es un plan anual le damos un beneficio
                System.out.println("AVISO VIP: La membresía anual " + membresiaAnual.getIdMembresia() + " tiene acceso a zonas VIP.");
            }
        }

        Miembro[] listaMiembros = {P1, P2, P3, P4};
        int totalActivos = GimnasioUtil.contarMiembrosActivos(listaMiembros);
        System.out.println("Total de miembros con membresía activa: " + totalActivos);

        ClaseGrupal[] listaClases = {C1, C2, C3, C4};
        ClaseGrupal masSolicitada = GimnasioUtil.obtenerClaseMasSolicitada(listaClases);
        System.out.println("La clase mas solicitada es " + masSolicitada.getNombre());


        System.out.println("-----Comparacion de miembros-----");
        System.out.println("Por referencia de memoria " + (P3 == P4));
        System.out.println("comparacion por hashcode de Miembro3 y Miembro 4 " + (P3.hashCode() == P4.hashCode()));
        System.out.println("Comparacion por equals de Miembro3 y Miembro4 " + P3.equals(P4));

        System.out.println("----Reservas-----");
        try {
            System.out.println("Reservar Miembro1 en Spinning ");
            C4.reservar(P1);
            System.out.println("Reservar Miembro3 en Yoga ");
            C1.reservar(P3);

        } catch (MembresiaVencidaException | CupoAgotadoException e) { //multi-catch que suguirio el intellij
            System.out.println("Error en reserva: " + e.getMessage());
        } finally {
            System.out.println("Reservas de clases finalizadas");
        }

        System.out.println("-----Registro de maquinas------");
        try{
            caminadora.registrarUso(reg1,45);
            caminadora.registrarUso(reg2,60);

            RegistroUsoMaquina regExtra = new RegistroUsoMaquina("REG03", P1.getIdMiembro(), "2026/08/30", 20);
            caminadora.registrarUso(regExtra, 20); // Dispara historialDeUsoLleno

        } catch (MaquinaNoDisponibleException | HistorialUsoLlenoException e) {
            System.out.println("Excepción " + e.getMessage());
        } finally {
            System.out.println("Registro de máquina procesado.");
        }
        System.out.println("---Ficha de los miembros---- " + P1);
        System.out.println("---Ficha de los miembros---- " + P2);
        System.out.println("----Estado de la maquna---- " + caminadora);
        System.out.println("Tiempo total acumulado en caminadora: " + caminadora.calcularTiempoTotalUso() + " mins");
    }

}