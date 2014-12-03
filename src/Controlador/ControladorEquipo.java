/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.ConexionBD;
import Modelo.MovimientoAprendido;
import Modelo.Pokemon;
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
public class ControladorEquipo implements ActionListener{
    private VistaNuevoEquipo vista;
    private VistaNuevosMovimientos vista_mov;
    private Pokemon[] equipo;
    private ConexionBD cBD;
    private MovimientoAprendido[] movimientos1;
    private MovimientoAprendido[] movimientos2;
    private MovimientoAprendido[] movimientos3;
    private MovimientoAprendido[] movimientos4;
    private MovimientoAprendido[] movimientos5;
    private MovimientoAprendido[] movimientos6;
    private int seleccion;
    private int nuevo_o_temporal;   //Nuevo = 1, Temporal = 0
    private int id_entrenador;
    private Boolean movimientos1_activados;
    private Boolean movimientos2_activados;
    private Boolean movimientos3_activados;
    private Boolean movimientos4_activados;
    private Boolean movimientos5_activados;
    private Boolean movimientos6_activados;
    private ControladorPrincipal controlador_principal;
    private ControladorCombate controlador_combate;
    private VistaPreviaCombate vpc;
    private int equipo_modificado;
    private ControladorRegistros creg;
    
    
    
    public ControladorEquipo(VistaNuevoEquipo vnew,   
            int cambio_o_nuevo, int id_entrenador, ControladorPrincipal cp) throws SQLException{
        this.controlador_principal = cp;
        this.cBD = new ConexionBD();
        this.vista_mov = new VistaNuevosMovimientos();
            vista_mov.agregarListener(this);
        this.vista = vnew;
            vista.agregarListener(this);
            vista.desactivarBotonListo();
            vista.setVisible(true);
        this.nuevo_o_temporal = cambio_o_nuevo;
        this.id_entrenador = id_entrenador;
        ArrayList<String> JLmovimientos = cBD.obtenerTodosNombresMovimientos();
            vista_mov.setJL_movimientos1(JLmovimientos);
            vista_mov.setJL_movimientos2(JLmovimientos);
            vista_mov.setJL_movimientos3(JLmovimientos);
            vista_mov.setJL_movimientos4(JLmovimientos);
        this.movimientos1 = new MovimientoAprendido[4];
        this.movimientos2 = new MovimientoAprendido[4];
        this.movimientos3 = new MovimientoAprendido[4];
        this.movimientos4 = new MovimientoAprendido[4];
        this.movimientos5 = new MovimientoAprendido[4];
        this.movimientos6 = new MovimientoAprendido[4];
        this.movimientos1_activados = false;
        this.movimientos2_activados = false;
        this.movimientos3_activados = false;
        this.movimientos4_activados = false;
        this.movimientos5_activados = false;
        this.movimientos6_activados = false;
        this.creg = new ControladorRegistros();
        
    }
    public ControladorEquipo(VistaNuevoEquipo vnew,   
            int cambio_o_nuevo, int id_entrenador, ControladorPrincipal cp, ControladorCombate cc, VistaPreviaCombate vpc, 
            int equipo) throws SQLException{
        this.equipo_modificado = equipo;
        this.controlador_combate = cc;
        this.vpc = vpc;
        this.controlador_principal = cp;
        this.cBD = new ConexionBD();
        this.vista_mov = new VistaNuevosMovimientos();
            vista_mov.agregarListener(this);
        this.vista = vnew;
            vista.agregarListener(this);
            vista.desactivarBotonListo();
            vista.setVisible(true);
        this.nuevo_o_temporal = cambio_o_nuevo;
        this.id_entrenador = id_entrenador;
        ArrayList<String> JLmovimientos = cBD.obtenerTodosNombresMovimientos();
            vista_mov.setJL_movimientos1(JLmovimientos);
            vista_mov.setJL_movimientos2(JLmovimientos);
            vista_mov.setJL_movimientos3(JLmovimientos);
            vista_mov.setJL_movimientos4(JLmovimientos);
        this.movimientos1 = new MovimientoAprendido[4];
        this.movimientos2 = new MovimientoAprendido[4];
        this.movimientos3 = new MovimientoAprendido[4];
        this.movimientos4 = new MovimientoAprendido[4];
        this.movimientos5 = new MovimientoAprendido[4];
        this.movimientos6 = new MovimientoAprendido[4];
        this.movimientos1_activados = false;
        this.movimientos2_activados = false;
        this.movimientos3_activados = false;
        this.movimientos4_activados = false;
        this.movimientos5_activados = false;
        this.movimientos6_activados = false;
        this.creg = new ControladorRegistros();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.getjB_Listo()== (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio sus pokemon, movimientos, nombres y niveles");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            int nivel1 = vista.getjS_Nivel1();
            int nivel2 = vista.getjS_Nivel2();
            int nivel3 = vista.getjS_Nivel3();
            int nivel4 = vista.getjS_Nivel4();
            int nivel5 = vista.getjS_Nivel5();
            int nivel6 = vista.getjS_Nivel6();
            String nombre1 = vista.getJL_Pokemon1();
            String nombre2 = vista.getJL_Pokemon2();
            String nombre3 = vista.getJL_Pokemon3();
            String nombre4 = vista.getJL_Pokemon4();
            String nombre5 = vista.getJL_Pokemon5();
            String nombre6 = vista.getJL_Pokemon6();
            String pseudonimo1 = vista.getPseudonimo1();
            String pseudonimo2 = vista.getPseudonimo2();
            String pseudonimo3 = vista.getPseudonimo3();
            String pseudonimo4 = vista.getPseudonimo4();
            String pseudonimo5 = vista.getPseudonimo5();
            String pseudonimo6 = vista.getPseudonimo6();
            
            try {
                this.equipo = cBD.crearEquipoPokemon(nombre1, nombre2, nombre3, nombre4, nombre5, nombre6, 
                        nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, pseudonimo1, pseudonimo2, pseudonimo3, 
                        pseudonimo4, pseudonimo5, pseudonimo6);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(this.nuevo_o_temporal == 0){
                this.equipo[0].setMovimientos(movimientos1);
                this.equipo[1].setMovimientos(movimientos2);
                this.equipo[2].setMovimientos(movimientos3);
                this.equipo[3].setMovimientos(movimientos4);
                this.equipo[4].setMovimientos(movimientos5);
                this.equipo[5].setMovimientos(movimientos6); 
                if(equipo_modificado == 1){
                    controlador_combate.setEquipo1(equipo); 
                    String[] nombres = new String[6];
                    for (int i = 0; i < 6; i++) {
                        nombres[i]=equipo[i].getPseudonimo();   
                    }
                vpc.removerJc_Pokemons1();
                vpc.setjC_Equipo1(nombres);
                JOptionPane.showMessageDialog(this.vpc, "El Equpo temporal esta Listo!", "Equipo Agregado", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(equipo_modificado == 2){
                    controlador_combate.setEquipo2(equipo); 
                    String[] nombres = new String[6];
                    for (int i = 0; i < 6; i++) {
                        nombres[i]=equipo[i].getPseudonimo();   
                    }
                vpc.removerJc_Pokemons2();
                vpc.setjC_Equipo2(nombres);
                JOptionPane.showMessageDialog(this.vpc, "El Equpo temporal esta Listo!", "Equipo Agregado", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
            else{
                try {
                    int id1 = cBD.guardarPokemon(equipo[0].getId_pokedex(), equipo[0].getPseudonimo(), equipo[0].getNivel(),
                            equipo[0].getVida(), equipo[0].getAtaque(), equipo[0].getAtaque_especial(), equipo[0].getDefensa(),
                            equipo[0].getDefensa_especial(), equipo[0].getVelocidad());
                    int id2 = cBD.guardarPokemon(equipo[1].getId_pokedex(), equipo[1].getPseudonimo(), equipo[1].getNivel(),
                            equipo[1].getVida(), equipo[1].getAtaque(), equipo[1].getAtaque_especial(), equipo[1].getDefensa(),
                            equipo[1].getDefensa_especial(), equipo[1].getVelocidad());
                    int id3 = cBD.guardarPokemon(equipo[2].getId_pokedex(), equipo[2].getPseudonimo(), equipo[2].getNivel(),
                            equipo[2].getVida(), equipo[2].getAtaque(), equipo[2].getAtaque_especial(), equipo[2].getDefensa(),
                            equipo[2].getDefensa_especial(), equipo[2].getVelocidad());
                    int id4 = cBD.guardarPokemon(equipo[3].getId_pokedex(), equipo[3].getPseudonimo(), equipo[3].getNivel(),
                            equipo[3].getVida(), equipo[3].getAtaque(), equipo[3].getAtaque_especial(), equipo[3].getDefensa(),
                            equipo[3].getDefensa_especial(), equipo[3].getVelocidad());
                    int id5 = cBD.guardarPokemon(equipo[4].getId_pokedex(), equipo[4].getPseudonimo(), equipo[4].getNivel(),
                            equipo[4].getVida(), equipo[4].getAtaque(), equipo[4].getAtaque_especial(), equipo[4].getDefensa(),
                            equipo[4].getDefensa_especial(), equipo[4].getVelocidad());
                    int id6 = cBD.guardarPokemon(equipo[5].getId_pokedex(), equipo[5].getPseudonimo(), equipo[5].getNivel(),
                            equipo[5].getVida(), equipo[5].getAtaque(), equipo[5].getAtaque_especial(), equipo[5].getDefensa(),
                            equipo[5].getDefensa_especial(), equipo[5].getVelocidad());
                    System.out.println(id1+ " "+id2+ " "+id3+ " "+id4+ " "+id5+ " "+id6);
                    cBD.guardarEquipo(id1, equipo[0].getId_pokedex(), id_entrenador);
                    cBD.guardarEquipo(id2, equipo[1].getId_pokedex(), id_entrenador);
                    cBD.guardarEquipo(id3, equipo[2].getId_pokedex(), id_entrenador);
                    cBD.guardarEquipo(id4, equipo[3].getId_pokedex(), id_entrenador);
                    cBD.guardarEquipo(id5, equipo[4].getId_pokedex(), id_entrenador);
                    cBD.guardarEquipo(id6, equipo[5].getId_pokedex(), id_entrenador);
                    for (int i = 0; i < 4; i++) {
                        cBD.guardarMovimiento(equipo[0].getId_pokedex(), id1, movimientos1[i].getPuntos_poder_restantes(), 
                                movimientos1[i].getId_movimiento());
                        cBD.guardarMovimiento(equipo[1].getId_pokedex(), id2, movimientos2[i].getPuntos_poder_restantes(), 
                                movimientos2[i].getId_movimiento());
                        cBD.guardarMovimiento(equipo[2].getId_pokedex(), id3, movimientos3[i].getPuntos_poder_restantes(), 
                                movimientos3[i].getId_movimiento());
                        cBD.guardarMovimiento(equipo[3].getId_pokedex(), id4, movimientos4[i].getPuntos_poder_restantes(), 
                                movimientos4[i].getId_movimiento());
                        cBD.guardarMovimiento(equipo[4].getId_pokedex(), id5, movimientos5[i].getPuntos_poder_restantes(), 
                                movimientos5[i].getId_movimiento());
                        cBD.guardarMovimiento(equipo[5].getId_pokedex(), id6, movimientos6[i].getPuntos_poder_restantes(), 
                                movimientos6[i].getId_movimiento());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            vista.dispose();
            vista_mov.dispose();
        }
        if (vista.getjB_movimientos1() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar los movimientos de su primer pokemon");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
           vista_mov.setVisible(true);
           this.seleccion = 1;
        }
        if (vista.getjB_movimientos2() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar los movimientos de su segundo pokemon");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
           vista_mov.setVisible(true);
           this.seleccion = 2;
        }
        if (vista.getjB_movimientos3() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar los movimientos de su tercer pokemon");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
           vista_mov.setVisible(true); 
           this.seleccion = 3;
        }
        if (vista.getjB_movimientos4() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar los movimientos de su cuarto pokemon");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
           vista_mov.setVisible(true); 
           this.seleccion = 4;
        }
        if (vista.getjB_movimientos5() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar los movimientos de su quinto pokemon");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
           vista_mov.setVisible(true); 
           this.seleccion = 5;
        }
        if (vista.getjB_movimientos6() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio cambiar los movimientos de su sexto pokemon");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
           vista_mov.setVisible(true);  
           this.seleccion = 6;
        }
        if(vista_mov.getjB_Listo() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio los movimientos de su pokemon");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(vista_mov.getJL_Movimiento1().equals(vista_mov.getJL_Movimiento2()) || 
                    vista_mov.getJL_Movimiento1().equals(vista_mov.getJL_Movimiento3()) || 
                    vista_mov.getJL_Movimiento1().equals(vista_mov.getJL_Movimiento4()) || 
                    vista_mov.getJL_Movimiento2().equals(vista_mov.getJL_Movimiento3()) || 
                    vista_mov.getJL_Movimiento2().equals(vista_mov.getJL_Movimiento4()) || 
                    vista_mov.getJL_Movimiento3().equals(vista_mov.getJL_Movimiento4())){
                
                JOptionPane.showMessageDialog(this.vista_mov, " Uno o mas Movimientos estan repetidos, por favor seleccione denuevo.", "Intentelo denuevo", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
           if(seleccion == 1){
               try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento1());
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento2());
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento3());
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento4());
                    this.movimientos1[0] = movimiento1;
                    this.movimientos1[1] = movimiento2;
                    this.movimientos1[2] = movimiento3;
                    this.movimientos1[3] = movimiento4;
                    this.movimientos1_activados = true;
                    if(movimientos1_activados == true && movimientos2_activados == true && movimientos3_activados == true && 
                            movimientos4_activados == true && movimientos5_activados == true && movimientos6_activados == true){
                        vista.activarBotonListo();
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 2){
               try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento1());
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento2());
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento3());
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento4());
                    this.movimientos2[0] = movimiento1;
                    this.movimientos2[1] = movimiento2;
                    this.movimientos2[2] = movimiento3;
                    this.movimientos2[3] = movimiento4;
                    this.movimientos2_activados = true;
                    if(movimientos1_activados == true && movimientos2_activados == true && movimientos3_activados == true && 
                            movimientos4_activados == true && movimientos5_activados == true && movimientos6_activados == true){
                        vista.activarBotonListo();
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 3){
                try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento1());
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento2());
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento3());
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento4());
                    this.movimientos3[0] = movimiento1;
                    this.movimientos3[1] = movimiento2;
                    this.movimientos3[2] = movimiento3;
                    this.movimientos3[3] = movimiento4;
                    this.movimientos3_activados = true;
                    if(movimientos1_activados == true && movimientos2_activados == true && movimientos3_activados == true && 
                            movimientos4_activados == true && movimientos5_activados == true && movimientos6_activados == true){
                        vista.activarBotonListo();
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 4){
               try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento1());
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento2());
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento3());
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento4());
                    this.movimientos4[0] = movimiento1;
                    this.movimientos4[1] = movimiento2;
                    this.movimientos4[2] = movimiento3;
                    this.movimientos4[3] = movimiento4;
                    this.movimientos4_activados = true;
                    if(movimientos1_activados == true && movimientos2_activados == true && movimientos3_activados == true && 
                            movimientos4_activados == true && movimientos5_activados == true && movimientos6_activados == true){
                        vista.activarBotonListo();
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 5){
               try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento1());
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento2());
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento3());
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento4());
                    this.movimientos5[0] = movimiento1;
                    this.movimientos5[1] = movimiento2;
                    this.movimientos5[2] = movimiento3;
                    this.movimientos5[3] = movimiento4;
                    this.movimientos5_activados = true;
                    if(movimientos1_activados == true && movimientos2_activados == true && movimientos3_activados == true && 
                            movimientos4_activados == true && movimientos5_activados == true && movimientos6_activados == true){
                        vista.activarBotonListo();
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 6){
               try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento1());
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento2());
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento3());
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(vista_mov.getJL_Movimiento4());
                    this.movimientos6[0] = movimiento1;
                    this.movimientos6[1] = movimiento2;
                    this.movimientos6[2] = movimiento3;
                    this.movimientos6[3] = movimiento4;
                    this.movimientos6_activados = true;
                    if(movimientos1_activados == true && movimientos2_activados == true && movimientos3_activados == true && 
                            movimientos4_activados == true && movimientos5_activados == true && movimientos6_activados == true){
                        vista.activarBotonListo();
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           vista_mov.setVisible(false);
           vista_mov.limpiarListas();
            }
        }
        
        
    }
    
    public Pokemon[] obtenerEquipo(){
        return this.equipo;
    }

    
    
    
}
