public enum EstadoMaquina {
    DISPONIBLE,
    EN_MANTENIMIENTO,
    FUERA_DE_SERVICIO;
}
// Creamos las unicas 3 opciones que habran para el estado de una maquina, de modo que no compile si
// no se usa unas de estas, idealmente habra que poner DISPONIBLE por default al crear una maquina
// no tendria sentido crear un maquina que ya este en mantenimiendo o fuera de servicio