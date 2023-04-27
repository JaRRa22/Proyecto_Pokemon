package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoObjetos;
import org.Proyecto_Pokemon.model.TipoPokeball;

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
    @FXML
    private Label labelPesa;
    @FXML
    private Label labelPluma;
    @FXML
    private Label labelChaleco;
    @FXML
    private Label labelBaston;
    @FXML
    private Label labelPila;

    public void initialize(){
        Entrenador e = new Entrenador("Entrenador");
        System.out.println(Entrenador.getPokedollars());
        Tienda tienda = new Tienda();
        tienda.comprarPokeball(TipoPokeball.SUPERBALL, 1);
        tienda.comprarObjeto(TipoObjetos.CHALECO, 2);
    }
    public void mostrarPokeballs(ActionEvent event){
        labelPokeball.setText("Pokeballs: " + Entrenador.getPokeball().getCantidad());
        labelSuperball.setText("Superballs: " + Entrenador.getSuperball().getCantidad());
        labelUltraball.setText("Ultraballs: " + Entrenador.getUltraball().getCantidad());
        labelMasterball.setText("Masterballs: " + Entrenador.getMasterball().getCantidad());
    }
        public void mostrarObjetos(ActionEvent event){
        labelPesa.setText("Pesa: " + Entrenador.getPesa().getCantidad());
        labelPluma.setText("Pluma: " + Entrenador.getPluma().getCantidad());
        labelChaleco.setText("Chaleco: " + Entrenador.getChaleco().getCantidad());
        labelBaston.setText("Baston: " + Entrenador.getBaston().getCantidad());
        labelPila.setText("Pila: " + Entrenador.getPilas().getCantidad());
    }
}
