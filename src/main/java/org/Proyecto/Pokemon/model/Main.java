package org.Proyecto.Pokemon.model;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al mundo pokemon!");
        Movimiento []movimientosPkmn1=new Movimiento[4];
        Ataque placaje= new Ataque("placaje",60,100,Tipo.TIERRA,"fisico");
        movimientosPkmn1[0]=placaje;

         Pokemon jigglypugg= new Pokemon(50,80,89,98,87,876,"Jigglipuff",Tipo.ELECTRICO );

        Pokemon pokachu= new Pokemon(30,40,20,40,23,421,"Pepkachu",Tipo.TIERRA );
        pokachu.setMovimientosActivos(movimientosPkmn1);
        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());

        pokachu.atacar((Ataque) movimientosPkmn1[0],jigglypugg);
        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());


    }
}
