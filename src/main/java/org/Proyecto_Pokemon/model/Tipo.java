package org.Proyecto_Pokemon.model;

public enum Tipo {
    AGUA,PLANTA,FUEGO,ROCA,TIERRA,ACERO,ELECTRICO, NORMAL,LUCHA,FANTASMA,
    PSIQUICO,VOLADOR, VENENO,DRAGON,BICHO,HIELO,SINIESTRO;

    /*
Posible ejemplo de como puede funcionar  la comprobacion de efectividad de los movimientos y tipos
IDEALMENTE CON UN SWITCH
    public float comprobar(Tipo tipejo){
        if (this.equals(AGUA) && tipejo.equals(FUEGO)){
            return 2.0f;
        }
        return 0;
    }   */
}
