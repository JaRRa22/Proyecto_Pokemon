package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.Proyecto_Pokemon.database.CRUD;
import org.Proyecto_Pokemon.model.*;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
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
    private Button btnPokeAleatorio;
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
    public HashMap<Integer, Image> idPokemonFilePathImagen=new HashMap<>();
    @FXML
    private Label labelPk1;
    @FXML
    private Label labelPk2;
    @FXML
    private Label labelPk3;
    @FXML
    private Label labelPk4;
    @FXML
    private Label labelPk5;
    @FXML
    private Label labelPk6;
    @FXML
    private Button btnEquipo;

    private int id;


    public void initialize() throws SQLException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        btnCapturar.setVisible(false);
        btnCapturar.setDisable(true);
        Entrenador e = new Entrenador("Entrenador");
        Entrenador.setPokedollars(10000);
        Tienda tienda = new Tienda();
        tienda.comprarPokeball(TipoPokeball.POKEBALL, 3);
        tienda.comprarPokeball(TipoPokeball.SUPERBALL, 3);
        tienda.comprarPokeball(TipoPokeball.ULTRABALL, 3);
        tienda.comprarPokeball(TipoPokeball.MASTERBALL, 3);


        File fileCarreroBlanco = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\carreroBlanco.jpeg");
        Image carreroBlanco = new Image(fileCarreroBlanco.toURI().toString());
        File fileIvysaur = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\002.png");
        Image ivysaur = new Image(fileIvysaur.toURI().toString());
        File fileBulbasaur = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\bulba001.png");
        Image bulbasaur = new Image(fileBulbasaur.toURI().toString());
        File fileCharmander = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\charmander04.png");
        Image charmander = new Image(fileCharmander.toURI().toString());
        File filePicachu = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\rataAmarilla05.png");
        Image picachu = new Image(filePicachu.toURI().toString());
        File fileMetapod = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\capullo06.png");
        Image metapod = new Image(fileMetapod.toURI().toString());
        File fileSquirtle = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\Squirtle.png");
        Image squirtle = new Image(fileSquirtle.toURI().toString());
        File filePidgey = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\pajarofeo08.png");
        Image pidgey = new Image(filePidgey.toURI().toString());
        File fileCaterpie = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\caterpie09.png");
        Image caterpie = new Image(fileCaterpie.toURI().toString());
        File fileDragonite = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\Dragonite10.png");
        Image dragonite = new Image(fileDragonite.toURI().toString());
        File fileJigglypuff = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\jiggy11.png");
        Image jigglypuff = new Image(fileJigglypuff.toURI().toString());
        File filePonyta = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\Ponyta12.png");
        Image ponyta = new Image(filePonyta.toURI().toString());
        File fileGeodude = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\geodude13.png");
        Image geodude = new Image(fileGeodude.toURI().toString());
        File fileMagnemite = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\magnemite14.png");
        Image magnemite = new Image(fileMagnemite.toURI().toString());
        File fileSnorlax = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\snorlax15.png");
        Image snorlax = new Image(fileSnorlax.toURI().toString());
        File fileFlareon = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\flareon16.png");
        Image flareon = new Image(fileFlareon.toURI().toString());
        File fileVaporeon = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\vaporeon17.png");
        Image vaporeon = new Image(fileVaporeon.toURI().toString());
        File fileEvee = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\evee18.png");
        Image evee = new Image(fileEvee.toURI().toString());
        File fileLapras = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\lapras19.png");
        Image lapras = new Image(fileLapras.toURI().toString());
        File fileMagikarp = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\Magikarp20.png");
        Image magikarp = new Image(fileMagikarp.toURI().toString());

        idPokemonFilePathImagen.put(3,carreroBlanco);
        idPokemonFilePathImagen.put(1,bulbasaur);
        idPokemonFilePathImagen.put(2,ivysaur);
        idPokemonFilePathImagen.put(4,charmander);
        idPokemonFilePathImagen.put(5,picachu);
        idPokemonFilePathImagen.put(6,metapod);
        idPokemonFilePathImagen.put(7,squirtle);
        idPokemonFilePathImagen.put(8,pidgey);
        idPokemonFilePathImagen.put(9,caterpie);
        idPokemonFilePathImagen.put(10,dragonite);
        idPokemonFilePathImagen.put(11,jigglypuff);
        idPokemonFilePathImagen.put(12,ponyta);
        idPokemonFilePathImagen.put(13,geodude);
        idPokemonFilePathImagen.put(14,magnemite);
        idPokemonFilePathImagen.put(15,snorlax);
        idPokemonFilePathImagen.put(16,flareon);
        idPokemonFilePathImagen.put(17,vaporeon);
        idPokemonFilePathImagen.put(18,evee);
        idPokemonFilePathImagen.put(19,lapras);
        idPokemonFilePathImagen.put(20,magikarp);
    }
    public void comprobarImagen(){
            Random rd = new Random();
            int imagenPokemon = rd.nextInt(1,21);
            pokemonImageView.setImage(idPokemonFilePathImagen.get(imagenPokemon));
            id = imagenPokemon;
    }
    public void btnPokeAleatorioIsPressed(ActionEvent event){
        comprobarImagen();
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

    public void btnCapturarIsPressed(ActionEvent event) {
        if(menuPokeballs.getText().equals("Pokeball")){
            if(Entrenador.capturar(Entrenador.getPokeball(), CRUD.sacarEjemplarPokemonPokedex(id))){
                labelText.setText("Pokemon capturado");
                labeltex2.setText("Pokeballs restantes: " + Entrenador.getPokeball().getCantidad());
                btnCapturar.setVisible(false);
                btnCapturar.setDisable(false);
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
            }
            else {
                labelText.setText("Pokemon no capturado");
                labeltex2.setText("Masterballs restantes: " + Entrenador.getMasterball().getCantidad());
            }
        }
    }
    public void btnEquipoIsPressed(ActionEvent event){
        labelPk1.setText("Pk1: " + Entrenador.getEquipoPK()[0]);
        labelPk2.setText("Pk2: " + Entrenador.getEquipoPK()[1]);
        labelPk3.setText("Pk3: " + Entrenador.getEquipoPK()[2]);
        labelPk4.setText("Pk4: " + Entrenador.getEquipoPK()[3]);
        labelPk5.setText("Pk5: " + Entrenador.getEquipoPK()[4]);
        labelPk6.setText("Pk6: " + Entrenador.getEquipoPK()[5]);
    }

}
