package org.Proyecto_Pokemon.model;

import java.util.LinkedList;
import java.util.List;

public class CajaPokemon {
    private final List<Pokemon> CAJA;

    public CajaPokemon(){
        CAJA = new LinkedList<>();
    }

    public boolean introducirPK(Pokemon pokemonAIntroducir){
        CAJA.add(pokemonAIntroducir);
        return true;
    }
    public boolean sacarPK(Pokemon pokemonASacar){
        if (CAJA.contains(pokemonASacar)) {
            CAJA.remove(pokemonASacar);
            return true;
        }
        else{
            return false;
        }
    }
}
