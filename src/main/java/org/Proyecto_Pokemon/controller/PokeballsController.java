package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoObjetos;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.util.Objects;

public class PokeballsController {
    @FXML
    private Label labelPokeball;
    @FXML
    private Label labelSuperball;
    @FXML
    private Label labelUltraball;
    @FXML
    private Label labelMasterball;
    @FXML
    private Button btnMochila;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize(){
        labelPokeball.setText("Cantidad: " + Entrenador.getPokeball().getCantidad());
        labelSuperball.setText("Cantidad: " + Entrenador.getSuperball().getCantidad());
        labelUltraball.setText("Cantidad: " + Entrenador.getUltraball().getCantidad());
        labelMasterball.setText("Cantidad: " + Entrenador.getUltraball().getCantidad());
    }
    public void btnMochilaIsPressed(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Mochila.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
