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
            String nombre = rst.getString("nombre_familiapokemon").trim();
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
    
    public MovimientoAprendido obtenerMovimiento(String nombre) throws SQLException{
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT * FROM Movimiento WHERE nombre_movimiento='" + nombre + "'";
        rst = stmt.executeQuery(consulta);
        rst.next();
        MovimientoAprendido movimiento = new MovimientoAprendido(rst.getInt("puntospoder_movimiento"), rst.getInt("presicion_movimiento"), 
            rst.getInt("potencia_movimiento"), rst.getString("nombre_movimiento"), rst.getInt("id_elemento"), 
            rst.getBoolean("envenena_movimiento"), rst.getBoolean("confunde_movimiento"), rst.getBoolean("paraliza_movimiento"), 
            rst.getBoolean("congela_movimiento"), rst.getBoolean("quema_movimiento"), rst.getBoolean("duerme_movimiento"), 
            rst.getBoolean("contacto_movimiento"), rst.getInt("puntospoder_movimiento")); 
        
        rst.close();
        stmt.close();
        return movimiento;
    }
    
    public ArrayList<String> obtenerNombresMovimientos(int tipo)throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        ArrayList<String> movimientos = new ArrayList<String>();
        stmt = conexion.createStatement();
        String consulta = "SELECT nombre_movimiento FROM Movimiento WHERE id_elemento="+tipo+"";
        rst = stmt.executeQuery(consulta);
        
        while(rst.next()){
            String nombre = rst.getString("nombre_movimiento").trim();
            System.out.println("Nombre: " + nombre);
            movimientos.add(nombre);
        }
        rst.close();
        conexion.close();
        return movimientos;
    }
    //MODIFICAR DESPUES
    public Pokemon[] crearEquipoPokemon(String nombre1, String nombre2, String nombre3, 
            String nombre4, String nombre5, String nombre6) throws SQLException{
        
        ResultSet rst1;
        ResultSet rst2;
        ResultSet rst3;
        ResultSet rst4;
        ResultSet rst5;
        ResultSet rst6;
        Statement stmt1;
        Statement stmt2;
        Statement stmt3;
        Statement stmt4;
        Statement stmt5;
        Statement stmt6;
        Pokemon[] equipo = new Pokemon[6];
        stmt1 = conexion.createStatement();
        stmt2 = conexion.createStatement();
        stmt3 = conexion.createStatement();
        stmt4 = conexion.createStatement();
        stmt5 = conexion.createStatement();
        stmt6 = conexion.createStatement();
        String consulta1 = "SELECT * FROM Familia_pokemon WHERE nombre_familiapokemon='"+nombre1+"'";
        String consulta2 = "SELECT * FROM Familia_pokemon WHERE nombre_familiapokemon='"+nombre2+"'";
        String consulta3 = "SELECT * FROM Familia_pokemon WHERE nombre_familiapokemon='"+nombre3+"'";
        String consulta4 = "SELECT * FROM Familia_pokemon WHERE nombre_familiapokemon='"+nombre4+"'";
        String consulta5 = "SELECT * FROM Familia_pokemon WHERE nombre_familiapokemon='"+nombre5+"'";
        String consulta6 = "SELECT * FROM Familia_pokemon WHERE nombre_familiapokemon='"+nombre6+"'";
        rst1 = stmt1.executeQuery(consulta1);
        rst2 = stmt2.executeQuery(consulta2);
        rst3 = stmt3.executeQuery(consulta3);
        rst4 = stmt4.executeQuery(consulta4);
        rst5 = stmt5.executeQuery(consulta5);
        rst6 = stmt6.executeQuery(consulta6);
        rst1.next();
        rst2.next();
        rst3.next();
        rst4.next();
        rst5.next();
        rst6.next();
        
            Pokemon pokemon1 = new Pokemon(rst1.getString("nombre_familiapokemon"), rst1.getString("especie_familiapokemon"), 
            1, 1, rst1.getInt("id_familiapokemon"), 100, 50, 50, 50, 50, 200, 200);
            Pokemon pokemon2 = new Pokemon(rst2.getString("nombre_familiapokemon"), rst2.getString("especie_familiapokemon"), 
            1, 1, rst2.getInt("id_familiapokemon"), 100, 50, 50, 50, 50, 200, 200);
            Pokemon pokemon3 = new Pokemon(rst3.getString("nombre_familiapokemon"), rst3.getString("especie_familiapokemon"), 
            1, 1, rst3.getInt("id_familiapokemon"), 100, 50, 50, 50, 50, 200, 200);
            Pokemon pokemon4 = new Pokemon(rst4.getString("nombre_familiapokemon"), rst4.getString("especie_familiapokemon"), 
            1, 1, rst4.getInt("id_familiapokemon"), 100, 50, 50, 50, 50, 200, 200);
            Pokemon pokemon5 = new Pokemon(rst5.getString("nombre_familiapokemon"), rst5.getString("especie_familiapokemon"), 
            1, 1, rst5.getInt("id_familiapokemon"), 100, 50, 50, 50, 50, 200, 200);
            Pokemon pokemon6 = new Pokemon(rst6.getString("nombre_familiapokemon"), rst6.getString("especie_familiapokemon"), 
            1, 1, rst6.getInt("id_familiapokemon"), 100, 50, 50, 50, 50, 200, 200);
            
            equipo[0] = pokemon1;
            equipo[1] = pokemon2;
            equipo[2] = pokemon3;
            equipo[3] = pokemon4;
            equipo[4] = pokemon5;
            equipo[5] = pokemon6;  
        rst1.close();
        rst2.close();
        rst3.close();
        rst4.close();
        rst5.close();
        rst6.close();
        conexion.close();
        return equipo;
        
    }
}
