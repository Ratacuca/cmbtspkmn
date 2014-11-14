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
            Pokemon[] pokemones = new Pokemon[6];    
                pokemones[0] = new Pokemon(getPokemon1());
                pokemones[1] = new Pokemon(getPokemon2());
                pokemones[2] = new Pokemon(getPokemon3());
                pokemones[3] = new Pokemon(getPokemon4());
                pokemones[4] = new Pokemon(getPokemon5());
                pokemones[5] = new Pokemon(getPokemon6());
            
            Entrenador entrenador = new Entrenador(nombre,pokemones,region,
            medallas_adquiridas,victorias_torre_batalla,distincion);
            vista.setVisible(false);
            System.out.println(entrenador.getNombre()+ entrenador.getRegion()+entrenador.getDistincion()+entrenador.getPokemones()[0].getNombre());
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
        
        String nombre = null;
        
        if ((vista.getjC_Pokemon1()== 0)){
            nombre = "Bulbasaur";
        }
        if ((vista.getjC_Pokemon1()== 1)){
            nombre = "Charizard";
        }
        if ((vista.getjC_Pokemon1()== 2)){
            nombre = "Squirtle";
        }
        return nombre;
    }
    public String getPokemon2(){
        
        String nombre = null;
        
        if ((vista.getjC_Pokemon2()== 0)){
            nombre = "Bulbasaur";
        }
        if ((vista.getjC_Pokemon2()== 1)){
            nombre = "Charizard";
        }
        if ((vista.getjC_Pokemon2()== 2)){
            nombre = "Squirtle";
        }
        return nombre;
    }
    public String getPokemon3(){
        
        String nombre = null;
        
        if ((vista.getjC_Pokemon3()== 0)){
            nombre = "Bulbasaur";
        }
        if ((vista.getjC_Pokemon3()== 1)){
            nombre = "Charizard";
        }
        if ((vista.getjC_Pokemon3()== 2)){
            nombre = "Squirtle";
        }
        return nombre;
    }
    public String getPokemon4(){
        
        String nombre = null;
        
        if ((vista.getjC_Pokemon4()== 0)){
            nombre = "Bulbasaur";
        }
        if ((vista.getjC_Pokemon4()== 1)){
            nombre = "Charizard";
        }
        if ((vista.getjC_Pokemon4()== 2)){
            nombre = "Squirtle";
        }
        return nombre;
    }
    public String getPokemon5(){
        
        String nombre = null;
        
        if ((vista.getjC_Pokemon5()== 0)){
            nombre = "Bulbasaur";
        }
        if ((vista.getjC_Pokemon5()== 1)){
            nombre = "Charizard";
        }
        if ((vista.getjC_Pokemon5()== 2)){
            nombre = "Squirtle";
        }
        return nombre;
    }
    public String getPokemon6(){
        
        String nombre = null;
        
        if ((vista.getjC_Pokemon6()== 0)){
            nombre = "Bulbasaur";
        }
        if ((vista.getjC_Pokemon6()== 1)){
            nombre = "Charizard";
        }
        if ((vista.getjC_Pokemon6()== 2)){
            nombre = "Squirtle";
        }
        return nombre;
    }
}
