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
                
        
    }
    
    public void generarCombate(){
        VistaPreviaCombate vpc = new VistaPreviaCombate(vistaPrincipal.getjC_TipoSimulacion());
        int tipo_combate = vistaPrincipal.getjC_TipoSimulacion();
        Entrenador entrenador1 = new Entrenador(); // aqui se instanciaran los entrenadores cuando se tenga la bd
        Entrenador entrenador2 = new Entrenador();
        //acciones
        vpc.setVisible(true);
        ControladorCombate cc = new ControladorCombate(vpc, tipo_combate, entrenador1, entrenador2);
        System.out.println("Se selecciono simular combate");
    }
    
    public void generarEntrenador(){
        VistaCrearEntrenador vce = new VistaCrearEntrenador();
        vce.setVisible(true);
        ControladorEntrenador ce = new ControladorEntrenador(vce);
        
    }
}
