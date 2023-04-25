package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.io.File;

public class InicioController {
    private static Entrenador usuario;
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



    public void initialize(){
        File f = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\pokemon-2.gif");
        Image image = new Image(f.toURI().toString());
        imagenPokemon.setImage(image);

    }


    public void registro(ActionEvent event){
        if(introNombre.getText().equals("Nombre") || introNombre.getText().length() == 0 || (introNombre.getText().length() > 0 && introNombre.getText().length()<= 3) || introNombre.getText().length() > 10){
            chulo.setText("✗");
            info.setText("ERROR: Nombre no válido");
            introNombre.setText("");
        }
        else{

            chulo.setText("✓");
            info.setText("¡Bienvenido " +"("+introNombre.getText()+")"+ "!");
            usuario = new Entrenador(introNombre.getText());
        }

    }
}
