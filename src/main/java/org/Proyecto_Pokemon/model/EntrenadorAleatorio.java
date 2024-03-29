package org.Proyecto_Pokemon.model;

import javafx.event.ActionEvent;
import org.Proyecto_Pokemon.Logger;
import org.Proyecto_Pokemon.controller.CombateController;

import java.io.IOException;
import java.util.Random;

public class EntrenadorAleatorio{
    private String nombre;
    private Pokemon[] equipoPK;
    private int dinero;

    public EntrenadorAleatorio(){
        this.equipoPK = new Pokemon[6];
        Random rd=new Random();
        this.setDinero(rd.nextInt(500,3200));
    }
    public EntrenadorAleatorio(String nombre, Pokemon pokemon, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6){
        this.nombre = nombre;
        this.equipoPK = new Pokemon[6];
        Random rd = new Random();

        equipoPK[0]= pokemon;
        equipoPK[1]= pokemon2;
        equipoPK[2]= pokemon3;
        equipoPK[3]= pokemon4;
        equipoPK[4]= pokemon5;
        equipoPK[5]= pokemon6;
        this.setDinero(rd.nextInt(500,3200));

    }
    public EntrenadorAleatorio(Pokemon pok1,Pokemon pok2){
        this.nombre="Placeholder";
        this.equipoPK = new Pokemon[6];
        equipoPK[0]=pok1;
        equipoPK[1]=pok2;
        Random rd = new Random();

        this.setDinero(rd.nextInt(500,3200));

    }


    /**
     *
     * @param combate
     * @param combat2
     * @throws IOException
     * Este metodo recorre el equipo enemigo, hace que el pokemon del jugador gane experiencia y cambia de equipo automaticamente.
     * Si no, hace que un boton gigante aparezca en la vista del combate  haciendo que ganes el combate
     */
    public void cambiarPokemonSiDebilitado(CombateController combate,Combate combat2) throws IOException {


       if (getEquipoPK()[0].getVitalidadActual()<=0){
        getEquipoPK()[0].setStatus(Status.DEBILITADO);
        Logger.write(getEquipoPK()[0].getNombre() + " se ha debilitado\n");
        Entrenador.getEquipoPK()[0].setExperiencia(this.getEquipoPK()[0].getNivel()*7);
        Entrenador.getEquipoPK()[0].subirNivel();

                int i= 1;
                while (true){
                //Esto va cambiando de pokemon si es posible. SI no es posible el jugador gana
                if (i>=5) {
                    combat2.setGanador(Entrenador.getNombre());
                    combate.hasGanadoButton.setVisible(true);
                    return;

                }
                if (getEquipoPK()[i]!=null && getEquipoPK()[i].getVitalidadActual() > 0) {
                    getEquipoPK()[0] = getEquipoPK()[i];

                    combate.getPkmnRivalNombre().setText(getEquipoPK()[0].getNombre());
                    combate.getPkmnRivalVida().setText(Integer.toString(getEquipoPK()[0].getVitalidadActual()));
                    combate.getPkmonRivalStamina().setText(Integer.toString(getEquipoPK()[0].getEstaminaActual()));

                    break;
                }
                    i++;}




            }

        }


    /**
     * Este metodo elige un movimiento aleatorio del pokemon y  lo usa
     * Es funcional pero aun no se ha implementado las listas de movimientos de cada pokemon
     * @param objetivo
     * @throws IOException
     */
    public void usarAtaque(Pokemon objetivo) throws IOException {
        Random rd=new Random();
        boolean isUsed= false;
        while (!isUsed){
            //Esto calcula la eleccion un movimiento aleatorio. Si este espacio de movimiento está vacio, coge otro nuevo
        Movimiento mov = getEquipoPK()[0].getMovimientosActivos()[rd.nextInt(3)];
        if (mov!=null){
            isUsed=true;


            Logger.write(this.equipoPK[0].getNombre() + " ha usado " + mov +"\n");

        getEquipoPK()[0].usarMovimiento(mov,objetivo);


            //Esto mira si el pokemon actual tiene vida para poder hacer el movimiento, si no, cambia de pokemon a uno que si tenga vida




            }}}





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
        return this.dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
}