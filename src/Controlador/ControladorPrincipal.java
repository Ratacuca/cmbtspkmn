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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Mario Caceres
 */
public class ControladorPrincipal implements ActionListener{
    
    private VistaPrincipal vistaPrincipal;
    
    
    public ControladorPrincipal(VistaPrincipal vp){
        vistaPrincipal = vp;
        this.vistaPrincipal.agregarListener(this);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (vistaPrincipal.getBotonSimularCombate() == (JButton) e.getSource()) {
            generarCombate();
        }
        if (vistaPrincipal.getBotonCrearEntrenador() == (JButton) e.getSource()){
            try {
                generarEntrenador();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (vistaPrincipal.getBotonCargarEntrenador1() == (JButton) e.getSource()){
            try {
                vistaPrincipal.removerJc_Entrenador1();
                vistaPrincipal.removerJc_Entrenador2();
                leerBD("BD.txt");
            } catch (IOException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
                
        
    }
    
    public void generarCombate(){
        String nombre1 = vistaPrincipal.getjC_Nombre1();
        String nombre2 = vistaPrincipal.getjC_Nombre2();
        VistaPreviaCombate vpc = new VistaPreviaCombate(vistaPrincipal.getjC_TipoSimulacion(), nombre1, nombre2);
        int tipo_combate = vistaPrincipal.getjC_TipoSimulacion();
        Pokemon[] equipo1 = equipoPrueba1();
        Pokemon[] equipo2 = equipoPrueba2();
        Entrenador entrenador1 = new Entrenador(nombre1, equipo1); 
        Entrenador entrenador2 = new Entrenador(nombre2, equipo2);
        String[] nombres1 = new String[6];
        String[] nombres2 = new String[6];
        for (int i = 0; i < 6; i++) {
            nombres1[i]=equipo1[i].getPseudonimo();
            nombres2[i]=equipo2[i].getPseudonimo();    
        }
        vpc.setjC_Equipo1(nombres1);
        vpc.setjC_Equipo2(nombres2);
        vpc.setVisible(true);
        ControladorCombate cc = new ControladorCombate(vpc, tipo_combate, entrenador1, entrenador2);
        System.out.println("Se selecciono simular combate");
    }
    
    public void generarEntrenador() throws SQLException{
        VistaCrearEntrenador vce = new VistaCrearEntrenador();
        vce.setVisible(true);
        ControladorEntrenador ce = new ControladorEntrenador(vce);
        
    }
    public void leerBD(String ruta) throws FileNotFoundException, IOException{
        File adquisicion = new File(ruta);
        FileReader carga = new FileReader(adquisicion);
        BufferedReader procesador = new BufferedReader(carga);
        String linea = procesador.readLine();
        int l = 1;
        while(linea!=null){
            String[] linealeida = linea.split(" ");
            vistaPrincipal.setjC_Entrenador1(linealeida[0]);
            vistaPrincipal.setjC_Entrenador2(linealeida[0]);
            l++;
            linea = procesador.readLine();
        } 
        carga.close();
        procesador.close();
        
        }
     public Pokemon[] equipoPrueba1(){
         Pokemon[] equipo = new Pokemon[6];
         String[] debilidades_Charmander = new String[2];
         String[] fortalezas_Charmander= new String[2];
         debilidades_Charmander[0] = "Agua";
         fortalezas_Charmander[0] = "Planta";
         String[] debilidades_Squirtle= new String[2];
         String[] fortalezas_Squirtle= new String[2];
         debilidades_Squirtle[0] = "Planta";
         fortalezas_Squirtle[0] = "Fuego";
         Pokemon pokemon1 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon2 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon3 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon4 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon5 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon6 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         equipo[0]=pokemon1;
         equipo[1]=pokemon2;
         equipo[2]=pokemon3;
         equipo[3]=pokemon4;
         equipo[4]=pokemon5;
         equipo[5]=pokemon6;
         return equipo;
     }   
     public Pokemon[] equipoPrueba2(){
         Pokemon[] equipo = new Pokemon[6];
         String[] debilidades_Charmander = new String[2];
         String[] fortalezas_Charmander= new String[2];
         debilidades_Charmander[0] = "Agua";
         fortalezas_Charmander[0] = "Planta";
         String[] debilidades_Squirtle= new String[2];
         String[] fortalezas_Squirtle= new String[2];
         debilidades_Squirtle[0] = "Planta";
         fortalezas_Squirtle[0] = "Fuego";
         Pokemon pokemon1 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon2 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon3 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon4 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon5 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon6 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         equipo[0]=pokemon1;
         equipo[1]=pokemon2;
         equipo[2]=pokemon3;
         equipo[3]=pokemon4;
         equipo[4]=pokemon5;
         equipo[5]=pokemon6;
         return equipo;
     }   
    
}
