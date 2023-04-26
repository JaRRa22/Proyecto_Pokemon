package org.Proyecto_Pokemon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MochilaController {

    @FXML
    private ImageView mochila;
    @FXML
    private ImageView fondo;
    @FXML
    private ChoiceBox <String> myChoiceBox;
    private String [] items = {"Objetos", "Pokeballs"};
    @FXML
    private Label labelText;

    public void initialize(){
        fondo.setVisible(true);
        mochila.setVisible(true);
        myChoiceBox.getItems().addAll(items);
        myChoiceBox.setAccessibleText("Tipo de objetos");
        labelText.setText("Elige el tipo de objeto");
    }
}
