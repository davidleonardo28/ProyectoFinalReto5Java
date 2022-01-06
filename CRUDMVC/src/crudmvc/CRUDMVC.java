//Clase main

package crudmvc;
import Controlador.ControllerComandante;
import Controlador.CtrlComandante;
import Modelo.Comandante;
import Modelo.Consultastabla;
import Vista.VistaPrincipal;
import Vista.frmComandante;


public class CRUDMVC {

    
    public static void main(String[] args) {
        
        Comandante mod = new Comandante();
        Consultastabla modC = new Consultastabla();
        VistaPrincipal view = new VistaPrincipal();      
        ControllerComandante ctrl = new ControllerComandante(mod, modC, view); 
        ctrl.iniciar();
        view.setVisible(true);
            
    }
    
}
