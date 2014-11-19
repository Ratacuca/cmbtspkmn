/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public class Pokemon extends EspeciePokemon {
    
    private String pseudonimo;
    private int nivel;
    private int ranking;
    private int ataque;
    private int defensa;
    private int ataque_especial;
    private int defensa_especial;
    private int vida;
    private int vida_restante;
    private Habilidad habilidad;
    private Boolean confuso;
    private Boolean paralizado;
    private Boolean envenenado;
    private Boolean congelado;
    private Boolean dormido;
    private Boolean quemado;
    
    
    public Pokemon (String nombre_especie, String especie, 
            String naturaleza_primaria, String naturaleza_secundaria, 
            String[] debilidades, String[] fortalezas, int id_pokedex, 
            String pseudonimo, int nivel, int ataque, int defensa, int ataque_especial, int defensa_especial, int vida){
        
       super(nombre_especie, especie, naturaleza_primaria, naturaleza_secundaria, debilidades, fortalezas, id_pokedex);
       this.pseudonimo = pseudonimo;
       this.ataque = ataque;
       this.ataque_especial = ataque_especial;
       this.defensa = defensa;
       this.defensa_especial = defensa_especial;
       this.nivel = nivel;
       this.vida = vida;
       
    }
    

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque_especial() {
        return ataque_especial;
    }

    public void setAtaque_especial(int ataque_especial) {
        this.ataque_especial = ataque_especial;
    }

    public int getDefensa_especial() {
        return defensa_especial;
    }

    public void setDefensa_especial(int defensa_especial) {
        this.defensa_especial = defensa_especial;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida_restante() {
        return vida_restante;
    }

    public void setVida_restante(int vida_restante) {
        this.vida_restante = vida_restante;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public Boolean getConfuso() {
        return confuso;
    }

    public void setConfuso(Boolean confuso) {
        this.confuso = confuso;
    }

    public Boolean getParalizado() {
        return paralizado;
    }

    public void setParalizado(Boolean paralizado) {
        this.paralizado = paralizado;
    }

    public Boolean getEnvenenado() {
        return envenenado;
    }

    public void setEnvenenado(Boolean envenenado) {
        this.envenenado = envenenado;
    }

    public Boolean getCongelado() {
        return congelado;
    }

    public void setCongelado(Boolean congelado) {
        this.congelado = congelado;
    }

    public Boolean getDormido() {
        return dormido;
    }

    public void setDormido(Boolean dormido) {
        this.dormido = dormido;
    }

    public Boolean getQuemado() {
        return quemado;
    }

    public void setQuemado(Boolean quemado) {
        this.quemado = quemado;
    }

    

    
    
}
