package org.Proyecto_Pokemon.model;

import javafx.scene.image.Image;
import org.Proyecto_Pokemon.controller.CriarController;
import org.Proyecto_Pokemon.database.CRUD;
import org.Proyecto_Pokemon.database.MySQLConnection;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {



    public static void main(String[] args) throws SQLException {

        System.out.println(MySQLConnection.getConnection());

        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();


        Pokemon padre = CRUD.sacarEjemplarPokemonPokedex(1);
        Pokemon madre = CRUD.sacarEjemplarPokemonPokedex(2);
        Pokemon p = CRUD.sacarEjemplarPokemonPokedex(3);
        Pokemon e = CRUD.sacarEjemplarPokemonPokedex(4);
        Pokemon de = CRUD.sacarEjemplarPokemonPokedex(17);
        Pokemon mre = CRUD.sacarEjemplarPokemonPokedex(12);
        Pokemon dre = CRUD.sacarEjemplarPokemonPokedex(13);
        Pokemon made = CRUD.sacarEjemplarPokemonPokedex(8);

        System.out.println(padre);
        System.out.println(madre);
        System.out.println(p);
        System.out.println(e);
        System.out.println(de);
        System.out.println(mre);
        System.out.println(dre);
        System.out.println(made);
        System.out.println("--------------------------------");
        System.out.println(padre.getSexo());
        System.out.println(madre.getSexo());
        System.out.println(p.getSexo());
        System.out.println(e.getSexo());
        System.out.println(de.getSexo());
        System.out.println(mre.getSexo());
        System.out.println(dre.getSexo());
        System.out.println(made.getSexo());



        System.out.println( padre.getTipos());
        System.out.println(madre.getTipos());

        System.out.println( padre.getTipos().get(0));
        System.out.println(madre.getTipos().get(0));


        System.out.println(madre.getTipos().get(1));

        System.out.println(madre.getTipos().size());
        System.out.println(padre.getTipos().size());


        Random rd = new Random();

        List<Tipo> prueba = new LinkedList<>();
        Tipo uno;
        Tipo dos;
        if(padre.getTipos().size() > 1){
            if(rd.nextInt(1,3) == 1) {
                uno = padre.getTipos().get(0);
            }
            else {
                uno = padre.getTipos().get(1);
            }
        }
        else{
            uno = padre.getTipos().get(0);
        }

        if(madre.getTipos().size() > 1){
            if(rd.nextInt(1,3) == 1) {
                dos = madre.getTipos().get(0);
            }
            else {
                dos = madre.getTipos().get(1);
            }
        }
        else{
            dos = madre.getTipos().get(0);
        }


        System.out.println(uno);
        System.out.println(dos);
        
        prueba.add(uno);
        prueba.add(dos);

        System.out.println(prueba);



        /*
        CRUD.addMovimientosInsert();
        System.out.println(CRUD.listaMovimientos);
        for (Movimiento mov:CRUD.listaMovimientos) {
            System.out.println(mov.getTipo());

        }
        CRUD.insertPokemon();System.out.println(CRUD.pokedex);


        //pokeImagenes se usaría para  asociar a cada pokemon de la pokedex una imagen
        HashMap <Integer, Image> pokeImagenes=new HashMap<>();



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

