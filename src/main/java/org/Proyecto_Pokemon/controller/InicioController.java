package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.database.CRUD;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;


public class InicioController {


    public static Entrenador entrenador;
    protected static Tienda tienda;
    protected static HashMap<Integer, Image> idPokemonFilePathImagen;


    @FXML
    private Button btnSignIn;

    @FXML
    private TextField introNombre;

    @FXML
    private Text chulo;

    @FXML
    private Text info;

    @FXML
    private ImageView imagenPokemon;

    private Parent root;
    private Stage stage;

    private Scene scene;



    public void initialize() throws SQLException {
        File f = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\pokemon-2.gif");
        Image image = new Image(f.toURI().toString());
        imagenPokemon.setImage(image);
        tienda = new Tienda();
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        idPokemonFilePathImagen=new HashMap<>();

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


    public void registro(ActionEvent event) throws IOException, InterruptedException, SQLException {
        if(introNombre.getText().equals("Nombre") || introNombre.getText().length() == 0 || (introNombre.getText().length() > 0 && introNombre.getText().length()<= 3) || introNombre.getText().length() > 10){
            chulo.setText("✗");
            info.setText("ERROR: Nombre no válido");
            introNombre.setText("");
        }
        else{

            chulo.setText("✓");
            info.setText("¡Bienvenido " +"("+introNombre.getText()+")"+ "!");
            entrenador = new Entrenador(introNombre.getText());
            Entrenador.setPokedollars(40000);
            CRUD.insertPokemon();
            CRUD.addMovimientosInsert();


            root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        }

    }

