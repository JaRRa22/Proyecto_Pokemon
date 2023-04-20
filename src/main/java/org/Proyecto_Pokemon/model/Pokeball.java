package org.Proyecto_Pokemon.model;

import java.util.HashMap;
import java.util.Random;

public class Pokeball extends Objeto{
    private TipoPokeball tipoPokeball ;
    private HashMap<TipoPokeball, Pokemon> pokemonEnPokeball;

    public Pokeball(TipoObjetos tipo, TipoPokeball poke) {
        super(tipo);
        this.tipoPokeball = poke;
        this.pokemonEnPokeball = new HashMap<>();
    }


    public HashMap<TipoPokeball, Pokemon> getPoke() {
        return pokemonEnPokeball;
    }

    public void setPoke(HashMap<TipoPokeball, Pokemon> poke) {
        this.pokemonEnPokeball = poke;
    }

    public boolean usarAtraparPokemon(Pokemon pokemonAtrapado){
        if(formula()) {
            this.pokemonEnPokeball.put(this.tipoPokeball, pokemonAtrapado);
            return true;
        }
        return false;
    }

    public Pokemon saberPokemonAtrapado( ){
        return this.pokemonEnPokeball.get(this.tipoPokeball);
    }

    public boolean formula(){
        Random rd = new Random();
        int total = rd.nextInt(0,4);
        if(total == 1 || total == 3){
            return true;
        }
        return false;

    }


    @Override
    public String toString() {
        return "" + this.tipoPokeball;
    }
}