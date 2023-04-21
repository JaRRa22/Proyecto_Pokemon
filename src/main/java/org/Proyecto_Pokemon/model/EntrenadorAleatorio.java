package org.Proyecto_Pokemon.model;

import java.util.Random;

public class EntrenadorAleatorio{
    private String nombre;
    private Pokemon[] equipoPK;
    private int dinero;
    public EntrenadorAleatorio(String nombre, Pokemon pokemon, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6){
        this.nombre = nombre;
        this.equipoPK = new Pokemon[6];
        Random rd = new Random();
        this.dinero = rd.nextInt(500,1501);
        equipoPK[0]= pokemon;
        equipoPK[1]= pokemon2;
        equipoPK[2]= pokemon3;
        equipoPK[3]= pokemon4;
        equipoPK[4]= pokemon5;
        equipoPK[5]= pokemon6;

    }
    public EntrenadorAleatorio(Pokemon pok1,Pokemon pok2){
        this.nombre="Placeholder";
        this.equipoPK = new Pokemon[6];
        equipoPK[0]=pok1;
        equipoPK[1]=pok2;

    }
    public void usarAtaque(Pokemon objetivo){
        Random rd=new Random();
        boolean isUsed= false;
        while (!isUsed){
            //Esto calcula elige un movimiento aleatorio. Si este espacio de movimiento está vacio, coge otro nuevo
        Movimiento mov = getEquipoPK()[0].getMovimientosActivos()[rd.nextInt(3)];
        if (mov!=null){
            isUsed=true;
            //Esto mira si el pokeon actual tiene vida para poder hacer el movimiento, si no, cambia de pokemon a uno que si tenga vida
            if (getEquipoPK()[0].getVitalidadActual()>0){
                getEquipoPK()[0].usarMovimiento(mov,objetivo);}
            else {
                getEquipoPK()[0].setStatus(Status.DEBILITADO);
                for (int i = 0; i <getEquipoPK().length ; i++) {
                    if (getEquipoPK()[i].getVitalidadActual()>0){
                        getEquipoPK()[0]=getEquipoPK()[i];
                        break;
                    }

                }



            }
        }


    }}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pokemon[] getEquipoPK() {
        return equipoPK;
    }

    public void setEquipoPK(Pokemon[] equipoPK) {
        this.equipoPK = equipoPK;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
}