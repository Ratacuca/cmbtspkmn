/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Mario Caceres
 */
public class ConexionBD {
   
    private Connection conexion;
    
    public ConexionBD()throws SQLException{
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
    
    
    public int guardarEntrenador(String nombre, String categoria, int region) throws SQLException{
        
        
        ResultSet rst1;
        Statement stmt1;
        stmt1 = conexion.createStatement();
        String consulta1 = "SELECT id_entrenador FROM entrenador";
        rst1 = stmt1.executeQuery(consulta1);
        int id = 0;
        while(rst1.next()){
            id = rst1.getInt("id_entrenador");
        }
        id += 1;
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "INSERT INTO entrenador (id_entrenador, nombre_entrenador, categoria_entrenador, id_region) values ("+id+", '"+nombre+"','"+categoria+"', "+region+")";
        int resultado = stmt.executeUpdate(consulta);
        return id;
        
    }
    
    
    public int guardarPokemon(int id, String pseudonimo, int nivel, int hp, 
            int atk, int spatk, int def, int spdef, int vel) throws SQLException{
        
        ResultSet rst1;
        Statement stmt1;
        stmt1 = conexion.createStatement();
        String consulta1 = "SELECT id_pokemon FROM pokemon";
        rst1 = stmt1.executeQuery(consulta1);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        while(rst1.next()){
            ids.add(rst1.getInt("id_pokemon"));
        }
        Integer id_pokemon = 1;
        if(ids.isEmpty()){
           id_pokemon = 1; 
        }
        else{
            id_pokemon = Collections.max(ids)+1;
        }
        rst1.close();
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "INSERT INTO pokemon (id_familiapokemon, id_pokemon, pseudonimo_pokemon, nivel_pokemon, puntossaludtotales_pokemon, puntossaludrestantes, ataque_pokemon, ataqueespecial_pokemon, defensa_pokemon, defensaespecial_pokemon, velocidad_pokemon) values ("+id+", "+id_pokemon+", '"+pseudonimo+"', "+nivel+", "+hp+", "+hp+", "+atk+", "+spatk+", "+def+", "+spdef+", "+vel+")";
        int resultado = stmt.executeUpdate(consulta);
        return id_pokemon;
    }
    
    
    public void guardarMovimiento(int id_familia, int id_pokemon, int pprestantes, int id_movimiento) throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "INSERT INTO movimiento_aprendido (id_familiapokemon, id_movimiento, pok_id_familiapokemon, id_pokemon, puntospoderrestantes_movimientopokemon) values ("+id_familia+", "+id_movimiento+", "+id_familia+", "+id_pokemon+", "+pprestantes+")";
        int resultado = stmt.executeUpdate(consulta);
    }
    
    
    public void actualizarPokemon(int id_pokemon){
        
    }
    
    
    public void guardarEquipo(int id_pokemon, int id_familia, int id_entrenador) throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "INSERT INTO equipopokemon (id_familiapokemon, id_pokemon, id_entrenador) values ("+id_familia+", "+id_pokemon+", "+id_entrenador+")";
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
            rst.getBoolean("contacto_movimiento"), rst.getInt("puntospoder_movimiento"), rst.getInt("id_movimiento")); 
        stmt.close();
        rst.close();
        
        
        return movimiento;
    }
    
    
    public MovimientoAprendido obtenerMovimientoDefault() throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT * FROM Movimiento";
        rst = stmt.executeQuery(consulta);
        rst.next();
        MovimientoAprendido movimiento = new MovimientoAprendido(rst.getInt("puntospoder_movimiento"), rst.getInt("presicion_movimiento"), 
            rst.getInt("potencia_movimiento"), rst.getString("nombre_movimiento"), rst.getInt("id_elemento"), 
            rst.getBoolean("envenena_movimiento"), rst.getBoolean("confunde_movimiento"), false, 
            rst.getBoolean("congela_movimiento"), rst.getBoolean("quema_movimiento"), rst.getBoolean("duerme_movimiento"), 
            rst.getBoolean("contacto_movimiento"), rst.getInt("puntospoder_movimiento"), rst.getInt("id_movimiento")); 
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
            String nombre4, String nombre5, String nombre6, int nivel1, int nivel2, int nivel3, int nivel4, 
            int nivel5, int nivel6, String pseudonimo1, String pseudonimo2, String pseudonimo3, String pseudonimo4, 
            String pseudonimo5, String pseudonimo6) throws SQLException{
        
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
        
            double ataque1 = ((rst1.getInt("Ataquemax_familiapokemon")-rst1.getInt("Ataquebase_familiapokemon"))*nivel1)/99 + 
                    rst1.getInt("Ataquebase_familiapokemon");
            double ataque2 = ((rst2.getInt("Ataquemax_familiapokemon")-rst2.getInt("Ataquebase_familiapokemon"))*nivel2)/99 + 
                    rst2.getInt("Ataquebase_familiapokemon");
            double ataque3 = ((rst3.getInt("Ataquemax_familiapokemon")-rst3.getInt("Ataquebase_familiapokemon"))*nivel3)/99 + 
                    rst3.getInt("Ataquebase_familiapokemon");
            double ataque4 = ((rst4.getInt("Ataquemax_familiapokemon")-rst4.getInt("Ataquebase_familiapokemon"))*nivel4)/99 + 
                    rst4.getInt("Ataquebase_familiapokemon");
            double ataque5 = ((rst5.getInt("Ataquemax_familiapokemon")-rst5.getInt("Ataquebase_familiapokemon"))*nivel5)/99 + 
                    rst5.getInt("Ataquebase_familiapokemon");
            double ataque6 = ((rst6.getInt("Ataquemax_familiapokemon")-rst6.getInt("Ataquebase_familiapokemon"))*nivel6)/99 + 
                    rst6.getInt("Ataquebase_familiapokemon");
            double ataquesp1 = ((rst1.getInt("Ataqueespecialmax_familiapokemon")-rst1.getInt("Ataqueespecialbase_familiapokemon"))*nivel1)/99 + 
                    rst1.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp2 = ((rst2.getInt("Ataqueespecialmax_familiapokemon")-rst2.getInt("Ataqueespecialbase_familiapokemon"))*nivel2)/99 + 
                    rst2.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp3 = ((rst3.getInt("Ataqueespecialmax_familiapokemon")-rst3.getInt("Ataqueespecialbase_familiapokemon"))*nivel3)/99 + 
                    rst3.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp4 = ((rst4.getInt("Ataqueespecialmax_familiapokemon")-rst4.getInt("Ataqueespecialbase_familiapokemon"))*nivel4)/99 + 
                    rst4.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp5 = ((rst5.getInt("Ataqueespecialmax_familiapokemon")-rst5.getInt("Ataqueespecialbase_familiapokemon"))*nivel5)/99 + 
                    rst5.getInt("Ataqueespecialbase_familiapokemon");
            double ataquesp6 = ((rst6.getInt("Ataqueespecialmax_familiapokemon")-rst6.getInt("Ataqueespecialbase_familiapokemon"))*nivel6)/99 + 
                    rst6.getInt("Ataqueespecialbase_familiapokemon");
            double defensa1 = ((rst1.getInt("Defensamax_familiapokemon")-rst1.getInt("Defensabase_familiapokemon")*nivel1))/99 + 
                    rst1.getInt("Defensabase_familiapokemon");
            double defensa2 = ((rst2.getInt("Defensamax_familiapokemon")-rst2.getInt("Defensabase_familiapokemon"))*nivel2)/99 + 
                    rst2.getInt("Defensabase_familiapokemon");
            double defensa3 = ((rst3.getInt("Defensamax_familiapokemon")-rst3.getInt("Defensabase_familiapokemon"))*nivel3)/99 + 
                    rst3.getInt("Defensabase_familiapokemon");
            double defensa4 = ((rst4.getInt("Defensamax_familiapokemon")-rst4.getInt("Defensabase_familiapokemon"))*nivel4)/99 + 
                    rst4.getInt("Defensabase_familiapokemon");
            double defensa5 = ((rst5.getInt("Defensamax_familiapokemon")-rst5.getInt("Defensabase_familiapokemon"))*nivel5)/99 + 
                    rst5.getInt("Defensabase_familiapokemon");
            double defensa6 = ((rst6.getInt("Defensamax_familiapokemon")-rst6.getInt("Defensabase_familiapokemon"))*nivel6)/99 + 
                    rst6.getInt("Defensabase_familiapokemon");
            double defensasp1 = ((rst1.getInt("Defensaespecialmax_familiapokemon")-rst1.getInt("Defensaespecialbase_familiapokemon"))*nivel1)/99 + 
                    rst1.getInt("Defensaespecialbase_familiapokemon");
            double defensasp2 = ((rst2.getInt("Defensaespecialmax_familiapokemon")-rst2.getInt("Defensaespecialbase_familiapokemon"))*nivel2)/99 + 
                    rst2.getInt("Defensaespecialbase_familiapokemon");
            double defensasp3 = ((rst3.getInt("Defensaespecialmax_familiapokemon")-rst3.getInt("Defensaespecialbase_familiapokemon"))*nivel3)/99 + 
                    rst3.getInt("Defensaespecialbase_familiapokemon");
            double defensasp4 = ((rst4.getInt("Defensaespecialmax_familiapokemon")-rst4.getInt("Defensaespecialbase_familiapokemon"))*nivel4)/99 + 
                    rst4.getInt("Defensaespecialbase_familiapokemon");
            double defensasp5 = ((rst5.getInt("Defensaespecialmax_familiapokemon")-rst5.getInt("Defensaespecialbase_familiapokemon"))*nivel5)/99 + 
                    rst5.getInt("Defensaespecialbase_familiapokemon");
            double defensasp6 = ((rst6.getInt("Defensaespecialmax_familiapokemon")-rst6.getInt("Defensaespecialbase_familiapokemon"))*nivel6)/99 + 
                    rst6.getInt("Defensaespecialbase_familiapokemon");
            double vida1 = ((rst1.getInt("hpmax_familiapokemon")-rst1.getInt("hpbase_familiapokemon"))*nivel1)/99 + 
                    rst1.getInt("hpbase_familiapokemon");
            double vida2 = ((rst2.getInt("hpmax_familiapokemon")-rst2.getInt("hpbase_familiapokemon"))*nivel2)/99 + 
                    rst2.getInt("hpbase_familiapokemon");
            double vida3 = ((rst3.getInt("hpmax_familiapokemon")-rst3.getInt("hpbase_familiapokemon"))*nivel3)/99 + 
                    rst3.getInt("hpbase_familiapokemon");
            double vida4 = ((rst4.getInt("hpmax_familiapokemon")-rst4.getInt("hpbase_familiapokemon"))*nivel4)/99 + 
                    rst4.getInt("hpbase_familiapokemon");
            double vida5 = ((rst5.getInt("hpmax_familiapokemon")-rst5.getInt("hpbase_familiapokemon"))*nivel5)/99 + 
                    rst5.getInt("hpbase_familiapokemon");
            double vida6 = ((rst6.getInt("hpmax_familiapokemon")-rst6.getInt("hpbase_familiapokemon"))*nivel6)/99 + 
                    rst6.getInt("hpbase_familiapokemon");
            double velocidad1 = ((rst1.getInt("velocidadmax_familiapokemon")-rst1.getInt("velocidadbase_familiapokemon"))*nivel1)/99 + 
                    rst1.getInt("velocidadbase_familiapokemon");
            double velocidad2 = ((rst2.getInt("velocidadmax_familiapokemon")-rst2.getInt("velocidadbase_familiapokemon"))*nivel2)/99 + 
                    rst2.getInt("velocidadbase_familiapokemon");
            double velocidad3 = ((rst3.getInt("velocidadmax_familiapokemon")-rst3.getInt("velocidadbase_familiapokemon"))*nivel3)/99 + 
                    rst3.getInt("velocidadbase_familiapokemon");
            double velocidad4 = ((rst4.getInt("velocidadmax_familiapokemon")-rst4.getInt("velocidadbase_familiapokemon"))*nivel4)/99 + 
                    rst4.getInt("velocidadbase_familiapokemon");
            double velocidad5 = ((rst5.getInt("velocidadmax_familiapokemon")-rst5.getInt("velocidadbase_familiapokemon"))*nivel5)/99 + 
                    rst5.getInt("velocidadbase_familiapokemon");
            double velocidad6 = ((rst6.getInt("velocidadmax_familiapokemon")-rst6.getInt("velocidadbase_familiapokemon"))*nivel6)/99 + 
                    rst6.getInt("velocidadbase_familiapokemon");
            Pokemon pokemon1 = new Pokemon(pseudonimo1, nivel1,(int)ataque1, (int)defensa1, (int)ataquesp1, (int)defensasp1, 
                    (int)vida1, (int)vida1, (int)velocidad1, nombre1, rst1.getInt("id_familiapokemon"));
            Pokemon pokemon2 = new Pokemon(pseudonimo2, nivel2,(int)ataque2, (int)defensa2, (int)ataquesp2, (int)defensasp2, 
                    (int)vida2, (int)vida2, (int)velocidad2, nombre2, rst2.getInt("id_familiapokemon"));
            Pokemon pokemon3 = new Pokemon(pseudonimo3, nivel3,(int)ataque3, (int)defensa3, (int)ataquesp3, (int)defensasp3, 
                    (int)vida3, (int)vida3, (int)velocidad3, nombre3, rst3.getInt("id_familiapokemon"));
            Pokemon pokemon4 = new Pokemon(pseudonimo4, nivel4,(int)ataque4, (int)defensa4, (int)ataquesp4, (int)defensasp4, 
                    (int)vida4, (int)vida4, (int)velocidad4, nombre4, rst4.getInt("id_familiapokemon"));
            Pokemon pokemon5 = new Pokemon(pseudonimo5, nivel5,(int)ataque5, (int)defensa5, (int)ataquesp5, (int)defensasp5, 
                    (int)vida5, (int)vida5, (int)velocidad5, nombre5, rst5.getInt("id_familiapokemon"));
            Pokemon pokemon6 = new Pokemon(pseudonimo6, nivel6,(int)ataque6, (int)defensa6, (int)ataquesp6, (int)defensasp6, 
                    (int)vida6, (int)vida6, (int)velocidad6, nombre6, rst6.getInt("id_familiapokemon"));
            
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
    
    
    public Pokemon crearPokemon(String nombre, int nivel, String pseudonimo) throws SQLException{
        
        ResultSet rst;
        
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT * FROM Familia_pokemon WHERE nombre_familiapokemon='"+nombre+"'";
        
        rst = stmt.executeQuery(consulta);
        rst.next();
            double ataque = ((rst.getInt("Ataquemax_familiapokemon")-rst.getInt("Ataquebase_familiapokemon"))*nivel)/99 + 
                    rst.getInt("Ataquebase_familiapokemon");
            
            double ataquesp = ((rst.getInt("Ataqueespecialmax_familiapokemon")-rst.getInt("Ataqueespecialbase_familiapokemon"))*nivel)/99 + 
                    rst.getInt("Ataqueespecialbase_familiapokemon");
            
            double defensa = ((rst.getInt("Defensamax_familiapokemon")-rst.getInt("Defensabase_familiapokemon")*nivel))/99 + 
                    rst.getInt("Defensabase_familiapokemon");
            
            double defensasp = ((rst.getInt("Defensaespecialmax_familiapokemon")-rst.getInt("Defensaespecialbase_familiapokemon"))*nivel)/99 + 
                    rst.getInt("Defensaespecialbase_familiapokemon");
            
            double vida = ((rst.getInt("hpmax_familiapokemon")-rst.getInt("hpbase_familiapokemon"))*nivel)/99 + 
                    rst.getInt("hpbase_familiapokemon");
            
            double velocidad = ((rst.getInt("velocidadmax_familiapokemon")-rst.getInt("velocidadbase_familiapokemon"))*nivel)/99 + 
                    rst.getInt("velocidadbase_familiapokemon");
            
            Pokemon pokemon = new Pokemon(pseudonimo, nivel,(int)ataque, (int)defensa, (int)ataquesp, (int)defensasp, 
                    (int)vida, (int)vida, (int)velocidad, nombre, rst.getInt("id_familiapokemon"));
        rst.close();
        return pokemon;
        
    }
    
    
    public ArrayList<String> obtenerNombresEntrenadores() throws SQLException{
        ResultSet rst;
        Statement stmt;
        ArrayList<String> entrenadores = new ArrayList<String>();
        stmt = conexion.createStatement();
        String consulta = "SELECT nombre_entrenador FROM entrenador WHERE id_entrenador > 55";
        rst = stmt.executeQuery(consulta);
        
        while(rst.next()){
            String nombre = rst.getString("nombre_entrenador").trim();
            System.out.println("Nombre: " + nombre);
            entrenadores.add(nombre);
        }
        rst.close();
        return entrenadores;
    }
    
    
    public Pokemon[] obtenerEquipo(int id_entrenador) throws SQLException{
        ResultSet rst;
        Statement stmt;
        Pokemon[] equipo = new Pokemon[6];
        stmt = conexion.createStatement();
        String consulta = "SELECT * FROM equipopokemon WHERE id_entrenador = "+id_entrenador+"";
        rst = stmt.executeQuery(consulta);
        int i = 0;
        while(rst.next()){
            
            equipo[i] = obtenerPokemon(rst.getInt("id_pokemon"));
            i = i+1;
        }
        return equipo;
    }
    
    public Pokemon obtenerPokemon(int id_pokemon) throws SQLException{
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT * FROM pokemon WHERE id_pokemon = "+id_pokemon+"";
        rst = stmt.executeQuery(consulta);
        rst.next();
        String nombre = obtenerNombrePokemon(rst.getInt("id_familiapokemon"));
        Pokemon pokemon = new Pokemon(rst.getString("pseudonimo_pokemon").trim(), rst.getInt("nivel_pokemon"),rst.getInt("ataque_pokemon"), 
                    rst.getInt("defensa_pokemon"), rst.getInt("ataqueespecial_pokemon"), rst.getInt("defensaespecial_pokemon"), 
                    rst.getInt("puntossaludtotales_pokemon"), rst.getInt("puntossaludtotales_pokemon"), rst.getInt("velocidad_pokemon"), 
                    nombre, rst.getInt("id_familiapokemon"), rst.getInt("id_pokemon"));
        
        return pokemon;
    }
    
    public String obtenerNombrePokemon(int id)throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT nombre_familiapokemon FROM familia_pokemon WHERE id_familiapokemon = "+id+"";
        rst = stmt.executeQuery(consulta);
        rst.next();
        String nombre = rst.getString("nombre_familiapokemon").trim();
       
        rst.close();
        
        return nombre;
    }
    public String obtenerNombreEntrenador(int id)throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT nombre_entrenador FROM entrenador WHERE id_entrenador = "+id+"";
        rst = stmt.executeQuery(consulta);
        rst.next();
        String nombre = rst.getString("nombre_entrenador").trim();
       
        rst.close();
        
        return nombre;
    }
    public String obtenerDistincionEntrenador(int id)throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT categoria_entrenador FROM entrenador WHERE id_entrenador = "+id+"";
        rst = stmt.executeQuery(consulta);
        rst.next();
        String categoria = rst.getString("categoria_entrenador").trim();
       
        rst.close();
        
        return categoria;
    }
    public ArrayList<String> obtenerNombresEntrenadoresNPC()throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        ArrayList<String> npc = new ArrayList<String>();
        stmt = conexion.createStatement();
        String consulta = "SELECT nombre_entrenador FROM entrenador WHERE id_entrenador < 56 ";
        rst = stmt.executeQuery(consulta);
        while(rst.next()){
            String nombre = rst.getString("nombre_entrenador").trim();
            System.out.println("Nombre: " + nombre);
            npc.add(nombre);
        }
        rst.close();
        return npc;
    }
    
    public MovimientoAprendido[] obtenerMovesetPokemon(int id_pokemon) throws SQLException{
        MovimientoAprendido[] moveset = new MovimientoAprendido[4];
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT * FROM movimiento_aprendido WHERE id_pokemon = "+id_pokemon+"";
        rst = stmt.executeQuery(consulta);
        int i=0;
        
        while(rst.next()){
            MovimientoAprendido movimiento = obtenerMovimientoPorID(rst.getInt("id_movimiento"));
            moveset[i] = movimiento;
            i = i+1;
        }
        rst.close();
        return moveset;
    }
    
    public MovimientoAprendido obtenerMovimientoPorID(int id) throws SQLException{
        
        ResultSet rst;
        Statement stmt;
        stmt = conexion.createStatement();
        String consulta = "SELECT * FROM Movimiento WHERE id_movimiento=" + id + "";
        rst = stmt.executeQuery(consulta);
        rst.next();
        MovimientoAprendido movimiento = new MovimientoAprendido(rst.getInt("puntospoder_movimiento"), rst.getInt("presicion_movimiento"), 
            rst.getInt("potencia_movimiento"), rst.getString("nombre_movimiento").trim(), rst.getInt("id_elemento"), 
            rst.getBoolean("envenena_movimiento"), rst.getBoolean("confunde_movimiento"), false, 
            rst.getBoolean("congela_movimiento"), rst.getBoolean("quema_movimiento"), rst.getBoolean("duerme_movimiento"), 
            rst.getBoolean("contacto_movimiento"), rst.getInt("puntospoder_movimiento"), rst.getInt("id_movimiento")); 
        stmt.close();
        rst.close();
        
        
        return movimiento;
    }
    
    
    
   
    
}
