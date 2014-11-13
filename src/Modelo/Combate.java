/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public class Combate {
    
    private Entrenador ganador;
    private Entrenador perdedor;
    private int numero_turnos;

    public Entrenador getGanador() {
        return ganador;
    }

    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    public Entrenador getPerdedor() {
        return perdedor;
    }

    public void setPerdedor(Entrenador perdedor) {
        this.perdedor = perdedor;
    }

    public int getNumero_turnos() {
        return numero_turnos;
    }

    public void setNumero_turnos(int numero_turnos) {
        this.numero_turnos = numero_turnos;
    }
    
    
 
}
