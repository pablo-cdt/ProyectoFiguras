package excepciones;

import constants.ProcesosEnum;

public class ProcesoInterrumpidoException extends Exception {

    private String mensaje;
    private ProcesosEnum proceso;

    public ProcesoInterrumpidoException(ProcesosEnum proceso) {
        this.proceso = proceso;
    }

    public ProcesoInterrumpidoException(String mensaje, ProcesosEnum proceso) {
        super(mensaje);
        this.proceso = proceso;
    }

    public ProcesosEnum getProceso() {
        return proceso;
    }
}