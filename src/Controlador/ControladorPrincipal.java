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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Mario Caceres
 */
public class ControladorPrincipal implements ActionListener{
    
    private VistaPrincipal vistaPrincipal;
    private Entrenador entrenador_activo1;
    private Entrenador entrenador_activo2;
    private Pokemon[] equipo1;
    private Pokemon[] equipo2;
    private ControladorRegistros creg;
    
    //Constructor
    public ControladorPrincipal(VistaPrincipal vp) throws SQLException{
        vistaPrincipal = vp;
        this.vistaPrincipal.agregarListener(this);
        this.creg = new ControladorRegistros();
        this.entrenador_activo1 =obtenerEntrenadorBD(56);
        this.entrenador_activo2 =obtenerEntrenadorBD(56);
        this.equipo1 = entrenador_activo1.getPokemones();
        this.equipo2 = entrenador_activo2.getPokemones();
        vp.setJl_entrenador1(entrenador_activo1.getNombre());
        vp.setJl_entrenador2(entrenador_activo2.getNombre());
              
    }
    //Botones de la vista principal, aqui el controlador escucha a la vista principal
    @Override
    public void actionPerformed(ActionEvent e) {
        //Boton para simular el combate simple
        if (vistaPrincipal.getBotonSimularCombate() == (JButton) e.getSource()) {
            try {
                creg.guardarAccionUsuario("Usuario eligio simular un combate individual");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                generarCombate();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        //Boton para crear un nuevo entrenador
        if (vistaPrincipal.getBotonCrearEntrenador() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio crear un nuevo entrenador");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                generarEntrenador();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Boton para simular el torneo
        if (vistaPrincipal.getBotonSimularTorneo() == (JButton) e.getSource()){
            try {
                creg.guardarAccionUsuario("Usuario eligio simular un torneo");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                generarTorneo();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Boton para la informacion del primer entrenador
        if(vistaPrincipal.getBotonInfo1() == (JButton) e.getSource()){
           VistaEntrenador ven = new VistaEntrenador();
            try {
                ControladorInfoEntrenador cen = new ControladorInfoEntrenador(ven, this.entrenador_activo1);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        //Boton para la informacion del segundo entrenador
        if(vistaPrincipal.getBotonInfo2() == (JButton) e.getSource()){
            VistaEntrenador ven = new VistaEntrenador();
            try {
                ControladorInfoEntrenador cen = new ControladorInfoEntrenador(ven, this.entrenador_activo2);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        
        //Boton para la obtencion de medallas de gimnasio
        if(vistaPrincipal.getBotonMedallas() == (JButton) e.getSource()){
            try {
                ControladorMedallas cmed = new ControladorMedallas(entrenador_activo1, this);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Boton para logear al segundo jugador
        if(vistaPrincipal.getBotoniniciarjugador2() == (JButton) e.getSource()){
            try {
                ControladorLogin clogin = new ControladorLogin(vistaPrincipal, this, 2);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Lo mismo para el primero
        if(vistaPrincipal.getBotoniniciarjugador1() == (JButton) e.getSource()){
            try {
                ControladorLogin clogin = new ControladorLogin(vistaPrincipal, this, 1);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
                
        
    }
    
    public void generarTorneo() throws SQLException{
        VistaCampeonato vt = new VistaCampeonato();
        int tipo_torneo = vistaPrincipal.getjC_TipoTorneo();
        Entrenador[] participantes = participantes();
        ArrayList<JLabel> textos = new ArrayList();
        textos.add(vt.getLabel1());
        textos.add(vt.getLabel2());
        textos.add(vt.getLabel3());
        textos.add(vt.getLabel4());
        textos.add(vt.getLabel5());
        textos.add(vt.getLabel6());
        textos.add(vt.getLabel7());
        textos.add(vt.getLabel8());
        textos.add(vt.getLabel9());
        textos.add(vt.getLabel10());
        textos.add(vt.getLabel11());
        textos.add(vt.getLabel12());
        textos.add(vt.getLabel13());
        textos.add(vt.getLabel14());
        textos.add(vt.getLabel15());
        textos.add(vt.getLabel16());
        textos.add(vt.getLabel17());
        textos.add(vt.getLabel18());
        textos.add(vt.getLabel19());
        textos.add(vt.getLabel20());
        textos.add(vt.getLabel21());
        textos.add(vt.getLabel22());
        textos.add(vt.getLabel23());
        textos.add(vt.getLabel24());
        textos.add(vt.getLabel25());
        textos.add(vt.getLabel26());
        textos.add(vt.getLabel27());
        textos.add(vt.getLabel28());
        textos.add(vt.getLabel29());
        textos.add(vt.getLabel30());
        textos.add(vt.getLabel31());
        textos.add(vt.getLabel32());
        if(tipo_torneo == 0){
        Collections.shuffle(textos);
        int i;
        JLabel a;
        for(i=0;i<textos.size();i++){
            a = textos.get(i);
            String b = participantes[i].getNombre();
            a.setText(b);
        }
        
        vt.setVisible(true);
        ControladorCampeonato ccamp = new ControladorCampeonato(vt);
        }
    }
    //Metodo para generar un combate luego que se llama en el boton iniciar combate
    //Obtiene los nombres de los entrenadores, crea los objetos y llama al controlador combate para
    //que se haga cargo
    public void generarCombate() throws SQLException{
        int tipo_combate = vistaPrincipal.getjC_TipoSimulacion();
        ControladorCombate cc = new ControladorCombate(tipo_combate, entrenador_activo1, entrenador_activo2, this);
        System.out.println("Se selecciono simular combate");
    }
    //Aqui se genera un nuevo entrenador
    public void generarEntrenador() throws SQLException{
        VistaCrearEntrenador vce = new VistaCrearEntrenador();
        vce.setVisible(true);
        ControladorEntrenador ce = new ControladorEntrenador(vce, this);
        
    }
    
    //Crea al entrenador como objeto, con sus pokemon y movimientos
    public Entrenador obtenerEntrenadorBD(int id) throws SQLException{
        ConexionBD cBD = new ConexionBD();
        Pokemon[] equipo = cBD.obtenerEquipo(id);
            equipo[0].setMovimientos(cBD.obtenerMovesetPokemon(equipo[0].getId_pokemon()));
            equipo[1].setMovimientos(cBD.obtenerMovesetPokemon(equipo[1].getId_pokemon()));
            equipo[2].setMovimientos(cBD.obtenerMovesetPokemon(equipo[2].getId_pokemon()));
            equipo[3].setMovimientos(cBD.obtenerMovesetPokemon(equipo[3].getId_pokemon()));
            equipo[4].setMovimientos(cBD.obtenerMovesetPokemon(equipo[4].getId_pokemon()));
            equipo[5].setMovimientos(cBD.obtenerMovesetPokemon(equipo[5].getId_pokemon()));
        String nombre = cBD.obtenerNombreEntrenador(id);
        String distincion = cBD.obtenerDistincionEntrenador(id);
        Entrenador entrenador = new Entrenador(nombre, equipo, id);
        entrenador.setDistincion(distincion);
        return entrenador;
    }
    
     
    public Entrenador[] participantes(){
         Entrenador[] participantesPrueba = new Entrenador[32];
         Entrenador entrenador1 = new Entrenador("1",1);
         Entrenador entrenador2 = new Entrenador("2",2);
         Entrenador entrenador3 = new Entrenador("3",3);
         Entrenador entrenador4 = new Entrenador("4",4);
         Entrenador entrenador5 = new Entrenador("5",5);
         Entrenador entrenador6 = new Entrenador("6",6);
         Entrenador entrenador7 = new Entrenador("7",7);
         Entrenador entrenador8 = new Entrenador("8",8);
         Entrenador entrenador9 = new Entrenador("9",9);
         Entrenador entrenador10 = new Entrenador("10",10);
         Entrenador entrenador11 = new Entrenador("11",11);
         Entrenador entrenador13 = new Entrenador("12",12);
         Entrenador entrenador14 = new Entrenador("13",13);
         Entrenador entrenador15 = new Entrenador("14",14);
         Entrenador entrenador16 = new Entrenador("15",15);
         Entrenador entrenador17 = new Entrenador("16",16);
         Entrenador entrenador18 = new Entrenador("17",17);
         Entrenador entrenador19 = new Entrenador("18",18);
         Entrenador entrenador20 = new Entrenador("19",19);
         Entrenador entrenador21 = new Entrenador("20",20);
         Entrenador entrenador22 = new Entrenador("21",21);
         Entrenador entrenador23 = new Entrenador("22",22);
         Entrenador entrenador24 = new Entrenador("23",23);
         Entrenador entrenador25 = new Entrenador("24",24);
         Entrenador entrenador26 = new Entrenador("25",25);
         Entrenador entrenador27 = new Entrenador("26",26);
         Entrenador entrenador28 = new Entrenador("27",27);
         Entrenador entrenador29 = new Entrenador("28",28);
         Entrenador entrenador30 = new Entrenador("29",29);
         Entrenador entrenador31 = new Entrenador("30",30);
         Entrenador entrenador32 = new Entrenador("31",31);
         Entrenador entrenador12 = new Entrenador("32",32);
         participantesPrueba[0] = entrenador1;
         participantesPrueba[1] = entrenador2;
         participantesPrueba[2] = entrenador3;
         participantesPrueba[3] = entrenador4;
         participantesPrueba[4] = entrenador5;
         participantesPrueba[5] = entrenador6;
         participantesPrueba[6] = entrenador7;
         participantesPrueba[7] = entrenador8;
         participantesPrueba[8] = entrenador9;
         participantesPrueba[9] = entrenador10;
         participantesPrueba[10] = entrenador11;
         participantesPrueba[11] = entrenador12;
         participantesPrueba[12] = entrenador13;
         participantesPrueba[13] = entrenador14;
         participantesPrueba[14] = entrenador15;
         participantesPrueba[15] = entrenador16;
         participantesPrueba[16] = entrenador17;
         participantesPrueba[17] = entrenador18;
         participantesPrueba[18] = entrenador19;
         participantesPrueba[19] = entrenador20;
         participantesPrueba[20] = entrenador21;
         participantesPrueba[21] = entrenador22;
         participantesPrueba[22] = entrenador23;
         participantesPrueba[23] = entrenador24;
         participantesPrueba[24] = entrenador25;
         participantesPrueba[25] = entrenador26;
         participantesPrueba[26] = entrenador27;
         participantesPrueba[27] = entrenador28;
         participantesPrueba[28] = entrenador29;
         participantesPrueba[29] = entrenador30;
         participantesPrueba[30] = entrenador31;
         participantesPrueba[31] = entrenador32;
         return participantesPrueba;
     }
    public void setEntrenador1(Entrenador entrenador){
        this.entrenador_activo1 = entrenador;
    }
    public void setEntrenador2(Entrenador entrenador){
        this.entrenador_activo2 = entrenador;
    }
    
}
