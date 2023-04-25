package org.Proyecto_Pokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CombateController implements Initializable {


    //TODO: Parchear fallo de que al cambiar de Pokemon se vuelve a ejecutar Initialize, deshaciendo todos los cambios en el combate, incluyendo el propio cambio de Pokemon
    private static boolean seHainiciado=false;

    @FXML
    private Button cancel;

    @FXML
    private Button changePokemon;
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



    private static Pokemon pokemon;
    private static Pokemon pokemonRival;
    private static EntrenadorAleatorio entrenadorRival;
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

    public void changePokemonIsPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(SceneController.class.getResource("/fxml/CambiarPokemon.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*public void changePokemonIsPressed(ActionEvent event) throws IOException {


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/CambiarPokemon.fxml")));
            Scene scene = new Scene(root, 600, 400);
            stage.setTitle("Cambiar Pokemon");
            stage.setScene(scene);
            stage.show();
        }
*/
    public void usarMov0(ActionEvent event) {
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[0], entrenadorRival.getEquipoPK()[0]);
        pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));


    }

    public void usarMov1(ActionEvent event) {
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[1], entrenadorRival.getEquipoPK()[0]);
        pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));


    }

    public void usarMov2(ActionEvent event) {
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[2], entrenadorRival.getEquipoPK()[0]);
        pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));

    }

    public void usarMov3(ActionEvent event) {
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[3], entrenadorRival.getEquipoPK()[0]);
        pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (!seHainiciado) {
            seHainiciado=true;

            Ataque placaje = new Ataque("placaje", 40, 100, Tipo.NORMAL, "Fisico");
            Mejora danzaEspada = new Mejora("Danza espada", 2.0f, 2, "ataque", Tipo.ACERO);
            Pokemon pokemonEnemigo1 = new Pokemon("Pokachu", 100, 120, 200, 250, 230, 20, 200, Tipo.ELECTRICO, placaje, null, Sexo.MACHO);
            Pokemon pokemonEnemigo2 = new Pokemon("Carrero Blanco", 100, 223, 100, 400, 20, 200, 200, placaje, Tipo.VOLADOR, Tipo.ACERO, null, Sexo.MACHO);

            pokemon = new Pokemon("Genghis Khan", 170, 290, 290, 200, 299, 222, 222, Tipo.NORMAL, placaje, null, Sexo.MACHO);
            Entrenador.getEquipoPK()[0] = pokemon;
            Entrenador.getEquipoPK()[1] = pokemonEnemigo1;
            Entrenador.getEquipoPK()[0].getMovimientosActivos()[1] = danzaEspada;
            entrenadorRival = new EntrenadorAleatorio(pokemonEnemigo2, pokemonEnemigo1);}
            mov0.setText(Entrenador.getEquipoPK()[0].getMovimientosActivos()[0].getNombre() + "   " + Entrenador.getEquipoPK()[0].getMovimientosActivos()[0].getCosteEstamina() + " ST");

            if (Entrenador.getEquipoPK()[0].getMovimientosActivos()[1] == null) {
                mov1.setDisable(true);
                mov1.setVisible(false);
            } else
                mov1.setText(Entrenador.getEquipoPK()[0].getMovimientosActivos()[1].getNombre() + "   " + Entrenador.getEquipoPK()[0].getMovimientosActivos()[1].getCosteEstamina() + " ST");

            if (Entrenador.getEquipoPK()[0].getMovimientosActivos()[2] == null) {
                mov2.setDisable(true);
                mov2.setVisible(false);
            } else
                mov2.setText(Entrenador.getEquipoPK()[0].getMovimientosActivos()[2].getNombre() + "   " + Entrenador.getEquipoPK()[0].getMovimientosActivos()[2].getCosteEstamina() + " ST");

            if (Entrenador.getEquipoPK()[0].getMovimientosActivos()[3] == null) {
                mov3.setDisable(true);
                mov3.setVisible(false);
            } else mov3.setText(Entrenador.getEquipoPK()[0].getMovimientosActivos()[3].getNombre() + "   " + Entrenador.getEquipoPK()[0].getMovimientosActivos()[0].getCosteEstamina() + " ST");
            pkmnRivalNombre.setText(entrenadorRival.getEquipoPK()[0].getNombre());
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnMote.setText(Entrenador.getEquipoPK()[0].getMote());
            pkmnVida.setText(Integer.toString(Entrenador.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            pkmonRivalStamina.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getEstaminaActual()));
        }




    }

