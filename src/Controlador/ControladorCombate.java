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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Pokemon pokemon_activo1;
    private Pokemon pokemon_activo2;
    
    
    
    public ControladorCombate(VistaPreviaCombate vista, int tipo_simulacion,
            Entrenador entrenador1, Entrenador entrenador2){
        this.tipo_simulacion = tipo_simulacion;
        this.vpc = vista;
        this.vpc.agregarListener(this);
        this.combate = new Combate();
        this.equipo1 = entrenador1.getPokemones();
        this.equipo2 = entrenador2.getPokemones();
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (vpc.getBotonIniciar() == (JButton) e.getSource()){
            this.vc = new VistaCombate();
            this.va = new VistaAtaque();
            va.agregarListener(this);
            System.out.println("Se inicio el Combate");
            this.vc.agregarListener(this);
            vpc.setVisible(false);
            int Index_inicial1 = vpc.getIndexjC_Inicial1();
            int Index_inicial2 = vpc.getIndexjC_Inicial1();
                vc.setjL_jugador1(entrenador1.getNombre());
                vc.setjL_jugador2(entrenador2.getNombre());
                vc.setjL_nombrepokemon1(equipo1[Index_inicial1].getPseudonimo());
                vc.setjL_nombrepokemon2(equipo1[Index_inicial2].getPseudonimo());
                vc.setjL_nombrepokemon2(vpc.getjC_Inicial2());
                vc.setjL_vida_actual1(equipo1[Index_inicial1].getVida_restante(), equipo1[Index_inicial1].getVida());
                vc.setjL_vida_actual2(equipo2[Index_inicial2].getVida_restante(), equipo2[Index_inicial2].getVida());
            this.turno = 0;
            this.pokemon_activo1 = equipo1[Index_inicial1];
            this.pokemon_activo2 = equipo2[Index_inicial2];
            vc.setVisible(true);
            JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
            vc.setjL_Turno_actual(entrenador1.getNombre());
            vc.turnoJugador1();
            
        }
                   
        if (vc.getBotonAtacar1() == (JButton) e.getSource()){
            this.va = new VistaAtaque();
            va.agregarListener(this);
            va.setVistaAtaque(pokemon_activo1);
            va.setVisible(true);
            
        }
        if (vc.getBotonAtacar2() == (JButton) e.getSource()){
            this.va = new VistaAtaque();
            va.agregarListener(this);
            va.setVistaAtaque(pokemon_activo2);
            va.setVisible(true);           
        }
        if(va.getBotonAtaque1() == (JButton) e.getSource()){
            if(turno ==0){
                inflingirDaño(pokemon_activo1.getMovimientos()[0], pokemon_activo2, pokemon_activo1);
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador2.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador2();
                this.turno = 1;
            }
            else if(turno ==1){
                inflingirDaño(pokemon_activo2.getMovimientos()[0], pokemon_activo1, pokemon_activo2);
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador1.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador1();
                this.turno = 0;
            }
        }
        if(va.getBotonAtaque2() == (JButton) e.getSource()){
            if(turno ==0){
                inflingirDaño(pokemon_activo1.getMovimientos()[1], pokemon_activo2, pokemon_activo1);
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador2.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador2();
                this.turno = 1;
            }
            else if(turno ==1){
                inflingirDaño(pokemon_activo2.getMovimientos()[1], pokemon_activo1, pokemon_activo2);
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador1.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador1();
                this.turno = 0;
            }
        }
        if(va.getBotonAtaque3() == (JButton) e.getSource()){
            if(turno ==0){
                inflingirDaño(pokemon_activo1.getMovimientos()[2], pokemon_activo2, pokemon_activo1);
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador2.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador2();
                this.turno = 1;
            }
            else if(turno ==1){
                inflingirDaño(pokemon_activo2.getMovimientos()[2], pokemon_activo1, pokemon_activo2);
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador1.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador1();
                this.turno = 0;
            }
        }
        if(va.getBotonAtaque4() == (JButton) e.getSource()){
            if(turno ==0){
                inflingirDaño(pokemon_activo1.getMovimientos()[3], pokemon_activo2, pokemon_activo1);
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador2.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador2();
                this.turno = 1;
            }
            else if(turno ==1){
                inflingirDaño(pokemon_activo2.getMovimientos()[3], pokemon_activo1, pokemon_activo2);
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador1.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador1();
                this.turno = 0;
            }
        }
        if(vc.getBotonCambiar1() == (JButton) e.getSource()){
            this.va = new VistaAtaque();
            va.agregarListener(this);
            va.setVistaAtaque(pokemon_activo1);
            va.setVisible(true);
        
        }
        
                        
                    
                  
               
             
            
    }
        
        
             
    
    public Boolean condicionVictoria(Pokemon[] equipo1, Pokemon[] equipo2){
        if(equipo1[0].getDebilitado() == true && equipo1[1].getDebilitado()== true 
                && equipo1[2].getDebilitado() == true && equipo1[3].getDebilitado() == true 
                && equipo1[4].getDebilitado() == true && equipo1[5].getDebilitado() == true){
            return true;
        }
        else if(equipo2[0].getDebilitado() == true && equipo2[1].getDebilitado()== true 
                && equipo2[2].getDebilitado() == true && equipo2[3].getDebilitado() == true 
                && equipo2[4].getDebilitado() == true && equipo2[5].getDebilitado() == true){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    
    
    public void inflingirDaño(MovimientoAprendido movimiento, Pokemon victima, Pokemon atacante){
        int vida_actual = victima.getVida_restante();
        double daño=0;
        double multiplicador_daño=1;
        int[] debilidades_victima = victima.getDebilidades();
        int[] fortalezas_victima = victima.getFortalezas();
        int daño_total;
        int pp_actual = movimiento.getPuntos_poder_restantes();
        
        if(movimiento.getContacto() == true){
            daño = (2*atacante.getNivel() + 10)*movimiento.getPotencia()*atacante.getAtaque()/(victima.getDefensa()*250);
        }
        else if(movimiento.getContacto() == false){
            daño = (2*atacante.getNivel() + 10 )*movimiento.getPotencia()*atacante.getAtaque_especial()/(victima.getDefensa_especial()*250);
        }
        
        for (int i = 0; i < debilidades_victima.length; i++) {
            if(movimiento.getTipo() == debilidades_victima[i]){
                multiplicador_daño = 2.0;   
            }
        }
        for (int j = 0; j < fortalezas_victima.length; j++){
            if(movimiento.getTipo() == fortalezas_victima[j]){
                multiplicador_daño = 1/2.0;
            }
        }    
        
        daño_total = (int) (daño*multiplicador_daño);
        int vida_neta = vida_actual-daño_total;
        victima.setVida_restante(vida_neta);
        movimiento.setPuntos_poder_restantes(pp_actual-1);
    }
    
    public String evaluarAccion(Pokemon atacante, Pokemon defensor){
        int[] debilidades_atacante = atacante.getDebilidades();
        for (int i = 0; i < debilidades_atacante.length; i++) {
            if(debilidades_atacante[i] == defensor.getNaturaleza_primaria() || debilidades_atacante[i] == defensor.getNaturaleza_secundaria()){
                return "Cambiar";
            }
            
        }
        return "Atacar";
    }
  
}
    
        

