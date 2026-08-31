public final class GimnasioUtil {
    private GimnasioUtil(){
    }
    public static boolean ValidarMembresiaActiva(Miembro miembro){
        return miembro != null && miembro.MembresiaValida();
    }
    public static int contarMiembrosActivos(Miembro[] listaMiembros){
        if(listaMiembros == null ){
            return 0;
        }
        int totalActivos = 0;

            for (Miembro m : listaMiembros) {
                if (ValidarMembresiaActiva(m)) {
                    totalActivos++;
                }
            }
            return totalActivos;

    }
    public static ClaseGrupal obtenerClaseMasSolicitada(ClaseGrupal[] listaClases) {
        if (listaClases == null || listaClases.length == 0) {
            return null;
        }
        ClaseGrupal masSolicitada = listaClases[0];

        for (int i = 1; i < listaClases.length; i++) {
            if (listaClases[i] != null) {
                if ( masSolicitada == null || listaClases[i].getContadorInscritos() > masSolicitada .getContadorInscritos()){
                    masSolicitada = listaClases[i];
                }
            }

        }
        return masSolicitada;
        /*Primero que no sea nulo, tomar un punto de referencia, recorrer desde la primera posicion
        pasa una de las dos condiciones si la referencia inicial era nula se asigna a la primera clase valida
         */

    }
}
