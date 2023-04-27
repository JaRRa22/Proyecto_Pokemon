package org.Proyecto_Pokemon.model;

import java.util.*;

public class Entrenador {
    private static LinkedList<Pokemon> cajaPoke;
    private static String nombre;
    private static Pokemon[] equipoPK =new Pokemon[6];
    private static Pokemon[] equipoTraspaso;
    private static Pokemon[] equipoPK2;
    private static int pokedollars;
    private static List<Objeto> mochila;

    private static boolean haActuado;

    //TODO Comentar esta linea luego


    public Entrenador(String nombre) {
        Random rd = new Random();
        cajaPoke = new LinkedList<>();
        this.nombre = nombre;
        pokedollars = rd.nextInt(800,1001);
        Entrenador.equipoPK = new Pokemon[6];
        Entrenador.equipoTraspaso = new Pokemon[6];
        Entrenador.equipoPK2 = new Pokemon[6];
        mochila = new ArrayList<>();
        this.cajaPoke = new LinkedList<>();
    }

    public static boolean cambiarEquipo() {
        for(int i = 0; i < equipoPK.length ; i++){
            equipoTraspaso[i] = equipoPK[i];
            equipoPK[i] = equipoPK2[i];
            equipoPK2[i] = equipoTraspaso[i];
        }
        return true;
    }

    public static boolean anadirAEquipo(Pokemon pokemon) {
        for(int i = 0; i < equipoPK.length; i++){
            if(equipoPK[i]== null){
                equipoPK[i] = pokemon;
                return true;
            }
        }
        return false;
    }

    public static boolean anadirAEquipo2PK2(Pokemon pokemon) {
        for(int i = 0; i < equipoPK2.length; i++){
            if(equipoPK2[i]== null){
                equipoPK2[i] = pokemon;
                return true;
            }
        }
        return false;
    }

    public static boolean sacarDeEquipo(int numero) {
        if (numero <= equipoPK.length && equipoPK[numero] != null) {
            equipoPK[numero] = null;
            return true;
        }
        return true;
    }
    public static boolean sacarDeEquipoPK2(int numero) {
        if (numero <= equipoPK2.length && equipoPK2[numero] != null) {
            equipoPK2[numero] = null;
            return true;
        }
        return true;
    }
    public static boolean introducirElementos(Objeto obje) {
        mochila.add(obje);
        return true;
    }


    public static boolean anadirACaja(Pokemon pokemon) {
        cajaPoke.add(pokemon);
        return true;
    }



    public static boolean sacarDeCaja() {
        return true;
    }
    public static void curarEquipos(){
        for (Pokemon p: equipoPK) {
            p.setVitalidadActual(p.getVitalidadMaxima());
            p.setEstaminaActual(p.getEstaminaMaxima());
        }
        for (Pokemon p: equipoPK2) {
            p.setVitalidadActual(p.getVitalidadMaxima());
            p.setEstaminaActual(p.getEstaminaMaxima());
        }
    }

    public static void setMochila(List<Objeto> mochila) {
        Entrenador.mochila = mochila;
    }

    public static boolean isHaActuado() {
        return haActuado;
    }

    public static void setHaActuado(boolean haActuado) {
        Entrenador.haActuado = haActuado;
    }

    public static boolean capturar(Pokeball pokeball , Pokemon pokemon) {
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

    public static Pokemon mirarPokeball(Pokeball pokeball){
        return pokeball.saberPokemonAtrapado();
    }

    public static boolean comprarTienda() {
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


    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Entrenador.nombre = nombre;
    }

    public static int getPokedollars() {
        return pokedollars;
    }

    public static void setPokedollars(int pokedollars) {
        Entrenador.pokedollars = pokedollars;
    }


    public Pokemon[] getEquipoTrasPaso() {
        return equipoTraspaso;
    }
    public void setEquipoTrasPaso(Pokemon[] equipoTrasPaso) {
        equipoTraspaso = equipoTrasPaso;
    }

    public LinkedList<Pokemon> getCajaPoke() {
        return cajaPoke;
    }

    public void setCajaPoke(LinkedList<Pokemon> cajaPoke) {
        Entrenador.cajaPoke = cajaPoke;
    }


    public void setEquipoPK(Pokemon[] equipoPK) {
        Entrenador.equipoPK = equipoPK;
    }

    public static Pokemon[] getEquipoPK() {
        return equipoPK;
    }

    public void setEquipoPK2(Pokemon[] equipoPK2) {
        Entrenador.equipoPK2 = equipoPK2;
    }

    public Pokemon[] getEquipoPK2() {
        return equipoPK2;
    }

    public void setEquipoTraspaso(Pokemon[] equipoTraspaso) {
        Entrenador.equipoTraspaso = equipoTraspaso;
    }

    public Pokemon[] getEquipoTraspaso() {
        return equipoTraspaso;
    }

    public static List<Objeto> getMochila() {
        return mochila;
    }

    public void setMochila(HashMap<TipoObjetos, Integer> mochila) {
        mochila = mochila;
    }






    @Override

    public String toString() {
        return nombre + " " + pokedollars + " " ;

    }
}