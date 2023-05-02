package org.Proyecto_Pokemon.model;

import javafx.scene.control.Button;
import org.Proyecto_Pokemon.controller.CombateController;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Combate {

    private String ganador;
    //private Entrenador jugador;
    //private rival EntrenadorAleatorio
    private Turno turno;
    private int pokemonKOJugador;
    private int pokemonKORival;

    public Combate() {

    }
    //TODO Implementar funcionalidad de duracion de efectos
    public String hacerCombate( EntrenadorAleatorio enemigo) {
        Turno.setTurnoActual(1);

        boolean jugadorHaPerdido = false;
        boolean enemigoHaPerdido = false;
        while(!jugadorHaPerdido && !enemigoHaPerdido){

        Turno.fasesDeTurno( enemigo);
        for (int i = 0; i < Entrenador.getEquipoPK().length; i++) {
            if (Entrenador.getEquipoPK()[i] == null || Entrenador.getEquipoPK()[i].getStatus().equals(Status.DEBILITADO)  ) {
                jugadorHaPerdido = true;
            } else {
                jugadorHaPerdido = false;
            }
        }

        if (jugadorHaPerdido) {
            this.setGanador(enemigo.getNombre());
        }

        for (int i = 0; i < enemigo.getEquipoPK().length; i++) {
            if (enemigo.getEquipoPK()[i] == null || enemigo.getEquipoPK()[i].getStatus().equals(Status.DEBILITADO)) {
                enemigoHaPerdido = true;
            } else {
                enemigoHaPerdido = false;
            }
        }

        if (enemigoHaPerdido) {
            this.setGanador(Entrenador.getNombre());
            Entrenador.setPokedollars(Entrenador.getPokedollars()+enemigo.getDinero());
        }
        for (Pokemon p: Entrenador.getEquipoPK()) {
            int contador=0;
            try {


            if (p.getStatus().equals(Status.DEBILITADO)) contador+=1;
            this.setPokemonKOJugador(contador);}
            catch (NullPointerException ignore){}

        }
            int contador=0;
        for (Pokemon p:enemigo.getEquipoPK()) {
            try {


            if (p.getStatus().equals(Status.DEBILITADO)) contador+=1;
            this.setPokemonKORival(contador);}
            catch (Exception ignore){}

        }}

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


    //TODO CUANDO ESTÉ LA PARTE GRAFICA
    private void accionEntrenador() {





        }


    }


