package org.Proyecto_Pokemon.model;

import java.util.*;

public class Entrenador {
    private static LinkedList<Pokemon> cajaPoke;
    private String nombre;
    private static Pokemon[] equipoPK;
    private static Pokemon[] equipoTraspaso;
    private static Pokemon[] equipoPK2;
    private static int pokedollars;
    private static HashMap<Objeto, Integer> mochila;
    private static ObjetoEquipable baston;
    private static ObjetoEquipable pesa;
    private static ObjetoEquipable chaleco;
    private static ObjetoEquipable pilas;
    private static ObjetoEquipable pluma;
    private static Pokeball pokeball;
    private static Pokeball superball;
    private static Pokeball masterball;
    private static Pokeball ultraball;

    public Entrenador(String nombre) {
        Entrenador.pokeball = new Pokeball(TipoObjetos.POKEBALL, TipoPokeball.POKEBALL);
        Entrenador.superball = new Pokeball(TipoObjetos.POKEBALL, TipoPokeball.SUPERBALL);
        Entrenador.masterball = new Pokeball(TipoObjetos.POKEBALL, TipoPokeball.MASTERBALL);
        Entrenador.ultraball = new Pokeball(TipoObjetos.POKEBALL, TipoPokeball.ULTRABALL);
        Entrenador.baston = new ObjetoEquipable(TipoObjetos.BASTON);
        Entrenador.pesa = new ObjetoEquipable(TipoObjetos.PESA);
        Entrenador.chaleco = new ObjetoEquipable(TipoObjetos.CHALECO);
        Entrenador.pilas = new ObjetoEquipable(TipoObjetos.PILAS);
        Entrenador.pluma = new ObjetoEquipable(TipoObjetos.PLUMA);
        Random rd = new Random();
        cajaPoke = new LinkedList<>();
        this.nombre = nombre;
        pokedollars = rd.nextInt(800,1001);
        Entrenador.equipoPK = new Pokemon[6];
        Entrenador.equipoTraspaso = new Pokemon[6];
        Entrenador.equipoPK2 = new Pokemon[6];
        mochila = new HashMap<>();
        mochila.put(baston, baston.getCantidad());
        mochila.put(pesa, pesa.getCantidad());
        mochila.put(chaleco, chaleco.getCantidad());
        mochila.put(pilas, pilas.getCantidad());
        mochila.put(pluma, pluma.getCantidad());
        mochila.put(pokeball, pokeball.getCantidad());
        mochila.put(superball, superball.getCantidad());
        mochila.put(masterball, masterball.getCantidad());
        mochila.put(ultraball, ultraball.getCantidad());
        Entrenador.cajaPoke = new LinkedList<>();
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
    public static void introducirObjetos(TipoObjetos obje, int cantidad) {
        if(obje.equals(TipoObjetos.BASTON)){
            baston.setCantidad(baston.getCantidad() + cantidad);
            mochila.replace(baston, baston.getCantidad());
        }
        if(obje.equals(TipoObjetos.PILAS)) {
            pilas.setCantidad(pilas.getCantidad() + cantidad);
            mochila.replace(pilas, pilas.getCantidad());
        }
        if(obje.equals(TipoObjetos.PLUMA)) {
            pluma.setCantidad(pluma.getCantidad() + cantidad);
            mochila.replace(pluma, pluma.getCantidad());
        }
        if(obje.equals(TipoObjetos.CHALECO)) {
            chaleco.setCantidad(chaleco.getCantidad() + cantidad);
            mochila.replace(chaleco, chaleco.getCantidad());
        }
        if(obje.equals(TipoObjetos.PESA)) {
            pesa.setCantidad(pesa.getCantidad() + cantidad);
            mochila.replace(pesa, pesa.getCantidad());
        }
    }
    public static void introducirPokeballs(TipoPokeball tipoPokeball, int cantidad){
        if(tipoPokeball.equals(TipoPokeball.POKEBALL)){
            pokeball.setCantidad(pokeball.getCantidad() + cantidad);
            mochila.replace(pokeball, pokeball.getCantidad());
        }
        if(tipoPokeball.equals(TipoPokeball.SUPERBALL)){
            superball.setCantidad(superball.getCantidad() + cantidad);
            mochila.replace(superball, superball.getCantidad());
        }
        if(tipoPokeball.equals(TipoPokeball.MASTERBALL)){
            masterball.setCantidad(masterball.getCantidad() + cantidad);
            mochila.replace(masterball, masterball.getCantidad());
        }
        if(tipoPokeball.equals(TipoPokeball.ULTRABALL)){
            ultraball.setCantidad(ultraball.getCantidad() + cantidad);
            mochila.replace(ultraball, ultraball.getCantidad());
        }
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
    public static boolean capturar(Pokeball pokeball ,Pokemon pokemon) {
        pokeball.setCantidad(pokeball.getCantidad() - 1);
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

    public boolean entrenar() {
        return true;
    }


    public boolean combatir() {
        if(Entrenador.equipoPK[0] != null){
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


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        Entrenador.equipoTraspaso = equipoTrasPaso;
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

    public static Pokeball getPokeball() {
        return pokeball;
    }
    public static Pokeball getSuperball() {
        return superball;
    }
    public static Pokeball getUltraball() {
        return ultraball;
    }
    public static Pokeball getMasterball() {
        return masterball;
    }

    public static ObjetoEquipable getPluma() {
        return pluma;
    }

    public static ObjetoEquipable getBaston() {
        return baston;
    }

    public static ObjetoEquipable getPesa() {
        return pesa;
    }

    public static ObjetoEquipable getChaleco() {
        return chaleco;
    }

    public static ObjetoEquipable getPilas() {
        return pilas;
    }

    public static HashMap<Objeto, Integer> getMochila() {
        return mochila;
    }
    public void setMochila(HashMap<TipoObjetos, Integer> mochila) {
        mochila = mochila;
    }

    @Override

    public String toString() {
        return this.nombre + " " + Entrenador.pokedollars + " " ;

    }
}