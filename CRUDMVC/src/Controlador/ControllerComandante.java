//Establecimiento de la conexion entre el modelo y la vista 

package Controlador;
import Modelo.Comandante;
import Modelo.Consultastabla;
import Vista.VistaPrincipal;
import Vista.frmComandante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerComandante implements ActionListener {

    private Comandante mod;
    private Consultastabla modC;
    private VistaPrincipal view;

    public ControllerComandante(Comandante mod, Consultastabla modC, VistaPrincipal view) {
        this.mod = mod;
        this.modC = modC;
        this.view = view;
        this.view.btnConsulta.addActionListener(this);
        this.view.btnBuscar.addActionListener(this);
        this.view.btnGuardar.addActionListener(this);
        this.view.btnModificar.addActionListener(this);
        this.view.btnLimpiar.addActionListener(this);
        this.view.btnEliminar.addActionListener(this);

    }

    /**
     * Metodo Iniciar Ventanas *
     *
     */
    public void iniciar() {
        view.setTitle("Comandantes");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        /// frm.txtId.setVisible(false);
    }

    /**
     * Metodo Limpiar
     */
    public void limpiar() {
        view.txtCodigo.setText(null);
        view.txtNombre.setText(null);
        view.txtApellido.setText(null);
        view.buttonGroup1.clearSelection();
        view.txtAnios.setText(null);
        view.txtFecha.setDate(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnGuardar) {
            mod.setCod_comandante(Integer.parseInt(view.txtCodigo.getText()));
            mod.setNombre(view.txtNombre.getText());
            mod.setApellidos(view.txtApellido.getText());
            if (view.rbCrateriana.isSelected()) {
                mod.setEscuela(view.rbCrateriana.getText());
            } else {
                if (view.rbTerrestre.isSelected()) {
                    mod.setEscuela(view.rbTerrestre.getText());
                }
            }
            mod.setAnio_servicio(Integer.parseInt(view.txtAnios.getText()));
            mod.setFecha_ingreso(view.txtFecha.getDate());

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado con éxito" + JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar" + JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }
        if (e.getSource() == view.btnModificar) {
            mod.setCod_comandante(Integer.parseInt(view.txtCodigo.getText()));
            mod.setNombre(view.txtNombre.getText());
            mod.setApellidos(view.txtApellido.getText());
            if (view.rbCrateriana.isSelected()) {
                mod.setEscuela(view.rbCrateriana.getText());
            } else {
                if (view.rbTerrestre.isSelected()) {
                    mod.setEscuela(view.rbTerrestre.getText());
                }
            }
            mod.setAnio_servicio(Integer.parseInt(view.txtAnios.getText()));
            mod.setFecha_ingreso(view.txtFecha.getDate());

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }

        }
      
        if (e.getSource() == view.btnEliminar) {
            mod.setCod_comandante(Integer.parseInt(view.txtCodigo.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado" + JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar" + JOptionPane.ERROR_MESSAGE);
                    limpiar();
                
            }

        }
       
        if (e.getSource() == view.btnBuscar) {
        if (view.txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No dejar campos Vacíos", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
           mod.setCod_comandante(Integer.parseInt(view.txtCodigo.getText()));
            if (modC.buscar(mod)) {
                view.txtCodigo.setText(String.valueOf(mod.getCod_comandante()));
                view.txtNombre.setText(mod.getNombre());
                view.txtApellido.setText(mod.getApellidos());
                String variable = mod.getEscuela();
                if(variable.equals("Terrestre")){
                     view.rbTerrestre.setSelected(true);
                     System.out.println(variable);
                }else if (variable.equals("Crateriana")){
                    view.rbCrateriana.setSelected(true);
                    System.out.println(variable);
                }
                view.txtAnios.setText(String.valueOf(mod.getAnio_servicio()));
                view.txtFecha.setDate(mod.getFecha_ingreso());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
                limpiar();
            }
        }
        }


            
        if (e.getSource() == view.btnLimpiar) {
            limpiar();
        }
        
    }
}
