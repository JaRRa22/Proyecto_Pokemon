package org.Proyecto_Pokemon.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class PokemonApplication extends Application {

    @Override
    public void start (Stage stage) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/inicio.fxml")));
            Scene scene = new Scene(root, 627, 391);
            stage.setTitle("Captura pokemon");
            stage.setScene(scene);
            stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}