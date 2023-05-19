package org.Proyecto_Pokemon.model;

import java.util.HashMap;

public class Tienda {


    private HashMap<TipoObjetos, Integer> objetos;
    private HashMap<TipoPokeball, Integer> pokeballs;
    /**
     * El constructor de tienda inicializa la tienda
     * Añadiendo los Tipos de objetos y los Tipos de Pokeball a sus respectivos Hash Map**/
    public Tienda(){
        objetos = new HashMap<>();
        objetos.put(TipoObjetos.BASTON,500);
        objetos.put(TipoObjetos.PESA,600);
        objetos.put(TipoObjetos.CHALECO,800);
        objetos.put(TipoObjetos.PILAS,700);
        objetos.put(TipoObjetos.PLUMA,900);

        pokeballs = new HashMap<>();
        pokeballs.put(TipoPokeball.SUPERBALL,600);
        pokeballs.put(TipoPokeball.POKEBALL, 200);
        pokeballs.put(TipoPokeball.MASTERBALL, 3200);
        pokeballs.put(TipoPokeball.ULTRABALL, 1200);
    }

    public HashMap<TipoObjetos, Integer> getObjetos() {
        return objetos;
    }
    public HashMap<TipoPokeball, Integer> getPokeballs(){
        return pokeballs;
    }
    /**
     * Método comprarObjeto
     * @param objeto
     * @param cantidad
     * El método comprueba si el Entrenador tiene suficientes pokedollars para comprar el objeto según la cantidad indicada
     * @return true si los pokedollars son mayores que el valor del objeto multiplicado por la cantidad y la cantidad del objeto sube en la mochila del Entrenador, o false si los pokedollars son menores**/
    public boolean comprarObjeto(TipoObjetos objeto, int cantidad){

        if(Entrenador.getPokedollars() < objetos.get(objeto) * cantidad)
            return false;

        if(objeto.equals(TipoObjetos.BASTON)){
            Entrenador.introducirObjetos(TipoObjetos.BASTON, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - objetos.get(TipoObjetos.BASTON) * cantidad);
        }
        if(objeto.equals(TipoObjetos.PESA)){
            Entrenador.introducirObjetos(TipoObjetos.PESA, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - objetos.get(TipoObjetos.PESA) * cantidad);
        }
        if(objeto.equals(TipoObjetos.CHALECO)){
            Entrenador.introducirObjetos(TipoObjetos.CHALECO, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - objetos.get(TipoObjetos.CHALECO) * cantidad);
        }
        if(objeto.equals(TipoObjetos.PILAS)){
            Entrenador.introducirObjetos(TipoObjetos.PILAS, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - objetos.get(TipoObjetos.PILAS) * cantidad);
        }
        if(objeto.equals(TipoObjetos.PLUMA)){
            Entrenador.introducirObjetos(TipoObjetos.PLUMA, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - objetos.get(TipoObjetos.PLUMA) * cantidad);
        }
        return true;
    }
    /**
     * Método comprarPokeball
     * @param tipoPokeball
     * @param cantidad
     * El método comprueba si el Entrenador tiene suficientes pokedollars para comprar el tipo de pokeball según la cantidad indicada
     * @return true si los pokedollars son mayores que el valor de la pokeball multiplicado por la cantidad y la cantidad de la pokeball sube en la mochila del Entrenador, o false si los pokedollars son menores**/
    public boolean comprarPokeball(TipoPokeball tipoPokeball, int cantidad){
        try{if(Entrenador.getPokedollars() < pokeballs.get(tipoPokeball) * cantidad)
            return false;

            if(tipoPokeball.equals(TipoPokeball.POKEBALL)){
                Entrenador.introducirPokeballs(TipoPokeball.POKEBALL, cantidad);
                Entrenador.setPokedollars(Entrenador.getPokedollars() - pokeballs.get(TipoPokeball.POKEBALL) * cantidad);
            }
            if(tipoPokeball.equals(TipoPokeball.SUPERBALL)){
                Entrenador.introducirPokeballs(TipoPokeball.SUPERBALL, cantidad);
                Entrenador.setPokedollars(Entrenador.getPokedollars() - pokeballs.get(TipoPokeball.SUPERBALL) * cantidad);
            }
            if(tipoPokeball.equals(TipoPokeball.MASTERBALL)){
                Entrenador.introducirPokeballs(TipoPokeball.MASTERBALL, cantidad);
                Entrenador.setPokedollars(Entrenador.getPokedollars() - pokeballs.get(TipoPokeball.MASTERBALL) * cantidad);
            }
            if(tipoPokeball.equals(TipoPokeball.ULTRABALL)){
                Entrenador.introducirPokeballs(TipoPokeball.ULTRABALL, cantidad);
                Entrenador.setPokedollars(Entrenador.getPokedollars() - pokeballs.get(TipoPokeball.ULTRABALL) * cantidad);
            }
            return true;}catch (NullPointerException nullPointerException){
            return  false;
        }
    }
}
