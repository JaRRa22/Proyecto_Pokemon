package org.Proyecto_Pokemon.model;

import java.util.HashMap;

public class Tienda {


    private HashMap<TipoObjetos, Integer> objetos;
    private HashMap<TipoPokeball, Integer> pokeballs;
    public Tienda(){
        objetos = new HashMap<>();
        objetos.put(TipoObjetos.BASTON,500);
        objetos.put(TipoObjetos.PESA,600);
        objetos.put(TipoObjetos.CHALECO,800);
        objetos.put(TipoObjetos.PILAS,700);
        objetos.put(TipoObjetos.PLUMA,900);

        pokeballs = new HashMap<>();
        pokeballs.put(TipoPokeball.POKEBALL, 400);
        pokeballs.put(TipoPokeball.MASTERBALL, 900);
        pokeballs.put(TipoPokeball.ULTRABALL, 700);
    }

    public HashMap<TipoObjetos, Integer> getObjetos() {
        return objetos;
    }
    public HashMap<TipoPokeball, Integer> getPokeballs(){
        return pokeballs;
    }
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
    public boolean comprarPokeball(TipoPokeball tipoPokeball, int cantidad){
        if(Entrenador.getPokedollars() < pokeballs.get(tipoPokeball) * cantidad)
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
        return true;
    }
}
