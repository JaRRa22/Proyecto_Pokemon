package org.Proyecto_Pokemon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.Proyecto_Pokemon.model.Entrenador;

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

    public void initialize(){
        labelBaston.setText("Cantidad: " + Entrenador.getBaston().getCantidad());
        labelChaleco.setText("Cantidad: " + Entrenador.getChaleco().getCantidad());
        labelPila.setText("Cantidad: " + Entrenador.getPilas().getCantidad());
        labelPesa.setText("Cantidad: " + Entrenador.getPesa().getCantidad());
        labelPluma.setText("Cantidad: " + Entrenador.getPluma().getCantidad());
    }
}
