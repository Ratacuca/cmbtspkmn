/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public class PosibleMovimiento extends Movimiento{
     
    private int nivel_necesario;
    
    public PosibleMovimiento(int cantidad_pp, int precision, int potencia, String nombre, 
            int tipo, Boolean envenena, Boolean confunde, Boolean paraliza, 
            Boolean congela, Boolean quema, Boolean duerme, Boolean contacto, int nivel_necesario){
       super(cantidad_pp, precision, potencia, nombre, tipo, envenena, confunde, paraliza, congela, quema, duerme, contacto);
       this.nivel_necesario = nivel_necesario;
    }

    public int getNivel_necesario() {
        return nivel_necesario;
    }

    public void setNivel_necesario(int nivel_necesario) {
        this.nivel_necesario = nivel_necesario;
    }
}
