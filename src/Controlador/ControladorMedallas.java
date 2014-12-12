/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.*;
import Modelo.ConexionBD;
import Modelo.Entrenador;
import Modelo.MovimientoAprendido;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario Caceres
 */
public class ControladorMedallas implements ActionListener{
   private VistaCombateMedallas vmed;
   private VistaLobbyMedallas vlobby;
   private Entrenador retador;
   private int posicion_entrenador; //Define contra que lider se esta enfrentando, desde 0 a 7
   private Entrenador[] lideres;
   private ConexionBD cBD;
   private ControladorPrincipal cp;
   
   
   public ControladorMedallas(Entrenador entrenador, ControladorPrincipal cp) throws SQLException{
       this.cp = cp;
       this.cBD = new ConexionBD();
       this.vlobby = new VistaLobbyMedallas();
       this.vmed = new VistaCombateMedallas();
       this.retador = entrenador;
       this.vmed.agregarListener(this);
       this.vlobby.agregarListener(this);
       this.lideres = new Entrenador[8];
       vlobby.setJL_Hoenn(cBD.obtenerNombresLideresGimnasio(3));
       vlobby.setJL_Johto(cBD.obtenerNombresLideresGimnasio(2));
       vlobby.setJL_Kalos(cBD.obtenerNombresLideresGimnasio(6));
       vlobby.setJL_Kanto(cBD.obtenerNombresLideresGimnasio(1));
       vlobby.setJL_Sinnoh(cBD.obtenerNombresLideresGimnasio(4));
       vlobby.setJL_Teselia(cBD.obtenerNombresLideresGimnasio(5));
       vlobby.setJL_lider1(cBD.obtenerNombresEntrenadoresNPC());
       vlobby.setJL_lider2(cBD.obtenerNombresEntrenadoresNPC());
       vlobby.setJL_lider3(cBD.obtenerNombresEntrenadoresNPC());
       vlobby.setJL_lider4(cBD.obtenerNombresEntrenadoresNPC());
       vlobby.setJL_lider5(cBD.obtenerNombresEntrenadoresNPC());
       vlobby.setJL_lider6(cBD.obtenerNombresEntrenadoresNPC());
       vlobby.setJL_lider7(cBD.obtenerNombresEntrenadoresNPC());
       vlobby.setJL_lider8(cBD.obtenerNombresEntrenadoresNPC());
       vmed.setJL_Distincion(retador.getDistincion());
       vmed.setJL_Entrenador(retador.getNombre());
       this.vlobby.setVisible(true);
       this.posicion_entrenador = 0;
   }
   
