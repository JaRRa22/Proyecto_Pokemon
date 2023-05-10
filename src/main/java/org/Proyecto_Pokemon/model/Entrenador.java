package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.controller.CriarController;

import java.util.*;

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

    public static void anadirACaja(Pokemon pokemon) {
        cajaPoke.add(pokemon);
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

    public static void setHaActuado(boolean b) {
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
    @Override
    public String toString() {
        return this.nombre + " " + Entrenador.pokedollars + " " ;
    }
}