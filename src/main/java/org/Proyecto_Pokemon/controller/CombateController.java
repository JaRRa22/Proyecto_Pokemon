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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Objects;
import java.util.ResourceBundle;

public class CombateController implements Initializable {
    private static Pokemon pokemon;
    private static Pokemon pokemonRival;

    
    @FXML
    public Text winText;
    @FXML
    private Button descansar;
    @FXML
    private Text pkmnStatusLabel;

    @FXML
    private Text pkmnRivalStatusLabel;
    public EntrenadorAleatorio getEntrenadorRival() {
        return entrenadorRival;
    }

    public void setEntrenadorRival(EntrenadorAleatorio entrenadorRival) {
        this.entrenadorRival = entrenadorRival;
    }

    public static boolean isSeHaActuado() {
        return seHaActuado;
    }

    public static void setSeHaActuado(boolean seHaActuado) {
        CombateController.seHaActuado = seHaActuado;
    }

    private  static EntrenadorAleatorio entrenadorRival = new EntrenadorAleatorio();


    //TODO:Implementar cambio de turnos, preguntar a Paco
    private static boolean seHainiciado=false;
     static boolean seHaActuado=false;
     private Combate combate= new Combate(entrenadorRival);

    @FXML
    public static Text textoPokemon=new Text();

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
    private  Text pkmnVida=new Text();





    @FXML
    private Button btnCrtPokemon;
    @FXML
    private Label lblNombrePokemon;

    @FXML
    private Button mov0=new Button();
    @FXML
    private Button mov1=new Button();
    @FXML
    private Button mov2=new Button();
    @FXML
    private Button mov3=new Button();

