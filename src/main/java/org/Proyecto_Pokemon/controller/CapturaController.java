package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.io.File;
import java.util.Random;


public class CapturaController {
    @FXML
    private Button btnCapturar;
    @FXML
    private Label labelText;
    @FXML
    private ImageView pokemonImageView;
    @FXML
    private Label labeltex2;
    @FXML
    private Button bntPokeAleatorio;
    @FXML
    private ImageView fondoImageView;



    public void initialize(){
        btnCapturar.setVisible(false);
        btnCapturar.setDisable(true);
        Entrenador e = new Entrenador("Entrenador");
        Tienda tienda = new Tienda();
        tienda.comprarPokeball(TipoPokeball.POKEBALL, 3);
        labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
        File file2 = new File("C:\\Users\\agsil\\Desktop\\Pokemons\\FondoCaptura.png");
        Image image2 = new Image(file2.toURI().toString());
        fondoImageView.setImage(image2);
    }
    public void bntPokeAleatorioIsPressed(ActionEvent event){
        if(Entrenador.getPokeball().getCantidad() == 0){
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
        else{
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        Random rd = new Random();
        int random = rd.nextInt(3);
        if(random == 0){
            File file = new File("C:\\Users\\agsil\\Desktop\\Pokemons\\Picachu.png");
            Image image = new Image(file.toURI().toString());
            pokemonImageView.setImage(image);
        }
        else if (random == 1) {
            File file = new File("C:\\Users\\agsil\\Desktop\\Pokemons\\Charmander.png");
            Image image = new Image(file.toURI().toString());
            pokemonImageView.setImage(image);
        }
        else {
            File file = new File("C:\\Users\\agsil\\Desktop\\Pokemons\\Squirtle.png");
            Image image = new Image(file.toURI().toString());
            pokemonImageView.setImage(image);
        }

    }

    public void btnCapturarIsPressed(ActionEvent event){
        if(Entrenador.getPokeball().getCantidad() == 0){
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
        else{
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        Pokemon pikachu = new Pokemon("Pikachu");
        if(Entrenador.capturar(Entrenador.getPokeball() ,pikachu)){
            labelText.setText("Pokemon capturado");
            labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
        else {
            if(Entrenador.getPokeball().getCantidad() == 0){
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            }
            labelText.setText("Pokemon no capturado");
            labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
        }
    }
}
