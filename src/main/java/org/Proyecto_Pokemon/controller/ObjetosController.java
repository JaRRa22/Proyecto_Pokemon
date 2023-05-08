package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoObjetos;
import org.Proyecto_Pokemon.model.TipoPokeball;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ObjetosController {
    @FXML
    private Label labelBaston;
    @FXML
    private Label labelChaleco;
    @FXML
    private Label labelPila;
    @FXML
    private Label labelPesa;
    @FXML
    private Label labelPluma;
    @FXML
    private Button btnMochila;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize(){
        Entrenador e = new Entrenador("Hola");
        Tienda tienda = new Tienda();
        tienda.comprarPokeball(TipoPokeball.SUPERBALL, 1);
        tienda.comprarObjeto(TipoObjetos.CHALECO, 2);
        labelBaston.setText("Cantidad: " + Entrenador.getBaston().getCantidad());
        labelChaleco.setText("Cantidad: " + Entrenador.getChaleco().getCantidad());
        labelPila.setText("Cantidad: " + Entrenador.getPilas().getCantidad());
        labelPesa.setText("Cantidad: " + Entrenador.getPesa().getCantidad());
        labelPluma.setText("Cantidad: " + Entrenador.getPluma().getCantidad());
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
