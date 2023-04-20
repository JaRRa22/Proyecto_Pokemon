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
    public boolean comprarObjeto(TipoObjetos objeto){
        ObjetoEquipable baston = new ObjetoEquipable(TipoObjetos.BASTON);
        ObjetoEquipable pesa = new ObjetoEquipable(TipoObjetos.PESA);
        ObjetoEquipable chaleco = new ObjetoEquipable(TipoObjetos.CHALECO);
        ObjetoEquipable pilas = new ObjetoEquipable(TipoObjetos.PILAS);
        ObjetoEquipable pluma = new ObjetoEquipable(TipoObjetos.PLUMA);

        if(Entrenador.getPokedollars() < objetos.get(objeto))
            return false;

        if(objeto.equals(TipoObjetos.BASTON)){
            Entrenador.introducirElementos(baston);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        if(objeto.equals(TipoObjetos.PESA)){
            Entrenador.introducirElementos(pesa);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        if(objeto.equals(TipoObjetos.CHALECO)){
            Entrenador.introducirElementos(chaleco);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        if(objeto.equals(TipoObjetos.PILAS)){
            Entrenador.introducirElementos(pilas);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        if(objeto.equals(TipoObjetos.PLUMA)){
            Entrenador.introducirElementos(pluma);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        return true;
    }
    public boolean comprarPokeball(TipoPokeball tipoPokeball){
        Pokeball pokeball = new Pokeball(TipoObjetos.POKEBALL, TipoPokeball.POKEBALL);
        Pokeball superball = new Pokeball(TipoObjetos.POKEBALL, TipoPokeball.SUPERBALL);
        Pokeball masterball = new Pokeball(TipoObjetos.POKEBALL, TipoPokeball.MASTERBALL);
        Pokeball ultraball = new Pokeball(TipoObjetos.POKEBALL, TipoPokeball.ULTRABALL);
        if(Entrenador.getPokedollars() < pokeballs.get(tipoPokeball))
            return false;

        if(tipoPokeball.equals(TipoPokeball.POKEBALL)){
            Entrenador.introducirElementos(pokeball);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 200);
        }
        if(tipoPokeball.equals(TipoPokeball.SUPERBALL)){
            Entrenador.introducirElementos(superball);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 200);
        }
        if(tipoPokeball.equals(TipoPokeball.MASTERBALL)){
            Entrenador.introducirElementos(masterball);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 200);
        }
        if(tipoPokeball.equals(TipoPokeball.ULTRABALL)){
            Entrenador.introducirElementos(ultraball);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 200);
        }
        return true;
    }
}
