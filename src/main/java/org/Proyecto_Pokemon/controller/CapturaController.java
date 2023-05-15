package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.io.IOException;
import java.util.Random;


public class CapturaController {
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Button btnIrAMenu;
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
        fondoImageView.setVisible(true);
    }
    public void bntPokeAleatorioIsPressed(ActionEvent event){
        if(menuPokeballs.getText().equals("Pokeballs")){
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
        if(menuPokeballs.getText().equals("Pokeball") && InicioController.entrenador.getPokeball().getCantidad() > 0) {
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        if(menuPokeballs.getText().equals("Superball") && InicioController.entrenador.getSuperball().getCantidad() > 0) {
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        if(menuPokeballs.getText().equals("Ultraball") && InicioController.entrenador.getUltraball().getCantidad() > 0) {
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        if(menuPokeballs.getText().equals("Masterball") && InicioController.entrenador.getMasterball().getCantidad() > 0) {
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
        if(InicioController.entrenador.getPokeball().getCantidad() > 0){
            menuPokeballs.setText("Pokeball");
            labeltex2.setText("Pokeballs restantes: " + InicioController.entrenador.getPokeball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        else{
            menuPokeballs.setText("Pokeball");
            labeltex2.setText("Pokeballs restantes: " + InicioController.entrenador.getPokeball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
    }
    public void menuItemSuperballPressed(ActionEvent event){
        if(InicioController.entrenador.getSuperball().getCantidad() > 0){
            menuPokeballs.setText("Superball");
            labeltex2.setText("Superballs restantes: " + InicioController.entrenador.getSuperball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        else{
            menuPokeballs.setText("Superball");
            labeltex2.setText("Superballs restantes: " + InicioController.entrenador.getSuperball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
    }
    public void menuItemUltraballPressed(ActionEvent event){
        if(InicioController.entrenador.getUltraball().getCantidad() > 0){
            menuPokeballs.setText("Ultraball");
            labeltex2.setText("Ultraballs restantes: " + InicioController.entrenador.getUltraball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
       else{
            menuPokeballs.setText("Ultraball");
            labeltex2.setText("Ultraballs restantes: " + InicioController.entrenador.getUltraball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);

        }
    }
    public void menuItemMasterballPressed(ActionEvent event){
        if(InicioController.entrenador.getMasterball().getCantidad() > 0){
            menuPokeballs.setText("Masterball");
            labeltex2.setText("Masterballs restantes: " + InicioController.entrenador.getMasterball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
        }
        else{
            menuPokeballs.setText("Masterball");
            labeltex2.setText("Masterballs restantes: " + InicioController.entrenador.getMasterball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
        }
    }

    public void btnCapturarIsPressed(ActionEvent event) {
        if(menuPokeballs.getText().equals("Pokeball")){
            if (InicioController.entrenador.getPokeball().getCantidad() == 0) {
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                btnCapturar.setVisible(true);
                btnCapturar.setDisable(false);
            }

            if (picahcuImageView.isVisible()) {
                Pokemon pikachu = new Pokemon("Pikachu");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getPokeball(), pikachu)) {
                    labelText.setText("Pokemon capturado");
                    picahcuImageView.setVisible(false);
                    labeltex2.setText("Pokeballs restantes: " + InicioController.entrenador.getPokeball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getPokeball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Pokeballs restantes: " + InicioController.entrenador.getPokeball().getCantidad());
                }
            }
            if (charmanderImageView.isVisible()) {
                Pokemon charmander = new Pokemon("Charmander");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getPokeball(), charmander)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Pokeballs restantes: " + InicioController.entrenador.getPokeball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getPokeball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Pokeballs restantes: " + InicioController.entrenador.getPokeball().getCantidad());
                }
            }
            if (squirtleImageView.isVisible()) {

                Pokemon squirtle = new Pokemon("Squirtle");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getPokeball(), squirtle)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Pokeballs restantes: " + InicioController.entrenador.getPokeball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getPokeball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Pokeballs restantes: " + InicioController.entrenador.getPokeball().getCantidad());
                }
            }
        }
        if(menuPokeballs.getText().equals("Superball")){
            if (InicioController.entrenador.getSuperball().getCantidad() == 0) {
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                btnCapturar.setVisible(true);
                btnCapturar.setDisable(false);
            }

            if (picahcuImageView.isVisible()) {
                Pokemon pikachu = new Pokemon("Pikachu");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getSuperball(), pikachu)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Superballs restantes: " + InicioController.entrenador.getSuperball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getSuperball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Superballs restantes: " + InicioController.entrenador.getSuperball().getCantidad());
                }
            }
            if (charmanderImageView.isVisible()) {
                Pokemon charmander = new Pokemon("Charmander");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getSuperball(), charmander)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Superballs restantes: " +InicioController.entrenador.getSuperball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getSuperball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Superballs restantes: " + InicioController.entrenador.getSuperball().getCantidad());
                }
            }
            if (squirtleImageView.isVisible()) {
                Pokemon squirtle = new Pokemon("Squirtle");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getSuperball(), squirtle)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Superballs restantes: " + InicioController.entrenador.getSuperball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getSuperball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Superballs restantes: " + InicioController.entrenador.getSuperball().getCantidad());
                }
            }
        }
        if(menuPokeballs.getText().equals("Ultraball")){
            if (InicioController.entrenador.getUltraball().getCantidad() == 0) {
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                btnCapturar.setVisible(true);
                btnCapturar.setDisable(false);
            }

            if (picahcuImageView.isVisible()) {
                Pokemon pikachu = new Pokemon("Pikachu");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getUltraball(), pikachu)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Ultraballs restantes: " + InicioController.entrenador.getUltraball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getUltraball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Ultraballs restantes: " + InicioController.entrenador.getUltraball().getCantidad());
                }
            }
            if (charmanderImageView.isVisible()) {
                Pokemon charmander = new Pokemon("Charmander");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getUltraball(), charmander)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Ultrballs restantes: " +InicioController.entrenador.getUltraball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getUltraball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Ultraballs restantes: " + InicioController.entrenador.getUltraball().getCantidad());
                }
            }
            if (squirtleImageView.isVisible()) {
                Pokemon squirtle = new Pokemon("Squirtle");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getUltraball(), squirtle)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Ultraballs restantes: " + InicioController.entrenador.getUltraball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getUltraball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Ultraballs restantes: " + InicioController.entrenador.getUltraball().getCantidad());
                }
            }
        }
        if(menuPokeballs.getText().equals("Masterball")){
            if (InicioController.entrenador.getMasterball().getCantidad() == 0) {
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(true);
            } else {
                btnCapturar.setVisible(true);
                btnCapturar.setDisable(false);
            }

            if (picahcuImageView.isVisible()) {
                Pokemon pikachu = new Pokemon("Pikachu");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getMasterball(), pikachu)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Masterballs restantes: " + InicioController.entrenador.getMasterball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getMasterball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Masterballs restantes: " + InicioController.entrenador.getMasterball().getCantidad());
                }
            }
            if (charmanderImageView.isVisible()) {
                Pokemon charmander = new Pokemon("Charmander");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getMasterball(), charmander)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Masterballs restantes: " + InicioController.entrenador.getMasterball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getMasterball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Masterballs restantes: " + InicioController.entrenador.getMasterball().getCantidad());
                }
            }
            if (squirtleImageView.isVisible()) {
                Pokemon squirtle = new Pokemon("Squirtle");
                if (InicioController.entrenador.capturar(InicioController.entrenador.getMasterball(), squirtle)) {
                    labelText.setText("Pokemon capturado");
                    labeltex2.setText("Masterballs restantes: " + InicioController.entrenador.getMasterball().getCantidad());
                    btnCapturar.setVisible(false);
                    btnCapturar.setDisable(true);
                } else {
                    if (InicioController.entrenador.getMasterball().getCantidad() == 0) {
                        btnCapturar.setVisible(false);
                        btnCapturar.setDisable(true);
                    }
                    labelText.setText("Pokemon no capturado");
                    labeltex2.setText("Masterballs restantes: " + InicioController.entrenador.getMasterball().getCantidad());
                }
            }
        }
    }
    public void irAMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
