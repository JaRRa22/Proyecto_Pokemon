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
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class InicioController {
    protected static Entrenador entrenador;
    protected static Tienda tienda;


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


    public void initialize(){
        File f = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\pokemon-2.gif");
        Image image = new Image(f.toURI().toString());
        imagenPokemon.setImage(image);
        tienda = new Tienda();

    }


    public void registro(ActionEvent event) throws IOException, InterruptedException {
        if(introNombre.getText().equals("Nombre") || introNombre.getText().length() == 0 || (introNombre.getText().length() > 0 && introNombre.getText().length()<= 3) || introNombre.getText().length() > 10){
            chulo.setText("✗");
            info.setText("ERROR: Nombre no válido");
            introNombre.setText("");
        }
        else{

            chulo.setText("✓");
            info.setText("¡Bienvenido " +"("+introNombre.getText()+")"+ "!");
            entrenador = new Entrenador(introNombre.getText());

            root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        }

    }

