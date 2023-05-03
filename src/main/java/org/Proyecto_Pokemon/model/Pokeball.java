package org.Proyecto_Pokemon.model;

import java.util.HashMap;
import java.util.Random;

public class Pokeball extends Objeto{
    private TipoPokeball tipoPokeball;
    private HashMap<TipoPokeball, Pokemon> pokemonEnPokeball;

    public Pokeball(TipoObjetos tipo, TipoPokeball poke) {
        super(tipo);
        this.tipoPokeball = poke;
        this.pokemonEnPokeball = new HashMap<>();
    }

    public TipoPokeball getTipoPokeball() {
        return tipoPokeball;
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

    //Este método calcula la probabilidad de capturar al pokemon segun el tipo de pokeball
    public boolean formula(){
        Random rd = new Random();
        if(this.tipoPokeball.equals(TipoPokeball.POKEBALL)){
            int total = rd.nextInt(2);
            if(total == 0){
                return true;
            }
        } else if (this.tipoPokeball.equals(TipoPokeball.SUPERBALL)) {
            int total = rd.nextInt(3);
            if(total == 0 || total == 1){
                return true;
            }
        } else if (this.tipoPokeball.equals(TipoPokeball.ULTRABALL)) {
            int total = rd.nextInt(5);
            if(total == 0 || total == 1 || total == 2 || total == 3){
                return true;
            }
        } else if (this.tipoPokeball.equals(TipoPokeball.MASTERBALL)) {
            int total = rd.nextInt(100);
            if(total == 0){
                return false;
            }
            else{
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + this.tipoPokeball;
    }
}