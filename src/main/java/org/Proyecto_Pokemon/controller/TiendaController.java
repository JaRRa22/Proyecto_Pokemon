package org.Proyecto_Pokemon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.Proyecto_Pokemon.Logger;
import org.Proyecto_Pokemon.model.*;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class TiendaController {

    private boolean comprado = false;

    private Parent root;

    private Stage stage;

    private Scene scene;

    private TipoObjetos tipoSelectObje = null;

    private TipoPokeball tipoSelectPoke = null;


    @FXML
    private Text NombreObjetoSeleccionado;

    @FXML
    private Text saberCompraRealizada;

    @FXML
    private Text NumCosteObjetoSeleccionado;

    @FXML
    private Text DineroEntrenador;

    @FXML
    private ImageView plumaEnTienda;

    @FXML
    private ImageView imagenChalecoEnTienda;

    @FXML
    private ImageView pokeballEnTienda;

    @FXML
    private ImageView bastonEnTienda;

    @FXML
    private ImageView pesaEnTienda;

    @FXML
    private ImageView pilaEnTienda;

    @FXML
    private ImageView fondo;

    @FXML
    private ImageView pokeball1;

    @FXML
    private ImageView pokeball2;

    @FXML
    private ImageView pokeball3;

    @FXML
    private ImageView pokeball4;

    @FXML
    private ImageView imagenSelecccionada;

    @FXML
    private Button btnIrMenu;

    @FXML
    private Button btnPlumaEnTienda;

    @FXML
    private Button btnPokeballEnTienda;

    @FXML
    private Button btnPesaEnTienda;

    @FXML
    private Button btnBastonEnTienda;

    @FXML
    private Button btnChalecoEnTienda;

    @FXML
    private Button btnPilaEnTienda;

    @FXML
    private MenuButton btnComprar;

    @FXML
    private MenuButton SelecTipoPokeball;

    @FXML
    private MenuItem selectNum1;

    @FXML
    private MenuItem selectNum2;

    @FXML
    private MenuItem selectNum3;

    @FXML
    private MenuItem selectNum4;
    @FXML
    private MenuItem selectNum5;

    @FXML
    private MenuItem select1;

    @FXML
    private MenuItem select2;

    @FXML
    private MenuItem select3;

    @FXML
    private MenuItem select4;





    public void initialize(){

        btnComprar.setVisible(false);

        saberCompraRealizada.setText("");

        DineroEntrenador.setText( "" + Entrenador.getPokedollars());

        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);

        File f = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\fondoTienda.jpg");
        Image image = new Image(f.toURI().toString());
        fondo.setImage(image);


        File chaleco = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\chaleco.png");
        Image image2 = new Image(chaleco.toURI().toString());
        imagenChalecoEnTienda.setImage(image2);


        File pokeball = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\Pokeball.png");
        Image image3 = new Image(pokeball.toURI().toString());
        pokeballEnTienda.setImage(image3);

        File pluma = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\pluma.png");
        Image image4 = new Image(pluma.toURI().toString());
        plumaEnTienda.setImage(image4);

        File baston = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\baston.png");
        Image image5 = new Image(baston.toURI().toString());
        bastonEnTienda.setImage(image5);

        File pesa = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\pesa.png");
        Image image6 = new Image(pesa.toURI().toString());
        pesaEnTienda.setImage(image6);

        File pila = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\pila.png");
        Image image7 = new Image(pila.toURI().toString());
        pilaEnTienda.setImage(image7);

    }

    public void saberPokeballs(){

        SelecTipoPokeball.setDisable(false);
        SelecTipoPokeball.setVisible(true);


        File poke1 = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\Pokeball.png");
        Image image8 = new Image(poke1.toURI().toString());
        pokeball1.setImage(image8);

        File poke2 = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\Superball.png");
        Image image9 = new Image(poke2.toURI().toString());
        pokeball2.setImage(image9);

        File poke3 = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\Ultraball.png");
        Image image10 = new Image(poke3.toURI().toString());
        pokeball3.setImage(image10);

        File poke4 = new File("Proyecto_Pokemon\\src\\main\\resources\\imagenes\\Materball.png");
        Image image11 = new Image(poke4.toURI().toString());
        pokeball4.setImage(image11);
    }

    public void metCambPoke(){
        btnComprar.setVisible(true);
    imagenSelecccionada.setImage(pokeball1.getImage());
        NumCosteObjetoSeleccionado.setText("" + InicioController.tienda.getPokeballs().get(TipoPokeball.POKEBALL));
        NombreObjetoSeleccionado.setText("Pokeball");
        tipoSelectObje = null;
        tipoSelectPoke = TipoPokeball.POKEBALL;
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPoke2(){
        btnComprar.setVisible(true);
        imagenSelecccionada.setImage(pokeball2.getImage());
        NumCosteObjetoSeleccionado.setText("" + InicioController.tienda.getPokeballs().get(TipoPokeball.SUPERBALL));
        NombreObjetoSeleccionado.setText("Superball");
        tipoSelectObje = null;
        tipoSelectPoke = TipoPokeball.SUPERBALL;
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPoke3(){
        btnComprar.setVisible(true);
        imagenSelecccionada.setImage(pokeball3.getImage());
        NumCosteObjetoSeleccionado.setText("" + InicioController.tienda.getPokeballs().get(TipoPokeball.ULTRABALL));
        NombreObjetoSeleccionado.setText("Ultraball");
        tipoSelectObje = null;
        tipoSelectPoke = TipoPokeball.ULTRABALL;
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPoke4(){
        btnComprar.setVisible(true);
        imagenSelecccionada.setImage(pokeball4.getImage());
        NumCosteObjetoSeleccionado.setText("" + InicioController.tienda.getPokeballs().get(TipoPokeball.MASTERBALL));
        NombreObjetoSeleccionado.setText("Masterball");
        tipoSelectObje = null;
        tipoSelectPoke = TipoPokeball.MASTERBALL;
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambChaleco(){
        btnComprar.setVisible(true);
        imagenSelecccionada.setImage(imagenChalecoEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("" + InicioController.tienda.getObjetos().get(TipoObjetos.CHALECO));
        NombreObjetoSeleccionado.setText("Chaleco");
        tipoSelectPoke = null;
        tipoSelectObje = TipoObjetos.CHALECO;
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPluma(){
        btnComprar.setVisible(true);
        imagenSelecccionada.setImage(plumaEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("" + InicioController.tienda.getObjetos().get(TipoObjetos.PLUMA));
        NombreObjetoSeleccionado.setText("Pluma");
        tipoSelectPoke = null;
        tipoSelectObje = TipoObjetos.PLUMA;
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambBaston(){
        btnComprar.setVisible(true);
        imagenSelecccionada.setImage(bastonEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("" + InicioController.tienda.getObjetos().get(TipoObjetos.BASTON));
        NombreObjetoSeleccionado.setText("Baston");
        tipoSelectPoke = null;
        tipoSelectObje = TipoObjetos.BASTON;
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPesa(){
        btnComprar.setVisible(true);
        imagenSelecccionada.setImage(pesaEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("" + InicioController.tienda.getObjetos().get(TipoObjetos.PESA));
        NombreObjetoSeleccionado.setText("Pesa");
        tipoSelectPoke = null;
        tipoSelectObje = TipoObjetos.PESA;
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPila(){
        btnComprar.setVisible(true);
        imagenSelecccionada.setImage(pilaEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("" + InicioController.tienda.getObjetos().get(TipoObjetos.PILAS));
        NombreObjetoSeleccionado.setText("Pila");
        tipoSelectPoke = null;
        tipoSelectObje = TipoObjetos.PILAS;
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void volver(ActionEvent event) throws IOException {
        Random rnd= new Random();
        int dinero =rnd.nextInt(1,800);
        Logger.write("Has perdido y el rival te ha cogido la cartera y robado " + dinero + " pokedollares");
        Entrenador.setPokedollars(Entrenador.getPokedollars() - dinero);
        Logger.close();

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menu.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void cantidad1(){
       if(tipoSelectPoke != null){
          comprado = InicioController.tienda.comprarPokeball(tipoSelectPoke,1);
       }

       if(tipoSelectObje != null){
            comprado = InicioController.tienda.comprarObjeto(tipoSelectObje,1);
        }

       if(comprado == true){
           saberCompraRealizada.setText("¡Compra Exitosa!");
       }

       else if(comprado == false){
           saberCompraRealizada.setText("¡Compra Denegada!");
       }

        DineroEntrenador.setText( "" + Entrenador.getPokedollars());
    }

    public void cantidad2(){
        if(tipoSelectPoke != null){
            comprado = InicioController.tienda.comprarPokeball(tipoSelectPoke,2);
        }

        if(tipoSelectObje != null){
            comprado = InicioController.tienda.comprarObjeto(tipoSelectObje,2);
        }

        if(comprado == true){
            saberCompraRealizada.setText("¡Compra Exitosa!");
        }

        else if(comprado == false){
            saberCompraRealizada.setText("¡Compra Denegada!");
        }

        DineroEntrenador.setText( "" + Entrenador.getPokedollars());
    }

    public void cantidad3(){
        if(tipoSelectPoke != null){
            comprado = InicioController.tienda.comprarPokeball(tipoSelectPoke,3);
        }

        if(tipoSelectObje != null){
            comprado = InicioController.tienda.comprarObjeto(tipoSelectObje,3);
        }

        if(comprado == true){
            saberCompraRealizada.setText("¡Compra Exitosa!");
        }

        else if(comprado == false){
            saberCompraRealizada.setText("¡Compra Denegada!");
        }

        DineroEntrenador.setText( "" + Entrenador.getPokedollars());
    }

    public void cantidad4(){
        if(tipoSelectPoke != null){
            comprado = InicioController.tienda.comprarPokeball(tipoSelectPoke,4);
        }

        if(tipoSelectObje != null){
            comprado = InicioController.tienda.comprarObjeto(tipoSelectObje,4);
        }

        if(comprado == true){
            saberCompraRealizada.setText("¡Compra Exitosa!");
        }

        else if(comprado == false){
            saberCompraRealizada.setText("¡Compra Denegada!");
        }

        DineroEntrenador.setText( "" + Entrenador.getPokedollars());
    }

    public void cantidad5(){
        if(tipoSelectPoke != null){
            comprado = InicioController.tienda.comprarPokeball(tipoSelectPoke,5);
        }

        if(tipoSelectObje != null){
            comprado = InicioController.tienda.comprarObjeto(tipoSelectObje,5);
        }

        if(comprado == true){
            saberCompraRealizada.setText("¡Compra Exitosa!");
        }

        else if(comprado == false){
            saberCompraRealizada.setText("¡Compra Denegada!");
        }

        DineroEntrenador.setText( "" + Entrenador.getPokedollars());
    }



}