    public void changePokemonIsPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(SceneController.class.getResource("/fxml/CambiarPokemon.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void mostrarGanador(){
        winText.setVisible(true);
        winText.setText(combate.getGanador() + " ha ganado el combate, y ha ganado " + entrenadorRival.getDinero() );
        Entrenador.setPokedollars(Entrenador.getPokedollars() + entrenadorRival.getDinero());
    }
    /*public void changePokemonIsPressed(ActionEvent event) throws IOException {


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/CambiarPokemon.fxml")));
            Scene scene = new Scene(root, 600, 400);
            stage.setTitle("Cambiar Pokemon");
            stage.setScene(scene);
            stage.show();
        }*/

    public Text getPkmonRivalStamina() {
        return pkmonRivalStamina;
    }

    public Text getPkmnRivalVida() {
        return pkmnRivalVida;
    }

    public void mostrarAccionPokemon(Pokemon a, Movimiento mov){
        textoPokemon.setVisible(true);
        textoPokemon.setText(a.getMote() + " ha usado " + mov );



    }

    public void actualizarEstados(){
        if (Entrenador.getEquipoPK()[0].getStatus()== Status.ENVENENADO){
            pkmnStatusLabel.setVisible(true);
            pkmnStatusLabel.setText("Envenenado");
        }
        else if (Entrenador.getEquipoPK()[0].getStatus()== Status.QUEMADO){
            pkmnStatusLabel.setVisible(true);
            pkmnStatusLabel.setText("Quemado");
        }
        else if (Entrenador.getEquipoPK()[0].getStatus()== Status.PARALIZADO){
            pkmnStatusLabel.setText("Parlalizado");
        }
    }

    public void usarMov0(ActionEvent event) throws IOException, InterruptedException {
        if (combate.calcularVelocidad(entrenadorRival)) {
            pkmnStatusLabel.setVisible(false);
            pkmnRivalStatusLabel.setVisible(false);

            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[0], entrenadorRival.getEquipoPK()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);

            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[0]);



            entrenadorRival.usarAtaque(Entrenador.getEquipoPK()[0]);
            pkmnVida.setText(Integer.toString(Entrenador.getEquipoPK()[0].getVitalidadActual()));
            pkmonRivalStamina.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getEstaminaActual()));
            comprobarSiSeHaDebilitado(event);







        }
        else {

            entrenadorRival.usarAtaque(Entrenador.getEquipoPK()[0]);
            pkmnVida.setText(Integer.toString(Entrenador.getEquipoPK()[0].getVitalidadActual()));
            pkmonRivalStamina.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getEstaminaActual()));
            comprobarSiSeHaDebilitado(event);


            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[0], entrenadorRival.getEquipoPK()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);
            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[0]);




        }

        actualizarEstados();
        combate.comprobarEstados();

    }

    public void usarMov1(ActionEvent event) throws IOException, InterruptedException {
        if (combate.calcularVelocidad(entrenadorRival)) {

            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[1].getMovimientosActivos()[0], entrenadorRival.getEquipoPK()[0]);
            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);



            entrenadorRival.usarAtaque(Entrenador.getEquipoPK()[0]);
            pkmnVida.setText(Integer.toString(Entrenador.getEquipoPK()[0].getVitalidadActual()));
            pkmonRivalStamina.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getEstaminaActual()));
            comprobarSiSeHaDebilitado(event);






        }
        else {
            entrenadorRival.usarAtaque(Entrenador.getEquipoPK()[0]);
            pkmnVida.setText(Integer.toString(Entrenador.getEquipoPK()[0].getVitalidadActual()));
            pkmonRivalStamina.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getEstaminaActual()));
            comprobarSiSeHaDebilitado(event);



            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[1], entrenadorRival.getEquipoPK()[0]);
            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[0]);

            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);




        }



        actualizarEstados();
        combate.comprobarEstados();
    }

    public void usarMov2(ActionEvent event) {

            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[2], entrenadorRival.getEquipoPK()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            seHaActuado=true;
            entrenadorRival.usarAtaque(Entrenador.getEquipoPK()[0]);

    }

    public void usarMov3(ActionEvent event) {

            pokemon.usarMovimiento(pokemon.getMovimientosActivos()[3], entrenadorRival.getEquipoPK()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            seHaActuado=true;
            entrenadorRival.usarAtaque(Entrenador.getEquipoPK()[0]);

    }

    public Text getPkmnRivalNombre() {
        return pkmnRivalNombre;
    }

    public  Text getPkmnVida() {
        return pkmnVida;
    }

    public void setPkmnVida(Text pkmnVida) {
        this.pkmnVida = pkmnVida;
    }

public void comprobarSiSeHaDebilitado(ActionEvent event) throws IOException {

    if (Entrenador.getEquipoPK()[0].getVitalidadActual()<=0){
        Entrenador.getEquipoPK()[0].setStatus(Status.DEBILITADO);
        changePokemonIsPressed(event);
        pkmnMote.setText(Entrenador.getEquipoPK()[0].getMote());
        pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getStamina()));
        pkmnVida.setText(Integer.toString(Entrenador.getEquipoPK()[0].getVitalidadActual()));
    }
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO sacar pokemon de BBDD
        if (!seHainiciado) {
            textoPokemon.setVisible(false);


            MovEstado envenenar= new MovEstado("envenenar",2,100,Tipo.VENENO,Status.ENVENENADO) ;

            seHaActuado=false;
            seHainiciado=true;
            Entrenador entrenador = new Entrenador("Pepe");
            Ataque placaje = new Ataque("placaje", 40, 100, Tipo.NORMAL, "Fisico");
            Mejora danzaEspada = new Mejora("Danza espada", 2.0f, 2, "ataque", Tipo.ACERO);
            Pokemon pokemonEnemigo1 = new Pokemon("Pokachu", 100, 170, 200, 250, 230, 200, 200, Tipo.ELECTRICO, placaje, null, Sexo.MACHO);
            Pokemon pokemon2 = new Pokemon("Tumadre", 100, 120, 200, 250, 230, 200, 200, Tipo.ELECTRICO, placaje, null, Sexo.MACHO);
            Pokemon pokemonEnemigo2 = new Pokemon("Skarmory", 100, 300, 100, 900, 20, 200, 200, placaje, Tipo.VOLADOR, Tipo.ACERO, null, Sexo.MACHO);

            pokemon = new Pokemon("Bidoof", 1700, 100000, 290, 200, 299, 222, 222, Tipo.NORMAL, placaje, null, Sexo.MACHO);
            Entrenador.getEquipoPK()[0] = pokemon;
            Entrenador.getEquipoPK()[1] = pokemon2;
            Entrenador.getEquipoPK()[0].getMovimientosActivos()[1] = danzaEspada;

            entrenadorRival.getEquipoPK()[0]=pokemonEnemigo1;
            entrenadorRival.getEquipoPK()[0].getMovimientosActivos()[1]=envenenar;
            entrenadorRival.getEquipoPK()[1]=pokemonEnemigo2;



        }
        pkmnStatusLabel.setVisible(false);
        pkmnRivalStatusLabel.setVisible(false);
        winText.setVisible(false);



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


    public void descansarOnAction(ActionEvent event) {
        Entrenador.getEquipoPK()[0].descansar();
        entrenadorRival.usarAtaque(Entrenador.getEquipoPK()[0]);
        pkmnVida.setText(Integer.toString(Entrenador.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
        pkmonRivalStamina.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getEstaminaActual()));
    }
}

