package org.Proyecto.Pokemon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.Proyecto.Pokemon.model.Pokemon;

public class PokemonController {
    @FXML
    private Button btnCrtPokemon;
    public Pokemon crtPokemonIsPressed(){
        Pokemon pikachu = new Pokemon();
        System.out.println("Pika Pika");
        return pikachu;
    }
}
