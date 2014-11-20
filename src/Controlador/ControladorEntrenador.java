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
    
    public ControladorEntrenador(VistaCrearEntrenador vce)throws SQLException{
        vista = vce;
        this.vista.agregarListener(this);
        ControladorBD cBD = new ControladorBD();
        ArrayList<String> JLpokemones = cBD.obtenerNombresPokemones();
        vista.setJL_Pokemon1(JLpokemones);
        vista.setJL_Pokemon2(JLpokemones);
        vista.setJL_Pokemon3(JLpokemones);
        vista.setJL_Pokemon4(JLpokemones);
        vista.setJL_Pokemon5(JLpokemones);
        vista.setJL_Pokemon6(JLpokemones);
 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (vista.getjB_Crear() == (JButton) e.getSource()){
            String nombre = vista.getNombre();
            String region = getRegion();
            int medallas_adquiridas = 0;
            int victorias_torre_batalla = 0;
            String distincion = "Entrenador";
            String[] pokemones = new String[6];
            pokemones[0]= getPokemon1();
            pokemones[1]= getPokemon2();
            pokemones[2]= getPokemon3();
            pokemones[3]= getPokemon4();
            pokemones[4]= getPokemon5();
            pokemones[5]= getPokemon6();
            try {
                guardarEntrenador(nombre, region, distincion, medallas_adquiridas,
                        victorias_torre_batalla, pokemones);
            } catch (IOException ex) {
                Logger.getLogger(ControladorEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
//            Entrenador entrenador = new Entrenador(nombre,pokemones,region,
//            medallas_adquiridas,victorias_torre_batalla,distincion);
            vista.dispose();
            
//            System.out.println(entrenador.getNombre()+ entrenador.getRegion()+entrenador.getDistincion()+entrenador.getPokemones()[0].getNombre());
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
    
    public String getPokemon1(){
        String nombre = vista.getJL_Pokemon1();
        return nombre;
    }
    public String getPokemon2(){
        String nombre = vista.getJL_Pokemon2();
        return nombre;
    }
    public String getPokemon3(){
        String nombre = vista.getJL_Pokemon3();
        return nombre;
    }
    public String getPokemon4(){
        String nombre = vista.getJL_Pokemon4();
        return nombre;
    }
    public String getPokemon5(){
        String nombre = vista.getJL_Pokemon5();
        return nombre;
    }
    public String getPokemon6(){
        String nombre = vista.getJL_Pokemon6();
        return nombre;
    }
   
    
    
    private void guardarEntrenador(String nombre, String region, String distincion, 
            int victorias, int torre, String[] pokemones) throws IOException {
        String nombreArchivo = "BD.txt";
        FileWriter adquirir = new FileWriter(nombreArchivo, true);
        PrintWriter procesador = new PrintWriter(adquirir);

        procesador.println(nombre+" "+region+" "+distincion+" "+victorias+" "+torre+
                " "+pokemones[0]+" "+pokemones[1]+" "+pokemones[2]+" "+pokemones[3]+
                " "+pokemones[4]+" "+pokemones[5]);

        procesador.close();
    }
}
