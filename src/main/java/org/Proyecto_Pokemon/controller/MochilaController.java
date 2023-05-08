package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoObjetos;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.util.Objects;

public class MochilaController {
    @FXML
    private ImageView mochila;
    @FXML
    private ImageView fondo;
    @FXML
    private Button btnPokeballs;
    @FXML
    private Button btnObjetos;
    @FXML
    private Label labelPokeball;
    @FXML
    private Label labelSuperball;
    @FXML
    private Label labelUltraball;
    @FXML
    private Label labelMasterball;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize(){
        Entrenador e = new Entrenador("Entrenador");
        System.out.println(Entrenador.getPokedollars());
        Tienda tienda = new Tienda();
        tienda.comprarPokeball(TipoPokeball.SUPERBALL, 1);
        tienda.comprarObjeto(TipoObjetos.CHALECO, 2);
    }
    public void mostrarPokeballs(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Pokeballs.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void mostrarObjetos(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Objetos.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
