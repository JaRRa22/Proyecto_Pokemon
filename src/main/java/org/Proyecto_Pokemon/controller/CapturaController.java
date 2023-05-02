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
        Entrenador.setPokedollars(10000);
        Tienda tienda = new Tienda();
        tienda.comprarPokeball(TipoPokeball.POKEBALL, 5);
        tienda.comprarPokeball(TipoPokeball.SUPERBALL, 5);
        tienda.comprarPokeball(TipoPokeball.ULTRABALL, 5);
        tienda.comprarPokeball(TipoPokeball.MASTERBALL, 5);
        fondoImageView.setVisible(true);
    }
    public void bntPokeAleatorioIsPressed(ActionEvent event){
        if(menuPokeballs.getText().equals("Pokeballs")){
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
        if(menuPokeballs.getText().equals("Pokeball") && Entrenador.getPokeball().getCantidad() > 0) {
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        if(menuPokeballs.getText().equals("Superball") && Entrenador.getSuperball().getCantidad() > 0) {
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        if(menuPokeballs.getText().equals("Ultraball") && Entrenador.getUltraball().getCantidad() > 0) {
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        if(menuPokeballs.getText().equals("Masterball") && Entrenador.getMasterball().getCantidad() > 0) {
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
        if(Entrenador.getPokeball().getCantidad() > 0){
            menuPokeballs.setText("Pokeball");
            labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        else{
            menuPokeballs.setText("Pokeball");
            labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
    }
    public void menuItemSuperballPressed(ActionEvent event){
        if(Entrenador.getSuperball().getCantidad() > 0){
            menuPokeballs.setText("Superball");
            labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        else{
            menuPokeballs.setText("Superball");
            labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
    }
    public void menuItemUltraballPressed(ActionEvent event){
        if(Entrenador.getUltraball().getCantidad() > 0){
            menuPokeballs.setText("Ultraball");
            labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
       else{
            menuPokeballs.setText("Ultraball");
            labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
    }
    public void menuItemMasterballPressed(ActionEvent event){
        if(Entrenador.getSuperball().getCantidad() > 0){
            menuPokeballs.setText("Masterball");
            labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        else{
            menuPokeballs.setText("Masterball");
            labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
    }

    public void btnCapturarIsPressed(ActionEvent event) {
        if(menuPokeballs.getText().equals("Pokeball")){
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
        if(menuPokeballs.getText().equals("Superball")){
            if (Entrenador.getSuperball().getCantidad() == 0) {
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                btnCapturar.setVisible(true);
                btnCapturar.setDisable(false);
            }

            if (picahcuImageView.isVisible()) {
                Pokemon pikachu = new Pokemon("Pikachu");
                if (Entrenador.capturar(Entrenador.getSuperball(), pikachu)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (Entrenador.getSuperball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
                }
            }
            if (charmanderImageView.isVisible()) {
                Pokemon charmander = new Pokemon("Charmander");
                if (Entrenador.capturar(Entrenador.getSuperball(), charmander)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (Entrenador.getSuperball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
                }
            }
            if (squirtleImageView.isVisible()) {
                Pokemon squirtle = new Pokemon("Squirtle");
                if (Entrenador.capturar(Entrenador.getSuperball(), squirtle)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (Entrenador.getSuperball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Superballs restantes: " + Entrenador.getPokeball().getCantidad());
                }
            }
        }
        if(menuPokeballs.getText().equals("Ultraball")){
            if (Entrenador.getUltraball().getCantidad() == 0) {
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                btnCapturar.setVisible(true);
                btnCapturar.setDisable(false);
            }

            if (picahcuImageView.isVisible()) {
                Pokemon pikachu = new Pokemon("Pikachu");
                if (Entrenador.capturar(Entrenador.getUltraball(), pikachu)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (Entrenador.getUltraball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
                }
            }
            if (charmanderImageView.isVisible()) {
                Pokemon charmander = new Pokemon("Charmander");
                if (Entrenador.capturar(Entrenador.getUltraball(), charmander)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Ultrballs restantes: " + Entrenador.getUltraball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (Entrenador.getUltraball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
                }
            }
            if (squirtleImageView.isVisible()) {
                Pokemon squirtle = new Pokemon("Squirtle");
                if (Entrenador.capturar(Entrenador.getUltraball(), squirtle)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (Entrenador.getUltraball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
                }
            }
        }
        if(menuPokeballs.getText().equals("Masterball")){
            if (Entrenador.getMasterball().getCantidad() == 0) {
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                btnCapturar.setVisible(true);
                btnCapturar.setDisable(false);
            }

            if (picahcuImageView.isVisible()) {
                Pokemon pikachu = new Pokemon("Pikachu");
                if (Entrenador.capturar(Entrenador.getMasterball(), pikachu)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (Entrenador.getMasterball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
                }
            }
            if (charmanderImageView.isVisible()) {
                Pokemon charmander = new Pokemon("Charmander");
                if (Entrenador.capturar(Entrenador.getMasterball(), charmander)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (Entrenador.getMasterball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
                }
            }
            if (squirtleImageView.isVisible()) {
                Pokemon squirtle = new Pokemon("Squirtle");
                if (Entrenador.capturar(Entrenador.getMasterball(), squirtle)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (Entrenador.getMasterball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
                }
            }
        }
    }
}
