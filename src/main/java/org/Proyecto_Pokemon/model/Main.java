package org.Proyecto.Pokemon.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Main extends Application {

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

        Date d= new Date();

        System.out.println("Bienvenido al mundo pokemon!");
        Movimiento []movimientosPkmn1=new Movimiento[4];
        Ataque placaje= new Ataque("placaje",60,100,Tipo.NORMAL,"fisico");
        movimientosPkmn1[0]=placaje;

         Pokemon jigglypugg= new Pokemon(50,80,89,98,87,876,"Jigglipuff",Tipo.ROCA );

        Pokemon pokachu= new Pokemon(30,40,20,40,23,421,"Pepkachu",Tipo.TIERRA );
        pokachu.setMovimientosActivos(movimientosPkmn1);
        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());

        pokachu.atacar((Ataque) movimientosPkmn1[0],jigglypugg);
        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());










    }
}