   @Override
    public void actionPerformed(ActionEvent e) {
        
        if(vlobby.getjB_CombatirSeleccionPropia() == (JButton) e.getSource()){
            if(vlobby.getJL_indexLider1() == -1 || vlobby.getJL_indexLider2() == -1 || vlobby.getJL_indexLider3() == -1 || 
               vlobby.getJL_indexLider4() == -1 || vlobby.getJL_indexLider5() == -1 || vlobby.getJL_indexLider6() == -1 || 
               vlobby.getJL_indexLider7() == -1 ||vlobby.getJL_indexLider8() == -1){
                JOptionPane.showMessageDialog(this.vlobby, "Uno o mas lideres se encuentran sin seleccion, por favor eliga a todos los lideres para continuar", "Intentelo denuevo", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                try {
                    lideres[0] = new Entrenador(vlobby.getJL_lider1(), cBD.obtenerRegionLider(vlobby.getJL_lider1()),
                            "Lider de Gimnasio", cBD.obtenerIdLider(vlobby.getJL_lider1()), cBD.obtenerIdMedalla(vlobby.getJL_lider1()),
                            equipoDefaultLider());
                    lideres[1] = new Entrenador(vlobby.getJL_lider2(), cBD.obtenerRegionLider(vlobby.getJL_lider2()),
                            "Lider de Gimnasio", cBD.obtenerIdLider(vlobby.getJL_lider2()), cBD.obtenerIdMedalla(vlobby.getJL_lider2()),
                            equipoDefaultLider());
                    lideres[2] = new Entrenador(vlobby.getJL_lider3(), cBD.obtenerRegionLider(vlobby.getJL_lider3()),
                            "Lider de Gimnasio", cBD.obtenerIdLider(vlobby.getJL_lider3()), cBD.obtenerIdMedalla(vlobby.getJL_lider3()),
                            equipoDefaultLider());
                    lideres[3] = new Entrenador(vlobby.getJL_lider4(), cBD.obtenerRegionLider(vlobby.getJL_lider4()),
                            "Lider de Gimnasio", cBD.obtenerIdLider(vlobby.getJL_lider4()), cBD.obtenerIdMedalla(vlobby.getJL_lider4()),
                            equipoDefaultLider());
                    lideres[4] = new Entrenador(vlobby.getJL_lider5(), cBD.obtenerRegionLider(vlobby.getJL_lider5()),
                            "Lider de Gimnasio", cBD.obtenerIdLider(vlobby.getJL_lider5()), cBD.obtenerIdMedalla(vlobby.getJL_lider5()),
                            equipoDefaultLider());
                    lideres[5] = new Entrenador(vlobby.getJL_lider6(), cBD.obtenerRegionLider(vlobby.getJL_lider6()),
                            "Lider de Gimnasio", cBD.obtenerIdLider(vlobby.getJL_lider6()), cBD.obtenerIdMedalla(vlobby.getJL_lider6()),
                            equipoDefaultLider());
                    lideres[6] = new Entrenador(vlobby.getJL_lider7(), cBD.obtenerRegionLider(vlobby.getJL_lider7()),
                            "Lider de Gimnasio", cBD.obtenerIdLider(vlobby.getJL_lider7()), cBD.obtenerIdMedalla(vlobby.getJL_lider7()),
                            equipoDefaultLider());
                    lideres[7] = new Entrenador(vlobby.getJL_lider8(), cBD.obtenerRegionLider(vlobby.getJL_lider8()),
                            "Lider de Gimnasio", cBD.obtenerIdLider(vlobby.getJL_lider8()), cBD.obtenerIdMedalla(vlobby.getJL_lider8()),
                            equipoDefaultLider());
                    vmed.setJL_lider(lideres[0].getNombre());
                    vmed.setJL_region(lideres[0].getRegion());
                    vmed.setJL_tipo(cBD.obtenerNombreMedalla(lideres[0].getId_medalla()));
                    vlobby.setVisible(false);
                    vmed.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorMedallas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if(vlobby.getjB_Kanto() == (JButton) e.getSource()){
            try {
                porRegion(1);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMedallas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vlobby.getjB_Johto()== (JButton) e.getSource()){
            try {
                porRegion(2);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMedallas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vlobby.getjB_Hoenn()== (JButton) e.getSource()){
            try {
                porRegion(3);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMedallas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vlobby.getjB_Sinnoh()== (JButton) e.getSource()){
            try {
                porRegion(4);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMedallas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vlobby.getjB_Teselia() == (JButton) e.getSource()){
            try {
                porRegion(5);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMedallas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vlobby.getjB_Kalos()== (JButton) e.getSource()){
            try {
                porRegion(6);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMedallas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(vlobby.getjB_Aleatorio() == (JButton) e.getSource()){
            try {
                ArrayList<String> lista_lideres = cBD.obtenerNombresEntrenadoresNPC();
                Collections.shuffle(lista_lideres);
                for (int i = 0; i < 8; i++) {
                    lideres[i] = new Entrenador(lista_lideres.get(i), cBD.obtenerRegionLider(lista_lideres.get(i)),
                            "Lider de Gimnasio", cBD.obtenerIdLider(lista_lideres.get(i)), cBD.obtenerIdMedalla(lista_lideres.get(i)),
                            equipoDefaultLider());
                }
                
                
                vmed.setJL_lider(lideres[0].getNombre());
                vmed.setJL_region(lideres[0].getRegion());
                vmed.setJL_tipo(cBD.obtenerNombreMedalla(lideres[0].getId_medalla()));
                vlobby.setVisible(false);
                vmed.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMedallas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(vmed.getjB_combate() == (JButton) e.getSource()){
            ControladorCombate cc = new ControladorCombate(2, retador, lideres[posicion_entrenador], cp, this);
            vmed.setVisible(false);
        }
        
    
    }
   
   
    public Pokemon[] equipoDefaultLider() throws SQLException{
        ConexionBD cBD = new ConexionBD();
        ArrayList<Integer> ids_pokemon = cBD.obtenerIdsPokedex();
        ArrayList<Integer> ids_movimientos = cBD.obtenerIdsMovimientos();
        Collections.shuffle(ids_pokemon);
        Collections.shuffle(ids_movimientos);
        Pokemon[] equipo = new Pokemon[6];
        Pokemon pokemon1 = cBD.crearPokemon(50, ids_pokemon.get(0));
        Pokemon pokemon2 = cBD.crearPokemon(50, ids_pokemon.get(1));
        Pokemon pokemon3 = cBD.crearPokemon(50, ids_pokemon.get(2));
        Pokemon pokemon4 = cBD.crearPokemon(50, ids_pokemon.get(3));
        Pokemon pokemon5 = cBD.crearPokemon(50, ids_pokemon.get(4));
        Pokemon pokemon6 = cBD.crearPokemon(50, ids_pokemon.get(5));
        MovimientoAprendido[] movimientos1 = new MovimientoAprendido[4];
        MovimientoAprendido[] movimientos2 = new MovimientoAprendido[4];
        MovimientoAprendido[] movimientos3 = new MovimientoAprendido[4];
        MovimientoAprendido[] movimientos4 = new MovimientoAprendido[4];
        MovimientoAprendido[] movimientos5 = new MovimientoAprendido[4];
        MovimientoAprendido[] movimientos6 = new MovimientoAprendido[4];
        for (int i = 0; i < 4; i++) {
            movimientos1[i] = cBD.obtenerMovimientoPorID(ids_movimientos.get(i));
            movimientos2[i] = cBD.obtenerMovimientoPorID(ids_movimientos.get(i+1));
            movimientos3[i] = cBD.obtenerMovimientoPorID(ids_movimientos.get(i+2));
            movimientos4[i] = cBD.obtenerMovimientoPorID(ids_movimientos.get(i+3));
            movimientos5[i] = cBD.obtenerMovimientoPorID(ids_movimientos.get(i+4));
            movimientos6[i] = cBD.obtenerMovimientoPorID(ids_movimientos.get(i+5));
        }
        pokemon1.setMovimientos(movimientos1);
        pokemon2.setMovimientos(movimientos2);
        pokemon3.setMovimientos(movimientos3);
        pokemon4.setMovimientos(movimientos4);
        pokemon5.setMovimientos(movimientos5);
        pokemon6.setMovimientos(movimientos6);
        equipo[0] = pokemon1;
        equipo[1] = pokemon2;
        equipo[2] = pokemon3;
        equipo[3] = pokemon4;
        equipo[4] = pokemon5;
        equipo[5] = pokemon6;
        return equipo;
    }
    
    public void porRegion(int region) throws SQLException{
        this.lideres = cBD.obtenerLideresGimnasio(region);
        for (int i = 0; i < 8; i++) {
            lideres[i].setPokemones(equipoDefaultLider());
        }
            vmed.setJL_lider(lideres[0].getNombre());
            vmed.setJL_region(lideres[0].getRegion());
            vmed.setJL_tipo(cBD.obtenerNombreMedalla(lideres[0].getId_medalla()));
            vlobby.setVisible(false);
            vmed.setVisible(true);
    }
    public void avanzarPosicion(){
        this.posicion_entrenador +=1;
    }
    
    public void ganoCombate() throws SQLException{
        ArrayList<Integer> medallas = cBD.revisarMedallasEntrenador(retador.getId_entrenador());
        vmed.setVisible(true);
        JOptionPane.showMessageDialog(this.vmed, "Has ganado el combate contra el lider!", "Ganador", JOptionPane.INFORMATION_MESSAGE);
        if(medallas.contains(lideres[posicion_entrenador].getId_medalla())){
          JOptionPane.showMessageDialog(this.vmed, "Ya posees esta medalla", "Ya tienes la medalla", JOptionPane.INFORMATION_MESSAGE);  
        }
        else{
        JOptionPane.showMessageDialog(this.vmed, "Se te ha otorgado la  "+cBD.obtenerNombreMedalla(lideres[posicion_entrenador].getId_medalla()), "Nueva Medalla!", JOptionPane.INFORMATION_MESSAGE);
        cBD.guardarMedalla(retador.getId_entrenador(),lideres[posicion_entrenador].getId_medalla() );
        }
        
        avanzarPosicion();
        if(posicion_entrenador >7){
            JOptionPane.showMessageDialog(this.vmed, "Has vencido a los 8 lideres de gimnasio!" , "Vencedor", JOptionPane.INFORMATION_MESSAGE); 
            vmed.dispose();
        }
        else{
            vmed.setJL_lider(lideres[posicion_entrenador].getNombre());
            vmed.setJL_region(lideres[posicion_entrenador].getRegion());
            vmed.setJL_tipo(cBD.obtenerNombreMedalla(lideres[posicion_entrenador].getId_medalla()));
        }
    }
    
}
