package org.Proyecto_Pokemon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;

public class EquiposController {
    @FXML
    private Label labelPrimerPk;
    @FXML
    private Label labelSegundoPk;
    @FXML
    private Label labelTercerPk;
    @FXML
    private Label labelCuartoPk;
    @FXML
    private Label labelQuintoPk;
    @FXML
    private Label labelSextoPk;

    public void initialize(){
        Entrenador e = new Entrenador("Hola");
        Pokemon picachu = new Pokemon("Picachu");
        Pokemon charmander = new Pokemon("Charmander");
        Pokemon squirtle = new Pokemon("Squirtle");
        Entrenador.anadirAEquipo(picachu);
        Entrenador.anadirAEquipo(charmander);
        Entrenador.anadirAEquipo(squirtle);
        labelPrimerPk.setText("" + Entrenador.getEquipoPK()[0]);
        labelSegundoPk.setText("" + Entrenador.getEquipoPK()[1]);
        labelTercerPk.setText("" + Entrenador.getEquipoPK()[2]);
        labelCuartoPk.setText("");
        labelQuintoPk.setText("");
        labelSextoPk.setText("");
    }
}
