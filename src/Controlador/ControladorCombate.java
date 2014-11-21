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
import javax.swing.JButton;

/**
 *
 * @author Mario Caceres
 */
public class ControladorCombate implements ActionListener{
    
    private VistaPreviaCombate vpc;
    private VistaCombate vc;
    private VistaAtaque va;
    private VistaEquipo ve;
    private int tipo_simulacion;
    private Combate combate;
    private int turno;
    private Pokemon[] equipo1;
    private Pokemon[] equipo2;
    
    public ControladorCombate(VistaPreviaCombate vista, int tipo_simulacion,
            Entrenador entrenador1, Entrenador entrenador2){
        this.tipo_simulacion = tipo_simulacion;
        this.vpc = vista;
        this.vpc.agregarListener(this);
        this.combate = new Combate();
        this.equipo1 = entrenador1.getPokemones();
        this.equipo2 = entrenador2.getPokemones();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (vpc.getBotonIniciar() == (JButton) e.getSource()){
            this.vc = new VistaCombate();
            vc.setVisible(true);
            System.out.println("Se inicio el Combate");
            this.vc.agregarListener(this);
            
        }
        
        
            
        } 
    
    
  
}
    
        

