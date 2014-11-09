/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public class Movimiento{
    
    private int cantidad_pp;
    private int precision;
    private int potencia;
    private int nivel_requerido;
    private String tipo;
    private String efecto;
    private String tipo_ataque;
    private Boolean contacto;
    private int blanco;
    
    public Movimiento(int cantidad_pp, int precision, int potencia, String tipo,
            String efecto, String tipo_ataque, Boolean contacto, int blanco){
        
        this.blanco = blanco;
        this.cantidad_pp = cantidad_pp;
        this.contacto = contacto;
        this.efecto = efecto;
        this.potencia = potencia;
        this.precision = precision;
        this.tipo = tipo;
        this.tipo_ataque = tipo_ataque;
    }

    /**
     * @return the cantidad_pp
     */
    public int getCantidad_pp() {
        return cantidad_pp;
    }

    /**
     * @param cantidad_pp the cantidad_pp to set
     */
    public void setCantidad_pp(int cantidad_pp) {
        this.cantidad_pp = cantidad_pp;
    }

    /**
     * @return the precision
     */
    public int getPrecision() {
        return precision;
    }

    /**
     * @param precision the precision to set
     */
    public void setPrecision(int precision) {
        this.precision = precision;
    }

    /**
     * @return the potencia
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * @param potencia the potencia to set
     */
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    /**
     * @return the nivel_requerido
     */
    public int getNivel_requerido() {
        return nivel_requerido;
    }

    /**
     * @param nivel_requerido the nivel_requerido to set
     */
    public void setNivel_requerido(int nivel_requerido) {
        this.nivel_requerido = nivel_requerido;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the efecto
     */
    public String getEfecto() {
        return efecto;
    }

    /**
     * @param efecto the efecto to set
     */
    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    /**
     * @return the tipo_ataque
     */
    public String getTipo_ataque() {
        return tipo_ataque;
    }

    /**
     * @param tipo_ataque the tipo_ataque to set
     */
    public void setTipo_ataque(String tipo_ataque) {
        this.tipo_ataque = tipo_ataque;
    }

    /**
     * @return the contacto
     */
    public Boolean getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(Boolean contacto) {
        this.contacto = contacto;
    }

    /**
     * @return the blanco
     */
    public int getBlanco() {
        return blanco;
    }

    /**
     * @param blanco the blanco to set
     */
    public void setBlanco(int blanco) {
        this.blanco = blanco;
    }
    
    
}
