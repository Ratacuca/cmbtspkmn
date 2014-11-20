/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public class MovimientoAprendido extends Movimiento{
    
   private int puntos_poder_restantes;
   
   public MovimientoAprendido(int cantidad_pp, int precision, int potencia, String nombre, 
            int tipo, Boolean envenena, Boolean confunde, Boolean paraliza, 
            Boolean congela, Boolean quema, Boolean duerme, Boolean contacto, int puntos_poder_restantes){
       super(cantidad_pp, precision, potencia, nombre, tipo, envenena, confunde, paraliza, congela, quema, duerme, contacto);
       this.puntos_poder_restantes = puntos_poder_restantes;
   }

    public int getPuntos_poder_restantes() {
        return puntos_poder_restantes;
    }

    public void setPuntos_poder_restantes(int puntos_poder_restantes) {
        this.puntos_poder_restantes = puntos_poder_restantes;
    }
}
