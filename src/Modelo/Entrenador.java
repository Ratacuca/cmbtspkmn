/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public class Entrenador {
    
    private String nombre;
    private Pokemon[] pokemones;
    private String region;
    private int medallas_adquiridas;
    private int victorias_torre_batalla;
    private String distincion;
    private int ranking;
    private int id_entrenador;
    private int id_medalla;
    
    public Entrenador(String nombre, Pokemon[] pokemones, String region,
            int medallas_adquiridas, int victorias_torre_batalla, String distincion){
        
        this.pokemones = pokemones;
        this.distincion = distincion;
        this.medallas_adquiridas = medallas_adquiridas;
        this.nombre = nombre;
        this.region = region;
        this.victorias_torre_batalla = victorias_torre_batalla;
    }
    //Constructor Entrenadores
    public Entrenador(String nombre, Pokemon[] pokemones, int id_entrenador){
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.id_entrenador = id_entrenador;
        
    }
    //Constructor Lideres
    public Entrenador(String nombre, String region, String distincion, int id_entrenador, int id_medalla) {
        this.nombre = nombre;
        this.region = region;
        this.distincion = distincion;
        this.id_entrenador = id_entrenador;
        this.id_medalla = id_medalla;
    }
    
    public Entrenador(){
        
    }
    public Entrenador(String nombre,int ranking){
        this.ranking = ranking;
        this.nombre = nombre;
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
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    /**
     * @return the pokemones
     */
    public Pokemon[] getPokemones() {
        
        return pokemones;
    }

    /**
     * @param pokemones the pokemones to set
     */
    public void setPokemones(Pokemon[] pokemones) {
        this.pokemones = pokemones;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the medallas_adquiridas
     */
    public int getMedallas_adquiridas() {
        return medallas_adquiridas;
    }

    /**
     * @param medallas_adquiridas the medallas_adquiridas to set
     */
    public void setMedallas_adquiridas(int medallas_adquiridas) {
        this.medallas_adquiridas = medallas_adquiridas;
    }

    /**
     * @return the victorias_torre_batalla
     */
    public int getVictorias_torre_batalla() {
        return victorias_torre_batalla;
    }

    /**
     * @param victorias_torre_batalla the victorias_torre_batalla to set
     */
    public void setVictorias_torre_batalla(int victorias_torre_batalla) {
        this.victorias_torre_batalla = victorias_torre_batalla;
    }

    /**
     * @return the distincion
     */
    public String getDistincion() {
        return distincion;
    }

    /**
     * @param distincion the distincion to set
     */
    public void setDistincion(String distincion) {
        this.distincion = distincion;
    }
           
}
