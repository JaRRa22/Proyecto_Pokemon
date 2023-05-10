package org.Proyecto_Pokemon.model;

import java.util.*;
/**
 * Clase entrenador
 * **/
public class Entrenador {
    private static LinkedList<Pokemon> cajaPoke;
    private static String nombre;
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

    /**
     * Constructor de Entrenador
     * Crea un entrenador a partir del nombre que se pase como parametro
     **/
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
        Entrenador.nombre = nombre;
        pokedollars = rd.nextInt(800, 1001);
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

    /**
     * cambiarEquipo
     * Cambia el pokemon que elijas del equipo 1 al equipo 2
     * Pasando por otro equipo intermedio llamado equipoTraspaso
     *
     * @return true
     **/
    public static boolean cambiarEquipo() {
        for (int i = 0; i < equipoPK.length; i++) {
            equipoTraspaso[i] = equipoPK[i];
            equipoPK[i] = equipoPK2[i];
            equipoPK2[i] = equipoTraspaso[i];
        }
        return true;
    }

    /**
     * anadirAEquipo
     * Añade el pokemon que elijas al equipo 1 del entrenador
     * Si alguna posicion es nula
     *
     * @return true or false
     **/
    public static boolean anadirAEquipo(Pokemon pokemon) {
        for (int i = 0; i < equipoPK.length; i++) {
            if (equipoPK[i] == null) {
                equipoPK[i] = pokemon;
                return true;
            }
        }
        return false;
    }

    /**
     * anadirAEquipo2
     * Añade el pokemon que elijas al equipo 1 del entrenador
     * Si alguna posicion es nula
     *
     * @return true or false
     **/
    public static boolean anadirAEquipo2PK2(Pokemon pokemon) {
        for (int i = 0; i < equipoPK2.length; i++) {
            if (equipoPK2[i] == null) {
                equipoPK2[i] = pokemon;
                return true;
            }
        }
        return false;
    }

    /**
     * Introducir objetos
     * @param obje
     * @param cantidad
     * Introduce el objeto pasado por parametro con la cantidad pasada por parametro**/
    public static void introducirObjetos(TipoObjetos obje, int cantidad) {
        if (obje.equals(TipoObjetos.BASTON)) {
            baston.setCantidad(baston.getCantidad() + cantidad);
            mochila.replace(baston, baston.getCantidad());
        }
        if (obje.equals(TipoObjetos.PILAS)) {
            pilas.setCantidad(pilas.getCantidad() + cantidad);
            mochila.replace(pilas, pilas.getCantidad());
        }
        if (obje.equals(TipoObjetos.PLUMA)) {
            pluma.setCantidad(pluma.getCantidad() + cantidad);
            mochila.replace(pluma, pluma.getCantidad());
        }
        if (obje.equals(TipoObjetos.CHALECO)) {
            chaleco.setCantidad(chaleco.getCantidad() + cantidad);
            mochila.replace(chaleco, chaleco.getCantidad());
        }
        if (obje.equals(TipoObjetos.PESA)) {
            pesa.setCantidad(pesa.getCantidad() + cantidad);
            mochila.replace(pesa, pesa.getCantidad());
        }
    }

    /**
     * Introducir pokeballs
     * @param tipoPokeball
     * @param cantidad
     * Introduce el tipo de pokeball pasado por parametro con la cantidad pasada por parametro**/
    public static void introducirPokeballs(TipoPokeball tipoPokeball, int cantidad) {
        if (tipoPokeball.equals(TipoPokeball.POKEBALL)) {
            pokeball.setCantidad(pokeball.getCantidad() + cantidad);
            mochila.replace(pokeball, pokeball.getCantidad());
        }
        if (tipoPokeball.equals(TipoPokeball.SUPERBALL)) {
            superball.setCantidad(superball.getCantidad() + cantidad);
            mochila.replace(superball, superball.getCantidad());
        }
        if (tipoPokeball.equals(TipoPokeball.MASTERBALL)) {
            masterball.setCantidad(masterball.getCantidad() + cantidad);
            mochila.replace(masterball, masterball.getCantidad());
        }
        if (tipoPokeball.equals(TipoPokeball.ULTRABALL)) {
            ultraball.setCantidad(ultraball.getCantidad() + cantidad);
            mochila.replace(ultraball, ultraball.getCantidad());
        }
    }

    /**
     * anadirACaja
     * Añade un pokemon a la caja del entrenador
     **/
    public static void anadirACaja(Pokemon pokemon) {
        cajaPoke.add(pokemon);
    }


    /**
     * curarEquipos
     * Recorre los dos equipos del entrenador para cambiar la vitalidad actual a la maxima
     **/
    public static void curarEquipos() {
        for (Pokemon p : equipoPK) {
            p.setVitalidadActual(p.getVitalidadMaxima());
            p.setEstaminaActual(p.getEstaminaMaxima());
        }
        for (Pokemon p : equipoPK2) {
            p.setVitalidadActual(p.getVitalidadMaxima());
            p.setEstaminaActual(p.getEstaminaMaxima());
        }
    }

