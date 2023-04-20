package org.Proyecto_Pokemon.model;

public class Combate {
    private String ganador;
    //private Entrenador jugador;
    //private rival EntrenadorAleatorio
    private Turno turno;
    private int pokemonKOJugador;
    private int pokemonKORival;

    public Combate() {

    }

    public String hacerCombate(Entrenador jugador, EntrenadorAleatorio enemigo) {
        boolean jugadorHaPerdido = false;
        boolean enemigoHaPerdido = false;
        turno.fasesDeTurno(jugador, enemigo);
        for (int i = 0; i < jugador.getEquipoPK().length; i++) {
            if (jugador.getEquipoPK()[i].getStatus().equals(Status.DEBILITADO) || jugador.getEquipoPK()[i] == null) {
                jugadorHaPerdido = true;
            } else {
                jugadorHaPerdido = false;
            }
        }

        if (jugadorHaPerdido) {
            this.setGanador(enemigo.getNombre());
        }

        for (int i = 0; i < enemigo.getEquipoPK().length; i++) {
            if (enemigo.getEquipoPK()[i].getStatus().equals(Status.DEBILITADO) || enemigo.getEquipoPK()[i] == null) {
                enemigoHaPerdido = true;
            } else {
                enemigoHaPerdido = false;
            }
        }

        if (enemigoHaPerdido) {
            this.setGanador(jugador.getNombre());
            jugador.setPokedollars(jugador.getPokedollars()+enemigo.getDinero());
        }
        for (Pokemon p:jugador.getEquipoPK()) {
            int contador=0;
            if (p.getStatus().equals(Status.DEBILITADO)) contador+=1;
            this.setPokemonKOJugador(contador);

        }
        for (Pokemon p:enemigo.getEquipoPK()) {
            int contador=0;
            if (p.getStatus().equals(Status.DEBILITADO)) contador+=1;
            this.setPokemonKORival(contador);

        }

        return "El ganador es: " + this.getGanador();
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

    public boolean comprobarEquipos() {
        return true;
    }

    public boolean retirarse() {
        return true;
    }

    public boolean darDineroAGanador() {
        return true;
    }

    public boolean darNiveles() {
        return true;
    }
}
