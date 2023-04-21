package org.Proyecto_Pokemon.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.Proyecto_Pokemon.model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class PokemonController implements Initializable {

    //TODO: Cambiar en un futuro para coger el entrenador de un Singleton (?)
    private Entrenador entrenador;
    private Pokemon pokemon;
    private Pokemon pokemonRival;
    private EntrenadorAleatorio entrenadorRival;
    @FXML
    private Button btnCrtPokemon;
    @FXML
    private Label lblNombrePokemon;

    @FXML
    private Button mov0;
    @FXML
    private Button mov1;
    @FXML
    private Button mov2;
    @FXML
    private Button mov3;
    @FXML
    private Button soutDelCombate;

    public void usarMov0(){
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[0],entrenadorRival.getEquipoPK()[0]);


    }

    public void usarMov1(){
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[1],entrenadorRival.getEquipoPK()[0]);


    }
    public void usarMov2(){
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[2],entrenadorRival.getEquipoPK()[0]);


    }
    public void usarMov3(){
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[3],entrenadorRival.getEquipoPK()[0]);


    }

    public void hacersout(){
        System.out.println(entrenador.getEquipoPK()[0] + "\n" + entrenadorRival.getEquipoPK()[0]);

    }

    public Pokemon crtPokemonIsPressed(){
        Pokemon pikachu = new Pokemon();
        System.out.println("Pika Pika");
        return pikachu;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ataque placaje = new Ataque("placaje", 100, 85, Tipo.NORMAL, "Fisico");
        Pokemon pokemonEnemigo1=new Pokemon("Pokachu",100,120,200,250,230,20,200, Tipo.ELECTRICO,placaje,null,Sexo.MACHO);
        Pokemon pokemonEnemigo2=new Pokemon("Carrero Blanco",100,223,100,400,20,200,200,placaje,Tipo.VOLADOR,Tipo.ACERO,null,Sexo.MACHO);
        entrenador = new Entrenador("Pepe");
        pokemon=new Pokemon("Genghis Khan",170,290,290,200,299,222,222,Tipo.NORMAL,placaje,null,Sexo.MACHO);
        entrenador.getEquipoPK()[0]=pokemon;
        entrenadorRival =new EntrenadorAleatorio(pokemonEnemigo2,pokemonEnemigo1);



    }
}
