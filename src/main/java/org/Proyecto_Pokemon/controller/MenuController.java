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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.model.*;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MenuController {
    @FXML
    public Button btnIrACentroPokemon;
    @FXML
    public Label labelNoCombate;
    private Parent root;
    private Stage stage;

    private Scene scene;
    @FXML
    private Button combate;
    @FXML
    private Button btnIrATienda;

    @FXML
    private Button IrACaptura;

    @FXML
    private Button btnIrACriar;

    @FXML
    private Button btnIrAMochila;
    @FXML
    private ImageView imagenFondo;


    public void initialize(){
        labelNoCombate.setVisible(false);
        File f = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\menu.gif");
        Image image = new Image(f.toURI().toString());
        imagenFondo.setImage(image);
    }

    public void tienda(ActionEvent event) throws IOException {

    }

    public void criar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Cria.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void captura(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Captura.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void irACombate(ActionEvent event) throws IOException {
        if (Entrenador.getEquipoPK()[0]!=null && Entrenador.getEquipoPK()[0].getVitalidadActual()>0){
            labelNoCombate.setVisible(true);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Combate.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }else labelNoCombate.setVisible(true);
    }

    public void irACentropokemon(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/CentroPokemon.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void irAMochila(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Mochila.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
