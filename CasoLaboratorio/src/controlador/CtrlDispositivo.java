package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Dispositivo;
import modelo.Operaciones;
import vista.Vista;

/**
 * @author Nashiro
 */
public class CtrlDispositivo implements ActionListener {
    private Dispositivo mod;
    private Operaciones modC;
    private Vista vista;
    
    public CtrlDispositivo (Dispositivo mod, Operaciones modC, Vista vista){
        this.mod = mod;
        this.modC = modC;
        this.vista = vista;
        this.vista.BtnBuscar.addActionListener(this);
        this.vista.BtnEliminar.addActionListener(this);
        this.vista.BtnAgregar.addActionListener(this);
        this.vista.BtnLimpiar.addActionListener(this);
        this.vista.BtnModificar.addActionListener(this);
    }
    
    public void iniciar() {
        vista.setTitle("Carga de dispositivos");
        vista.setLocationRelativeTo(null);
    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource()== vista.BtnAgregar){
            mod.setNSerie(Integer.parseInt(vista.TxtNSerie.getText()));
            mod.setSede(vista.TxtSede.getText());
            mod.setEquipo(vista.TxtEquipo.getText());
            mod.setMarca(vista.TxtMarca.getText());
            mod.setAño(Integer.parseInt(vista.TxtAFab.getText()));
            if (modC.agregar(mod)){
                JOptionPane.showMessageDialog(null, "Dispositivo Guardado");
                limpiar();
            }else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        
        if (e.getSource()== vista.BtnModificar){
            mod.setNSerie(Integer.parseInt(vista.TxtNSerie.getText()));
            mod.setSede(vista.TxtSede.getText());
            mod.setEquipo(vista.TxtEquipo.getText());
            mod.setMarca(vista.TxtMarca.getText());
            mod.setAño(Integer.parseInt(vista.TxtAFab.getText()));
            if (modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificado");
                limpiar();
            }
        }
        
        if (e.getSource()== vista.BtnEliminar){
            mod.setNSerie(Integer.parseInt(vista.TxtNSerie.getText()));
            if (modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        if (e.getSource()== vista.BtnBuscar){
            mod.setNSerie(Integer.parseInt(vista.TxtNSerie.getText()));
            if (modC.buscar(mod)){
                vista.TxtNSerie.setText(String.valueOf(mod.getNSerie()));
                vista.TxtSede.setText(mod.getSede());
                vista.TxtEquipo.setText(mod.getEquipo());
                vista.TxtMarca.setText(mod.getMarca());
                vista.TxtAFab.setText(String.valueOf(mod.getAño()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encuentra el dispositivo");
                limpiar();
            }
        }
    }
    
    public void limpiar() {

        vista.TxtNSerie.setText(null);
        vista.TxtSede.setText(null);
        vista.TxtEquipo.setText(null);
        vista.TxtMarca.setText(null);
        vista.TxtAFab.setText(null);
    } 
}