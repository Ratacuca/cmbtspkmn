/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public class Pokemon extends EspeciePokemon {
    
    private String pseudonimo;
    private int nivel;
    private int ataque;
    private int defensa;
    private int ataque_especial;
    private int defensa_especial;
    private int vida;
    private int vida_restante;
    private int velocidad;
    private Habilidad habilidad;
    private Boolean confuso = false;
    private Boolean paralizado = false;
    private Boolean envenenado = false;
    private Boolean congelado = false;
    private Boolean dormido = false;
    private Boolean quemado = false;
    private MovimientoAprendido[] movimientos = new MovimientoAprendido[4];
    private Boolean debilitado;
    private int id_pokemon;
    
    
    public Pokemon (String nombre_especie, int naturaleza_primaria, int naturaleza_secundaria, 
            int[] debilidades, int[] fortalezas, int id_pokedex, String pseudonimo, int nivel, 
            int ataque, int defensa, int ataque_especial, int defensa_especial, int vida, int vida_restante){
        
       super(nombre_especie, naturaleza_primaria, naturaleza_secundaria, debilidades, fortalezas, id_pokedex);
       this.pseudonimo = pseudonimo;
       this.ataque = ataque;
       this.ataque_especial = ataque_especial;
       this.defensa = defensa;
       this.defensa_especial = defensa_especial;
       this.nivel = nivel;
       this.vida = vida;
       this.vida_restante = vida_restante;
       this.debilitado = false;
       
    }
    public Pokemon (String nombre_especie, int naturaleza_primaria, int naturaleza_secundaria, 
             int id_pokedex, String pseudonimo, int nivel, int ataque, int defensa, int ataque_especial, 
             int defensa_especial, int vida, int vida_restante){
        
       super(nombre_especie, naturaleza_primaria, naturaleza_secundaria, id_pokedex);
       this.pseudonimo = pseudonimo;
       this.ataque = ataque;
       this.ataque_especial = ataque_especial;
       this.defensa = defensa;
       this.defensa_especial = defensa_especial;
       this.nivel = nivel;
       this.vida = vida;
       this.vida_restante = vida_restante;
       this.debilitado = false;
       
    }
    
    public Pokemon (String nombre_especie,  
            int naturaleza_primaria, int naturaleza_secundaria, int id_pokedex, 
            int nivel, int ataque, int defensa, int ataque_especial, int defensa_especial, int vida, int vida_restante){
        
       super(nombre_especie, naturaleza_primaria, naturaleza_secundaria, id_pokedex);
       this.ataque = ataque;
       this.ataque_especial = ataque_especial;
       this.defensa = defensa;
       this.defensa_especial = defensa_especial;
       this.nivel = nivel;
       this.vida = vida;
       this.vida_restante = vida_restante;
       this.debilitado = false;
       
    }
//constructor funcional
    public Pokemon(String pseudonimo, int nivel, int ataque, int defensa, int ataque_especial, 
            int defensa_especial, int vida, int vida_restante, int velocidad, String nombre_especie, int id_pokedex) {
        super(nombre_especie, id_pokedex);
        this.pseudonimo = pseudonimo;
        this.nivel = nivel;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataque_especial = ataque_especial;
        this.defensa_especial = defensa_especial;
        this.vida = vida;
        this.vida_restante = vida_restante;
        this.velocidad = velocidad;
        this.debilitado = false;
    }
    
    // constructor con id para bd
    public Pokemon(String pseudonimo, int nivel, int ataque, int defensa, int ataque_especial, 
            int defensa_especial, int vida, int vida_restante, int velocidad, String nombre_especie, int id_pokedex, int id_pokemon) {
        super(nombre_especie, id_pokedex);
        this.pseudonimo = pseudonimo;
        this.nivel = nivel;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataque_especial = ataque_especial;
        this.defensa_especial = defensa_especial;
        this.vida = vida;
        this.vida_restante = vida_restante;
        this.velocidad = velocidad;
        this.id_pokemon = id_pokemon;
        this.debilitado = false;
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

    public MovimientoAprendido[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(MovimientoAprendido[] movimientos) {
        this.movimientos = movimientos;
    }

    public Boolean getDebilitado() {
        return debilitado;
    }

    public void setDebilitado(Boolean debilitado) {
        this.debilitado = debilitado;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getId_pokemon() {
        return id_pokemon;
    }

    public void setId_pokemon(int id_pokemon) {
        this.id_pokemon = id_pokemon;
    }

    

    
    
}
