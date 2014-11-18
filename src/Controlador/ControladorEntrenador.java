/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario Caceres
 */
public class ControladorEntrenador implements ActionListener{
    
    private VistaCrearEntrenador vista;
    
    public ControladorEntrenador(VistaCrearEntrenador vce){
        vista = vce;
        this.vista.agregarListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (vista.getjB_Crear() == (JButton) e.getSource()){
            String nombre = vista.getNombre();
            String region = getRegion();
            int medallas_adquiridas = 0;
            int victorias_torre_batalla = 0;
            String distincion = "Entrenador";
//            Pokemon[] pokemones = new Pokemon[6];    
//                pokemones[0] = new Pokemon(getPokemon1());
//                pokemones[1] = new Pokemon(getPokemon2());
//                pokemones[2] = new Pokemon(getPokemon3());
//                pokemones[3] = new Pokemon(getPokemon4());
//                pokemones[4] = new Pokemon(getPokemon5());
//                pokemones[5] = new Pokemon(getPokemon6());
            
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
