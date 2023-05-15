package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.Logger;
import org.Proyecto_Pokemon.controller.CriarController;

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
     * Método capturar
     *
     * @param pokeball
     * @param pokemon
     * El metodo capturar captura al pokemon según la probabilidad de la pokeball elegida
     * Añade al pokemon capturado al equipo uno si alguna de las posiciones es nula, sino lo añade a la caja
     **/
    public static boolean capturar(Pokeball pokeball, Pokemon pokemon) {
        if(pokeball.getCantidad() <= 0) return false;
        pokeball.setCantidad(pokeball.getCantidad() - 1);

        if (pokeball.formula()){
            for (int i = 0; i < equipoPK.length; i++) {
                if (equipoPK[i] == null) {
                    equipoPK[i] = pokemon;
                    return true;
                }
            }
            if (equipoPK[0] != null && equipoPK[1] != null && equipoPK[2] != null && equipoPK[3] != null && equipoPK[4] != null && equipoPK[5] != null) {
                for (int i = 0; i < equipoPK2.length; i++) {
                    if (equipoPK2[i] == null) {
                        equipoPK2[i] = pokemon;
                        return true;
                    }
                }
            }
            if (equipoPK2[0] != null && equipoPK2[1] != null && equipoPK2[2] != null && equipoPK2[3] != null && equipoPK2[4] != null && equipoPK2[5] != null) {
                anadirACaja(pokemon);
            }


            Logger.write("El pokemon " + pokemon.getNombre() + " ha sido capturado" +
            "\n" + "Tus " + pokeball.getTipoPokeball() + " restantes son: " + pokeball.getCantidad());
            Logger.close();
            return true;

        }
        return false;
    }
    public static void setHaActuado(boolean b) {
    }

    /**
     * Método entrenar
     * @param pokemonAEntrenar
     * @param tipoEntrenamiento
     * El método entrenar mejora las estadisticas del pokemon que pases por parámetro segun el tipo de entrenamiento que elijas**/
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

    
    /**
     * criar
     * El método criar crea un nuevo pokemon a partir de las caracteristicas de los padres
     * El mote es la mitad del mote del padre y la mitad del mote de la madre
     * Las estadisticas coge las mejores entre el padre y la madre
     * Los ataques coge los dos primeros del padre y los dos últimos de la madre
     * Si los padres tienen dos tipos cogen aleatoriamente uno de cada uno y si los tipos de los padres son iguales coge uno de ellos**/
    public static boolean criar(Pokemon padre, Pokemon madre){
        Random rd = new Random();
        if((padre.getSexo().equals(madre.getSexo()))){
            return false;
        }
        if(padre.getFertilidad() == 0 || madre.getFertilidad() == 0){
            return false;
        }
        CriarController.pokemonCriado.setMote("");
        for(int i = 0; i < padre.getMote().length()/2; i++){
            CriarController.pokemonCriado.setMote(CriarController.pokemonCriado.getMote() +  padre.getMote().charAt(i));
        }
        for(int i = 0; i < madre.getMote().length()/2; i++){
            CriarController.pokemonCriado.setMote(CriarController.pokemonCriado.getMote() +  madre.getMote().charAt(i));
        }
        Movimiento movis[] = new Movimiento[4];
        int num = 0;
        while(num < 4){
            if(num == 0){
                movis[0] = padre.getMovimientosActivos()[0];
            }
            if(num == 1){
                movis[1] = padre.getMovimientosActivos()[1];
            }
            if(num == 2){
                movis[2] = madre.getMovimientosActivos()[2];
            }
            if(num == 3){
                movis[3] = madre.getMovimientosActivos()[3];
            }
            num++;
        }
        CriarController.pokemonCriado.setMovimientosActivos(movis);
        Tipo uno;
        Tipo dos;
        if(padre.getTipos().size() > 1){
            if(rd.nextInt(1,3) == 1) {
                uno = padre.getTipos().get(1);
            }
            else {
                uno = padre.getTipos().get(2);
            }
        }
        else{
            uno = padre.getTipos().get(1);
        }
        if(madre.getTipos().size() > 1){
            if(rd.nextInt(1,3) == 1) {
                dos = madre.getTipos().get(1);
            }
            else {
                dos = madre.getTipos().get(2);
            }
        }
        else{
            dos = madre.getTipos().get(1);
        }
        if(rd.nextInt(1,3) == 1){
            if(rd.nextInt(1,3) == 1){
                CriarController.pokemonCriado.getTipos().add(uno);
            }
            else{
                CriarController.pokemonCriado.getTipos().add(dos);
            }
        }
        else{
            CriarController.pokemonCriado.getTipos().add(uno);
            CriarController.pokemonCriado.getTipos().add(dos);
        }
        Tipo prueba1 = CriarController.pokemonCriado.getTipos().get(1);
        Tipo prueba2 = CriarController.pokemonCriado.getTipos().get(2);
        if(prueba1.equals(prueba2)){
         CriarController.pokemonCriado.getTipos().remove(2);
        }



        if(rd.nextInt(1,3) == 1){
            CriarController.pokemonCriado.setSexo(Sexo.MACHO);
        }
        else{
            CriarController.pokemonCriado.setSexo(Sexo.HEMBRA);
        }
        if(padre.getDefensa() > madre.getDefensa()){
            CriarController.pokemonCriado.setDefensa(padre.getDefensa());
        }
        else{
            CriarController.pokemonCriado.setDefensa(madre.getDefensa());
        }
        if(padre.getDefensaEspecial() > madre.getDefensaEspecial()){
            CriarController.pokemonCriado.setDefensa(padre.getDefensaEspecial());
        }
        else{
            CriarController.pokemonCriado.setDefensa(madre.getDefensaEspecial());
        }
        if(padre.getAtaqueEspecial() > madre.getAtaqueEspecial()){
            CriarController.pokemonCriado.setAtaqueEspecial(padre.getAtaqueEspecial());
        }
        else{
            CriarController.pokemonCriado.setAtaqueEspecial(madre.getAtaqueEspecial());
        }
        if(padre.getEstaminaMaxima() > madre.getEstaminaMaxima()){
            CriarController.pokemonCriado.setEstaminaMaxima(padre.getEstaminaMaxima());
        }
        else{
            CriarController.pokemonCriado.setEstaminaMaxima(madre.getEstaminaMaxima());
        }
        if(padre.getVelocidad() > madre.getVelocidad()){
            CriarController.pokemonCriado.setVelocidad(padre.getVelocidad());
        }
        else{
            CriarController.pokemonCriado.setVelocidad(madre.getVelocidad());
        }
        if(padre.getVitalidadMaxima() > madre.getEstaminaMaxima()){
            CriarController.pokemonCriado.setVitalidadMaxima(padre.getVitalidadMaxima());
        }
        else{
            CriarController.pokemonCriado.setVitalidadMaxima(madre.getVitalidadMaxima());
        }
        CriarController.pokemonCriado.setFertilidad(5);
        CriarController.pokemonCriado.setExperiencia(0);

        if(padre.getAtaque() > madre.getAtaque()){
            CriarController.pokemonCriado.setAtaque(padre.getAtaque());
        }
        else{
            CriarController.pokemonCriado.setAtaque(madre.getAtaque());
        }
        padre.setFertilidad(padre.getFertilidad() - 1);
        madre.setFertilidad(madre.getFertilidad() - 1);
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