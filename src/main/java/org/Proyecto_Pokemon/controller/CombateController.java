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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.Logger;
import org.Proyecto_Pokemon.database.CRUD;
import org.Proyecto_Pokemon.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

import static org.Proyecto_Pokemon.controller.InicioController.idPokemonFilePathImagen;

public class CombateController implements Initializable {
    private static Pokemon pokemon;
    private static Pokemon pokemonRival;
    @FXML
    public Button hasGanadoButton;

    @FXML
    private ImageView imageViewPokemonEntrenador;
    @FXML
    private ImageView imageViewPokemonEnemigo;
    @FXML
    private Button retirarse;
    private Random rnd=new Random();
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
        entrenadorRival.setDinero(rnd.nextInt(400,5000));
    }





    private  static EntrenadorAleatorio entrenadorRival = new EntrenadorAleatorio();


    public static boolean seHainiciado=false;

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




    public void actualizarImagen(){
        //Actualizar imagenes
        int idImagenEntrenador=Entrenador.getEquipoPK()[0].getId();
        imageViewPokemonEntrenador.setImage(idPokemonFilePathImagen.get(idImagenEntrenador));
        int idImagenRival=entrenadorRival.getEquipoPK()[0].getId();
        imageViewPokemonEnemigo.setImage(idPokemonFilePathImagen.get(idImagenRival));
    }

    /**
     * Metodo que se ejcuta al pulsar retirarse
     * @param event
     * @throws IOException
     */
    public void giveUp(ActionEvent event) throws IOException {

        int dineroAPerder=rnd.nextInt(1,800);
        Entrenador.setPokedollars(Entrenador.getPokedollars()-dineroAPerder);
        Logger.write("Te has retirado y has perdido " +dineroAPerder);
        Logger.close();
        volver(event);
    }

    /**
     * metodo que se ejecuta al pulsar cabiar de pokemon
     * @param event
     * @throws IOException
     */
    public void changePokemonIsPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(CambiarPokemonController.class.getResource("/fxml/CambiarPokemon.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void mostrarGanador(ActionEvent event) throws IOException {

        Logger.write(combate.getGanador() + " ha ganado el combate, y ha ganado " + entrenadorRival.getDinero() );
        Entrenador.setPokedollars(Entrenador.getPokedollars() + entrenadorRival.getDinero());
        Logger.close();
        volver(event);
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

    public void mostrarAccionPokemon(Pokemon a, Movimiento mov, ActionEvent event) throws IOException {
        if (!Logger.isIsClosed()){
        Logger.write(a.getMote() + " ha usado " + mov  + "\n");}
        else {
            volver(event);
        }



    }

    /**
     * Metodo que detecta el estado del pokemon y actualiza el texto
     */
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


    public void volver(ActionEvent event) throws IOException {
        seHainiciado=false;
      Parent  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menu.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     *
     * @param event
     * @throws IOException
     * @throws InterruptedException
     * Metodo que ejecuta un turno haciendo que el pokemon del usuario use el movimiento de la posicion 0
     * dependiendo de la velocidad, ataca uno u otro
     * actualiza la vida y stamina de un pokemon y otro.
     * Además despues de cada ataque comprueba si el pokemon se ha debilitado. Si se debilita el tuyo te obliga a cambiar, si no el rival cambia automaticamente.
     */
    public void usarMov0(ActionEvent event) throws IOException, InterruptedException {
        if (combate.calcularVelocidad(entrenadorRival)) {
            pkmnStatusLabel.setVisible(false);
            pkmnRivalStatusLabel.setVisible(false);

            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[0], entrenadorRival.getEquipoPK()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);


            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[0],event);



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
            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[0],event);




        }

        actualizarEstados();
        actualizarImagen();
        combate.comprobarEstados();

    }

    public void usarMov1(ActionEvent event) throws IOException, InterruptedException {
        if (combate.calcularVelocidad(entrenadorRival)) {

            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[1], entrenadorRival.getEquipoPK()[0]);
            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[1],event);
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
            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[1],event);

            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);




        }



        actualizarEstados();
        combate.comprobarEstados();
    }

    public void usarMov2(ActionEvent event) throws IOException {

        if (combate.calcularVelocidad(entrenadorRival)) {
            pkmnStatusLabel.setVisible(false);
            pkmnRivalStatusLabel.setVisible(false);

            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[2], entrenadorRival.getEquipoPK()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);

            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[2],event);



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


            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[2], entrenadorRival.getEquipoPK()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);
            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[2].getMovimientosActivos()[0],event);




        }

        actualizarEstados();
        combate.comprobarEstados();

    }

    public void usarMov3(ActionEvent event) throws IOException {

        if (combate.calcularVelocidad(entrenadorRival)) {
            pkmnStatusLabel.setVisible(false);
            pkmnRivalStatusLabel.setVisible(false);

            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[3], entrenadorRival.getEquipoPK()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);

            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[3],event);



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


            Entrenador.getEquipoPK()[0].usarMovimiento(Entrenador.getEquipoPK()[0].getMovimientosActivos()[3], entrenadorRival.getEquipoPK()[0]);
            pkmnRivalVida.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getVitalidadActual()));
            pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
            entrenadorRival.cambiarPokemonSiDebilitado(this,combate);
            mostrarAccionPokemon(Entrenador.getEquipoPK()[0],Entrenador.getEquipoPK()[0].getMovimientosActivos()[3],event);




        }

        actualizarEstados();
        combate.comprobarEstados();

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

    /**
     * Este metodo comprueba si tu pokemon se ha deebilitado, te obliga a cambiar y actualiza los labels
     * @param event
     * @throws IOException
     */

public void comprobarSiSeHaDebilitado(ActionEvent event) throws IOException {

    if (Entrenador.getEquipoPK()[0].getVitalidadActual()<=0){
        Entrenador.getEquipoPK()[0].setStatus(Status.DEBILITADO);
        changePokemonIsPressed(event);
        pkmnMote.setText(Entrenador.getEquipoPK()[0].getMote());
        pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getStamina()));
        pkmnVida.setText(Integer.toString(Entrenador.getEquipoPK()[0].getVitalidadActual()));
    }
}
    public void ganar(ActionEvent event) throws IOException {
        Entrenador.setPokedollars(Entrenador.getPokedollars()+entrenadorRival.getDinero());
        volver(event);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        hasGanadoButton.setVisible(false);



        if (!seHainiciado) {
            try {
                Logger.getOrCreateFileWriter().write("\n\n Se ha iniciado un nuevo combate\n");
            } catch (IOException e) {

            }
            textoPokemon.setVisible(false);

           for (int i = 0; i < rnd.nextInt(6) ; i++) {

               entrenadorRival.getEquipoPK()[i]=CRUD.sacarEjemplarPokemonPokedex(rnd.nextInt(1,CRUD.pokedex.size()));


           }








            seHainiciado=true;














        }
        pkmnStatusLabel.setVisible(false);
        pkmnRivalStatusLabel.setVisible(false);
        actualizarImagen();



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


    public void descansarOnAction(ActionEvent event) throws IOException {
        Entrenador.getEquipoPK()[0].descansar();
        entrenadorRival.usarAtaque(Entrenador.getEquipoPK()[0]);
        pkmnVida.setText(Integer.toString(Entrenador.getEquipoPK()[0].getVitalidadActual()));
        pkmnStamina.setText(Integer.toString(Entrenador.getEquipoPK()[0].getEstaminaActual()));
        pkmonRivalStamina.setText(Integer.toString(entrenadorRival.getEquipoPK()[0].getEstaminaActual()));
    }
}

