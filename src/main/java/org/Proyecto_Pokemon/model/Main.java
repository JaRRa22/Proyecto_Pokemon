package org.Proyecto_Pokemon.model;


import javafx.scene.image.Image;

import java.util.HashMap;

public class Main {



    public static void main(String[] args) {


        HashMap <Integer,Pokemon> pokedex=new HashMap<>();
        //pokeImagenes se usaría para  asociar a cada pokemon de la pokedex una imagen
        HashMap <Integer, Image> pokeImagenes=new HashMap<>();


        Ataque placaje = new Ataque("placaje", 40, 100, Tipo.NORMAL, "Fisico");
        Mejora danzaEspada=new Mejora("Danza espada",2.0f,2,"ataque",Tipo.ACERO);
        Pokemon pokemonEnemigo1 = new Pokemon("Pokachu", 100, 120, 200, 250, 230, 20, 200, Tipo.ELECTRICO, placaje, null, Sexo.MACHO);
        Pokemon pokemonEnemigo2 = new Pokemon("Carrero Blanco", 100, 223, 100, 400, 20, 200, 200, placaje, Tipo.VOLADOR, Tipo.ACERO, null, Sexo.MACHO);
        Entrenador entrenador = new Entrenador("Pepe");
       Pokemon pokemon = new Pokemon("Genghis Khan", 170, 290, 290, 200, 299, 222, 222, Tipo.NORMAL, placaje, null, Sexo.MACHO);
        entrenador.getEquipoPK()[0] = pokemon;
        entrenador.getEquipoPK()[0].getMovimientosActivos()[1]=danzaEspada;
        EntrenadorAleatorio entrenadorRival = new EntrenadorAleatorio(pokemonEnemigo2, pokemonEnemigo1);

        System.out.println(entrenadorRival.getEquipoPK()[0]);
        System.out.println(entrenador.getEquipoPK()[0]);
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[0], entrenadorRival.getEquipoPK()[0]);

        System.out.println(entrenadorRival.getEquipoPK()[0]);
        System.out.println(entrenador.getEquipoPK()[0]);
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[0], entrenadorRival.getEquipoPK()[0]);
        System.out.println(entrenadorRival.getEquipoPK()[0]);
        System.out.println(entrenador.getEquipoPK()[0]);
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

