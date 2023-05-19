package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    public static String nombre = "";
    public static String contrasenaElegida = "";

    public static String nombreBBDD = "";
    public static boolean entradaBBDDNombre = false;
    public static boolean entradaBBDDContrasena = false;
    public static String contrasenaBBDD = "";
    public static String introNombre22= "";
    public static String contrasena22 = "";

    protected static HashMap<Integer, Image> idPokemonFilePathImagen;
    private boolean entradaPermitida = false;
    private boolean contrasenaYConfirmarConiciden = false;

    private boolean parametrosContraYConfi = false;

    private boolean nombreValido = false;

    @FXML
    private Button btnSignIn;
    @FXML
    private Button btnSignIn2;
    @FXML
    private TextField introNombre;
    @FXML
    public TextField introducirNombreUsu;
    @FXML
    private TextField confirmar;
    @FXML
    private TextField contrasena;
    @FXML
    public TextField contrasenaIntroUsu;
    @FXML
    private Text chulo;
    @FXML
    private Text chulo1;
    @FXML
    private Text chulo11;
    @FXML
    private Text chulo2;
    @FXML
    private Text chulo3;
    @FXML
    private Text info;
    @FXML
    private Text info2;

    @FXML
    private Text infoContrasena;

    @FXML
    private Text infoContrasena2;
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("El nombre de Usuario no puede ser nulo y debe tener mas de 3 letras y menos de 10.");
            alert.showAndWait();
            nombreValido = false;
        }

        else{

            chulo.setText("✓");
            info.setText("El nombre: `" +"("+introNombre.getText()+")"+ "` es Correcto");
            nombreValido = true;
        }
        if(contrasena == null  || confirmar == null || contrasena.getText().length() < 1 || confirmar.getText().length() < 1 || contrasena.getText().length() > 15 || confirmar.getText().length() > 15){
        infoContrasena.setText("¡ERROR: parametros no validos!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            chulo2.setText("✗");
            chulo3.setText("✗");
            alert.setHeaderText("Error");
            alert.setContentText("ERROR: la contraseña y la confirmacion no pueden ser nulas y deben ser mayor de 1 y menor de 15.");
            alert.showAndWait();
            parametrosContraYConfi = false;
        }
        else{
            infoContrasena.setText("Contraseña Correcta");
            chulo2.setText("✓");
            chulo3.setText("✓");
            parametrosContraYConfi = true;
        }

        if(!(contrasena.getText().equals(confirmar.getText()))){
            infoContrasena.setText("¡ERROR: la confirmacion no coincide con la contraseña!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("La Contraseña debe coincidir con la confirmacion.");
            alert.showAndWait();
            contrasenaYConfirmarConiciden = false;
        }
        else {
            contrasenaYConfirmarConiciden = true;
        }

        if(contrasenaYConfirmarConiciden && parametrosContraYConfi && nombreValido){
            entradaPermitida =  true;
            nombre = introNombre.getText();
            contrasenaElegida = contrasena.getText();
        }
        else{
            entradaPermitida = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("algo debe estar fallando revisa los parametros introducidos en: (Nombre,Contraseña,Confirmar).");
            alert.showAndWait();
        }


        if(entradaPermitida){
            CRUD.addUsuario();
            entrenador = new Entrenador(nombre);
            root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        }
    public void iniciarSesion(ActionEvent event) throws SQLException, IOException {
    if(introducirNombreUsu.getText().length() <= 3 || introducirNombreUsu.getText().length() > 10){
        chulo1.setText("✗");
        info2.setText("ERROR: Nombre no válido");
        introNombre.setText("");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText("El nombre de Usuario no puede ser nulo y debe tener mas de 3 letras y menos de 10.");
        alert.showAndWait();
        nombreValido = false;
    }
    else{
        chulo1.setText("✓");
        info2.setText("El nombre: `" +"(" +introducirNombreUsu.getText()+")"+ "` es Correcto");
        nombreValido = true;
        introNombre22 = introducirNombreUsu.getText();


    }
    if(contrasenaIntroUsu.getText().length() < 1 || contrasenaIntroUsu.getText().length() > 15){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        chulo11.setText("✗");
        alert.setHeaderText("Error");
        alert.setContentText("ERROR: la contraseña  no pueden ser nula y debe ser mayor de 1 y menor de 15.");
        alert.showAndWait();
        parametrosContraYConfi = false;
    }
    else{
        infoContrasena2.setText("Contraseña Correcta");
        chulo11.setText("✓");
        parametrosContraYConfi = true;
        contrasena22 = contrasenaIntroUsu.getText();
    }

    if(nombreValido == false || parametrosContraYConfi == false){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText("ERROR: uno de los parametros no cumple con los requisitos");
        alert.showAndWait();
    }
    else{
        CRUD.addNombreYContrasena(introNombre22,contrasena22);
        if(!(introducirNombreUsu.getText().equals(CRUD.nombre)) || !(contrasenaIntroUsu.getText().equals(CRUD.contrasena))){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("La Cuenta No existe o uno de los valores es incorrecto");
            alert.showAndWait();
        }
        else{
            entrenador = new Entrenador(introducirNombreUsu.getText());
            root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }







    }


}

