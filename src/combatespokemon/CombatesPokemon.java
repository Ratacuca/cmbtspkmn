/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package combatespokemon;
import Controlador.*;
import Modelo.*;
import Vista.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
            InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException, SQLException {
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        VistaPrincipal vista = new VistaPrincipal();
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(vista);
        controladorPrincipal.leerBD("BD.txt");
        vista.setVisible(true);
     int a = 1;   
        double d = Math.random() * 100;
    if ((d -= 10) < 0) a=0;
    if ((d -= 90) < 0) a=1;
    
       
        
    }
        
    
    
}
