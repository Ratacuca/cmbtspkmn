/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public abstract class Movimiento{
    
    private int cantidad_pp;
    private int precision;
    private int potencia;
    private String nombre;
    private int tipo;
    private Boolean envenena;
    private Boolean confunde;
    private Boolean paraliza;
    private Boolean congela;
    private Boolean quema;
    private Boolean duerme;
    private String tipo_ataque;
    private Boolean contacto;
    private int blanco;
    
   

    public Movimiento(int cantidad_pp, int precision, int potencia, String nombre, 
            int tipo, Boolean envenena, Boolean confunde, Boolean paraliza, 
            Boolean congela, Boolean quema, Boolean duerme, Boolean contacto){
        
    this.cantidad_pp = cantidad_pp;
    this.precision = precision;
    this.potencia = potencia;
    this.nombre = nombre;
    this.tipo = tipo;
    this.envenena = envenena;
    this.confunde = confunde;
    this.paraliza = paraliza;
    this.congela = congela;
    this.quema = quema;
    this.duerme = duerme;
    this.contacto = contacto;   
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
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
