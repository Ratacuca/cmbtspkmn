/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.MovimientoAprendido;
import Modelo.Pokemon;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Mario Caceres
 */
public class ControladorEquipo implements ActionListener{
    private VistaNuevoEquipo vista;
    private VistaNuevosMovimientos vista_mov;
    private Pokemon[] equipo;
    private ControladorBD cBD;
    private MovimientoAprendido[] movimientos1;
    private MovimientoAprendido[] movimientos2;
    private MovimientoAprendido[] movimientos3;
    private MovimientoAprendido[] movimientos4;
    private MovimientoAprendido[] movimientos5;
    private MovimientoAprendido[] movimientos6;
    private String[] nombres_movimientos1;
    private String[] nombres_movimientos2;
    private String[] nombres_movimientos3;
    private String[] nombres_movimientos4;
    private String[] nombres_movimientos5;
    private String[] nombres_movimientos6;
    private int seleccion;
    
    
    public ControladorEquipo(VistaNuevoEquipo vnew, ControladorBD cBD, Pokemon[] equipo_default1) throws SQLException{
        cBD = new ControladorBD();
        this.equipo = equipo_default1;
        this.vista_mov = new VistaNuevosMovimientos();
        vista_mov.agregarListener(this);
        this.vista = vnew;
        vista.agregarListener(this);
        vista.setVisible(true);
        this.cBD = cBD;
        ArrayList<String> JLmovimientos = cBD.obtenerTodosNombresMovimientos();
        vista_mov.setJL_movimientos1(JLmovimientos);
        vista_mov.setJL_movimientos2(JLmovimientos);
        vista_mov.setJL_movimientos3(JLmovimientos);
        vista_mov.setJL_movimientos4(JLmovimientos);
        this.nombres_movimientos1 = new String[4];
        this.nombres_movimientos2 = new String[4];
        this.nombres_movimientos3 = new String[4];
        this.nombres_movimientos4 = new String[4];
        this.nombres_movimientos5 = new String[4];
        this.nombres_movimientos6 = new String[4];
        this.movimientos1 = new MovimientoAprendido[4];
        this.movimientos2 = new MovimientoAprendido[4];
        this.movimientos3 = new MovimientoAprendido[4];
        this.movimientos4 = new MovimientoAprendido[4];
        this.movimientos5 = new MovimientoAprendido[4];
        this.movimientos6 = new MovimientoAprendido[4];
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.getjB_Listo()== (JButton) e.getSource()){
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
            try {
                this.equipo = cBD.crearEquipoPokemon(nombre1, nombre2, nombre3, nombre4, nombre5, nombre6, nivel1, nivel2, nivel3, nivel4, nivel5, nivel6);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            vista.dispose();
            vista_mov.dispose();
        }
        if (vista.getjB_movimientos1() == (JButton) e.getSource()){
           vista_mov.setVisible(true);
           this.seleccion = 1;
        }
        if (vista.getjB_movimientos2() == (JButton) e.getSource()){
           vista_mov.setVisible(true);
           this.seleccion = 2;
        }
        if (vista.getjB_movimientos3() == (JButton) e.getSource()){
           vista_mov.setVisible(true); 
           this.seleccion = 3;
        }
        if (vista.getjB_movimientos4() == (JButton) e.getSource()){
           vista_mov.setVisible(true); 
           this.seleccion = 4;
        }
        if (vista.getjB_movimientos5() == (JButton) e.getSource()){
           vista_mov.setVisible(true); 
           this.seleccion = 5;
        }
        if (vista.getjB_movimientos6() == (JButton) e.getSource()){
           vista_mov.setVisible(true);  
           this.seleccion = 6;
        }
        if(vista_mov.getjB_Listo() == (JButton) e.getSource()){
           if(seleccion == 1){
               this.nombres_movimientos1[0] = vista_mov.getJL_Movimiento1();
               this.nombres_movimientos1[1] = vista_mov.getJL_Movimiento2();
               this.nombres_movimientos1[2] = vista_mov.getJL_Movimiento3();
               this.nombres_movimientos1[3] = vista_mov.getJL_Movimiento4();
           }
           else if(seleccion == 2){
               this.nombres_movimientos2[0] = vista_mov.getJL_Movimiento1();
               this.nombres_movimientos2[1] = vista_mov.getJL_Movimiento2();
               this.nombres_movimientos2[2] = vista_mov.getJL_Movimiento3();
               this.nombres_movimientos2[3] = vista_mov.getJL_Movimiento4();
           }
           else if(seleccion == 3){
               this.nombres_movimientos3[0] = vista_mov.getJL_Movimiento1();
               this.nombres_movimientos3[1] = vista_mov.getJL_Movimiento2();
               this.nombres_movimientos3[2] = vista_mov.getJL_Movimiento3();
               this.nombres_movimientos3[3] = vista_mov.getJL_Movimiento4();
           }
           else if(seleccion == 4){
               this.nombres_movimientos4[0] = vista_mov.getJL_Movimiento1();
               this.nombres_movimientos4[1] = vista_mov.getJL_Movimiento2();
               this.nombres_movimientos4[2] = vista_mov.getJL_Movimiento3();
               this.nombres_movimientos4[3] = vista_mov.getJL_Movimiento4();
           }
           else if(seleccion == 5){
               this.nombres_movimientos5[0] = vista_mov.getJL_Movimiento1();
               this.nombres_movimientos5[1] = vista_mov.getJL_Movimiento2();
               this.nombres_movimientos5[2] = vista_mov.getJL_Movimiento3();
               this.nombres_movimientos5[3] = vista_mov.getJL_Movimiento4();
           }
           else if(seleccion == 6){
               this.nombres_movimientos6[0] = vista_mov.getJL_Movimiento1();
               this.nombres_movimientos6[1] = vista_mov.getJL_Movimiento2();
               this.nombres_movimientos6[2] = vista_mov.getJL_Movimiento3();
               this.nombres_movimientos6[3] = vista_mov.getJL_Movimiento4();
           }
           vista_mov.setVisible(false);
        }
        if (vista_mov.getjB_Listo()== (JButton) e.getSource()){
            if(seleccion == 1){
                try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(nombres_movimientos1[0]);
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(nombres_movimientos1[1]);
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(nombres_movimientos1[2]);
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(nombres_movimientos1[3]);
                    this.movimientos1[0] = movimiento1;
                    this.movimientos1[1] = movimiento2;
                    this.movimientos1[2] = movimiento3;
                    this.movimientos1[3] = movimiento4;
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 2){
               try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(nombres_movimientos2[0]);
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(nombres_movimientos2[1]);
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(nombres_movimientos2[2]);
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(nombres_movimientos2[3]);
                    this.movimientos2[0] = movimiento1;
                    this.movimientos2[1] = movimiento2;
                    this.movimientos2[2] = movimiento3;
                    this.movimientos2[3] = movimiento4;
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 3){
               try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(nombres_movimientos3[0]);
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(nombres_movimientos3[1]);
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(nombres_movimientos3[2]);
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(nombres_movimientos3[3]);
                    this.movimientos3[0] = movimiento1;
                    this.movimientos3[1] = movimiento2;
                    this.movimientos3[2] = movimiento3;
                    this.movimientos3[3] = movimiento4;
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 4){
              try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(nombres_movimientos4[0]);
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(nombres_movimientos4[1]);
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(nombres_movimientos4[2]);
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(nombres_movimientos4[3]);
                    this.movimientos4[0] = movimiento1;
                    this.movimientos4[1] = movimiento2;
                    this.movimientos4[2] = movimiento3;
                    this.movimientos4[3] = movimiento4;
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 5){
               try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(nombres_movimientos5[0]);
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(nombres_movimientos5[1]);
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(nombres_movimientos5[2]);
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(nombres_movimientos5[3]);
                    this.movimientos5[0] = movimiento1;
                    this.movimientos5[1] = movimiento2;
                    this.movimientos5[2] = movimiento3;
                    this.movimientos5[3] = movimiento4;
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
           else if(seleccion == 6){
               try {
                    MovimientoAprendido movimiento1 = cBD.obtenerMovimiento(nombres_movimientos6[0]);
                    MovimientoAprendido movimiento2 = cBD.obtenerMovimiento(nombres_movimientos6[1]);
                    MovimientoAprendido movimiento3 = cBD.obtenerMovimiento(nombres_movimientos6[2]);
                    MovimientoAprendido movimiento4 = cBD.obtenerMovimiento(nombres_movimientos6[3]);
                    this.movimientos6[0] = movimiento1;
                    this.movimientos6[1] = movimiento2;
                    this.movimientos6[2] = movimiento3;
                    this.movimientos6[3] = movimiento4;
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
        }
    }
    public Pokemon[] getEquipo(){
        return this.equipo;
    }
    
}
