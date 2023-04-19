package org.Proyecto_Pokemon.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

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



        System.out.println("Bienvenido al mundo pokemon!");
        Movimiento []movimientosPkmn1=new Movimiento[4];
        Ataque placaje= new Ataque("placaje",60,100,Tipo.NORMAL,"fisico");
        movimientosPkmn1[0]=placaje;
/*
         Pokemon jigglypugg= new Pokemon(50,80,89,98,87,876,"Jigglipuff",Tipo.ACERO);

        Pokemon pokachu= new Pokemon(30,40,20,40,23,421,"Pepkachu",Tipo.TIERRA );

        pokachu.setMovimientosActivos(movimientosPkmn1);



        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());
        Mejora danzaEspada=new Mejora("danza espada",2.0f,2,"ataque",Tipo.NORMAL);
        movimientosPkmn1[1]=danzaEspada;
        pokachu.setNivel(9);
        pokachu.usarMovimiento((Ataque) movimientosPkmn1[0],jigglypugg);
        LinkedList<Movimiento> pokachuMovimientosAprendibles=new LinkedList<Movimiento>();
        pokachuMovimientosAprendibles.add(new Ataque("Impactrueno",70,95,Tipo.ELECTRICO,"Especial"));
        pokachuMovimientosAprendibles.add(danzaEspada);
        pokachuMovimientosAprendibles.add(new MovEstado("Latigo","defensa",1.25f,2,Tipo.NORMAL));
        pokachu.setMovimientosAprendibles(pokachuMovimientosAprendibles);

        if (pokachu.sePuedeAprenderMovimiento()){
            pokachu.reemplazarMovimiento(0);
        }
        pokachu.usarMovimiento((MovEstado) pokachu.getMovimientosActivos()[0],jigglypugg);


        System.out.println(pokachu.toString());
        System.out.println(jigglypugg.toString());*/











    }
}

