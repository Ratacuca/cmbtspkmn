/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package combatespokemon;
import Vista.*;
import Modelo.*;
import Controlador.*;


/**
 *
 * @author Mario Caceres
 */
public class CombatesPokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VistaPrincipal vista = new VistaPrincipal();
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(vista);
        vista.setVisible(true);
        
        
        
    }
    
}
