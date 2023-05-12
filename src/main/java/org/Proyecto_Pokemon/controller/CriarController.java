package org.Proyecto_Pokemon.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.Proyecto_Pokemon.model.Pokemon;

public class CriarController {

        private boolean imagen1elegida = false;
        private boolean imagen2elegida = false;
        public static Pokemon pokemonCriado = new Pokemon();
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


    public void initialize() {
    btnCriar.setVisible(false);
    btnCriar.setDisable(true);
    }
    public void equipo1Eleccion1(){
        eleccion1.setImage(eQ1Imagen1.getImage());
        imagen1elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }
    public void equipo1Eleccion2(){
        eleccion1.setImage(eQ1Imagen2.getImage());
        imagen1elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }
    public void equipo1Eleccion3(){
        eleccion1.setImage(eQ1Imagen3.getImage());
        imagen1elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }
    public void equipo1Eleccion4(){
        eleccion1.setImage(eQ1Imagen4.getImage());
        imagen1elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }
    public void equipo1Eleccion5(){
        eleccion1.setImage(eQ1Imagen5.getImage());
        imagen1elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }
    public void equipo1Eleccion6(){
        eleccion1.setImage(eQ1Imagen6.getImage());
        imagen1elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }

    public void equipo2Eleccion1(){
        eleccion2.setImage(eQ2Imagen1.getImage());
        imagen2elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }

    public void equipo2Eleccion2(){
        eleccion2.setImage(eQ2Imagen2.getImage());
        imagen2elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }

    public void equipo2Eleccion3(){
        eleccion2.setImage(eQ2Imagen3.getImage());
        imagen2elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }

    public void equipo2Eleccion4(){
        eleccion2.setImage(eQ2Imagen4.getImage());
        imagen2elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }

    public void equipo2Eleccion5(){
        eleccion2.setImage(eQ2Imagen5.getImage());
        imagen2elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }

    public void equipo2Eleccion6(){
        eleccion2.setImage(eQ2Imagen6.getImage());
        imagen2elegida = true;
        if(imagen1elegida && imagen2elegida){
            btnCriar.setVisible(true);
            btnCriar.setDisable(false);
        }
    }






















}

