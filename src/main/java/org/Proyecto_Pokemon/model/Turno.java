package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.controller.CombateController;

import java.io.FileNotFoundException;
import java.util.Random;

public class Turno {
    private  static int turnoActual=0;
    //TODO AÑADIR LOG
    public Turno() {
       turnoActual +=1;




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
