package org.Proyecto_Pokemon.model;

import java.util.HashMap;

public class Tienda {

    private HashMap<TipoObjetos, Integer> objetos;
    private HashMap<TipoPokeball, Integer> pokeballs;
    public Tienda(){
        objetos = new HashMap<>();
        objetos.put(TipoObjetos.BASTON,300);
        objetos.put(TipoObjetos.PESA,300);
        objetos.put(TipoObjetos.CHALECO,300);
        objetos.put(TipoObjetos.PILAS,300);
        objetos.put(TipoObjetos.PLUMA,300);

        pokeballs = new HashMap<>();
        pokeballs.put(TipoPokeball.POKEBALL, 200);
        pokeballs.put(TipoPokeball.SUPERBALL, 200);
        pokeballs.put(TipoPokeball.MASTERBALL, 200);
        pokeballs.put(TipoPokeball.ULTRABALL, 200);
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
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300 * cantidad);
        }
        if(objeto.equals(TipoObjetos.PESA)){
            Entrenador.introducirObjetos(TipoObjetos.PESA, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300 * cantidad);
        }
        if(objeto.equals(TipoObjetos.CHALECO)){
            Entrenador.introducirObjetos(TipoObjetos.CHALECO, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300 * cantidad);
        }
        if(objeto.equals(TipoObjetos.PILAS)){
            Entrenador.introducirObjetos(TipoObjetos.PILAS, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300 * cantidad);
        }
        if(objeto.equals(TipoObjetos.PLUMA)){
            Entrenador.introducirObjetos(TipoObjetos.PLUMA, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300 * cantidad);
        }
        return true;
    }
    public boolean comprarPokeball(TipoPokeball tipoPokeball, int cantidad){
        if(Entrenador.getPokedollars() < pokeballs.get(tipoPokeball) * cantidad)
            return false;

        if(tipoPokeball.equals(TipoPokeball.POKEBALL)){
            Entrenador.introducirPokeballs(TipoPokeball.POKEBALL, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 200 * cantidad);
        }
        if(tipoPokeball.equals(TipoPokeball.SUPERBALL)){
            Entrenador.introducirPokeballs(TipoPokeball.SUPERBALL, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 200 * cantidad);
        }
        if(tipoPokeball.equals(TipoPokeball.MASTERBALL)){
            Entrenador.introducirPokeballs(TipoPokeball.MASTERBALL, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 200 * cantidad);
        }
        if(tipoPokeball.equals(TipoPokeball.ULTRABALL)){
            Entrenador.introducirPokeballs(TipoPokeball.ULTRABALL, cantidad);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 200 * cantidad);
        }
        return true;
    }
}
