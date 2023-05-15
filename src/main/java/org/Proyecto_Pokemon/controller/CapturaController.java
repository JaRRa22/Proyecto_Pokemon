package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
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
    public HashMap<Integer, Image> idPokemonFilePathImagen=new HashMap<>();


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
    public int comprobarImagen(){
        Random rd = new Random();
        int imagenPokemon;
        imagenPokemon = rd.nextInt(1,21);
        pokemonImageView.setImage(idPokemonFilePathImagen.get(imagenPokemon));
        return imagenPokemon;
    }
    public void bntPokeAleatorioIsPressed(ActionEvent event){
        comprobarImagen();
        System.out.println(CRUD.sacarEjemplarPokemonPokedex(comprobarImagen()));
    }
    public boolean menuItemPokeballPressed(ActionEvent event){
        if(Entrenador.getPokeball().getCantidad() > 0){
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
        if(Entrenador.getSuperball().getCantidad() > 0){
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
        if(Entrenador.getUltraball().getCantidad() > 0){
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
        if(Entrenador.getMasterball().getCantidad() > 0){
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

    }
}
