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
    
    public ControladorCombate(VistaPreviaCombate vista, int tipo_simulacion,
            Entrenador entrenador1, Entrenador entrenador2){
        this.tipo_simulacion = tipo_simulacion;
        this.vpc = vista;
        this.vpc.agregarListener(this);
        this.combate = new Combate();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (vpc.getBotonIniciar() == (JButton) e.getSource()){
            this.vc = new VistaCombate();
            vc.setVisible(true);
            System.out.println("Se inicio el Combate");
            this.vc.agregarListener(this);}
        
        else if (vc.getBotonAtacar1() == (JButton) e.getSource()){
            this.va = new VistaAtaque();
            va.setVisible(true);}
            
        else if (vc.getBotonAtacar2() == (JButton) e.getSource()){
            this.va = new VistaAtaque();
            va.setVisible(true);}
        
        else if (vc.getBotonCambiar1() == (JButton) e.getSource()){
            this.ve = new VistaEquipo();
            ve.setVisible(true);}
        
        else if (vc.getBotonCambiar2() == (JButton) e.getSource()){
            this.ve = new VistaEquipo();
            ve.setVisible(true);}
            
        }    
        }
    
        

