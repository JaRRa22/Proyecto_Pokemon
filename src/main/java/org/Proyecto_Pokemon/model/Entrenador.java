package org.Proyecto_Pokemon.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Entrenador {

    private LinkedList<Pokemon> cajaPoke;
    private String nombre;

    private Pokemon[] equipoPK;

    private Pokemon[] equipoTraspaso;

    private Pokemon[] equipoPK2;


    private static int pokedollars;



    private HashMap<TipoObjetos,Integer> Mochila;


    public void curarEquipos(){
        for (Pokemon p: equipoPK) {
            p.setVitalidadActual(p.getVitalidadMaxima());
            p.setEstaminaActual(p.getEstaminaMaxima());
        }
        for (Pokemon p: equipoPK2) {
            p.setVitalidadActual(p.getVitalidadMaxima());
            p.setEstaminaActual(p.getEstaminaMaxima());
        }

    }
    public Entrenador(String nombre) {
        Random rd = new Random();

        cajaPoke = new LinkedList<>();

        this.nombre = nombre;

        this.pokedollars = rd.nextInt(800,1001);



        this.equipoPK = new Pokemon[6];

        this.equipoTraspaso = new Pokemon[6];

        this.equipoPK2 = new Pokemon[6];

       ;

        this.cajaPoke = new LinkedList<>();

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPokedollars() {
        return pokedollars;
    }

    public void setPokedollars(int pokedollars) {
        this.pokedollars = pokedollars;
    }


    public Pokemon[] getEquipoTrasPaso() {
        return equipoTraspaso;
    }
    public void setEquipoTrasPaso(Pokemon[] equipoTrasPaso) {
        this.equipoTraspaso = equipoTrasPaso;
    }

    public LinkedList<Pokemon> getCajaPoke() {
        return cajaPoke;
    }

    public void setCajaPoke(LinkedList<Pokemon> cajaPoke) {
        this.cajaPoke = cajaPoke;
    }

    public PC getPc() {
        return pc;
    }

    public void setEquipoPK(Pokemon[] equipoPK) {
        this.equipoPK = equipoPK;
    }

    public Pokemon[] getEquipoPK() {
        return equipoPK;
    }

    public void setEquipoPK2(Pokemon[] equipoPK2) {
        this.equipoPK2 = equipoPK2;
    }

    public Pokemon[] getEquipoPK2() {
        return equipoPK2;
    }

    public void setEquipoTraspaso(Pokemon[] equipoTraspaso) {
        this.equipoTraspaso = equipoTraspaso;
    }

    public Pokemon[] getEquipoTraspaso() {
        return equipoTraspaso;
    }


    public boolean cambiarEquipo() {
        for(int i = 0; i < equipoPK.length ; i++){
            equipoTraspaso[i] = equipoPK[i];
            equipoPK[i] = equipoPK2[i];
            equipoPK2[i] = equipoTraspaso[i];
        }
        return true;
    }

    public boolean anadirAEquipo(Pokemon pokemon) {
        for(int i = 0; i < equipoPK.length; i++){
            if(equipoPK[i]== null){
                equipoPK[i] = pokemon;
                return true;
            }
        }
        return false;
    }

    public boolean anadirAEquipo2PK2(Pokemon pokemon) {
        for(int i = 0; i < equipoPK2.length; i++){
            if(equipoPK2[i]== null){
                equipoPK2[i] = pokemon;
                return true;
            }
        }
        return false;
    }



    public boolean sacarDeEquipo(int numero) {
        if (numero <= equipoPK.length && equipoPK[numero] != null) {
            equipoPK[numero] = null;
            return true;
        }
        return true;
    }
    public boolean sacarDeEquipoPK2(int numero) {
        if (numero <= equipoPK2.length && equipoPK2[numero] != null) {
            equipoPK2[numero] = null;
            return true;
        }
        return true;
    }


    public boolean anadirACaja(Pokemon pokemon) {
        cajaPoke.add(pokemon);
        return true;
    }



    public boolean sacarDeCaja() {
        return true;
    }


    public boolean capturar(Pokeball pokeball ,Pokemon pokemon) {
        if(pokeball.usarAtraparPokemon(pokemon)){
            for(int i = 0; i < equipoPK.length;i ++){
                if(equipoPK[i] == null){
                    equipoPK[i] = pokemon;
                }
            }
            if(equipoPK[0] != null && equipoPK[1] != null && equipoPK[2] != null && equipoPK[3] != null && equipoPK[4] != null && equipoPK[5] != null){
                anadirACaja(pokemon);
            }
            return true;
        }
        return false;
    }

    public Pokemon mirarPokeball(Pokeball pokeball){
        return pokeball.saberPokemonAtrapado();
    }

    public boolean comprarTienda() {
        return true;
    }

    public boolean entrenar() {
        return true;
    }


    public boolean combatir() {
        if(this.equipoPK[0] != null){
            return true;
        }
        return false;
    };

    public boolean ponerACriar() {
        return true;
    }

    public boolean usarObjeto() {
        return true;
    }





    @Override

    public String toString() {
        return this.nombre + " " + this.pokedollars + " " ;

    }
}
 