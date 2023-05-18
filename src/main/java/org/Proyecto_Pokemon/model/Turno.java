package org.Proyecto_Pokemon.model;

//import org.Proyecto_Pokemon.controller.CombateController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Turno {



    private  static int turnoActual=0;
    //TODO AÑADIR LOG
    public Turno(EntrenadorAleatorio enemigo) {
       turnoActual +=1;




    }


    public static void fasesDeTurno(EntrenadorAleatorio enemy) throws IOException {

        Random rnd= new Random();
        if (Entrenador.getEquipoPK()[0].getVelocidad()+rnd.nextInt(5)>enemy.getEquipoPK()[0].getVelocidad()+rnd.nextInt(5)){


            enemy.usarAtaque(Entrenador.getEquipoPK()[0]);
        }
        else {
            enemy.usarAtaque(Entrenador.getEquipoPK()[0]);



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



    public static int getTurnoActual() {
        return turnoActual;
    }

    public void accionEntrenadorRival(){

    }

    public static void resetTurnoActual() {
        Turno.turnoActual = 0;
    }

    public static void setTurnoActual(int turnoActual) {
        Turno.turnoActual = turnoActual;
    }

}
