package org.Proyecto_Pokemon.model;

import javafx.scene.control.Button;
import org.Proyecto_Pokemon.controller.CombateController;

import java.io.FileNotFoundException;
import java.util.Random;

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

        boolean jugadorHaPerdido = false;
        boolean enemigoHaPerdido = false;
        while(!jugadorHaPerdido && !enemigoHaPerdido){

        this.fasesDeTurno( enemigo);
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
    public void fasesDeTurno(EntrenadorAleatorio enemy){

        Random rnd= new Random();
        if (Entrenador.getEquipoPK()[0].getVelocidad()+rnd.nextInt(5)>enemy.getEquipoPK()[0].getVelocidad()+rnd.nextInt(5)){
            accionEntrenador();

            enemy.usarAtaque(Entrenador.getEquipoPK()[0]);
        }
        else {
            enemy.usarAtaque(Entrenador.getEquipoPK()[0]);
            accionEntrenador();


        }

        //Efectos de los estados negativos
        if (enemy.getEquipoPK()[0].getStatus().equals(Status.ENVENENADO) || enemy.getEquipoPK()[0].getStatus().equals(Status.QUEMADO) ){
            enemy.getEquipoPK()[0].setVitalidadActual(enemy.getEquipoPK()[0].getVitalidadActual()-(enemy.getEquipoPK()[0].getVitalidadMaxima()/5));

        }
        if (Entrenador.getEquipoPK()[0].getStatus().equals(Status.ENVENENADO) || Entrenador.getEquipoPK()[0].getStatus().equals(Status.QUEMADO) ){
            Entrenador.getEquipoPK()[0].setVitalidadActual(Entrenador.getEquipoPK()[0].getVitalidadActual()-(Entrenador.getEquipoPK()[0].getVitalidadMaxima()/5));

        }
        if (enemy.getEquipoPK()[0].getStatus().equals(Status.DRENADORAS)){

            enemy.getEquipoPK()[0].setVitalidadActual(enemy.getEquipoPK()[0].getVitalidadActual()-(enemy.getEquipoPK()[0].getVitalidadMaxima()/8));
            Entrenador.getEquipoPK()[0].setVitalidadActual(Entrenador.getEquipoPK()[0].getVitalidadActual()+(enemy.getEquipoPK()[0].getVitalidadMaxima()/8));
        }
        if (Entrenador.getEquipoPK()[0].getVitalidadActual()<=0){
            Entrenador.getEquipoPK()[0].setStatus(Status.DEBILITADO);
        }
        Entrenador.setHaActuado(false);
    }

    //TODO CUANDO ESTÉ LA PARTE GRAFICA
    private void accionEntrenador() {





        }


    }


