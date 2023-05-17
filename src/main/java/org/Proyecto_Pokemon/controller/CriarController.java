package org.Proyecto_Pokemon.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.model.*;

import java.io.IOException;

public class CriarController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private boolean imagen1elegida = false;
    private boolean imagen2elegida = false;
    private Pokemon primeroElegido;
    private Pokemon segundoElegido;
    public static Pokemon pokemonCriado;
    @FXML
    private ImageView eleccion1;
    @FXML
    private ImageView eleccion2;
    @FXML
    private ImageView eQ1Imagen1;
    @FXML
    private ImageView eQ1Imagen2;
    @FXML
    private ImageView eQ1Imagen3;
    @FXML
    private ImageView eQ1Imagen4;
    @FXML
    private ImageView eQ1Imagen5;
    @FXML
    private ImageView eQ1Imagen6;
    @FXML
    private ImageView eQ2Imagen1;
    @FXML
    private ImageView eQ2Imagen2;
    @FXML
    private ImageView eQ2Imagen3;
    @FXML
    private ImageView eQ2Imagen4;
    @FXML
    private ImageView eQ2Imagen5;
    @FXML
    private ImageView eQ2Imagen6;
    @FXML
    private Button eQ1Btn1;
    @FXML
    private Button eQ1Btn2;
    @FXML
    private Button eQ1Btn3;
    @FXML
    private Button btnIrAMenu;
    @FXML
    private Button eQ1Btn4;
    @FXML
    private Button eQ1Btn5;
    @FXML
    private Button eQ1Btn6;
    @FXML
    private Button eQ2Btn1;
    @FXML
    private Button eQ2Btn2;
    @FXML
    private Button eQ2Btn3;
    @FXML
    private Button eQ2Btn4;
    @FXML
    private Button eQ2Btn5;
    @FXML
    private Button eQ2Btn6;
    @FXML
    private Button btnCriar;
    @FXML
    private Text txtCriaSaber;
    @FXML
    private Text txtFertilidad1Eq1;
    @FXML
    private Text txtFertilidad2Eq1;
    @FXML
    private Text txtFertilidad3Eq1;
    @FXML
    private Text txtFertilidad4Eq1;
    @FXML
    private Text txtFertilidad5Eq1;
    @FXML
    private Text txtFertilidad6Eq1;
    @FXML
    private Text txtNumFertilidad1Eq1;
    @FXML
    private Text txtNumFertilidad2Eq1;
    @FXML
    private Text txtNumFertilidad3Eq1;
    @FXML
    private Text txtNumFertilidad4Eq1;
    @FXML
    private Text txtNumFertilidad5Eq1;
    @FXML
    private Text txtNumFertilidad6Eq1;
    @FXML
    private Text txtFertilidad1Eq2;
    @FXML
    private Text txtFertilidad2Eq2;
    @FXML
    private Text txtFertilidad3Eq2;
    @FXML
    private Text txtFertilidad4Eq2;
    @FXML
    private Text txtFertilidad5Eq2;
    @FXML
    private Text txtFertilidad6Eq2;
    @FXML
    private Text txtNumFertilidad1Eq2;
    @FXML
    private Text txtNumFertilidad2Eq2;
    @FXML
    private Text txtNumFertilidad3Eq2;
    @FXML
    private Text txtNumFertilidad4Eq2;
    @FXML
    private Text txtNumFertilidad5Eq2;
    @FXML
    private Text txtNumFertilidad6Eq2;

    public void initialize() {
        txtCriaSaber.setVisible(false);
        btnCriar.setVisible(false);
        btnCriar.setDisable(true);

        //equipo 1 -------------------------------------------------------------------------------
        if (InicioController.entrenador.getEquipoPK()[0] == null) {
            txtFertilidad1Eq1.setVisible(false);
            txtNumFertilidad1Eq1.setVisible(false);
            eQ1Btn1.setVisible(false);
            eQ1Btn1.setDisable(true);
            eQ1Imagen1.setVisible(false);
        } else {
            txtFertilidad1Eq1.setVisible(true);
            txtNumFertilidad1Eq1.setVisible(true);
            txtNumFertilidad1Eq1.setText("" + Entrenador.getEquipoPK()[0].getFertilidad());
            eQ1Btn1.setVisible(true);
            eQ1Btn1.setDisable(false);
            eQ1Imagen1.setVisible(true);
            eQ1Imagen1.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK()[0].getId()));


        }
        if (InicioController.entrenador.getEquipoPK()[1] == null) {
            txtFertilidad2Eq1.setVisible(false);
            txtNumFertilidad2Eq1.setVisible(false);
            eQ1Btn2.setVisible(false);
            eQ1Btn2.setDisable(true);
            eQ1Imagen2.setVisible(false);
        } else {
            txtFertilidad2Eq1.setVisible(true);
            txtNumFertilidad2Eq1.setVisible(true);
            txtNumFertilidad2Eq1.setText("" + Entrenador.getEquipoPK()[1].getFertilidad());
            eQ1Btn2.setVisible(true);
            eQ1Btn2.setDisable(false);
            eQ1Imagen2.setVisible(true);
            eQ1Imagen2.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK()[1].getId()));

        }
        if (InicioController.entrenador.getEquipoPK()[2] == null) {
            txtFertilidad3Eq1.setVisible(false);
            txtNumFertilidad3Eq1.setVisible(false);
            eQ1Btn3.setVisible(false);
            eQ1Btn3.setDisable(true);
            eQ1Imagen3.setVisible(false);
        } else {
            txtFertilidad3Eq1.setVisible(true);
            txtNumFertilidad3Eq1.setVisible(true);
            txtNumFertilidad3Eq1.setText("" + Entrenador.getEquipoPK()[2].getFertilidad());
            eQ1Btn3.setVisible(true);
            eQ1Btn3.setDisable(false);
            eQ1Imagen3.setVisible(true);
            eQ1Imagen3.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK()[2].getId()));

        }
        if (InicioController.entrenador.getEquipoPK()[3] == null) {
            txtFertilidad4Eq1.setVisible(false);
            txtNumFertilidad4Eq1.setVisible(false);
            eQ1Btn4.setVisible(false);
            eQ1Btn4.setDisable(true);
            eQ1Imagen4.setVisible(false);
        } else {
            txtFertilidad4Eq1.setVisible(true);
            txtNumFertilidad4Eq1.setVisible(true);
            txtNumFertilidad4Eq1.setText("" + InicioController.entrenador.getEquipoPK()[3].getFertilidad());
            eQ1Btn4.setVisible(true);
            eQ1Btn4.setDisable(false);
            eQ1Imagen4.setVisible(true);
            eQ1Imagen4.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK()[3].getId()));

        }
        if (InicioController.entrenador.getEquipoPK()[4] == null) {
            txtFertilidad5Eq1.setVisible(false);
            txtNumFertilidad5Eq1.setVisible(false);
            eQ1Btn5.setVisible(false);
            eQ1Btn5.setDisable(true);
            eQ1Imagen5.setVisible(false);
        } else {
            txtFertilidad5Eq1.setVisible(true);
            txtNumFertilidad5Eq1.setVisible(true);
            txtNumFertilidad5Eq1.setText("" + InicioController.entrenador.getEquipoPK()[4].getFertilidad());
            eQ1Btn5.setVisible(true);
            eQ1Btn5.setDisable(false);
            eQ1Imagen5.setVisible(true);
            eQ1Imagen5.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK()[4].getId()));

        }
        if (InicioController.entrenador.getEquipoPK()[5] == null) {
            txtFertilidad6Eq1.setVisible(false);
            txtNumFertilidad6Eq1.setVisible(false);
            eQ1Btn6.setVisible(false);
            eQ1Btn6.setDisable(true);
            eQ1Imagen6.setVisible(false);
        } else {
            txtFertilidad6Eq1.setVisible(true);
            txtNumFertilidad6Eq1.setVisible(true);
            txtNumFertilidad6Eq1.setText("" + InicioController.entrenador.getEquipoPK()[5].getFertilidad());
            eQ1Btn6.setVisible(true);
            eQ1Btn6.setDisable(false);
            eQ1Imagen6.setVisible(true);
            eQ1Imagen6.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK()[5].getId()));

        }

        //equipo 1 ----------------------------------------------------------------------------------

        if (InicioController.entrenador.getEquipoPK2()[0] == null) {
            txtFertilidad1Eq2.setVisible(false);
            txtNumFertilidad1Eq2.setVisible(false);
            eQ2Btn1.setVisible(false);
            eQ2Btn1.setDisable(true);
            eQ2Imagen1.setVisible(false);
        } else {
            txtFertilidad1Eq2.setVisible(true);
            txtNumFertilidad1Eq2.setVisible(true);
            txtNumFertilidad1Eq2.setText("" + InicioController.entrenador.getEquipoPK2()[0].getFertilidad());
            eQ2Btn1.setVisible(true);
            eQ2Btn1.setDisable(false);
            eQ2Imagen1.setVisible(true);
            eQ2Imagen1.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK2()[0].getId()));


        }
        if (InicioController.entrenador.getEquipoPK2()[1] == null) {
            txtFertilidad2Eq2.setVisible(false);
            txtNumFertilidad2Eq2.setVisible(false);
            eQ2Btn2.setVisible(false);
            eQ2Btn2.setDisable(true);
            eQ2Imagen2.setVisible(false);

        } else {
            txtFertilidad2Eq2.setVisible(true);
            txtNumFertilidad2Eq2.setVisible(true);
            txtNumFertilidad2Eq2.setText("" + InicioController.entrenador.getEquipoPK2()[1].getFertilidad());
            eQ2Btn2.setVisible(true);
            eQ2Btn2.setDisable(false);
            eQ2Imagen2.setVisible(true);
            eQ2Imagen2.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK2()[1].getId()));


        }
        if (InicioController.entrenador.getEquipoPK2()[2] == null) {
            txtFertilidad3Eq2.setVisible(false);
            txtNumFertilidad3Eq2.setVisible(false);
            eQ2Btn3.setVisible(false);
            eQ2Btn3.setDisable(true);
            eQ2Imagen3.setVisible(false);

        } else {
            txtFertilidad3Eq2.setVisible(true);
            txtNumFertilidad3Eq2.setVisible(true);
            txtNumFertilidad3Eq2.setText("" + InicioController.entrenador.getEquipoPK2()[2].getFertilidad());
            eQ2Btn3.setVisible(true);
            eQ2Btn3.setDisable(false);
            eQ2Imagen3.setVisible(true);
            eQ2Imagen3.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK2()[2].getId()));

        }
        if (InicioController.entrenador.getEquipoPK2()[3] == null) {
            txtFertilidad4Eq2.setVisible(false);
            txtNumFertilidad4Eq2.setVisible(false);
            eQ2Btn4.setVisible(false);
            eQ2Btn4.setDisable(true);
            eQ2Imagen4.setVisible(false);
        } else {
            txtFertilidad4Eq2.setVisible(true);
            txtNumFertilidad4Eq2.setVisible(true);
            txtNumFertilidad4Eq2.setText("" + InicioController.entrenador.getEquipoPK2()[3].getFertilidad());
            eQ2Btn4.setVisible(true);
            eQ2Btn4.setDisable(false);
            eQ2Imagen4.setVisible(true);
            eQ2Imagen4.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK2()[3].getId()));


        }
        if (InicioController.entrenador.getEquipoPK2()[4] == null) {
            txtFertilidad5Eq2.setVisible(false);
            txtNumFertilidad5Eq2.setVisible(false);
            eQ2Btn5.setVisible(false);
            eQ2Btn5.setDisable(true);
            eQ2Imagen5.setVisible(false);

        } else {
            txtFertilidad5Eq2.setVisible(true);
            txtNumFertilidad5Eq2.setVisible(true);
            txtNumFertilidad5Eq2.setText("" + InicioController.entrenador.getEquipoPK2()[4].getFertilidad());
            eQ2Btn5.setVisible(true);
            eQ2Btn5.setDisable(false);
            eQ2Imagen5.setVisible(true);
            eQ2Imagen5.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK2()[4].getId()));


        }
        if (InicioController.entrenador.getEquipoPK2()[5] == null) {
            txtFertilidad6Eq2.setVisible(false);
            txtNumFertilidad6Eq2.setVisible(false);
            eQ2Btn6.setVisible(false);
            eQ2Btn6.setDisable(true);
            eQ2Imagen6.setVisible(false);

        } else {
            txtFertilidad6Eq2.setVisible(true);
            txtNumFertilidad6Eq2.setVisible(true);
            txtNumFertilidad6Eq2.setText("" + InicioController.entrenador.getEquipoPK2()[5].getFertilidad());
            eQ2Btn6.setVisible(true);
            eQ2Btn6.setDisable(false);
            eQ2Imagen6.setVisible(true);
            eQ2Imagen6.setImage(InicioController.idPokemonFilePathImagen.get(Entrenador.getEquipoPK2()[5].getId()));
        }
    }

    public void equipo1Eleccion1() {
        txtCriaSaber.setVisible(false);
        eleccion1.setImage(eQ1Imagen1.getImage());
        imagen1elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        primeroElegido = InicioController.entrenador.getEquipoPK()[0];
    }

    public void equipo1Eleccion2() {
        txtCriaSaber.setVisible(false);
        eleccion1.setImage(eQ1Imagen2.getImage());
        imagen1elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        primeroElegido = InicioController.entrenador.getEquipoPK()[1];
    }

    public void equipo1Eleccion3() {
        txtCriaSaber.setVisible(false);
        eleccion1.setImage(eQ1Imagen3.getImage());
        imagen1elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        primeroElegido = InicioController.entrenador.getEquipoPK()[2];
    }

    public void equipo1Eleccion4() {
        txtCriaSaber.setVisible(false);
        eleccion1.setImage(eQ1Imagen4.getImage());
        imagen1elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        primeroElegido = InicioController.entrenador.getEquipoPK()[3];
    }

    public void equipo1Eleccion5() {
        txtCriaSaber.setVisible(false);
        eleccion1.setImage(eQ1Imagen5.getImage());
        imagen1elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        primeroElegido = InicioController.entrenador.getEquipoPK()[4];
    }

    public void equipo1Eleccion6() {
        txtCriaSaber.setVisible(false);
        eleccion1.setImage(eQ1Imagen6.getImage());
        imagen1elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        primeroElegido = InicioController.entrenador.getEquipoPK()[5];
    }

    public void equipo2Eleccion1() {
        txtCriaSaber.setVisible(false);
        eleccion2.setImage(eQ2Imagen1.getImage());
        imagen2elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        segundoElegido = InicioController.entrenador.getEquipoPK2()[0];
    }

    public void equipo2Eleccion2() {
        txtCriaSaber.setVisible(false);
        eleccion2.setImage(eQ2Imagen2.getImage());
        imagen2elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        segundoElegido = InicioController.entrenador.getEquipoPK2()[1];
    }

    public void equipo2Eleccion3() {
        txtCriaSaber.setVisible(false);
        eleccion2.setImage(eQ2Imagen3.getImage());
        imagen2elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        segundoElegido = InicioController.entrenador.getEquipoPK2()[2];
    }

    public void equipo2Eleccion4() {
        txtCriaSaber.setVisible(false);
        eleccion2.setImage(eQ2Imagen4.getImage());
        imagen2elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        segundoElegido = InicioController.entrenador.getEquipoPK2()[3];
    }

    public void equipo2Eleccion5() {
        txtCriaSaber.setVisible(false);
        eleccion2.setImage(eQ2Imagen5.getImage());
        imagen2elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        segundoElegido = InicioController.entrenador.getEquipoPK2()[4];
    }

    public void equipo2Eleccion6() {
        txtCriaSaber.setVisible(false);
        eleccion2.setImage(eQ2Imagen6.getImage());
        imagen2elegida = true;
        if (imagen1elegida && imagen2elegida) {
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
        segundoElegido = InicioController.entrenador.getEquipoPK2()[5];
    }

    public void hacerCria() {
        if (InicioController.entrenador.criar(primeroElegido, segundoElegido)) {
            txtCriaSaber.setVisible(true);
            txtCriaSaber.setText("Cria Exitosa!");
            btnCriar.setVisible(false);
            btnCriar.setDisable(true);
            eleccion1.setImage(null);
            eleccion2.setImage(null);
        }

            else {
                txtCriaSaber.setVisible(true);
            txtCriaSaber.setText("Cria Fallida!");
            btnCriar.setVisible(false);
            btnCriar.setDisable(true);
            imagen1elegida = false;
            imagen2elegida = false;
            eleccion1.setImage(null);
            eleccion2.setImage(null);
        }
    }

    public void irAMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

