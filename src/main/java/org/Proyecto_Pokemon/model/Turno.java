package org.Proyecto_Pokemon.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class Turno {
    private  static int turnoActual=0;
    //TODO AÑADIR LOG
    public Turno() throws FileNotFoundException {
       turnoActual +=1;




    }
    public void fasesDeTurno(Entrenador player, EntrenadorAleatorio enemy){
        Random rnd= new Random();
        if (player.getEquipoPK()[0].getVelocidad()+rnd.nextInt(5)>enemy.getEquipoPK()[0].getVelocidad()+rnd.nextInt(5)){
            accionEntrenador();

            enemy.usarAtaque(player.getEquipoPK()[0]);
        }
        else {
            enemy.usarAtaque(player.getEquipoPK()[0]);
            accionEntrenador();
        }

        //Efectos de los estados negativos
        if (enemy.getEquipoPK()[0].getStatus().equals(Status.ENVENENADO) || enemy.getEquipoPK()[0].getStatus().equals(Status.QUEMADO) ){
            enemy.getEquipoPK()[0].setVitalidadActual(enemy.getEquipoPK()[0].getVitalidadActual()-(enemy.getEquipoPK()[0].getVitalidadMaxima()/5));

        }
        if (player.getEquipoPK()[0].getStatus().equals(Status.ENVENENADO) || player.getEquipoPK()[0].getStatus().equals(Status.QUEMADO) ){
            player.getEquipoPK()[0].setVitalidadActual(player.getEquipoPK()[0].getVitalidadActual()-(player.getEquipoPK()[0].getVitalidadMaxima()/5));

        }
         if (enemy.getEquipoPK()[0].getStatus().equals(Status.DRENADORAS)){

            enemy.getEquipoPK()[0].setVitalidadActual(enemy.getEquipoPK()[0].getVitalidadActual()-(enemy.getEquipoPK()[0].getVitalidadMaxima()/8));
            player.getEquipoPK()[0].setVitalidadActual(player.getEquipoPK()[0].getVitalidadActual()+(enemy.getEquipoPK()[0].getVitalidadMaxima()/8));
        }
         if (player.getEquipoPK()[0].getVitalidadActual()<=0){
             player.getEquipoPK()[0].setStatus(Status.DEBILITADO);
         }

    }

//TODO CUANDO ESTÉ LA PARTE GRAFICA
    private void accionEntrenador() {
    }



    public int getTurnoActual() {
        return turnoActual;
    }

    public void accionEntrenadorRival(){

    }

    public static void resetTurnoActual() {
        Turno.turnoActual = 0;
    }
}
