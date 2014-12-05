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
import java.util.Collections;
/**
 *
 * @author Paulo
 */
public class ControladorCampeonato implements ActionListener {
    
    private VistaCampeonato vista;
    private int tipo_campeonato; //Simulacion medallas = 0, Simulacion segunda fase = 1, Simulacion Completa = 2
    
    public ControladorCampeonato(VistaCampeonato vt)throws SQLException{
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
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
    
}
