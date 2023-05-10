package org.Proyecto_Pokemon.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.*;

public class PokemonApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start (Stage stage){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Captura.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Captura pokemon");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}