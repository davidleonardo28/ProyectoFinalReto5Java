package Controlador;
import Modelo.Comandante;
import Modelo.Consultastabla;
import Vista.frmComandante;
import javax.swing.JOptionPane;
import java.awt.event.*;


public class CtrlComandante implements ActionListener {
    private Comandante mod;
    private Consultastabla modC;
    private frmComandante frm;
    
    public CtrlComandante (Comandante mod, Consultastabla modC, frmComandante frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);       
    }
    public void iniciar(){
        frm.setTitle("Comandantes");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }
    public void limpiar(){
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtApellido.setText(null);
        frm.txtEscuela.setText(null);
        frm.txtAnios.setText(null);
        frm.txtFecha.setDate(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == frm.btnGuardar){
            mod.setCod_comandante(Integer.parseInt(frm.txtCodigo.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setApellidos(frm.txtApellido.getText());
            mod.setEscuela(frm.txtEscuela.getText());
            mod.setAnio_servicio(Integer.parseInt(frm.txtAnios.getText()));
            mod.setFecha_ingreso(frm.txtFecha.getDate());//OJO!!!
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null,"Registro guardado con éxito");
                limpiar();
            } else{
                JOptionPane.showMessageDialog(null,"Error al guardar");
                limpiar();
            }
            
        }
        if(e.getSource() == frm.btnModificar){
            mod.setCod_comandante(Integer.parseInt(frm.txtCodigo.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setApellidos(frm.txtApellido.getText());
            mod.setEscuela(frm.txtEscuela.getText());
            mod.setAnio_servicio(Integer.parseInt(frm.txtAnios.getText()));
            mod.setFecha_ingreso(frm.txtFecha.getDate());//OJO!!!
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null,"Registro modificado");
                limpiar();
            } else{
                JOptionPane.showMessageDialog(null,"Error al modificar");
                limpiar();
            }
            
        }
        if(e.getSource() == frm.btnEliminar){
            mod.setCod_comandante(Integer.parseInt(frm.txtCodigo.getText()));
                       
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null,"Registro eliminado");
                limpiar();
            } else{
                JOptionPane.showMessageDialog(null,"Error al eliminar");
                limpiar();
            }
            
        }
        if(e.getSource() == frm.btnBuscar){
            mod.setCod_comandante(Integer.parseInt(frm.txtCodigo.getText()));
                       
            if(modC.buscar(mod)){
                frm.txtCodigo.setText(String.valueOf(mod.getCod_comandante()));          
                frm.txtNombre.setText(mod.getNombre());
                frm.txtApellido.setText(mod.getApellidos());
                frm.txtEscuela.setText(mod.getEscuela());
                frm.txtAnios.setText(String.valueOf(mod.getAnio_servicio()));
                frm.txtFecha.setDate(mod.getFecha_ingreso());                              
                
            } else{
                JOptionPane.showMessageDialog(null,"No se encontró registro");
                limpiar();
            }
            
        }
        if(e.getSource() == frm.btnLimpiar){
            limpiar();
        }
    }
    
}
