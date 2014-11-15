/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package combatespokemon;
import Vista.*;
import Modelo.*;
import Controlador.*;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Mario Caceres
 */
public class CombatesPokemon {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws ClassNotFoundException, 
            InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException {
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        VistaPrincipal vista = new VistaPrincipal();
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(vista);
        controladorPrincipal.leerBD("BD.txt");
        vista.setVisible(true);
        
        
        
        
    }
    
}
