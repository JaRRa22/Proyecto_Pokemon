package org.example;

import java.util.HashMap;

public class Pokeball extends Objeto{
    private HashMap<TipoPokeball, Integer> poke;

    public Pokeball(TipoObjetos tipo) {
        super(tipo);
    }

    public HashMap<TipoPokeball, Integer> getPoke() {
        return poke;
    }

    public void setPoke(HashMap<TipoPokeball, Integer> poke) {
        this.poke = poke;
    }

    public boolean atraparPokemon(){
        return true;
    }
}
