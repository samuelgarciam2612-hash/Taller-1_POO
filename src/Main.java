public class Main {
    static void main(String[] args){
        Membresia m1 = new MembresiaAnual("1002", 750.000, EstadoMembresia.ACTIVA);
        Membresia m2 = new MembresiaMensual("1236", 105.000, EstadoMembresia.CANCELADA);
        Membresia m3 = new MembresiaAnual("5432", 950.000, EstadoMembresia.CANCELADA);
        Membresia m4 = new MembresiaMensual("2367", 75.000, EstadoMembresia.ACTIVA);

        Miembro P1 = new Miembro("103316", "Samuel G", m1);
        Miembro P2 = new Miembro("0434", "Sofia");
        Miembro P3 = new Miembro("103318", "Camilo", m2);
        Miembro P4 = new Miembro("103318", "Camilo", m3);

        System.out.println(Miembro.getContadorMiembros());

        System.out.println(Calcular);

        Miembro[] listaMiembros = {P1, P2, P3};
        int totalActivos = GimnasioUtil.contarMiembrosActivos(listaMiembros);
        System.out.println("Total de miembros con membresía activa: " + totalActivos);

        ClaseGrupal[] listaClases = {};
        ClaseGrupal masSolicitada = GimnasioUtil.obtenerClaseMasSolicitada(listaClases);
        System.out.println("La clase mas solicitada es " + masSolicitada);

        System.out.println("Comparacion de miembros");
        System.out.println("Por referencia de memoria " + (P3 == P4));
        System.out.println("comparacion por hashcode de Miembro3 y Miembro 4 " + (P3.hashCode()==P4.hashCode()));
        }

