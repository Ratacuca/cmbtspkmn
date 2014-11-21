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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List textos = new ArrayList();
        textos.add("jL_participante1");
        textos.add("jL_participante2");
        textos.add("jL_participante3");
        textos.add("jL_participante4");
        textos.add("jL_participante5");
        textos.add("jL_participante6");
        textos.add("jL_participante7");
        textos.add("jL_participante8");
        textos.add("jL_participante9");
        textos.add("jL_participante10");
        textos.add("jL_participante11");
        textos.add("jL_participante12");
        textos.add("jL_participante13");
        textos.add("jL_participante14");
        textos.add("jL_participante15");
        textos.add("jL_participante16");
        textos.add("jL_participante17");
        textos.add("jL_participante18");
        textos.add("jL_participante19");
        textos.add("jL_participante20");
        textos.add("jL_participante21");
        textos.add("jL_participante22");
        textos.add("jL_participante23");
        textos.add("jL_participante24");
        textos.add("jL_participante25");
        textos.add("jL_participante26");
        textos.add("jL_participante27");
        textos.add("jL_participante28");
        textos.add("jL_participante29");
        textos.add("jL_participante30");
        textos.add("jL_participante31");
        textos.add("jL_participante32");
        if(tipo_torneo == 0){
        Collections.shuffle(textos);
        int i;
        String a;
        for(i=0;i<textos.size();i++){
            a = textos.get(i).toString();
            String b = participantes[i].getNombre();
            
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
        Pokemon[] equipo1 = equipoPrueba1();
        Pokemon[] equipo2 = equipoPrueba2();
        Entrenador entrenador1 = new Entrenador(nombre1, equipo1); 
        Entrenador entrenador2 = new Entrenador(nombre2, equipo2);
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
         String[] debilidades_Charmander = new String[2];
         String[] fortalezas_Charmander= new String[2];
         debilidades_Charmander[0] = "Agua";
         fortalezas_Charmander[0] = "Planta";
         String[] debilidades_Squirtle= new String[2];
         String[] fortalezas_Squirtle= new String[2];
         debilidades_Squirtle[0] = "Planta";
         fortalezas_Squirtle[0] = "Fuego";
         Pokemon pokemon1 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon2 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon3 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon4 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon5 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon6 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
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
         String[] debilidades_Charmander = new String[2];
         String[] fortalezas_Charmander= new String[2];
         debilidades_Charmander[0] = "Agua";
         fortalezas_Charmander[0] = "Planta";
         String[] debilidades_Squirtle= new String[2];
         String[] fortalezas_Squirtle= new String[2];
         debilidades_Squirtle[0] = "Planta";
         fortalezas_Squirtle[0] = "Fuego";
         Pokemon pokemon1 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon2 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon3 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon4 = new Pokemon("Charmander", "Charmander", "Fuego", "Fuego", debilidades_Charmander, fortalezas_Charmander, 1, "Charmander", 100, 50, 40, 70, 20, 200);
         Pokemon pokemon5 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         Pokemon pokemon6 = new Pokemon("Squirtle", "Squirtle", "Agua", "Agua", debilidades_Squirtle, fortalezas_Squirtle, 2, "Squirtle", 100, 60, 20, 50, 30, 200);
         equipo[0]=pokemon1;
         equipo[1]=pokemon2;
         equipo[2]=pokemon3;
         equipo[3]=pokemon4;
         equipo[4]=pokemon5;
         equipo[5]=pokemon6;
         return equipo;
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
