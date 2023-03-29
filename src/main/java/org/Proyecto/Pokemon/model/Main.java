package org.Proyecto.Pokemon.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main  extends Application {



    @Override



        public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Pokemon.fxml")));
            Scene scene = new Scene(root, 600, 400);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }

