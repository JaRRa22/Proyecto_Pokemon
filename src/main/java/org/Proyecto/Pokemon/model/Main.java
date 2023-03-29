package org.Proyecto.Pokemon.model;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al mundo pokemon!");
        Movimiento []movimientosPkmn1=new Movimiento[4];
        Ataque placaje= new Ataque("placaje",50,100,Tipo.NORMAL,"fisico");
        movimientosPkmn1[0]=placaje;
        Pokemon jigglypugg= new Pokemon(50,80,89,98,87,876,"Jigglipuff");
        Pokemon pokachu= new Pokemon();
        pokachu.setMovimientosActivos(movimientosPkmn1);
        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());

        pokachu.atacar((Ataque) movimientosPkmn1[0],jigglypugg);
        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());


    }
}