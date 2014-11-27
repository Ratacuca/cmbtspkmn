/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Mario Caceres
 */
public class ControladorEntrenador implements ActionListener{
    
    private VistaCrearEntrenador vista;
    private VistaNuevoEquipo vnew;
    private ControladorPrincipal controlador_principal;
    
    public ControladorEntrenador(VistaCrearEntrenador vce, ControladorPrincipal cp)throws SQLException{
        this.controlador_principal = cp;
        vista = vce;
        this.vista.agregarListener(this);
        ControladorBD cBD = new ControladorBD();
        this.vnew = new VistaNuevoEquipo();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (vista.getjB_Crear() == (JButton) e.getSource()){
            
            String nombre = vista.getNombre();
            int regionBD = vista.getjC_Region() +1;
            String region = getRegion();
            String distincion = "Entrenador";
            try {
                guardarEntrenador(nombre, region, distincion);
            } catch (IOException ex) {
                Logger.getLogger(ControladorEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ControladorBD cBD = new ControladorBD();
                ArrayList<String> nombres_pokemon = new ArrayList();
                nombres_pokemon = cBD.obtenerNombresPokemones();
                    vnew.setJL_Pokemon1(nombres_pokemon);
                    vnew.setJL_Pokemon2(nombres_pokemon);
                    vnew.setJL_Pokemon3(nombres_pokemon);
                    vnew.setJL_Pokemon4(nombres_pokemon);
                    vnew.setJL_Pokemon5(nombres_pokemon);
                    vnew.setJL_Pokemon6(nombres_pokemon);
                int id_entrenador = cBD.guardarEntrenador(nombre, distincion, regionBD);
                int nuevo = 1;
                ControladorEquipo ce = new ControladorEquipo(vnew, nuevo, id_entrenador, controlador_principal);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            vista.dispose();
            

        }
    }
 
    public String getRegion(){
        
       String region = null;
       
       if (vista.getjC_Region() == 0){
           region = "Kanto";
       }
       if (vista.getjC_Region() == 1){
           region = "Johto";
       }
       if (vista.getjC_Region() == 2){
           region = "Hoenn";
       }
       if (vista.getjC_Region() == 3){
           region = "Sinnoh";
       }
       if (vista.getjC_Region() == 4){
           region = "Teselia";
       }
       if (vista.getjC_Region() == 5){
           region = "Kalos";
       }
       
       return region;
    }
    
    private void guardarEntrenador(String nombre, String region, String distincion) throws IOException {
        String nombreArchivo = "BD.txt";
        FileWriter adquirir = new FileWriter(nombreArchivo, true);
        PrintWriter procesador = new PrintWriter(adquirir);

        procesador.println(nombre+" "+region+" "+distincion);

        procesador.close();
    }
}
