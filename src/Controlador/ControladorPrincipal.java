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
            generarEntrenador();
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
        VistaPreviaCombate vpc = new VistaPreviaCombate(vistaPrincipal.getjC_TipoSimulacion());
        int tipo_combate = vistaPrincipal.getjC_TipoSimulacion();
        String nombre1 = vistaPrincipal.getjC_Nombre1();
        String nombre2 = vistaPrincipal.getjC_Nombre2();
        
        Entrenador entrenador1 = new Entrenador(); 
        Entrenador entrenador2 = new Entrenador();
        
        vpc.setVisible(true);
        ControladorCombate cc = new ControladorCombate(vpc, tipo_combate, entrenador1, entrenador2);
        System.out.println("Se selecciono simular combate");
    }
    
    public void generarEntrenador(){
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
        
    
}
