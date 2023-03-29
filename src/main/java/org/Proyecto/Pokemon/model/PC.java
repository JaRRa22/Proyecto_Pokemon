package org.example;

import java.util.LinkedList;
import java.util.List;

public class PC {
    private List<CajaPokemon> cajasPokemon;

    public PC(){
        cajasPokemon = new LinkedList<>();
    }

    public List<CajaPokemon> getCajasPokemon() {
        return cajasPokemon;
    }

    public boolean sacarPokemon(Pokemon pokemonASacar){
        return true;
    }
    public boolean meterPokemon(Pokemon pokemonAMeter){
        return true;
    }
    public boolean liberarPokemon(Pokemon pokemonALiberar){
        return true;
    }
    public boolean moverPokemon(Pokemon pokemonAMover){
        return true;
    }
}
