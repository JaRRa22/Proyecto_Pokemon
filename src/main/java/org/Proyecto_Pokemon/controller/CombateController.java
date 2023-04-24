package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import org.Proyecto_Pokemon.model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CombateController implements Initializable {

    //TODO: Añadir cambio de Pokemon

    @FXML
    private Text pkmonRivalStamina;
    @FXML
    private Text pkmnStamina;
    @FXML
    private Text pkmnRivalNombre;
    @FXML
    private Text pkmnRivalVida=new Text();
    @FXML
    private Text pkmnMote;
    @FXML
    private Text pkmnVida;


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

    public void usarMov0(ActionEvent event) {
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[0], entrenadorRival.getEquipoPK()[0]);
        pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(entrenador.getEquipoPK()[0].getEstaminaActual()));


    }

    public void usarMov1(ActionEvent event) {
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[1], entrenadorRival.getEquipoPK()[0]);
        pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(entrenador.getEquipoPK()[0].getEstaminaActual()));


    }

    public void usarMov2(ActionEvent event) {
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[2], entrenadorRival.getEquipoPK()[0]);
        pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(entrenador.getEquipoPK()[0].getEstaminaActual()));

    }

    public void usarMov3(ActionEvent event) {
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[3], entrenadorRival.getEquipoPK()[0]);
        pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(entrenador.getEquipoPK()[0].getEstaminaActual()));
    }

    public void hacersout() {
        System.out.println(entrenador.getEquipoPK()[0] + "\n" + entrenadorRival.getEquipoPK()[0]);

    }

    public Pokemon crtPokemonIsPressed() {
        Pokemon pikachu = new Pokemon();
        System.out.println("Pika Pika");
        return pikachu;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Ataque placaje = new Ataque("placaje", 40, 100, Tipo.NORMAL, "Fisico");
        Mejora danzaEspada=new Mejora("Danza espada",2.0f,2,"ataque",Tipo.ACERO);
        Pokemon pokemonEnemigo1 = new Pokemon("Pokachu", 100, 120, 200, 250, 230, 20, 200, Tipo.ELECTRICO, placaje, null, Sexo.MACHO);
        Pokemon pokemonEnemigo2 = new Pokemon("Carrero Blanco", 100, 223, 100, 400, 20, 200, 200, placaje, Tipo.VOLADOR, Tipo.ACERO, null, Sexo.MACHO);
        entrenador = new Entrenador("Pepe");
        pokemon = new Pokemon("Genghis Khan", 170, 290, 290, 200, 299, 222, 222, Tipo.NORMAL, placaje, null, Sexo.MACHO);
        entrenador.getEquipoPK()[0] = pokemon;
        entrenador.getEquipoPK()[0].getMovimientosActivos()[1]=danzaEspada;
        entrenadorRival = new EntrenadorAleatorio(pokemonEnemigo2, pokemonEnemigo1);
        mov0.setText(entrenador.getEquipoPK()[0].getMovimientosActivos()[0].getNombre() + "   " + entrenador.getEquipoPK()[0].getMovimientosActivos()[0].getCosteEstamina() + " ST");

        if (entrenador.getEquipoPK()[0].getMovimientosActivos()[1] == null) {
            mov1.setDisable(true);
            mov1.setVisible(false);
        } else mov1.setText(entrenador.getEquipoPK()[0].getMovimientosActivos()[1].getNombre());

        if (entrenador.getEquipoPK()[0].getMovimientosActivos()[2] == null) {
            mov2.setDisable(true);
            mov2.setVisible(false);
        } else mov2.setText(entrenador.getEquipoPK()[0].getMovimientosActivos()[2].getNombre());

        if (entrenador.getEquipoPK()[0].getMovimientosActivos()[3] == null) {
            mov3.setDisable(true);
            mov3.setVisible(false);
        } else mov3.setText(entrenador.getEquipoPK()[0].getMovimientosActivos()[3].getNombre());
        pkmnRivalNombre.setText(entrenadorRival.getEquipoPK()[0].getNombre());
        pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
        pkmnMote.setText(entrenador.getEquipoPK()[0].getMote());
        pkmnVida.setText(Integer.toString(entrenador.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(entrenador.getEquipoPK()[0].getEstaminaActual()));
        pkmonRivalStamina.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getEstaminaActual()));


    }
}
