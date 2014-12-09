/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.ConexionBD;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
    private int tipo_simulacion; //Us vs Us (1), Us vs Sist (2), Us vs Sist simulado(0)
    private Combate combate;
    private int turno;
    private Pokemon[] equipo1;
    private Pokemon[] equipo2;
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Pokemon pokemon_activo1;
    private Pokemon pokemon_activo2;
    private ControladorPrincipal controlador_principal;
    private ControladorRegistros creg;
    
    
    
    
    //Acciones que se ejecutan al instanciar el controlador, crea las vistas necesarias y asigna entrenadores y equipos
    public ControladorCombate(int tipo_simulacion,
            Entrenador entrenador1, Entrenador entrenador2, ControladorPrincipal cp){
        
        this.controlador_principal = cp;
        this.tipo_simulacion = tipo_simulacion;
        
        this.combate = new Combate();
        this.equipo1 = entrenador1.getPokemones();
        this.equipo2 = entrenador2.getPokemones();
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.vc = new VistaCombate();
        this.va = new VistaAtaque();
        this.ve = new VistaEquipo();
        this.creg = new ControladorRegistros();
        String[] nombres1 = new String[6];
        String[] nombres2 = new String[6];
        for (int i = 0; i < 6; i++) {
            nombres1[i]=equipo1[i].getPseudonimo();
            nombres2[i]=equipo2[i].getPseudonimo();    
        }
        this.vpc = new VistaPreviaCombate(tipo_simulacion, entrenador1.getNombre(), entrenador2.getNombre());
        this.vpc.agregarListener(this);
        this.vpc.setjC_Equipo1(nombres1);
        this.vpc.setjC_Equipo2(nombres2);
        this.vpc.setVisible(true);
        
    }
    
    //El controlador escucha a la vista correspondiente
    @Override
    public void actionPerformed(ActionEvent e) {
        //-------------------- ASIGNACIONES INICIALES PARA EL COMBATE-------------------
        //Aqui se cargan todas las vistas y parametros iniciales, se llenan los label, etc
        //Este boton es el de iniciar combate en la vista previa combate
        if (vpc.getBotonIniciar() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario inicio el combate");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            va.agregarListener(this);
            ve.agregarListener(this);
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
                vc.setjL_distincion1(entrenador1.getDistincion());
                vc.setjL_distincion2(entrenador2.getDistincion());
            this.turno = 0;
            this.pokemon_activo1 = getEquipo1()[Index_inicial1];
            this.pokemon_activo2 = getEquipo2()[Index_inicial2];
            vc.setVisible(true);
            if(tipo_simulacion == 1 || tipo_simulacion == 2){
                JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
                vc.turnoJugador1();
                System.out.println("Turno"+" "+entrenador1.getNombre());
                try {
                    creg.guardarRegistroSimulacion("Turno"+" "+entrenador1.getNombre());
                } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                }
                vc.setjL_Turno_actual(entrenador1.getNombre());
            }
            else{
               JOptionPane.showMessageDialog(this.vc, "Comenzando Simulacion Completa de un Combate Usuario vs Sistema", "Comienzo Simulacion", JOptionPane.INFORMATION_MESSAGE); 
               vc.turnoSimulacion();
               try {
                    creg.guardarRegistroSimulacion("Comenzando simulacion completa usuario vs sistema");
                } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (condicionVictoria(getEquipo1(), getEquipo2())==false){
                    turnoUsuario();
                    turnoSistema();
                }
            }
            
        }
        // Para cambiar a un equipo personalizado distinto al que se posee para el primer entrenador
        if(vpc.getBotonEquipo1()== (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Jugador1 eligió cambiar su equipo por uno personalizado");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            VistaNuevoEquipo vnew = new VistaNuevoEquipo();
            try {
                int equipo = 1;
                ControladorEquipo ce = new ControladorEquipo(vnew, 0, 0, controlador_principal, this, vpc, equipo);
                ConexionBD cBD = new ConexionBD();
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
        
        // Lo mismo pero para el segundo
        if(vpc.getBotonEquipo2()== (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Jugador2 eligió cambiar su equipo por uno personalizado");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            VistaNuevoEquipo vnew = new VistaNuevoEquipo();
            try {
                int equipo = 2;
                ControladorEquipo ce = new ControladorEquipo(vnew, 0, 0, controlador_principal, this, vpc, equipo);
                ConexionBD cBD = new ConexionBD();
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
        //Boton ataque jugador 1
        //Setea la vista para los movimientos del pokemon activo del jugador 1
        if (vc.getBotonAtacar1() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Jugador1 eligio atacar");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            va.setVistaAtaque(pokemon_activo1);
            va.setVisible(true);
           
        }
        //Boton ataque jugador 2
        //Setea la vista para los movimientos del pokemon activo del jugador 2
        if (vc.getBotonAtacar2() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Jugador2 eligió atacar");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            va.setVistaAtaque(pokemon_activo2);
            va.setVisible(true);
            
        }
    //-------------ACCIONES DE LOS ATAQUES SELECCIONADOS DESDE EL PRIMERO HASTA EL CUARTO----------
    //-------------ACCION ATAQUE 1--------------------    
    // Boton para el primer ataque de la lista de movimientos del pokemon seleccionado    
        if(va.getBotonAtaque1() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligió atacar con el primer ataque");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionAtaques(0);
        }
        
    //---------------------ACCION ATAQUE 2 ------------------
    // Boton para el segundo ataque de la lista de movimientos del pokemon seleccionado 
        if(va.getBotonAtaque2() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligió atacar con el segundo ataque");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionAtaques(1);
        }
        
    //-----------------ACCION ATAQUE 3------------------
    // Boton para el tercer ataque de la lista de movimientos del pokemon seleccionado 
        if(va.getBotonAtaque3() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligió atacar con el tercer ataque");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionAtaques(2);
        }
        
    //-----------------ACCION ATAQUE 4-------------------
    // Boton para el cuarto ataque de la lista de movimientos del pokemon seleccionado 
        if(va.getBotonAtaque4() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligió atacar con el cuarto ataque");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionAtaques(3);
        }
        
    //-----------------ACCIONES BOTONES CAMBIAR---------
    //Boton cambiar del primer jugador
        if(vc.getBotonCambiar1() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Jugador1 eligió cambiar de pokemon");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            ve.activarBotones();
            int index = -1;
            for (int j = 0; j < getEquipo1().length; j++) {
                if(getEquipo1()[j].equals(pokemon_activo1))
                    index=j;  
            }
            ve.setVistaCambio(getEquipo1(), pokemon_activo1, index);
            ve.setVisible(true);
        }
    //Boton cambiar del segundo jugador    
        if(vc.getBotonCambiar2() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Jugador2 eligió cambiar de pokemon");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        //Boton que ejecuta las acciones cuando se selecciona al primer pokemon del equipo para el cambio
        if(ve.getBotonPokemon1() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar el pokemon activo por el primero de su lista");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionCambios(0);
        }
        
        //----------------CAMBIO POKEMON 2 -------------------------------
        //Boton que ejecuta las acciones cuando se selecciona al segundo pokemon del equipo para el cambio
        if(ve.getBotonPokemon2() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar el pokemon activo por el segundo de su lista");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionCambios(1);
        
        }
        
        //----------------CAMBIO POKEMON 3 -------------------------------
        //Boton que ejecuta las acciones cuando se selecciona al tercer pokemon del equipo para el cambio
        if(ve.getBotonPokemon3() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar el pokemon activo por el tercero de su lista");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionCambios(2);
        
        }
        
        //----------------CAMBIO POKEMON 4 -------------------------------
        //Boton que ejecuta las acciones cuando se selecciona al cuarto pokemon del equipo para el cambio
        if(ve.getBotonPokemon4() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar el pokemon activo por el cuarto de su lista");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionCambios(3);
        
        }
        
        //----------------CAMBIO POKEMON 5 -------------------------------
        //Boton que ejecuta las acciones cuando se selecciona al quinto pokemon del equipo para el cambio
        if(ve.getBotonPokemon5() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar el pokemon activo por el quinto de su lista");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionCambios(4);
        
        }
        //----------------CAMBIO POKEMON 6 -------------------------------
        //Boton que ejecuta las acciones cuando se selecciona al sexto pokemon del equipo para el cambio
        if(ve.getBotonPokemon6() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar el pokemon activo por el sexto de su lista");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            accionCambios(5);
        
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
    
    //Metodo para cada ataque seleccionado por el usuario, la entrada corresponde a la posicion del ataque en el arreglo, de 0 a 3
    //Dependiendo del numero con el cual se llamo se ejecutaran las respectivas acciones para el respectivo movimiento
    public void accionAtaques(int i){
        if(turno ==0){
          if(pokemon_activo1.getCongelado() == false || pokemon_activo1.getDormido() == false){
              if(pokemon_activo1.getConfuso() == true && (int)(Math.random()*100) > 50){
                 inflingirDaño(pokemon_activo1.getMovimientos()[i], pokemon_activo1, pokemon_activo1);
                  System.out.println("El pokemon se ha hecho daño a si mismo!");
                  try {
                    creg.guardarRegistroSimulacion("El pokemon se ha hecho daño a si mismo");
                } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
              }
              else{
            inflingirDaño(pokemon_activo1.getMovimientos()[i], pokemon_activo2, pokemon_activo1);
            if(pokemon_activo2.getVida_restante() <= 0){
                pokemon_activo2.setVida_restante(0);
                pokemon_activo2.setDebilitado(true);
                JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado");
                try {
                    creg.guardarRegistroSimulacion("El Pokemon:  "+ pokemon_activo2.getPseudonimo()+"   se ha Debilitado");
                } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                    JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador1.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Ganador de este Combate es:"+ entrenador1.getNombre());
                    try {
                    creg.guardarRegistroSimulacion("El Ganador de este Combate es:"+ entrenador1.getNombre());
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                try {
                    creg.guardarRegistroSimulacion("Turno"+" "+entrenador2.getNombre());
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                vc.turnoJugador2();
                this.turno = 1;
            }
            else if(tipo_simulacion == 2){
                    turnoSistema();
            }
           }
          }
          else {
              System.out.println("El pokemon no puede atacar");
              try {
                    creg.guardarRegistroSimulacion("El pokemon no puede atacar");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
              if((int)(Math.random()*3) == 1){ //1/3 de probabilidad de desactivar el efecto
                pokemon_activo1.setCongelado(false);
                pokemon_activo1.setDormido(false);
              }
          }
            
        }
        else if(turno ==1){
            if(pokemon_activo2.getCongelado() == false || pokemon_activo2.getDormido() == false){
              if(pokemon_activo2.getConfuso() == true && (int)(Math.random()*100) > 50){
                 inflingirDaño(pokemon_activo2.getMovimientos()[i], pokemon_activo2, pokemon_activo2);
                  System.out.println("El pokemon se ha hecho daño a si mismo!");
                  try {
                    creg.guardarRegistroSimulacion("El pokemon se ha hecho daño a si mismo!");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
              }
              else{
            inflingirDaño(pokemon_activo2.getMovimientos()[i], pokemon_activo1, pokemon_activo2);
            if(pokemon_activo1.getVida_restante() <= 0){
                pokemon_activo1.setVida_restante(0);
                pokemon_activo1.setDebilitado(true);
                JOptionPane.showMessageDialog(this.vc, "El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado", "Debilitado", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado");
                try {
                    creg.guardarRegistroSimulacion("El Pokemon:  "+ pokemon_activo1.getPseudonimo()+"   se ha Debilitado");
                } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(condicionVictoria(getEquipo1(), getEquipo2()) == true){
                    JOptionPane.showMessageDialog(this.vc, "El Ganador de este Combate es:"+ entrenador2.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("El Ganador de este Combate es:"+ entrenador2.getNombre());
                    try {
                    creg.guardarRegistroSimulacion("El Ganador de este Combate es:"+ entrenador2.getNombre());
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                    creg.guardarRegistroSimulacion("Turno"+" "+entrenador1.getNombre());
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
            vc.turnoJugador1();
            this.turno = 0;
              }
            }
            else {
              System.out.println("El pokemon no puede atacar");
              try {
                    creg.guardarRegistroSimulacion("El pokemon no puede atacar");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
              if((int)(Math.random()*3) == 1){ //1/3 de probabilidad de desactivar el efecto
                pokemon_activo2.setCongelado(false);
                pokemon_activo2.setDormido(false);
              }
            }
        }
       setLabelEstados(1);
       setLabelEstados(0);     
        
    }
    
    //Metodo para cada pokemon seleccionado para el cambio, la entrada corresponde a la posicion del pokemon en el arreglo, de 0 a 5
    //Lo mismo que los ataques pero para el cambio
    public void accionCambios(int i){
        
        if(turno == 0){
            pokemon_activo1.setConfuso(false);
            pokemon_activo1.setDormido(false);
            this.pokemon_activo1 = this.getEquipo1()[i];
            ve.setVisible(false);
            vc.setjL_especie1(pokemon_activo1.getNombre_especie());
            vc.setjL_nombrepokemon1(pokemon_activo1.getPseudonimo());
            vc.setjL_vida_actual1(pokemon_activo1.getVida_restante(), pokemon_activo1.getVida());
            vc.setjL_Nivel1(pokemon_activo1.getNivel());
            vc.setjL_Turno_actual(entrenador2.getNombre());
            ve.setVisible(false);
            JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador2.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Turno"+" "+entrenador2.getNombre());
                    try {
                    creg.guardarRegistroSimulacion("Turno"+" "+entrenador2.getNombre());
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
            vc.turnoJugador2();
            this.turno = 1;
            setLabelEstados(1);
            setLabelEstados(0);
        }
        else if(turno == 1){
            pokemon_activo2.setConfuso(false);
            pokemon_activo2.setDormido(false);
            this.pokemon_activo2 = this.getEquipo2()[i];
            ve.setVisible(false);
            vc.setjL_especie2(pokemon_activo2.getNombre_especie());
            vc.setjL_nombrepokemon2(pokemon_activo2.getPseudonimo());
            vc.setjL_vida_actual2(pokemon_activo2.getVida_restante(), pokemon_activo2.getVida());
            vc.setjL_Nivel2(pokemon_activo2.getNivel());
            vc.setjL_Turno_actual(entrenador1.getNombre());
            ve.setVisible(false);
            JOptionPane.showMessageDialog(this.vc, "Turno"+" "+entrenador1.getNombre(), "Tu Turno", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Turno"+" "+entrenador1.getNombre());
                    try {
                    creg.guardarRegistroSimulacion("Turno"+" "+entrenador1.getNombre());
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
            vc.turnoJugador1();
            this.turno = 0;
            setLabelEstados(1);
            setLabelEstados(0);
        }
    }
    
    
    //-----------FORMULA PARA LA ASIGNACION DE DAÑO ------------------------------
    //Se deshabilito la verificacion de debilidad al no presentarse en la bd
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
            try {
                    creg.guardarRegistroSimulacion("El Ataque Seleccionado Fallo!");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        if(movimiento.getContacto() == true){
            daño = (2*atacante.getNivel() + 10)*movimiento.getPotencia()*atacante.getAtaque()/(victima.getDefensa()*250);
        }
        else if(movimiento.getContacto() == false){
            daño = (2*atacante.getNivel() + 10 )*movimiento.getPotencia()*atacante.getAtaque_especial()/(victima.getDefensa_especial()*250);
        }
        
        if(movimiento.getConfunde() == true && (int)(Math.random()*100) > 20){ //Porcentaje arbitrario del 20% de inflingir cambio de estado
           if(victima.getParalizado() == true) victima.setParalizado(false); //Desactiva los estados que no son compatibles entre si
           if(victima.getCongelado()== true) victima.setCongelado(false);
           if(victima.getDormido()== true) victima.setDormido(false);
           victima.setConfuso(true);
            System.out.println(victima.getPseudonimo()+" Ha sido confundido!");
                    try {
                    creg.guardarRegistroSimulacion(victima.getPseudonimo()+" Ha sido confundido!");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        if(movimiento.getCongela() == true && (int)(Math.random()*100) > 20){ //Porcentaje arbitrario del 20% de inflingir cambio de estado
           if(victima.getParalizado() == true) victima.setParalizado(false); //Desactiva los estados que no son compatibles entre si
           if(victima.getEnvenenado()== true) victima.setEnvenenado(false);
           if(victima.getDormido()== true) victima.setDormido(false);
           if(victima.getConfuso()== true) victima.setConfuso(false);
           if(victima.getQuemado()== true) victima.setQuemado(false);
            victima.setCongelado(true);
            System.out.println(victima.getPseudonimo()+" Ha sido congelado!");
            try {
                    creg.guardarRegistroSimulacion(victima.getPseudonimo()+" Ha sido congelado!");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        if(movimiento.getDuerme() == true && (int)(Math.random()*100) > 20){ //Porcentaje arbitrario del 20% de inflingir cambio de estado
           if(victima.getConfuso()== true) victima.setConfuso(false); //Desactiva los estados que no son compatibles entre si
           if(victima.getParalizado()== true) victima.setParalizado(false);
           if(victima.getCongelado()== true) victima.setCongelado(false);
           victima.setDormido(true);
           System.out.println(victima.getPseudonimo()+" Ha sido dormido!");
           try {
                    creg.guardarRegistroSimulacion(victima.getPseudonimo()+" Ha sido dormido!");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        if(movimiento.getEnvenena() == true && (int)(Math.random()*100) > 20){ //Porcentaje arbitrario del 20% de inflingir cambio de estado
            if(victima.getCongelado()== true) victima.setCongelado(false); //Desactiva los estados que no son compatibles entre si
            if(victima.getQuemado()== true) victima.setQuemado(false);
            victima.setEnvenenado(true);
            System.out.println(victima.getPseudonimo()+" Ha sido envenenado!");
            try {
                    creg.guardarRegistroSimulacion(victima.getPseudonimo()+" Ha sido envenenado!");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        if(movimiento.getParaliza() == true && (int)(Math.random()*100) > 20){ //Porcentaje arbitrario del 20% de inflingir cambio de estado
            if(victima.getCongelado()== true) victima.setCongelado(false); //Desactiva los estados que no son compatibles entre si
            if(victima.getDormido()== true) victima.setDormido(false);
            if(victima.getConfuso()== true) victima.setConfuso(false);
            victima.setParalizado(true);
            System.out.println(victima.getPseudonimo()+" Ha sido paralizado!");
            try {
                    creg.guardarRegistroSimulacion(victima.getPseudonimo()+" Ha sido paralizado!");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        if(movimiento.getQuema() == true && (int)(Math.random()*100) > 20){ //Porcentaje arbitrario del 20% de inflingir cambio de estado
            if(victima.getCongelado()== true) victima.setCongelado(false); //Desactiva los estados que no son compatibles entre si
            if(victima.getEnvenenado()== true) victima.setEnvenenado(false);
            victima.setQuemado(true);
            System.out.println(victima.getPseudonimo()+" Ha sido quemado!");
            try {
                    creg.guardarRegistroSimulacion(victima.getPseudonimo()+" Ha sido quemado!");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
        try {
                    creg.guardarRegistroSimulacion("Daño inflingido : "+daño_total+" puntos");
                    } catch (IOException ex) {
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
    
    //Simulador del turno del sistema en simulaciones parciales o completas
    public void turnoSistema(){
        System.out.println("Turno: "+ entrenador2.getNombre());
        if(evaluarAccion(this.pokemon_activo2, this.pokemon_activo1).equals("Cambiar")){
            System.out.println("Sistema eligio Cambiar Pokemon");
                    pokemon_activo2.setConfuso(false);
                    pokemon_activo2.setDormido(false);
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
               setLabelEstados(0);
                setLabelEstados(1);
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
            setLabelEstados(0);
            setLabelEstados(1);
            this.turno = 0;
        }
        
    }
    
    //Simulacion del turno del usuario o primer jugador en simulaciones completas
    public void turnoUsuario(){
        System.out.println("Turno: "+ entrenador1.getNombre());
        if(evaluarAccion(this.pokemon_activo1, this.pokemon_activo2).equals("Cambiar")){
            System.out.println("Usuario eligio Cambiar Pokemon");
            pokemon_activo1.setConfuso(false);
            pokemon_activo1.setDormido(false);
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
               setLabelEstados(0);
                setLabelEstados(1);
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
            setLabelEstados(0);
            setLabelEstados(1);
            this.turno = 1;
        }
        
    }
    //Setea el estado que posee el pokemon activo
    public void setLabelEstados(int pokemon){
        if(pokemon ==0){
            if(pokemon_activo1.getConfuso() == true) vc.setjL_Estado1("Confuso");
            else if(pokemon_activo1.getCongelado()== true) vc.setjL_Estado1("Congelado");
            else if(pokemon_activo1.getDormido()== true) vc.setjL_Estado1("Dormido");
            else if(pokemon_activo1.getEnvenenado()== true) vc.setjL_Estado1("Envenenado");
            else if(pokemon_activo1.getParalizado()== true) vc.setjL_Estado1("Paralizado");
            else if(pokemon_activo1.getQuemado()== true) vc.setjL_Estado1("Quemado");
            else if(pokemon_activo1.getCongelado() == false && pokemon_activo1.getDormido() == false && pokemon_activo1.getEnvenenado() == false && 
                  pokemon_activo1.getParalizado() == false && pokemon_activo1.getQuemado() == false){
              vc.setjL_Estado1("Normal");
          }
        }
        if(pokemon ==1){
            if(pokemon_activo2.getConfuso() == true) vc.setjL_Estado2("Confuso");
            else if(pokemon_activo2.getCongelado()== true) vc.setjL_Estado2("Congelado");
            else if(pokemon_activo2.getDormido()== true) vc.setjL_Estado2("Dormido");
            else if(pokemon_activo2.getEnvenenado()== true) vc.setjL_Estado2("Envenenado");
            else if(pokemon_activo2.getParalizado()== true) vc.setjL_Estado2("Paralizado");
            else if(pokemon_activo2.getQuemado()== true) vc.setjL_Estado2("Quemado");
            else if(pokemon_activo2.getCongelado() == false && pokemon_activo2.getDormido() == false && pokemon_activo2.getEnvenenado() == false && 
                  pokemon_activo2.getParalizado() == false && pokemon_activo2.getQuemado() == false){
              vc.setjL_Estado2("Normal");
            }
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
    
        

