package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    @FXML
    private MenuButton menuPokeballs;
    @FXML
    private MenuItem pokeballMenu;
    @FXML
    private MenuItem superballMenu;
    @FXML
    private MenuItem ultraballMenu;
    @FXML
    private MenuItem masterballMenu;


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
    public void menuItemPokeballPressed(ActionEvent event){
        menuPokeballs.setText("Pokeball");
        labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
    }
    public void menuItemSuperballPressed(ActionEvent event){
        menuPokeballs.setText("Superball");
        labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
    }
    public void menuItemUltraballPressed(ActionEvent event){
        menuPokeballs.setText("Ultraball");
        labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
    }
    public void menuItemMasterballPressed(ActionEvent event){
        menuPokeballs.setText("Masterball");
        labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
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
