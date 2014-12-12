/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Modelo.*;
import Vista.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mario Caceres
 */
public class ControladorInfoEntrenador {
    
    private VistaEntrenador ven;
    private ConexionBD cBD;
    private Entrenador entrenador;
    
    public ControladorInfoEntrenador(VistaEntrenador ven, Entrenador entrenador) throws SQLException{
        this.cBD = new ConexionBD();
        this.entrenador = entrenador;
            ArrayList<String> medallas = cBD.obtenerMedallasEntrenador(entrenador.getId_entrenador());
            String nombre = entrenador.getNombre();
            String distincion = entrenador.getDistincion();
            int niveles[] = new int[6];
            String[] nombres_pokemon = new String[6];
            String[] especies_pokemon = new String[6];
            String[] nombres_movimientos1 = new String[6];
            String[] nombres_movimientos2 = new String[6];
            String[] nombres_movimientos3 = new String[6];
            String[] nombres_movimientos4 = new String[6];
            for (int i = 0; i < 6; i++) {
                nombres_pokemon[i] = entrenador.getPokemones()[i].getPseudonimo();
            }
            for (int i = 0; i < 6; i++) {
                especies_pokemon[i] = entrenador.getPokemones()[i].getNombre_especie();
            }
            for (int i = 0; i < 6; i++) {
                niveles[i] = entrenador.getPokemones()[i].getNivel();
            }
            for (int i = 0; i < 6; i++) {
                nombres_movimientos1[i] = entrenador.getPokemones()[i].getMovimientos()[0].getNombre();
                nombres_movimientos2[i] = entrenador.getPokemones()[i].getMovimientos()[1].getNombre();
                nombres_movimientos3[i] = entrenador.getPokemones()[i].getMovimientos()[2].getNombre();
                nombres_movimientos4[i] = entrenador.getPokemones()[i].getMovimientos()[3].getNombre();
            
            }
            ven.setjL_nombre(nombre);
            ven.setjL_categoria(distincion);
            ven.setjTableEspecies(especies_pokemon);
            ven.setjTableMovimiento1(nombres_movimientos1);
            ven.setjTableMovimiento2(nombres_movimientos2);
            ven.setjTableMovimiento3(nombres_movimientos3);
            ven.setjTableMovimiento4(nombres_movimientos4);
            ven.setjTableNiveles(niveles);
            ven.setjTablePseudonimos(nombres_pokemon);
            ven.setJL_Medallas(medallas);
            ven.setVisible(true);
        
    }
   
}
