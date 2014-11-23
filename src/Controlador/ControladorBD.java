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
        
        return pokemones;
    }
    
    public void guardarEntrenador(String nombre, int id, String categoria) throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "INSERT INTO entrenador (id_entrenador,nombre_entrenador, categoria_entrenador) values ("+id+", '"+nombre+"','"+categoria+"')";
        int resultado = stmt.executeUpdate(consulta);
        
        
    }
    //FALTA PARALIZA EN LA TABLA
    public MovimientoAprendido obtenerMovimiento(String nombre) throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT * FROM Movimiento WHERE nombre_movimiento='" + nombre + "'";
        rst = stmt.executeQuery(consulta);
        rst.next();
        MovimientoAprendido movimiento = new MovimientoAprendido(rst.getInt("puntospoder_movimiento"), rst.getInt("presicion_movimiento"), 
            rst.getInt("potencia_movimiento"), rst.getString("nombre_movimiento"), rst.getInt("id_elemento"), 
            rst.getBoolean("envenena_movimiento"), rst.getBoolean("confunde_movimiento"), false, 
            rst.getBoolean("congela_movimiento"), rst.getBoolean("quema_movimiento"), rst.getBoolean("duerme_movimiento"), 
            rst.getBoolean("contacto_movimiento"), rst.getInt("puntospoder_movimiento")); 
        stmt.close();
        rst.close();
        
        
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
       
        return movimientos;
    }
    public ArrayList<String> obtenerTodosNombresMovimientos()throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        ArrayList<String> movimientos = new ArrayList<String>();
        stmt = conexion.createStatement();
        String consulta = "SELECT nombre_movimiento FROM Movimiento";
        rst = stmt.executeQuery(consulta);
        
        while(rst.next()){
            String nombre = rst.getString("nombre_movimiento").trim();
            System.out.println("Nombre: " + nombre);
            movimientos.add(nombre);
        }
        rst.close();
        
        return movimientos;
    }
    //MODIFICAR DESPUES
    public Pokemon[] crearEquipoPokemon(String nombre1, String nombre2, String nombre3, 
            String nombre4, String nombre5, String nombre6, int nivel1, int nivel2, int nivel3, int nivel4, int nivel5, int nivel6) throws SQLException{
        
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
        
            double ataque1 = (rst1.getInt("Ataquemax_familiapokemon")-rst1.getInt("Ataquebase_familiapokemon")*nivel1)/99 + 
                    rst1.getInt("Ataquebase_familiapokemon");
            double ataque2 = (rst2.getInt("Ataquemax_familiapokemon")-rst2.getInt("Ataquebase_familiapokemon")*nivel2)/99 + 
                    rst2.getInt("Ataquebase_familiapokemon");
            double ataque3 = (rst3.getInt("Ataquemax_familiapokemon")-rst3.getInt("Ataquebase_familiapokemon")*nivel3)/99 + 
                    rst3.getInt("Ataquebase_familiapokemon");
            double ataque4 = (rst4.getInt("Ataquemax_familiapokemon")-rst4.getInt("Ataquebase_familiapokemon")*nivel4)/99 + 
                    rst4.getInt("Ataquebase_familiapokemon");
            double ataque5 = (rst5.getInt("Ataquemax_familiapokemon")-rst5.getInt("Ataquebase_familiapokemon")*nivel5)/99 + 
                    rst5.getInt("Ataquebase_familiapokemon");
            double ataque6 = (rst6.getInt("Ataquemax_familiapokemon")-rst6.getInt("Ataquebase_familiapokemon")*nivel6)/99 + 
                    rst6.getInt("Ataquebase_familiapokemon");
            double ataquesp1 = (rst1.getInt("Ataqueespecialmax_familiapokemon")-rst1.getInt("Ataqueespecialbase_familiapokemon")*nivel1)/99 + 
                    rst1.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp2 = (rst2.getInt("Ataqueespecialmax_familiapokemon")-rst2.getInt("Ataqueespecialbase_familiapokemon")*nivel2)/99 + 
                    rst2.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp3 = (rst3.getInt("Ataqueespecialmax_familiapokemon")-rst3.getInt("Ataqueespecialbase_familiapokemon")*nivel3)/99 + 
                    rst3.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp4 = (rst4.getInt("Ataqueespecialmax_familiapokemon")-rst4.getInt("Ataqueespecialbase_familiapokemon")*nivel4)/99 + 
                    rst4.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp5 = (rst5.getInt("Ataqueespecialmax_familiapokemon")-rst5.getInt("Ataqueespecialbase_familiapokemon")*nivel5)/99 + 
                    rst5.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp6 = (rst6.getInt("Ataqueespecialmax_familiapokemon")-rst6.getInt("Ataqueespecialbase_familiapokemon")*nivel6)/99 + 
                    rst6.getInt("Ataqueespecialbase_familiapokemon");
            double defensa1 = (rst1.getInt("Defensamax_familiapokemon")-rst1.getInt("Defensabase_familiapokemon")*nivel1)/99 + 
                    rst1.getInt("Defensabase_familiapokemon");
            double defensa2 = (rst2.getInt("Defensamax_familiapokemon")-rst2.getInt("Defensabase_familiapokemon")*nivel2)/99 + 
                    rst2.getInt("Defensabase_familiapokemon");
            double defensa3 = (rst3.getInt("Defensamax_familiapokemon")-rst3.getInt("Defensabase_familiapokemon")*nivel3)/99 + 
                    rst3.getInt("Defensabase_familiapokemon");
            double defensa4 = (rst4.getInt("Defensamax_familiapokemon")-rst4.getInt("Defensabase_familiapokemon")*nivel4)/99 + 
                    rst4.getInt("Defensabase_familiapokemon");
            double defensa5 = (rst5.getInt("Defensamax_familiapokemon")-rst5.getInt("Defensabase_familiapokemon")*nivel5)/99 + 
                    rst5.getInt("Defensabase_familiapokemon");
            double defensa6 = (rst6.getInt("Defensamax_familiapokemon")-rst6.getInt("Defensabase_familiapokemon")*nivel6)/99 + 
                    rst6.getInt("Defensabase_familiapokemon");
            double defensasp1 = (rst1.getInt("Defensaespecialmax_familiapokemon")-rst1.getInt("Defensaespecialbase_familiapokemon")*nivel1)/99 + 
                    rst1.getInt("Defensaespecialbase_familiapokemon");
            double defensasp2 = (rst2.getInt("Defensaespecialmax_familiapokemon")-rst2.getInt("Defensaespecialbase_familiapokemon")*nivel2)/99 + 
                    rst2.getInt("Defensaespecialbase_familiapokemon");
            double defensasp3 = (rst3.getInt("Defensaespecialmax_familiapokemon")-rst3.getInt("Defensaespecialbase_familiapokemon")*nivel3)/99 + 
                    rst3.getInt("Defensaespecialbase_familiapokemon");
            double defensasp4 = (rst4.getInt("Defensaespecialmax_familiapokemon")-rst4.getInt("Defensaespecialbase_familiapokemon")*nivel4)/99 + 
                    rst4.getInt("Defensaespecialbase_familiapokemon");
            double defensasp5 = (rst5.getInt("Defensaespecialmax_familiapokemon")-rst5.getInt("Defensaespecialbase_familiapokemon")*nivel5)/99 + 
                    rst5.getInt("Defensaespecialbase_familiapokemon");
            double defensasp6 = (rst6.getInt("Defensaespecialmax_familiapokemon")-rst6.getInt("Defensaespecialbase_familiapokemon")*nivel6)/99 + 
                    rst6.getInt("Defensaespecialbase_familiapokemon");
            double vida1 = (rst1.getInt("hpmax_familiapokemon")-rst1.getInt("hpbase_familiapokemon")*nivel1)/99 + 
                    rst1.getInt("hpbase_familiapokemon");
            double vida2 = (rst2.getInt("hpmax_familiapokemon")-rst2.getInt("hpbase_familiapokemon")*nivel2)/99 + 
                    rst2.getInt("hpbase_familiapokemon");
            double vida3 = (rst3.getInt("hpmax_familiapokemon")-rst3.getInt("hpbase_familiapokemon")*nivel3)/99 + 
                    rst3.getInt("hpbase_familiapokemon");
            double vida4 = (rst4.getInt("hpmax_familiapokemon")-rst4.getInt("hpbase_familiapokemon")*nivel4)/99 + 
                    rst4.getInt("hpbase_familiapokemon");
            double vida5 = (rst5.getInt("hpmax_familiapokemon")-rst5.getInt("hpbase_familiapokemon")*nivel5)/99 + 
                    rst5.getInt("hpbase_familiapokemon");
            double vida6 = (rst6.getInt("hpmax_familiapokemon")-rst6.getInt("hpbase_familiapokemon")*nivel6)/99 + 
                    rst6.getInt("hpbase_familiapokemon");
            Pokemon pokemon1 = new Pokemon(rst1.getString("nombre_familiapokemon"),1, 1,rst1.getInt("id_familiapokemon"),
                    rst1.getString("nombre_familiapokemon"), nivel1,(int)ataque1, (int)defensa1, (int)ataquesp1, (int)defensasp1, 
                    (int)vida1, (int)vida1);
            Pokemon pokemon2 = new Pokemon(rst2.getString("nombre_familiapokemon"),1, 1,rst2.getInt("id_familiapokemon"),
                    rst2.getString("nombre_familiapokemon"), nivel2,(int)ataque2, (int)defensa2, (int)ataquesp2, (int)defensasp2, 
                    (int)vida2, (int)vida2);
            Pokemon pokemon3 = new Pokemon(rst3.getString("nombre_familiapokemon"),1, 1,rst3.getInt("id_familiapokemon"),
                    rst3.getString("nombre_familiapokemon"), nivel3,(int)ataque3, (int)defensa3, (int)ataquesp3, (int)defensasp3, 
                    (int)vida3, (int)vida3);
            Pokemon pokemon4 = new Pokemon(rst4.getString("nombre_familiapokemon"),1, 1,rst4.getInt("id_familiapokemon"),
                    rst4.getString("nombre_familiapokemon"), nivel4,(int)ataque4, (int)defensa4, (int)ataquesp4, (int)defensasp4, 
                    (int)vida4, (int)vida4);
            Pokemon pokemon5 = new Pokemon(rst5.getString("nombre_familiapokemon"),1, 1,rst5.getInt("id_familiapokemon"),
                    rst5.getString("nombre_familiapokemon"), nivel5,(int)ataque5, (int)defensa5, (int)ataquesp5, (int)defensasp5, 
                    (int)vida5, (int)vida5);
            Pokemon pokemon6 = new Pokemon(rst6.getString("nombre_familiapokemon"),1, 1,rst6.getInt("id_familiapokemon"),
                    rst6.getString("nombre_familiapokemon"), nivel6,(int)ataque6, (int)defensa6, (int)ataquesp6, (int)defensasp6, 
                    (int)vida6, (int)vida6);
            
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
        
        return equipo;
        
    }
    // FALTA PARALIZA EN LA TABLA DE MOVIMIENTO
    public MovimientoAprendido[] crearMoveset(String nombre1, String nombre2, String nombre3, 
            String nombre4) throws SQLException{
        
        MovimientoAprendido[] moveset = new MovimientoAprendido[4];
        moveset[0] = crearMoveset1(nombre1);
        moveset[1] = crearMoveset2(nombre2);
        moveset[2] = crearMoveset3(nombre3);
        moveset[3] = crearMoveset4(nombre4);
        return moveset;
        
        
    }
    public MovimientoAprendido crearMoveset1(String nombre) throws SQLException{
        ResultSet rst1;
        Statement stmt1;
        stmt1 = conexion.createStatement();
        String consulta1 = "SELECT * FROM Movimiento WHERE Nombre_Movimiento='"+nombre+"'";
        rst1 = stmt1.executeQuery(consulta1);
        rst1.next();
        int pp = rst1.getInt("puntospoder_movimiento");
        int precision = rst1.getInt("presicion_movimiento");
        int potencia = rst1.getInt("potencia_movimiento");
        int id = rst1.getInt("id_elemento");
        Boolean envenena = rst1.getBoolean("envenena_movimiento");
        Boolean confunde = rst1.getBoolean("confunde_movimiento");
        Boolean congela = rst1.getBoolean("congela_movimiento");
        Boolean quema = rst1.getBoolean("quema_movimiento");
        Boolean duerme = rst1.getBoolean("duerme_movimiento");
        Boolean contacto = rst1.getBoolean("contacto_movimiento");
        MovimientoAprendido movimiento = new MovimientoAprendido(pp, 
                    precision, potencia, nombre, 
                    id, envenena, confunde, 
                    false, congela, quema, 
                    duerme, contacto, pp);
        
        
        rst1.close();
        stmt1.close();
        return movimiento;
            
    }
    public MovimientoAprendido crearMoveset2(String nombre) throws SQLException{
        ResultSet rst1;
        Statement stmt1;
        stmt1 = conexion.createStatement();
        String consulta1 = "SELECT * FROM Movimiento WHERE Nombre_Movimiento='"+nombre+"'";
        rst1 = stmt1.executeQuery(consulta1);
        rst1.next();
        MovimientoAprendido movimiento = new MovimientoAprendido(rst1.getInt("puntospoder_movimiento"), 
                    rst1.getInt("presicion_movimiento"), rst1.getInt("potencia_movimiento"), rst1.getString("nombre_movimiento"), 
                    rst1.getInt("id_elemento"), rst1.getBoolean("envenena_movimiento"), rst1.getBoolean("confunde_movimiento"), 
                    false, rst1.getBoolean("congela_movimiento"), rst1.getBoolean("quema_movimiento"), 
                    rst1.getBoolean("duerme_movimiento"), rst1.getBoolean("contacto_movimiento"), rst1.getInt("puntospoder_movimiento"));
        rst1.close();
        stmt1.close();
        return movimiento;    
    }
    public MovimientoAprendido crearMoveset3(String nombre) throws SQLException{
        ResultSet rst1;
        Statement stmt1;
        stmt1 = conexion.createStatement();
        String consulta1 = "SELECT * FROM Movimiento WHERE Nombre_Movimiento='"+nombre+"'";
        rst1 = stmt1.executeQuery(consulta1);
        rst1.next();
        MovimientoAprendido movimiento = new MovimientoAprendido(rst1.getInt("puntospoder_movimiento"), 
                    rst1.getInt("presicion_movimiento"), rst1.getInt("potencia_movimiento"), rst1.getString("nombre_movimiento"), 
                    rst1.getInt("id_elemento"), rst1.getBoolean("envenena_movimiento"), rst1.getBoolean("confunde_movimiento"), 
                    false, rst1.getBoolean("congela_movimiento"), rst1.getBoolean("quema_movimiento"), 
                    rst1.getBoolean("duerme_movimiento"), rst1.getBoolean("contacto_movimiento"), rst1.getInt("puntospoder_movimiento"));
        rst1.close();
        stmt1.close();
        return movimiento;    
    }
    public MovimientoAprendido crearMoveset4(String nombre) throws SQLException{
        ResultSet rst1;
        Statement stmt1;
        stmt1 = conexion.createStatement();
        String consulta1 = "SELECT * FROM Movimiento WHERE Nombre_Movimiento='"+nombre+"'";
        rst1 = stmt1.executeQuery(consulta1);
        rst1.next();
        MovimientoAprendido movimiento = new MovimientoAprendido(rst1.getInt("puntospoder_movimiento"), 
                    rst1.getInt("presicion_movimiento"), rst1.getInt("potencia_movimiento"), rst1.getString("nombre_movimiento"), 
                    rst1.getInt("id_elemento"), rst1.getBoolean("envenena_movimiento"), rst1.getBoolean("confunde_movimiento"), 
                    false, rst1.getBoolean("congela_movimiento"), rst1.getBoolean("quema_movimiento"), 
                    rst1.getBoolean("duerme_movimiento"), rst1.getBoolean("contacto_movimiento"), rst1.getInt("puntospoder_movimiento"));
        rst1.close();
        stmt1.close();
        return movimiento;    
    }
    
}
