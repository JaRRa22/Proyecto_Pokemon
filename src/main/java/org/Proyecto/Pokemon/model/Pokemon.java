package org.Proyecto.Pokemon.model;

import java.util.LinkedList;

public class Pokemon {
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
