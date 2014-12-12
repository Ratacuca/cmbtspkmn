/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.ConexionBD;
import Vista.VistaPrincipal;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario Caceres
 */
public class ControladorLogin {
    private int numero_jugador; //1 o 2 dependiendo del jugador
    
    public ControladorLogin(VistaPrincipal vista, ControladorPrincipal cp, int numero_jugador) throws SQLException{
        this.numero_jugador = numero_jugador;
        ConexionBD cBD = new ConexionBD();
        ArrayList<String> entrenadores = cBD.obtenerNombresEntrenadores();
        String[] entrenadores2 = new String[entrenadores.size()];
        entrenadores.toArray(entrenadores2);
        Object[] possibilities = entrenadores2;
        Boolean proceso = true;
        while(proceso == true){
            String usuario = (String)JOptionPane.showInputDialog(vista,"Seleccione su usuario dentro de la siguiente lista","Usuario",
                    JOptionPane.DEFAULT_OPTION,null,possibilities, possibilities[0]);
            if(usuario == null){
               proceso = false;
            }
            else{
            String password = (String)JOptionPane.showInputDialog(vista, "Ingrese su contraseña");
            if(password.equals(cBD.obtenerContraseña(usuario))){
                JOptionPane.showMessageDialog(vista, "Bienvenido "+usuario, "Logeo exitoso", JOptionPane.INFORMATION_MESSAGE);
                proceso = false;
                int id =cBD.obtenerIdEntrenador(usuario);
                if(numero_jugador == 1){
                    cp.setEntrenador1(cp.obtenerEntrenadorBD(id));
                    vista.setJl_entrenador1(usuario);
                }
                else if(numero_jugador == 2){
                    cp.setEntrenador2(cp.obtenerEntrenadorBD(id));
                    vista.setJl_entrenador2(usuario);
                }
            }
            else{
                JOptionPane.showMessageDialog(vista, "Contraseña incorrecta intentelo denuevo", "Error", JOptionPane.WARNING_MESSAGE);
            }
            }
        }
        
    }
}