    /**
     * El método capturar
     *
     * @param pokeball
     * @param pokemon
     * El metodo capturar captura al pokemon según la probabilidad de la pokeball elegida
     * Añade al pokemon capturado al equipo uno si alguna de las posiciones es nula, sino lo añade a la caja
     **/
    public static boolean capturar(Pokeball pokeball, Pokemon pokemon) {
        pokeball.setCantidad(pokeball.getCantidad() - 1);
        if (pokeball.usarAtraparPokemon(pokemon)) {
            for (int i = 0; i < equipoPK.length; i++) {
                if (equipoPK[i] == null) {
                    equipoPK[i] = pokemon;
                }
            }
            if (equipoPK[0] != null && equipoPK[1] != null && equipoPK[2] != null && equipoPK[3] != null && equipoPK[4] != null && equipoPK[5] != null) {
                anadirACaja(pokemon);
            }
            return true;
        }
        return false;
    }
    public static void setHaActuado(boolean b) {
    }

    public static boolean entrenar(Pokemon pokemonAEntrenar, Entrenar tipoEntrenamiento) {
        if(tipoEntrenamiento.equals(Entrenar.PESADO)){
            if(Entrenador.getPokedollars() > 20*pokemonAEntrenar.getNivel()){
                Entrenador.setPokedollars(Entrenador.getPokedollars() - 20*pokemonAEntrenar.getNivel());
                pokemonAEntrenar.setDefensa(pokemonAEntrenar.getDefensa() + 5);
                pokemonAEntrenar.setDefensaEspecial(pokemonAEntrenar.getDefensaEspecial() + 5);
                pokemonAEntrenar.setVitalidadMaxima(pokemonAEntrenar.getVitalidadMaxima() + 5);
                return true;
            }
        }
        if(tipoEntrenamiento.equals(Entrenar.FURIOSO)){
            if(Entrenador.getPokedollars() > 30*pokemonAEntrenar.getNivel()){
                Entrenador.setPokedollars(Entrenador.getPokedollars() - 30*pokemonAEntrenar.getNivel());
                pokemonAEntrenar.setAtaque(pokemonAEntrenar.getAtaque() + 5);
                pokemonAEntrenar.setAtaqueEspecial(pokemonAEntrenar.getAtaqueEspecial() + 5);
                pokemonAEntrenar.setVelocidad(pokemonAEntrenar.getVelocidad() + 5);
                return true;
            }
        }
        if(tipoEntrenamiento.equals(Entrenar.FUNCIONAL)){
            if(Entrenador.getPokedollars() > 40*pokemonAEntrenar.getNivel()){
                Entrenador.setPokedollars(Entrenador.getPokedollars() - 40*pokemonAEntrenar.getNivel());
                pokemonAEntrenar.setAtaque(pokemonAEntrenar.getAtaque() + 5);
                pokemonAEntrenar.setDefensa(pokemonAEntrenar.getDefensa() + 5);
                pokemonAEntrenar.setVelocidad(pokemonAEntrenar.getVelocidad() + 5);
                pokemonAEntrenar.setVitalidadMaxima(pokemonAEntrenar.getVitalidadMaxima() + 5);
                return true;
            }
        }
        if(tipoEntrenamiento.equals(Entrenar.ONIRICO)){
            if(Entrenador.getPokedollars() > 40*pokemonAEntrenar.getNivel()){
                Entrenador.setPokedollars(Entrenador.getPokedollars() - 40*pokemonAEntrenar.getNivel());
                pokemonAEntrenar.setAtaqueEspecial(pokemonAEntrenar.getAtaqueEspecial() + 5);
                pokemonAEntrenar.setDefensaEspecial(pokemonAEntrenar.getDefensaEspecial() + 5);
                pokemonAEntrenar.setVelocidad(pokemonAEntrenar.getVelocidad() + 5);
                pokemonAEntrenar.setVitalidadMaxima(pokemonAEntrenar.getVitalidadMaxima() + 5);
                return true;
            }
        }
        return false;
    }

    public boolean ponerACriar() {
        return true;
    }


    public static String getNombre() {
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

    public static void setEquipoPK2(Pokemon[] equipoPK2) {
        Entrenador.equipoPK2 = equipoPK2;
    }

    public static Pokemon[] getEquipoPK2() {
        return equipoPK2;
    }

    public static void setEquipoTraspaso(Pokemon[] equipoTraspaso) {
        Entrenador.equipoTraspaso = equipoTraspaso;
    }

    public static Pokemon[] getEquipoTraspaso() {
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


    @Override

    public String toString() {
        return this.nombre + " " + Entrenador.pokedollars + " ";

    }
}