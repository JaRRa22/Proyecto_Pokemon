package org.Proyecto_Pokemon.model;

import javafx.scene.image.Image;
import org.Proyecto_Pokemon.database.CRUD;

import java.sql.SQLException;
import java.util.HashMap;

public class Main {



    public static void main(String[] args) throws SQLException {

        CRUD.addMovimientosInsert();
        System.out.println(CRUD.listaMovimientos);
        for (Movimiento mov:CRUD.listaMovimientos) {
            System.out.println(mov.getTipo());

        }
        CRUD.insertPokemon();System.out.println(CRUD.pokedex);





        /* Pokemon jigglypugg= new Pokemon(50,80,89,98,87,876,"Jigglipuff",Tipo.ACERO);

        Pokemon pokachu= new Pokemon(30,40,20,40,23,421,"Pepkachu",Tipo.TIERRA );

        pokachu.setMovimientosActivos(movimientosPkmn1);



        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());
        Mejora danzaEspada=new Mejora("danza espada",2.0f,2,"ataque",Tipo.NORMAL);
        movimientosPkmn1[1]=danzaEspada;
        pokachu.setNivel(9);
        pokachu.usarMovimiento((Ataque) movimientosPkmn1[0],jigglypugg);
        LinkedList<Movimiento> pokachuMovimientosAprendibles=new LinkedList<Movimiento>();
        pokachuMovimientosAprendibles.add(new Ataque("Impactrueno",70,95,Tipo.ELECTRICO,"Especial"));
        pokachuMovimientosAprendibles.add(danzaEspada);
        pokachuMovimientosAprendibles.add(new MovEstado("Latigo","defensa",1.25f,2,Tipo.NORMAL));
        pokachu.setMovimientosAprendibles(pokachuMovimientosAprendibles);

        if (pokachu.sePuedeAprenderMovimiento()){
            pokachu.reemplazarMovimiento(0);
        }
        pokachu.usarMovimiento((MovEstado) pokachu.getMovimientosActivos()[0],jigglypugg);


        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());*/











    }
}

