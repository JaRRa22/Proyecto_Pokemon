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
import org.Proyecto_Pokemon.Logger;
import org.Proyecto_Pokemon.database.CRUD;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static org.Proyecto_Pokemon.controller.InicioController.idPokemonFilePathImagen;


public class CapturaController {
    @FXML
    private Button menu;
    @FXML
    private ImageView pokemonImageView;
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


    private int id;


    public void initialize(){
        Logger.getOrCreateFileWriter();

    }



    public void comprobarImagen(){
        Random rd = new Random();
        int imagenPokemon = rd.nextInt(1,21);
        pokemonImageView.setImage(idPokemonFilePathImagen.get(imagenPokemon));
        id = imagenPokemon;
    }
    public void bntPokeAleatorioIsPressed(ActionEvent event){

        comprobarImagen();
        pokemonImageView.setVisible(true);
        btnCapturar.setVisible(true);
        btnCapturar.setDisable(false);
    }
    public boolean menuItemPokeballPressed(ActionEvent event){
        if(Entrenador.getPokeball().getCantidad() > 0 && id >= 1 && id <= 20){
            menuPokeballs.setText("Pokeball");
            labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
            return true;
        }
        else {
            menuPokeballs.setText("Pokeball");
            labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
            return false;
        }
    }
    public boolean menuItemSuperballPressed(ActionEvent event){
        if(Entrenador.getSuperball().getCantidad() > 0 && id >= 1 && id <= 20){
            menuPokeballs.setText("Superball");
            labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);

            return true;
        }
        else {
            menuPokeballs.setText("Superball");
            labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
            return false;
        }
    }
    public boolean menuItemUltraballPressed(ActionEvent event){
        if(Entrenador.getUltraball().getCantidad() > 0 && id >= 1 && id <= 20){
            menuPokeballs.setText("Ultraball");
            labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
            return true;
        }
        else {
            menuPokeballs.setText("Ultraball");
            labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
            return false;
        }
    }
    public boolean menuItemMasterballPressed(ActionEvent event){
        if(Entrenador.getMasterball().getCantidad() > 0 && id >= 1 && id <= 20){
            menuPokeballs.setText("Masterball");
            labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
            btnCapturar.setVisible(true);
            btnCapturar.setDisable(false);
            return true;
        }
        else {
            menuPokeballs.setText("Masterball");
            labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
            btnCapturar.setVisible(false);
            btnCapturar.setDisable(true);
            return false;
        }
    }

    public void btnCapturarIsPressed(ActionEvent event) throws IOException {
        if(menuPokeballs.getText().equals("Pokeball")){
            if(Entrenador.capturar(Entrenador.getPokeball(), CRUD.sacarEjemplarPokemonPokedex(id))){
                labelText.setText("Pokemon capturado");
                labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(false);
                pokemonImageView.setVisible(false);

                id = 0;
            }
            else {
                labelText.setText("Pokemon no capturado");
                labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
            }
        }
        if(menuPokeballs.getText().equals("Superball")){
            if(Entrenador.capturar(Entrenador.getSuperball(), CRUD.sacarEjemplarPokemonPokedex(id))){
                labelText.setText("Pokemon capturado");
                labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(false);
                pokemonImageView.setVisible(false);
                id = 0;
            }
            else {
                labelText.setText("Pokemon no capturado");
                labeltex2.setText("Superballs restantes: " + Entrenador.getSuperball().getCantidad());
            }
        }
        if(menuPokeballs.getText().equals("Ultraball")){
            if(Entrenador.capturar(Entrenador.getUltraball(), CRUD.sacarEjemplarPokemonPokedex(id))){
                labelText.setText("Pokemon capturado");
                labeltex2.setText("Ultraball restantes: " + Entrenador.getUltraball().getCantidad());
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(false);
                pokemonImageView.setVisible(false);
                id = 0;
            }
            else {
                labelText.setText("Pokemon no capturado");
                labeltex2.setText("Ultraballs restantes: " + Entrenador.getUltraball().getCantidad());
            }
        }
        if(menuPokeballs.getText().equals("Masterball")){
            if(Entrenador.capturar(Entrenador.getMasterball(), CRUD.sacarEjemplarPokemonPokedex(id))){
                labelText.setText("Pokemon capturado");
                labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(false);
                pokemonImageView.setVisible(false);
                id=0;
            }
            else {
                labelText.setText("Pokemon no capturado");
                labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
            }
        }

    }






    public void irAMenu(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menu.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
