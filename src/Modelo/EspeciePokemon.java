/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public abstract class EspeciePokemon {
    
    private String nombre_especie;
    private String naturaleza_primaria;
    private String naturaleza_secundaria;
    private String region;
    private int id;

    public String getNombre_especie() {
        return nombre_especie;
    }

    public void setNombre_especie(String nombre_especie) {
        this.nombre_especie = nombre_especie;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
