package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;
import org.Proyecto_Pokemon.model.Status;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SceneController implements Initializable {
    private Pokemon temporal;
    @FXML
    private Button cancel;

    @FXML
    public static Button pok1;
    @FXML
    public static Button pok2;
    @FXML
    public static Button pok3;
    @FXML
    public static Button pok4;
    @FXML
    public static Button pok5;
    @FXML
    public static Button pok6;



    private static Stage stage;
    private  static Scene scene;
    private static Parent parent;






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Entrenador.getEquipoPK()[0]==null || Entrenador.getEquipoPK()[0].getStatus().equals(Status.DEBILITADO)  ){
            pok1.setVisible(false);
            pok1.setDisable(true);
        }else pok1.setText(Entrenador.getEquipoPK()[0].getMote());
        if (Entrenador.getEquipoPK()[1]==null  ||        Entrenador.getEquipoPK()[1].getStatus().equals(Status.DEBILITADO)  ){
            pok2.setVisible(false);
            pok2.setDisable(true);

        }else pok2.setText(Entrenador.getEquipoPK()[1].getMote());
        if ( Entrenador.getEquipoPK()[2]==null || Entrenador.getEquipoPK()[2].getStatus().equals(Status.DEBILITADO) ){
            pok3.setVisible(false);
            pok3.setDisable(true);
        }else pok3.setText(Entrenador.getEquipoPK()[2].getMote());
        if ( Entrenador.getEquipoPK()[3]==null || Entrenador.getEquipoPK()[3].getStatus().equals(Status.DEBILITADO) ){
            pok4.setVisible(false);
            pok4.setDisable(true);
        }else pok4.setText(Entrenador.getEquipoPK()[3].getMote());
        if (Entrenador.getEquipoPK()[4]==null || Entrenador.getEquipoPK()[4].getStatus().equals(Status.DEBILITADO)  ){
            pok5.setVisible(false);
            pok5.setDisable(true);
        }else pok5.setText(Entrenador.getEquipoPK()[4].getMote());
        if (Entrenador.getEquipoPK()[5]==null  || Entrenador.getEquipoPK()[5].getStatus().equals(Status.DEBILITADO)  ){
            pok6.setVisible(false);
            pok6.setDisable(true);
        }else pok6.setText(Entrenador.getEquipoPK()[5].getMote());


    }



    public void switchToPoke4(ActionEvent event) {
    }



    public void switchToPoke5(ActionEvent event) {
    }

    public void switchToPoke6(ActionEvent event) {
    }


    public  void displayMessage(ActionEvent event){
        Pokemon temporal =Entrenador.getEquipoPK()[0];

    }
    public  void switchToPoke2(ActionEvent event) throws IOException {
        temporal =Entrenador.getEquipoPK()[0];
        Entrenador.getEquipoPK()[0]=Entrenador.getEquipoPK()[1];
        Entrenador.getEquipoPK()[1]=temporal;
        Entrenador.setHaActuado(true);

        goToCombat(event);

    }

    public static void changeToCambiarPokemon(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(SceneController.class.getResource("/fxml/CambiarPokemon.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void goToCombat(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(SceneController.class.getResource("/fxml/Combate.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPoke3(ActionEvent event) {
    }
}



