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
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Pokemon[] equipo1;
    private Pokemon[] equipo2;
    private int tipo_equipo;
    
    
    public ControladorPrincipal(VistaPrincipal vp){
        vistaPrincipal = vp;
        this.vistaPrincipal.agregarListener(this);
        this.tipo_equipo = 0;
              
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (vistaPrincipal.getBotonSimularCombate() == (JButton) e.getSource()) {
            generarCombate();
            
        }
        if (vistaPrincipal.getBotonCambiarEquipo1() == (JButton) e.getSource()) {
            try {
                generarCambioEquipo(1);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if (vistaPrincipal.getBotonCambiarEquipo2() == (JButton) e.getSource()) {
            try {
                generarCambioEquipo(2);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if (vistaPrincipal.getBotonCrearEntrenador() == (JButton) e.getSource()){
            try {
                generarEntrenador();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        if (vistaPrincipal.getBotonSimularTorneo() == (JButton) e.getSource()){
            try {
                generarTorneo();
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
    public void generarCombate(){
        String nombre1 = vistaPrincipal.getjC_Nombre1();
        String nombre2 = vistaPrincipal.getjC_Nombre2();
        VistaPreviaCombate vpc = new VistaPreviaCombate(vistaPrincipal.getjC_TipoSimulacion(), nombre1, nombre2);
        int tipo_combate = vistaPrincipal.getjC_TipoSimulacion();
        if(tipo_equipo == 0){
        this.equipo1 = equipoPrueba1();
        this.equipo2 = equipoPrueba2();
        }
        this.entrenador1 = new Entrenador(nombre1, equipo1); 
        this.entrenador2 = new Entrenador(nombre2, equipo2);
        String[] nombres1 = new String[6];
        String[] nombres2 = new String[6];
        for (int i = 0; i < 6; i++) {
            nombres1[i]=equipo1[i].getPseudonimo();
            nombres2[i]=equipo2[i].getPseudonimo();    
        }
        vpc.setjC_Equipo1(nombres1);
        vpc.setjC_Equipo2(nombres2);
        vpc.setVisible(true);
        ControladorCombate cc = new ControladorCombate(vpc, tipo_combate, entrenador1, entrenador2);
        System.out.println("Se selecciono simular combate");
    }
    public void generarCambioEquipo(int equipo) throws SQLException{
        ControladorBD cBD = new ControladorBD();
        ArrayList<String> nombres_pokemon = new ArrayList();
        nombres_pokemon = cBD.obtenerNombresPokemones();
        VistaNuevoEquipo vnew = new VistaNuevoEquipo();
        vnew.setJL_Pokemon1(nombres_pokemon);
        vnew.setJL_Pokemon2(nombres_pokemon);
        vnew.setJL_Pokemon3(nombres_pokemon);
        vnew.setJL_Pokemon4(nombres_pokemon);
        vnew.setJL_Pokemon5(nombres_pokemon);
        vnew.setJL_Pokemon6(nombres_pokemon);
        vnew.setVisible(true);
        ControladorEquipo ceq = new ControladorEquipo(vnew, cBD, equipoPrueba1());
        if(equipo == 1){
           this.equipo1 = ceq.getEquipo();
            System.out.println(equipo1[0].getPseudonimo());
           this.tipo_equipo = 1;
        }
        else{
           this.equipo2 = ceq.getEquipo();
           this.tipo_equipo = 1;
        }
    
    }
    
    public void generarEntrenador() throws SQLException{
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
     public Pokemon[] equipoPrueba1(){
         Pokemon[] equipo = new Pokemon[6];
         int[] debilidades_Charmander = new int[1];
         int[] fortalezas_Charmander= new int[1];
         debilidades_Charmander[0] = 2;
         fortalezas_Charmander[0] = 7;
         int[] debilidades_Squirtle= new int[1];
         int[] fortalezas_Squirtle= new int[1];
         debilidades_Squirtle[0] = 9;
         fortalezas_Squirtle[0] = 7;
         Pokemon pokemon1 = new Pokemon("Charmander", 7, 7, debilidades_Charmander, fortalezas_Charmander, 1, "Bellaco", 100, 150, 140, 170, 120, 250, 250);
         Pokemon pokemon2 = new Pokemon("Charmander", 7, 7, debilidades_Charmander, fortalezas_Charmander, 1, "Ratacuca", 100, 150, 140, 170, 120, 220, 220);
         Pokemon pokemon3 = new Pokemon("Squirtle", 2, 2, debilidades_Squirtle, fortalezas_Squirtle, 2, "Jesus", 100, 160, 120, 150, 130, 210, 210);
         Pokemon pokemon4 = new Pokemon("Charmander", 7, 7, debilidades_Charmander, fortalezas_Charmander, 1, "Superman", 100, 150, 140, 170, 120, 210, 210);
         Pokemon pokemon5 = new Pokemon("Squirtle", 2, 2, debilidades_Squirtle, fortalezas_Squirtle, 2, "Batman", 100, 160, 210, 150, 130, 220, 220);
         Pokemon pokemon6 = new Pokemon("Charmander", 7, 7, debilidades_Charmander, fortalezas_Charmander, 1, "CJ", 100, 150, 140, 170, 120, 220, 220);
         pokemon1.setMovimientos(movimientosPruebaCharmander());
         pokemon2.setMovimientos(movimientosPruebaCharmander());
         pokemon3.setMovimientos(movimientosPruebaSquirtle());
         pokemon4.setMovimientos(movimientosPruebaCharmander());
         pokemon5.setMovimientos(movimientosPruebaSquirtle());
         pokemon6.setMovimientos(movimientosPruebaCharmander());
         equipo[0]=pokemon1;
         equipo[1]=pokemon2;
         equipo[2]=pokemon3;
         equipo[3]=pokemon4;
         equipo[4]=pokemon5;
         equipo[5]=pokemon6;
         return equipo;
     }   
     public Pokemon[] equipoPrueba2(){
         Pokemon[] equipo = new Pokemon[6];
         int[] debilidades_Charmander = new int[1];
         int[] fortalezas_Charmander= new int[1];
         debilidades_Charmander[0] = 2;
         fortalezas_Charmander[0] = 7;
         int[] debilidades_Squirtle= new int[1];
         int[] fortalezas_Squirtle= new int[1];
         debilidades_Squirtle[0] = 9;
         fortalezas_Squirtle[0] = 7;
         Pokemon pokemon1 = new Pokemon("Squirtle", 2, 2, debilidades_Squirtle, fortalezas_Squirtle, 2, "Rata", 100, 160, 120, 150, 130, 250, 250);
         Pokemon pokemon2 = new Pokemon("Charmander", 7, 7, debilidades_Charmander, fortalezas_Charmander, 1, "Hulk", 100, 150, 140, 170, 120, 260, 260);
         Pokemon pokemon3 = new Pokemon("Squirtle", 2, 2, debilidades_Squirtle, fortalezas_Squirtle, 2, "Simba", 100, 160, 120, 150, 130, 220, 220);
         Pokemon pokemon4 = new Pokemon("Charmander", 7, 7, debilidades_Charmander, fortalezas_Charmander, 1, "Piñera", 100, 150, 140, 170, 120, 210, 210);
         Pokemon pokemon5 = new Pokemon("Squirtle", 2, 2, debilidades_Squirtle, fortalezas_Squirtle, 2, "Bachelet", 100, 160, 120, 150, 130, 230, 230);
         Pokemon pokemon6 = new Pokemon("Squirtle", 2, 2, debilidades_Squirtle, fortalezas_Squirtle, 2, "Obama", 100, 160, 120, 150, 150, 210, 210);
         pokemon1.setMovimientos(movimientosPruebaSquirtle());
         pokemon2.setMovimientos(movimientosPruebaCharmander());
         pokemon3.setMovimientos(movimientosPruebaSquirtle());
         pokemon4.setMovimientos(movimientosPruebaCharmander());
         pokemon5.setMovimientos(movimientosPruebaSquirtle());
         pokemon6.setMovimientos(movimientosPruebaSquirtle());
         equipo[0]=pokemon1;
         equipo[1]=pokemon2;
         equipo[2]=pokemon3;
         equipo[3]=pokemon4;
         equipo[4]=pokemon5;
         equipo[5]=pokemon6;
         return equipo;
     }  
     public MovimientoAprendido[] movimientosPruebaCharmander(){
         MovimientoAprendido[] movimientos = new MovimientoAprendido[4];
         MovimientoAprendido movimiento1 = new MovimientoAprendido(10, 60, 100, "Lanzallamas", 7, false, false, false, false, true, false, false, 10);
         MovimientoAprendido movimiento2 = new MovimientoAprendido(30, 100, 60, "Arañazo", 11, false, false, false, false, false, false, true, 30);
         MovimientoAprendido movimiento3 = new MovimientoAprendido(20, 90, 80, "Ascuas", 7, false, false, false, false, true, false, false, 20);
         MovimientoAprendido movimiento4 = new MovimientoAprendido(20, 100, 50, "Placaje", 11, false, false, false, false, false, false, true, 20);
         movimientos[0] = movimiento1;
         movimientos[1] = movimiento2;
         movimientos[2] = movimiento3;
         movimientos[3] = movimiento4;
         return movimientos;
     }
     public MovimientoAprendido[] movimientosPruebaSquirtle(){
         MovimientoAprendido[] movimientos = new MovimientoAprendido[4];
         MovimientoAprendido movimiento1 = new MovimientoAprendido(10, 60, 100, "Hidrobomba", 2, false, true, false, false, false, false, false, 10);
         MovimientoAprendido movimiento2 = new MovimientoAprendido(30, 100, 60, "Arañazo", 11, false, false, false, false, false, false, true, 30);
         MovimientoAprendido movimiento3 = new MovimientoAprendido(20, 100, 75, "Embestida", 11, false, false, false, false, false, false, true, 20);
         MovimientoAprendido movimiento4 = new MovimientoAprendido(20, 90, 50, "Burbujas", 2, false, false, false, false, false, false, false, 20);
         movimientos[0] = movimiento1;
         movimientos[1] = movimiento2;
         movimientos[2] = movimiento3;
         movimientos[3] = movimiento4;
         return movimientos;
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
    
}
