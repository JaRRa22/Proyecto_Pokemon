package org.Proyecto.Pokemon.model;

import java.util.LinkedList;
import java.util.List;

public class Ataque extends Movimiento {
    private int potencia;
    private int precision;

    public Ataque(String nombre, int potencia, int precision, Tipo tipo) {
        this.potencia = potencia;
        this.precision = precision;
        this.nombre=nombre;
        this.costeStamina=potencia/2;
        this.tipo=tipo;

    }

    //TODO
    public int calcularDanyo(){
return 0;
    }





    public void atacar(Pokemon objetivo) {

        objetivo.setVitalidad(objetivo.getVitalidad()-potencia);

    }

    public static class CajaPokemon {
        private final List<Pokemon> CAJA;

        public CajaPokemon(){
            CAJA = new LinkedList<>();
        }

        public boolean introducirPK(Pokemon pokemonAIntroducir){
            CAJA.add(pokemonAIntroducir);
            return true;
        }
        public boolean sacarPK(Pokemon pokemonASacar){
            CAJA.remove(pokemonASacar);
            return true;
        }
    }

    public static class CentroPokemon {
        private PC pc;
        private Tienda tienda;

        public CentroPokemon(){

        }
        public void curarEquipo(){

        }
    }

    public enum Entrenar {
        PESADO, FURIOSO, FUNCIONAL, ONIRICO
    }

    public static class Combate {
        private String ganador;
        //private Entrenador jugador;
        //private rival EntrenadorAleatorio
        private Turno turno;
        private int pokemonKOJugador;
        private int pokemonKORival;

        public Combate(){

        }

        public String getGanador() {
            return ganador;
        }

        public void setGanador(String ganador) {
            this.ganador = ganador;
        }

        public Turno getTurno() {
            return turno;
        }

        public void setTurno(Turno turno) {
            this.turno = turno;
        }

        public int getPokemonKOJugador() {
            return pokemonKOJugador;
        }

        public void setPokemonKOJugador(int pokemonKOJugador) {
            this.pokemonKOJugador = pokemonKOJugador;
        }

        public int getPokemonKORival() {
            return pokemonKORival;
        }

        public void setPokemonKORival(int pokemonKORival) {
            this.pokemonKORival = pokemonKORival;
        }

        public boolean comprobarEquipos(){
            return true;
        }
        public boolean retirarse(){
            return true;
        }
        public boolean darDineroAGanador(){
            return true;
        }
        public boolean darNiveles(){
            return true;
        }
    }

    public static class PC {
        private List<CajaPokemon> cajasPokemon;

        public PC(){
            cajasPokemon = new LinkedList<>();
        }

        public List<CajaPokemon> getCajasPokemon() {
            return cajasPokemon;
        }

        public boolean sacarPokemon(Pokemon pokemonASacar){
            return true;
        }
        public boolean meterPokemon(Pokemon pokemonAMeter){
            return true;
        }
        public boolean liberarPokemon(Pokemon pokemonALiberar){
            return true;
        }
        public boolean moverPokemon(Pokemon pokemonAMover){
            return true;
        }
    }

    public static class Pokemon {
        //private final String NOMBRE;
        //private final int ID;
        //private String mote = NOMBRE;
        private int vitalidad;
        private int velocidad;
        private int ataque;
        private int ataqueEspecial;
        private int defensa;
        private int defensaEspecial;
        private int stamina;
        private int nivel;

        //private List<Tipo> tipos;
        private int fertilidad;

        //private Status status;
        //private Sexo sexo;

        //private Movimiento[] movimientosActivos;
        //private Objeto objetoEquipado;
        //private List<Movimiento> movimientosAprendibles;

        public Pokemon(){
            //movimientosAprendibles = new LinkedList<>();
        }

        public int getVitalidad() {
            return vitalidad;
        }

        public void setVitalidad(int vitalidad) {
            this.vitalidad = vitalidad;
        }

        public int getVelocidad() {
            return velocidad;
        }

        public void setVelocidad(int velocidad) {
            this.velocidad = velocidad;
        }

        public int getAtaque() {
            return ataque;
        }

        public void setAtaque(int ataque) {
            this.ataque = ataque;
        }

        public int getAtaqueEspecial() {
            return ataqueEspecial;
        }

        public void setAtaqueEspecial(int ataqueEspecial) {
            this.ataqueEspecial = ataqueEspecial;
        }

        public int getDefensa() {
            return defensa;
        }

        public void setDefensa(int defensa) {
            this.defensa = defensa;
        }

        public int getDefensaEspecial() {
            return defensaEspecial;
        }

        public void setDefensaEspecial(int defensaEspecial) {
            this.defensaEspecial = defensaEspecial;
        }

        public int getStamina() {
            return stamina;
        }

        public void setStamina(int stamina) {
            this.stamina = stamina;
        }

        public int getNivel() {
            return nivel;
        }

        public void setNivel(int nivel) {
            this.nivel = nivel;
        }

        public int getFertilidad() {
            return fertilidad;
        }

        public void setFertilidad(int fertilidad) {
            this.fertilidad = fertilidad;
        }

        public void subirNivel(){

        }
        public boolean tenerHijo(Pokemon pareja){
            return true;
        }
        public boolean atacar(Pokemon target){
            return true;
        }
        public void descansar(){

        }
    }

    public static class Tienda {
        //private HashMap<Objeto, Integer> precio;
    }

    public static class Turno {
        private int turnoActual;

        public Turno(){

        }

        public int getTurnoActual() {
            return turnoActual;
        }
        public void accionEntrenador(){

        }
        public void accionEntrenadorRival(){

        }
    }
}
