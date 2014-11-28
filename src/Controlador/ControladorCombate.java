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
import java.sql.SQLException;
import java.util.ArrayList;
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
    private ControladorPrincipal controlador_principal;
    
    
    
    
    
    public ControladorCombate(VistaPreviaCombate vista, int tipo_simulacion,
            Entrenador entrenador1, Entrenador entrenador2, ControladorPrincipal cp){
        this.controlador_principal = cp;
        this.tipo_simulacion = tipo_simulacion;
        this.vpc = vista;
        this.vpc.agregarListener(this);
        this.combate = new Combate();
        this.equipo1 = entrenador1.getPokemones();
        this.equipo2 = entrenador2.getPokemones();
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.vc = new VistaCombate();
        this.va = new VistaAtaque();
        this.ve = new VistaEquipo();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //-------------------- ASIGNACIONES INICIALES PARA EL COMBATE-------------------
        if (vpc.getBotonIniciar() == (JButton) e.getSource()){
            va.agregarListener(this);
            ve.agregarListener(this);
            System.out.println("Se inicio el Combate");
            this.vc.agregarListener(this);
            vpc.setVisible(false);
            int Index_inicial1 = vpc.getIndexjC_Inicial1();
            int Index_inicial2 = vpc.getIndexjC_Inicial2();
                vc.setjL_jugador1(entrenador1.getNombre());
                vc.setjL_jugador2(entrenador2.getNombre());
                vc.setjL_nombrepokemon1(getEquipo1()[Index_inicial1].getPseudonimo());
                vc.setjL_nombrepokemon2(getEquipo2()[Index_inicial2].getPseudonimo());
                vc.setjL_especie1(getEquipo1()[Index_inicial1].getNombre_especie());
                vc.setjL_especie2(getEquipo2()[Index_inicial2].getNombre_especie());
                vc.setjL_nombrepokemon2(vpc.getjC_Inicial2());
                vc.setjL_vida_actual1(getEquipo1()[Index_inicial1].getVida_restante(), getEquipo1()[Index_inicial1].getVida());
                vc.setjL_vida_actual2(getEquipo2()[Index_inicial2].getVida_restante(), getEquipo2()[Index_inicial2].getVida());
                vc.setjL_Nivel1(getEquipo1()[Index_inicial1].getNivel());
                vc.setjL_Nivel2(getEquipo2()[Index_inicial2].getNivel());
            this.turno = 0;
            this.pokemon_activo1 = getEquipo1()[Index_inicial1];
            this.pokemon_activo2 = getEquipo2()[Index_inicial2];
            vc.setVisible(true);
            if(tipo_simulacion == 1 || tipo_simulacion == 2){
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador1();
                System.out.println("Turno"+" "+entrenador1.getNombre());
                vc.setjL_Turno_actual(entrenador1.getNombre());
            }
            else{
               JOptionPane.showMessageDialog(this.vc, "Comenzando Simulacion Completa de un Combate Usuario vs Sistema", "Comienzo Simulacion", JOptionPane.INFORMATION_MESSAGE); 
               vc.turnoSimulacion();
                while (condicionVictoria(getEquipo1(), getEquipo2())==false){
                    turnoUsuario();
                    turnoSistema();
                }
            }
            
        }
        
        if(vpc.getBotonEquipo1()== (JButton) e.getSource()){
            VistaNuevoEquipo vnew = new VistaNuevoEquipo();
            try {
                int equipo = 1;
                ControladorEquipo ce = new ControladorEquipo(vnew, 0, 0, controlador_principal, this, vpc, equipo);
                ControladorBD cBD = new ControladorBD();
                ArrayList<String> nombres_pokemon = new ArrayList();
                nombres_pokemon = cBD.obtenerNombresPokemones();
                    vnew.setJL_Pokemon1(nombres_pokemon);
                    vnew.setJL_Pokemon2(nombres_pokemon);
                    vnew.setJL_Pokemon3(nombres_pokemon);
                    vnew.setJL_Pokemon4(nombres_pokemon);
                    vnew.setJL_Pokemon5(nombres_pokemon);
                    vnew.setJL_Pokemon6(nombres_pokemon);
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vpc.getBotonEquipo2()== (JButton) e.getSource()){
            VistaNuevoEquipo vnew = new VistaNuevoEquipo();
            try {
                int equipo = 2;
                ControladorEquipo ce = new ControladorEquipo(vnew, 0, 0, controlador_principal, this, vpc, equipo);
                ControladorBD cBD = new ControladorBD();
                ArrayList<String> nombres_pokemon = new ArrayList();
                nombres_pokemon = cBD.obtenerNombresPokemones();
                    vnew.setJL_Pokemon1(nombres_pokemon);
                    vnew.setJL_Pokemon2(nombres_pokemon);
                    vnew.setJL_Pokemon3(nombres_pokemon);
                    vnew.setJL_Pokemon4(nombres_pokemon);
                    vnew.setJL_Pokemon5(nombres_pokemon);
                    vnew.setJL_Pokemon6(nombres_pokemon);
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    // ----------ACCIONES BOTONES DE ATAQUE-------------               
        if (vc.getBotonAtacar1() == (JButton) e.getSource()){
            va.setVistaAtaque(pokemon_activo1);
            va.setVisible(true);
           
        }
        if (vc.getBotonAtacar2() == (JButton) e.getSource()){
            va.setVistaAtaque(pokemon_activo2);
            va.setVisible(true);
            
        }
    //-------------ACCIONES DE LOS ATAQUES SELECCIONADOS DESDE EL PRIMERO HASTA EL CUARTO----------
    //-------------ACCION ATAQUE 1--------------------    
        if(va.getBotonAtaque1() == (JButton) e.getSource()){
            if(turno ==0){
                inflingirDaño(pokemon_activo1.getMovimientos()[0], pokemon_activo2, pokemon_activo1);
                if(pokemon_activo2.getVida_restante() <= 0){
                    pokemon_activo2.setVida_restante(0);
                    pokemon_activo2.setDebilitado(true);
                    JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador1.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador1.getNombre());
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador1);
                      combate.setPerdedor(entrenador2);
                    }
                    else if(getEquipo2()[0].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[0];   
                    }
                    else if(getEquipo2()[1].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[1];   
                    }
                    else if(getEquipo2()[2].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[2];   
                    }
                    else if(getEquipo2()[3].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[3];   
                    }
                    else if(getEquipo2()[4].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[4];   
                    }
                    else if(getEquipo2()[5].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[5];   
                    }
                    vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
                    vc.setjL_especie2(pokemon_activo2.getNombre_especie());
                    vc.setjL_Nivel2(pokemon_activo2.getNivel());
                    
                }
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador2.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                if(tipo_simulacion == 1){
                    JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Turno"+" "+entrenador2.getNombre());
                    vc.turnoJugador2();
                    this.turno = 1;
                }
                else if(tipo_simulacion == 2){
                    turnoSistema();
                }
            }
            else if(turno ==1){
                inflingirDaño(pokemon_activo2.getMovimientos()[0], pokemon_activo1, pokemon_activo2);
                if(pokemon_activo1.getVida_restante() <= 0){
                    pokemon_activo1.setVida_restante(0);
                    pokemon_activo1.setDebilitado(true);
                    JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador2.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador2.getNombre());
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador2);
                      combate.setPerdedor(entrenador1);
                    }
                    else if(getEquipo1()[0].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[0];   
                    }
                    else if(getEquipo1()[1].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[1];   
                    }
                    else if(getEquipo1()[2].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[2];   
                    }
                    else if(getEquipo1()[3].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[3];   
                    }
                    else if(getEquipo1()[4].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[4];   
                    }
                    else if(getEquipo1()[5].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[5];   
                    }
                    vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
                    vc.setjL_especie1(pokemon_activo1.getNombre_especie());
                    vc.setjL_Nivel1(pokemon_activo1.getNivel());
                }
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador1.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
                vc.turnoJugador1();
                this.turno = 0;
            }
        }
        //---------------ACCION ATAQUE 2 ---------------------
        if(va.getBotonAtaque2() == (JButton) e.getSource()){
            if(turno ==0){
                inflingirDaño(pokemon_activo1.getMovimientos()[1], pokemon_activo2, pokemon_activo1);
                if(pokemon_activo2.getVida_restante() <= 0){
                    pokemon_activo2.setVida_restante(0);
                    pokemon_activo2.setDebilitado(true);
                    JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador1.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador1.getNombre());
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador1);
                      combate.setPerdedor(entrenador2);
                    }
                    else if(getEquipo2()[0].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[0];   
                    }
                    else if(getEquipo2()[1].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[1];   
                    }
                    else if(getEquipo2()[2].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[2];   
                    }
                    else if(getEquipo2()[3].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[3];   
                    }
                    else if(getEquipo2()[4].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[4];   
                    }
                    else if(getEquipo2()[5].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[5];   
                    } 
                    vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
                    vc.setjL_especie2(pokemon_activo2.getNombre_especie());
                    vc.setjL_Nivel2(pokemon_activo2.getNivel());
                }
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador2.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                if(tipo_simulacion == 1){
                    JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Turno"+" "+entrenador2.getNombre());
                    vc.turnoJugador2();
                    this.turno = 1;
                }
                else if(tipo_simulacion == 2){
                    turnoSistema();
                }
            }
            else if(turno ==1){
                inflingirDaño(pokemon_activo2.getMovimientos()[1], pokemon_activo1, pokemon_activo2);
                if(pokemon_activo1.getVida_restante() <= 0){
                    pokemon_activo1.setVida_restante(0);
                    pokemon_activo1.setDebilitado(true);
                    JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador2.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador2.getNombre());
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador2);
                      combate.setPerdedor(entrenador1);
                    }
                    else if(getEquipo1()[0].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[0];   
                    }
                    else if(getEquipo1()[1].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[1];   
                    }
                    else if(getEquipo1()[2].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[2];   
                    }
                    else if(getEquipo1()[3].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[3];   
                    }
                    else if(getEquipo1()[4].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[4];   
                    }
                    else if(getEquipo1()[5].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[5];   
                    } 
                    vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
                    vc.setjL_especie1(pokemon_activo1.getNombre_especie());
                    vc.setjL_Nivel1(pokemon_activo1.getNivel());
                }
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador1.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
                vc.turnoJugador1();
                this.turno = 0;
            }
        }
        //-----------------ACCION ATAQUE 3------------------
        if(va.getBotonAtaque3() == (JButton) e.getSource()){
            if(turno ==0){
                inflingirDaño(pokemon_activo1.getMovimientos()[2], pokemon_activo2, pokemon_activo1);
                if(pokemon_activo2.getVida_restante() <= 0){
                     pokemon_activo2.setVida_restante(0);
                    pokemon_activo2.setDebilitado(true);
                    JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador1.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador1.getNombre());
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador1);
                      combate.setPerdedor(entrenador2);
                    }
                    else if(getEquipo2()[0].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[0];   
                    }
                    else if(getEquipo2()[1].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[1];   
                    }
                    else if(getEquipo2()[2].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[2];   
                    }
                    else if(getEquipo2()[3].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[3];   
                    }
                    else if(getEquipo2()[4].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[4];   
                    }
                    else if(getEquipo2()[5].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[5];   
                    }
                    vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
                    vc.setjL_especie2(pokemon_activo2.getNombre_especie());
                    vc.setjL_Nivel2(pokemon_activo2.getNivel());
                }
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador2.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                if(tipo_simulacion == 1){
                    JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Turno"+" "+entrenador2.getNombre());
                    vc.turnoJugador2();
                    this.turno = 1;
                }
                else if(tipo_simulacion == 2){
                    turnoSistema();
                }
            }
            else if(turno ==1){
                inflingirDaño(pokemon_activo2.getMovimientos()[2], pokemon_activo1, pokemon_activo2);
                if(pokemon_activo1.getVida_restante() <= 0){
                    pokemon_activo1.setVida_restante(0);
                    pokemon_activo1.setDebilitado(true);
                    JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador2.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador2.getNombre());
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador2);
                      combate.setPerdedor(entrenador1);
                    }
                    else if(getEquipo1()[0].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[0];   
                    }
                    else if(getEquipo1()[1].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[1];   
                    }
                    else if(getEquipo1()[2].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[2];   
                    }
                    else if(getEquipo1()[3].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[3];   
                    }
                    else if(getEquipo1()[4].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[4];   
                    }
                    else if(getEquipo1()[5].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[5];   
                    }  
                    vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
                    vc.setjL_especie1(pokemon_activo1.getNombre_especie());
                    vc.setjL_Nivel1(pokemon_activo1.getNivel());
                }
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador1.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
                vc.turnoJugador1();
                this.turno = 0;
            }
        }
        //------------------------ACCION ATAQUE 4------------------------
        if(va.getBotonAtaque4() == (JButton) e.getSource()){
            if(turno ==0){
                inflingirDaño(pokemon_activo1.getMovimientos()[3], pokemon_activo2, pokemon_activo1);
                if(pokemon_activo2.getVida_restante() <= 0){
                   pokemon_activo2.setVida_restante(0);
                    pokemon_activo2.setDebilitado(true);
                    JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador1.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador1.getNombre());
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador1);
                      combate.setPerdedor(entrenador2);
                    }
                    else if(getEquipo2()[0].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[0];   
                    }
                    else if(getEquipo2()[1].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[1];   
                    }
                    else if(getEquipo2()[2].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[2];   
                    }
                    else if(getEquipo2()[3].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[3];   
                    }
                    else if(getEquipo2()[4].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[4];   
                    }
                    else if(getEquipo2()[5].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[5];   
                    } 
                    vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
                    vc.setjL_especie2(pokemon_activo2.getNombre_especie());
                    vc.setjL_Nivel2(pokemon_activo2.getNivel());
                }
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador2.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                if(tipo_simulacion == 1){
                    JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Turno"+" "+entrenador2.getNombre());
                    vc.turnoJugador2();
                    this.turno = 1;
                }
                else if(tipo_simulacion == 2){
                    turnoSistema();
                }
            }
            else if(turno ==1){
                inflingirDaño(pokemon_activo2.getMovimientos()[3], pokemon_activo1, pokemon_activo2);
                if(pokemon_activo1.getVida_restante() <= 0){
                    pokemon_activo1.setVida_restante(0);
                    pokemon_activo1.setDebilitado(true);
                    JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador2.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador2.getNombre());
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador2);
                      combate.setPerdedor(entrenador1);
                    }
                    else if(getEquipo1()[0].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[0];   
                    }
                    else if(getEquipo1()[1].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[1];   
                    }
                    else if(getEquipo1()[2].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[2];   
                    }
                    else if(getEquipo1()[3].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[3];   
                    }
                    else if(getEquipo1()[4].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[4];   
                    }
                    else if(getEquipo1()[5].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[5];   
                    }  
                    vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
                    vc.setjL_especie1(pokemon_activo1.getNombre_especie());
                    vc.setjL_Nivel1(pokemon_activo1.getNivel());
                }
                va.setVisible(false);
                vc.setjL_Turno_actual(entrenador1.getNombre());
                vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
                vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
                vc.turnoJugador1();
                this.turno = 0;
            }
        }
        //-----------------ACCIONES BOTONES CAMBIAR----------------------
        if(vc.getBotonCambiar1() == (JButton) e.getSource()){
            ve.activarBotones();
            int index = -1;
            for (int j = 0; j < getEquipo1().length; j++) {
                if(getEquipo1()[j].equals(pokemon_activo1))
                    index=j;  
            }
            ve.setVistaCambio(getEquipo1(), pokemon_activo1, index);
            ve.setVisible(true);
        }
        if(vc.getBotonCambiar2() == (JButton) e.getSource()){
            ve.activarBotones();
            int index = -1;
            for (int j = 0; j < getEquipo2().length; j++) {
                if(getEquipo2()[j].equals(pokemon_activo2))
                    index=j;  
            }
            ve.setVistaCambio(getEquipo2(), pokemon_activo2, index);
            ve.setVisible(true);
        }
        //----------------SELECCION DE CADA POKEMON A CAMBIAR-------------
        //----------------CAMBIO POKEMON 1 -------------------------------
        if(ve.getBotonPokemon1() == (JButton) e.getSource()){
            if(turno == 0){
               this.pokemon_activo1 = this.getEquipo1()[0];
               ve.setVisible(false);
               vc.setjL_especie1(pokemon_activo1.getNombre_especie());
               vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
               vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
               vc.setjL_Nivel1(pokemon_activo1.getNivel());
               vc.setjL_Turno_actual(entrenador2.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador2.getNombre());
               vc.turnoJugador2();
               this.turno = 1;
            }
            else if(turno == 1){
               this.pokemon_activo2 = this.getEquipo2()[0];
               ve.setVisible(false);
               vc.setjL_especie2(pokemon_activo2.getNombre_especie());
               vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
               vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
               vc.setjL_Nivel2(pokemon_activo2.getNivel());
               vc.setjL_Turno_actual(entrenador1.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
               vc.turnoJugador1();
               this.turno = 0;
            }
        }
        //----------------CAMBIO POKEMON 2 -------------------------------
        if(ve.getBotonPokemon2() == (JButton) e.getSource()){
            if(turno == 0){
               this.pokemon_activo1 = this.getEquipo1()[1];
               ve.setVisible(false);
               vc.setjL_especie1(pokemon_activo1.getNombre_especie());
               vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
               vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
               vc.setjL_Nivel1(pokemon_activo1.getNivel());
               vc.setjL_Turno_actual(entrenador2.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador2.getNombre());
               vc.turnoJugador2();
               this.turno = 1;
            }
            else if(turno == 1){
               this.pokemon_activo2 = this.getEquipo2()[1];
               ve.setVisible(false);
               vc.setjL_especie2(pokemon_activo2.getNombre_especie());
               vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
               vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
               vc.setjL_Nivel2(pokemon_activo2.getNivel());
               vc.setjL_Turno_actual(entrenador1.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
               vc.turnoJugador1();
               this.turno = 0;
            }
        
        }
        //----------------CAMBIO POKEMON 3 -------------------------------
        if(ve.getBotonPokemon3() == (JButton) e.getSource()){
            if(turno == 0){
               this.pokemon_activo1 = this.getEquipo1()[2];
               ve.setVisible(false);
               vc.setjL_especie1(pokemon_activo1.getNombre_especie());
               vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
               vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
               vc.setjL_Nivel1(pokemon_activo1.getNivel());
               vc.setjL_Turno_actual(entrenador2.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador2.getNombre());
               vc.turnoJugador2();
               this.turno = 1;
            }
            else if(turno == 1){
               this.pokemon_activo2 = this.getEquipo2()[2];
               ve.setVisible(false);
               vc.setjL_especie2(pokemon_activo2.getNombre_especie());
               vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
               vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
               vc.setjL_Nivel2(pokemon_activo2.getNivel());
               vc.setjL_Turno_actual(entrenador1.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
               vc.turnoJugador1();
               this.turno = 0;
            }
        
        }
        //----------------CAMBIO POKEMON 4 -------------------------------
        if(ve.getBotonPokemon4() == (JButton) e.getSource()){
            if(turno == 0){
               this.pokemon_activo1 = this.getEquipo1()[3];
               ve.setVisible(false);
               vc.setjL_especie1(pokemon_activo1.getNombre_especie());
               vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
               vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
               vc.setjL_Nivel1(pokemon_activo1.getNivel());
               vc.setjL_Turno_actual(entrenador2.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador2.getNombre());
               vc.turnoJugador2();
               this.turno = 1;
            }
            else if(turno == 1){
               this.pokemon_activo2 = this.getEquipo2()[3];
               ve.setVisible(false);
               vc.setjL_especie2(pokemon_activo2.getNombre_especie());
               vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
               vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
               vc.setjL_Nivel2(pokemon_activo2.getNivel());
               vc.setjL_Turno_actual(entrenador1.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
               vc.turnoJugador1();
               this.turno = 0;
            }
        
        }
        //----------------CAMBIO POKEMON 5 -------------------------------
        if(ve.getBotonPokemon5() == (JButton) e.getSource()){
            if(turno == 0){
               this.pokemon_activo1 = this.getEquipo1()[4];
               ve.setVisible(false);
               vc.setjL_especie1(pokemon_activo1.getNombre_especie());
               vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
               vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
               vc.setjL_Nivel1(pokemon_activo1.getNivel());
               vc.setjL_Turno_actual(entrenador2.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador2.getNombre());
               vc.turnoJugador2();
               this.turno = 1;
            }
            else if(turno == 1){
               this.pokemon_activo2 = this.getEquipo2()[4];
               ve.setVisible(false);
               vc.setjL_especie2(pokemon_activo2.getNombre_especie());
               vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
               vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
               vc.setjL_Nivel2(pokemon_activo2.getNivel());
               vc.setjL_Turno_actual(entrenador1.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
               vc.turnoJugador1();
               this.turno = 0;
            }
        
        }
        //----------------CAMBIO POKEMON 6 -------------------------------
        if(ve.getBotonPokemon6() == (JButton) e.getSource()){
            if(turno == 0){
               this.pokemon_activo1 = this.getEquipo1()[5];
               ve.setVisible(false);
               vc.setjL_especie1(pokemon_activo1.getNombre_especie());
               vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
               vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
               vc.setjL_Nivel1(pokemon_activo1.getNivel());
               vc.setjL_Turno_actual(entrenador2.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador2.getNombre());
               vc.turnoJugador2();
               this.turno = 1;
            }
            else if(turno == 1){
               this.pokemon_activo2 = this.getEquipo2()[5];
               ve.setVisible(false);
               vc.setjL_especie2(pokemon_activo2.getNombre_especie());
               vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
               vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
               vc.setjL_Nivel2(pokemon_activo2.getNivel());
               vc.setjL_Turno_actual(entrenador1.getNombre());
               ve.setVisible(false);
               JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Turno"+" "+entrenador1.getNombre());
               vc.turnoJugador1();
               this.turno = 0;
            }
        
        }
        
                        
                    
                  
               
             
            
    }
        
        
             
    //------- VERIFICA SI EXISTE CONDICION DE VICTORIA-------------------
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
    
    
    //-----------FORMULA PARA LA ASIGNACION DE DAÑO ------------------------------
    public void inflingirDaño(MovimientoAprendido movimiento, Pokemon victima, Pokemon atacante){
        int vida_actual = victima.getVida_restante();
        int precision = movimiento.getPrecision();
        int tasa_fallo = 100-precision;
        double daño=0;
        double multiplicador_daño=1;
        int[] debilidades_victima = victima.getDebilidades();
        int[] fortalezas_victima = victima.getFortalezas();
        int daño_total;
        int pp_actual = movimiento.getPuntos_poder_restantes();
        int fallo = 1;
        double random = Math.random() * 100;
        if((random-=precision)<0) fallo=1;
        else if ((random-=tasa_fallo)<0) {
            fallo=0;
            System.out.println("El Ataque Seleccionado Fallo!");
        }
        
        if(movimiento.getContacto() == true){
            daño = (2*atacante.getNivel() + 10)*movimiento.getPotencia()*atacante.getAtaque()/(victima.getDefensa()*250);
        }
        else if(movimiento.getContacto() == false){
            daño = (2*atacante.getNivel() + 10 )*movimiento.getPotencia()*atacante.getAtaque_especial()/(victima.getDefensa_especial()*250);
        }
        
//        for (int i = 0; i < debilidades_victima.length; i++) {
//            if(movimiento.getTipo() == debilidades_victima[i]){
//                multiplicador_daño = 2.0;   
//            }
//        }
//        for (int j = 0; j < fortalezas_victima.length; j++){
//            if(movimiento.getTipo() == fortalezas_victima[j]){
//                multiplicador_daño = 1/2.0;
//            }
//        }    
        
        daño_total = (int) (daño*multiplicador_daño*fallo);
        int vida_neta = vida_actual-daño_total;
        victima.setVida_restante(vida_neta);
        movimiento.setPuntos_poder_restantes(pp_actual-1);
    }
    //Metodo que evalua la accion dependiendo de las debilidades y fortalezas
    //por el momento se genera aleatorio debido a la falta de las debilidades y fortalezas en la bd
    public String evaluarAccion(Pokemon atacante, Pokemon defensor){
//        int[] debilidades_atacante = atacante.getDebilidades();
//        for (int i = 0; i < debilidades_atacante.length; i++) {
//            if(debilidades_atacante[i] == defensor.getNaturaleza_primaria() || debilidades_atacante[i] == defensor.getNaturaleza_secundaria()){
//                return "Cambiar";
//            }
//            
//        }
//        return "Atacar";
        int random = (int)(Math.random()*2+1);
        if(random == 1){
            return "Atacar";
        }
        else{
            return "Cambiar";
        }
    }
    public void turnoSistema(){
        System.out.println("Turno: "+ entrenador2.getNombre());
        if(evaluarAccion(this.pokemon_activo2, this.pokemon_activo1).equals("Cambiar")){
            System.out.println("Sistema eligio Cambiar Pokemon");
                    if(getEquipo2()[0].getDebilitado() == false && getEquipo2()[0]!=pokemon_activo1){
                        pokemon_activo2 = getEquipo2()[0];   
                    }
                    else if(getEquipo2()[1].getDebilitado() == false && getEquipo2()[1]!=pokemon_activo1){
                        pokemon_activo2 = getEquipo2()[1];   
                    }
                    else if(getEquipo2()[2].getDebilitado() == false && getEquipo2()[2]!=pokemon_activo1){
                        pokemon_activo2 = getEquipo2()[2];   
                    }
                    else if(getEquipo2()[3].getDebilitado() == false && getEquipo2()[3]!=pokemon_activo1){
                        pokemon_activo2 = getEquipo2()[3];   
                    }
                    else if(getEquipo2()[4].getDebilitado() == false && getEquipo2()[4]!=pokemon_activo1){
                        pokemon_activo2 = getEquipo2()[4];   
                    }
                    else if(getEquipo2()[5].getDebilitado() == false && getEquipo2()[5]!=pokemon_activo1){
                        pokemon_activo2 = getEquipo2()[5];   
                    }
               vc.setjL_especie2(pokemon_activo2.getNombre_especie());
               vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
               vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
               vc.setjL_Nivel2(pokemon_activo2.getNivel());
               this.turno = 0;
        }
        else if(evaluarAccion(this.pokemon_activo2, this.pokemon_activo1).equals("Atacar")){
            System.out.println("Sistema eligio Atacar");
            inflingirDaño(pokemon_activo2.getMovimientos()[(int)(Math.random()*4)], pokemon_activo1, pokemon_activo2);
            if(pokemon_activo1.getVida_restante() <= 0){
                    pokemon_activo1.setVida_restante(0);
                    pokemon_activo1.setDebilitado(true);
                    System.out.println("El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador2.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador2.getNombre());
                        System.out.println(equipo1[0].getVida_restante()+ " "+equipo1[1].getVida_restante()+ " "+equipo1[2].getVida_restante()+ " "+equipo1[3].getVida_restante()+ " "+equipo1[4].getVida_restante()+ " "+equipo1[5].getVida_restante());
                        System.out.println(equipo2[0].getVida_restante()+ " "+equipo2[1].getVida_restante()+ " "+equipo2[2].getVida_restante()+ " "+equipo2[3].getVida_restante()+ " "+equipo2[4].getVida_restante()+ " "+equipo2[5].getVida_restante());
                      
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador2);
                      combate.setPerdedor(entrenador1);
                    }
                    else if(getEquipo1()[0].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[0];   
                    }
                    else if(getEquipo1()[1].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[1];   
                    }
                    else if(getEquipo1()[2].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[2];   
                    }
                    else if(getEquipo1()[3].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[3];   
                    }
                    else if(getEquipo1()[4].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[4];   
                    }
                    else if(getEquipo1()[5].getDebilitado() == false){
                        pokemon_activo1 = getEquipo1()[5];   
                    }  
                    vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
                    vc.setjL_especie1(pokemon_activo1.getNombre_especie());
                }
            vc.setjL_especie1(pokemon_activo1.getNombre_especie());
            vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
            vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
            vc.setjL_Nivel1(pokemon_activo1.getNivel());
            this.turno = 0;
        }
        
    }
    public void turnoUsuario(){
        System.out.println("Turno: "+ entrenador1.getNombre());
        if(evaluarAccion(this.pokemon_activo1, this.pokemon_activo2).equals("Cambiar")){
            System.out.println("Usuario eligio Cambiar Pokemon");
                    if(getEquipo1()[0].getDebilitado() == false && getEquipo1()[0]!=pokemon_activo1){
                        pokemon_activo1 = getEquipo1()[0];   
                    }
                    else if(getEquipo1()[1].getDebilitado() == false && getEquipo1()[1]!=pokemon_activo1){
                        pokemon_activo1 = getEquipo1()[1];   
                    }
                    else if(getEquipo1()[2].getDebilitado() == false && getEquipo1()[2]!=pokemon_activo1){
                        pokemon_activo1 = getEquipo1()[2];   
                    }
                    else if(getEquipo1()[3].getDebilitado() == false && getEquipo1()[3]!=pokemon_activo1){
                        pokemon_activo1 = getEquipo1()[3];   
                    }
                    else if(getEquipo1()[4].getDebilitado() == false && getEquipo1()[4]!=pokemon_activo1){
                        pokemon_activo1 = getEquipo1()[4];   
                    }
                    else if(getEquipo1()[5].getDebilitado() == false && getEquipo1()[5]!=pokemon_activo1){
                        pokemon_activo1 = getEquipo1()[5];   
                    }
               vc.setjL_especie1(pokemon_activo1.getNombre_especie());
               vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
               vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
               this.turno = 1;
        }
        else if(evaluarAccion(this.pokemon_activo1, this.pokemon_activo2).equals("Atacar")){
            System.out.println("Usuario eligio Atacar");
            inflingirDaño(pokemon_activo1.getMovimientos()[(int)(Math.random()*4)], pokemon_activo2, pokemon_activo1);
            if(pokemon_activo2.getVida_restante() <= 0){
                    pokemon_activo2.setVida_restante(0);
                    pokemon_activo2.setDebilitado(true);
                    System.out.println("El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado");
                    if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                      JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador1.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("El Ganador de este Combate es:"+ entrenador1.getNombre());
                        System.out.println(equipo1[0].getVida_restante()+ " "+equipo1[1].getVida_restante()+ " "+equipo1[2].getVida_restante()+ " "+equipo1[3].getVida_restante()+ " "+equipo1[4].getVida_restante()+ " "+equipo1[5].getVida_restante());
                        System.out.println(equipo2[0].getVida_restante()+ " "+equipo2[1].getVida_restante()+ " "+equipo2[2].getVida_restante()+ " "+equipo2[3].getVida_restante()+ " "+equipo2[4].getVida_restante()+ " "+equipo2[5].getVida_restante());
                      vc.dispose();
                      vpc.dispose();
                      combate.setGanador(entrenador1);
                      combate.setPerdedor(entrenador2);
                    }
                    else if(getEquipo1()[0].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[0];   
                    }
                    else if(getEquipo1()[1].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[1];   
                    }
                    else if(getEquipo1()[2].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[2];   
                    }
                    else if(getEquipo1()[3].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[3];   
                    }
                    else if(getEquipo1()[4].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[4];   
                    }
                    else if(getEquipo1()[5].getDebilitado() == false){
                        pokemon_activo2 = getEquipo2()[5];   
                    }  
                    vc.setjL_nombrepokemon1(pokemon_activo2.getPseudonimo());
                    vc.setjL_especie1(pokemon_activo2.getNombre_especie());
                }
            vc.setjL_especie2(pokemon_activo2.getNombre_especie());
            vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
            vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
            this.turno = 1;
        }
        
    }

    public Pokemon[] getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Pokemon[] equipo1) {
        this.equipo1 = equipo1;
    }

    public Pokemon[] getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Pokemon[] equipo2) {
        this.equipo2 = equipo2;
    }
    
  
}
    
        

