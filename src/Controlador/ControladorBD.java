/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Modelo.*;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Mario Caceres
 */
public class ControladorBD {
   
    private Connection conexion;
    
    public ControladorBD()throws SQLException{
        String ruta = "jdbc:derby://localhost:1527/Combates_Pokemon ;user=mario ;password=1234";
        conexion = java.sql.DriverManager.getConnection(ruta);
    }
    
    public ArrayList<String> obtenerNombresPokemones()throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        ArrayList<String> pokemones = new ArrayList<String>();
        stmt = conexion.createStatement();
        String consulta = "SELECT nombre_familiapokemon FROM familia_pokemon";
        rst = stmt.executeQuery(consulta);
        
        while(rst.next()){
            String nombre = rst.getString("nombre_familiapokemon");
            System.out.println("Nombre: " + nombre);
            pokemones.add(nombre);
        }
        rst.close();
        conexion.close();
        return pokemones;
    }
    
    public void guardarEntrenador(String nombre, int id, String categoria) throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "INSERT INTO entrenador (id_entrenador,nombre_entrenador, categoria_entrenador) values ("+id+", '"+nombre+"','"+categoria+"')";
        int resultado = stmt.executeUpdate(consulta);
        
        conexion.close();
    }
    
}
