package casolaboratorio;

import controlador.CtrlDispositivo;
import modelo.Dispositivo;
import modelo.Operaciones;
import vista.Vista;

/**
 * @author Nashiro
 */
public class claseP {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dispositivo mod = new Dispositivo();
        Operaciones modc = new Operaciones();
        Vista vista = new Vista();
        CtrlDispositivo ctrl = new CtrlDispositivo(mod,modc,vista);
        ctrl.iniciar();
        vista.setVisible(true);
    }
}