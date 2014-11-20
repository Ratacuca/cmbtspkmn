/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public abstract class EspeciePokemon {
    
    private String nombre_especie;
    private String especie;
    private String naturaleza_primaria;
    private String naturaleza_secundaria;
    private String[] debilidades;
    private String[] fortalezas;
    private int id_pokedex;
    
    public EspeciePokemon(String nombre_especie, String especie, 
            String naturaleza_primaria, String naturaleza_secundaria, 
            String[] debilidades, String[] fortalezas, int id_pokedex){
        
        this.debilidades = debilidades;
        this.especie = especie;
        this.fortalezas = fortalezas;
        this.id_pokedex = id_pokedex;
        this.naturaleza_primaria = naturaleza_primaria;
        this.naturaleza_secundaria = naturaleza_secundaria;
        this.nombre_especie = nombre_especie;
        
    }
    public EspeciePokemon(String nombre_especie, String especie, 
            String naturaleza_primaria, String naturaleza_secundaria, 
            int id_pokedex){
        
        this.especie = especie;
        this.id_pokedex = id_pokedex;
        this.naturaleza_primaria = naturaleza_primaria;
        this.naturaleza_secundaria = naturaleza_secundaria;
        this.nombre_especie = nombre_especie;
        
    }

    public String getNombre_especie() {
        return nombre_especie;
    }

    public void setNombre_especie(String nombre_especie) {
        this.nombre_especie = nombre_especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNaturaleza_primaria() {
        return naturaleza_primaria;
    }

    public void setNaturaleza_primaria(String naturaleza_primaria) {
        this.naturaleza_primaria = naturaleza_primaria;
    }

    public String getNaturaleza_secundaria() {
        return naturaleza_secundaria;
    }

    public void setNaturaleza_secundaria(String naturaleza_secundaria) {
        this.naturaleza_secundaria = naturaleza_secundaria;
    }

    public String[] getDebilidades() {
        return debilidades;
    }

    public void setDebilidades(String[] debilidades) {
        this.debilidades = debilidades;
    }

    public String[] getFortalezas() {
        return fortalezas;
    }

    public void setFortalezas(String[] fortalezas) {
        this.fortalezas = fortalezas;
    }

    public int getId_pokedex() {
        return id_pokedex;
    }

    public void setId_pokedex(int id_pokedex) {
        this.id_pokedex = id_pokedex;
    }

    

    
    
    
}
