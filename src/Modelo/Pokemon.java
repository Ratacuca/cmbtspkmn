/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public class Pokemon extends EspeciePokemon {
    
    private String nombre;
    private int nivel;
    private int ranking;
    private int ataque;
    private int defensa;
    private int ataque_especial;
    private int defensa_especial;
    private int vida;
    private Habilidad habilidad;
    private String[] estado;
    private int prueba;
    private int pruebamario;
    
    public Pokemon (String nombre, int nivel, int ranking, int ataque, 
            int defensa, int ataque_especial, int defensa_especial, int vida, 
            Habilidad habilidad, String[] estado){
        
        this.ataque = ataque;
        this.ataque_especial= ataque_especial;
        this.defensa = defensa;
        this.defensa_especial = defensa_especial;
        this.estado = estado;
        this.habilidad = habilidad;
        this.nivel = nivel;
        this.nombre = nombre;
        this.ranking = ranking;
        this.vida = vida;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the ranking
     */
    public int getRanking() {
        return ranking;
    }

    /**
     * @param ranking the ranking to set
     */
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    /**
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * @return the defensa
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * @param defensa the defensa to set
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * @return the ataque_especial
     */
    public int getAtaque_especial() {
        return ataque_especial;
    }

    /**
     * @param ataque_especial the ataque_especial to set
     */
    public void setAtaque_especial(int ataque_especial) {
        this.ataque_especial = ataque_especial;
    }

    /**
     * @return the defensa_especial
     */
    public int getDefensa_especial() {
        return defensa_especial;
    }

    /**
     * @param defensa_especial the defensa_especial to set
     */
    public void setDefensa_especial(int defensa_especial) {
        this.defensa_especial = defensa_especial;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the habilidad
     */
    public Habilidad getHabilidad() {
        return habilidad;
    }

    /**
     * @param habilidad the habilidad to set
     */
    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    /**
     * @return the estado
     */
    public String[] getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String[] estado) {
        this.estado = estado;
    }
    
}
