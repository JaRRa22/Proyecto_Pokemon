package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.model.Entrenador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.Objects;
import java.util.ResourceBundle;

public class CentroPokemonController implements Initializable {
    @FXML
    public Button menu;
    @FXML
    public Label texto;
    @FXML
    Button tiendaButton;
    @FXML
    Button centroPokemon;
    @FXML
    Button caja;
    @FXML
    ImageView imgCentroPokemon;

    private static Stage stage;
    private  static Scene scene;
    private static Parent root;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tiendaButton.setOpacity(0.00);
        texto.setVisible(false);
        centroPokemon.setOpacity(0.00);
        caja.setOpacity(0.00);
        File centroPokokemon = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\centroPokemon.png");
        Image image8 = new Image(centroPokokemon.toURI().toString());




    }


    public void curarPokemon(ActionEvent event) {
        Entrenador.curarEquipos();
        texto.setVisible(true);
    }

    public void irATienda(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(TiendaController.class.getResource("/fxml/Tienda.fxml")));
         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void accederACaja(ActionEvent event) {
    }

    public void irAMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(MenuController.class.getResource("/fxml/Menu.fxml")));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
