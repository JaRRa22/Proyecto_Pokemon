package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.util.Random;


public class CapturaController {
    @FXML
    private Button btnCapturar;
    @FXML
    private Label labelText;
    @FXML
    private ImageView picahcuImageView;
    @FXML
    private ImageView charmanderImageView;
    @FXML
    private ImageView squirtleImageView;
    @FXML
    private Label labeltex2;
    @FXML
    private Button bntPokeAleatorio;
    @FXML
    private ImageView fondoImageView;


    public void initialize(){
        picahcuImageView.setVisible(false);
        charmanderImageView.setVisible(false);
        squirtleImageView.setVisible(false);
        btnCapturar.setVisible(false);
        btnCapturar.setDisable(true);
        Entrenador e = new Entrenador("Entrenador");
        Tienda tienda = new Tienda();
        tienda.comprarPokeball(TipoPokeball.POKEBALL, 4);
        labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
        fondoImageView.setVisible(true);
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
            picahcuImageView.setVisible(true);
            charmanderImageView.setVisible(false);
            squirtleImageView.setVisible(false);
        }
        else if (random == 1) {
            charmanderImageView.setVisible(true);
            picahcuImageView.setVisible(false);
            squirtleImageView.setVisible(false);
        }
        else {
            squirtleImageView.setVisible(true);
            picahcuImageView.setVisible(false);
            charmanderImageView.setVisible(false);
        }
    }

    public void btnCapturarIsPressed(ActionEvent event) {
        if (Entrenador.getPokeball().getCantidad() == 0) {
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        } else {
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }

        if (picahcuImageView.isVisible()) {
            Pokemon pikachu = new Pokemon("Pikachu");
            if (Entrenador.capturar(Entrenador.getPokeball(), pikachu)) {
                labelText.setText("Pokemon capturado");
                labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                if (Entrenador.getPokeball().getCantidad() == 0) {
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                }
                labelText.setText("Pokemon no capturado");
                labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
            }
        }
        if (charmanderImageView.isVisible()) {
            Pokemon charmander = new Pokemon("Charmander");
            if (Entrenador.capturar(Entrenador.getPokeball(), charmander)) {
                labelText.setText("Pokemon capturado");
                labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                if (Entrenador.getPokeball().getCantidad() == 0) {
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                }
                labelText.setText("Pokemon no capturado");
                labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
            }
        }
        if (squirtleImageView.isVisible()) {
            Pokemon squirtle = new Pokemon("Squirtle");
            if (Entrenador.capturar(Entrenador.getPokeball(), squirtle)) {
                labelText.setText("Pokemon capturado");
                labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                if (Entrenador.getPokeball().getCantidad() == 0) {
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                }
                labelText.setText("Pokemon no capturado");
                labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
            }
        }
    }
}
