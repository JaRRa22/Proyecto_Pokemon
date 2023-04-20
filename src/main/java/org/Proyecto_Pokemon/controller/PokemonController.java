package org.Proyecto_Pokemon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.Proyecto_Pokemon.model.Pokemon;

public class PokemonController {
    @FXML
    private Button btnCrtPokemon;
    @FXML
    private Label lblNombrePokemon;



    public Pokemon crtPokemonIsPressed(){
        Pokemon pikachu = new Pokemon();
        System.out.println("Pika Pika");
        return pikachu;
    }
}
