/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Mario Caceres
 */
public class ControladorRegistros {
  
    public ControladorRegistros(){
        
    }
    
    public void guardarAccionUsuario(String accion) throws IOException {
        String nombreArchivo = "Registros Acciones Usuario.txt";
        FileWriter adquirir = new FileWriter("." + nombreArchivo, true);
        PrintWriter procesador = new PrintWriter(adquirir);

        procesador.println(accion);

        procesador.close();
    }
    public void guardarRegistroSimulacion(String accion) throws IOException {
        String nombreArchivo = "Registros Simulaciones.txt";
        FileWriter adquirir = new FileWriter("." + nombreArchivo, true);
        PrintWriter procesador = new PrintWriter(adquirir);

        procesador.println(accion);

        procesador.close();
    }
}
