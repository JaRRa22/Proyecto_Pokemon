package org.Proyecto.Pokemon.model;

public class Combate {
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
