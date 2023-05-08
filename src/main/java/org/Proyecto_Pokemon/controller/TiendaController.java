package org.Proyecto_Pokemon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.Proyecto_Pokemon.model.Entrenador;
import org.Proyecto_Pokemon.model.Pokemon;
import org.Proyecto_Pokemon.model.Tienda;
import org.Proyecto_Pokemon.model.TipoPokeball;

import java.io.File;

public class TiendaController {
    @FXML
    private Text NombreObjetoSeleccionado;
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
    private MenuButton SelecTipoPokeball;



    @FXML
    private MenuItem select1;

    @FXML
    private MenuItem select2;

    @FXML
    private MenuItem select3;

    @FXML
    private MenuItem select4;





    public void initialize(){

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
    imagenSelecccionada.setImage(pokeball1.getImage());
        NumCosteObjetoSeleccionado.setText("30");
        NombreObjetoSeleccionado.setText("Pokeball");
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPoke2(){
        imagenSelecccionada.setImage(pokeball2.getImage());
        NumCosteObjetoSeleccionado.setText("40");
        NombreObjetoSeleccionado.setText("Superball");
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPoke3(){
        imagenSelecccionada.setImage(pokeball3.getImage());
        NumCosteObjetoSeleccionado.setText("50");
        NombreObjetoSeleccionado.setText("Ultraball");
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPoke4(){
        imagenSelecccionada.setImage(pokeball4.getImage());
        NumCosteObjetoSeleccionado.setText("60");
        NombreObjetoSeleccionado.setText("Masterball");
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambChaleco(){
        imagenSelecccionada.setImage(imagenChalecoEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("200");
        NombreObjetoSeleccionado.setText("Chaleco");
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPluma(){
        imagenSelecccionada.setImage(plumaEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("100");
        NombreObjetoSeleccionado.setText("Pluma");
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambBaston(){
        imagenSelecccionada.setImage(bastonEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("160");
        NombreObjetoSeleccionado.setText("Baston");
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPesa(){
        imagenSelecccionada.setImage(pesaEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("120");
        NombreObjetoSeleccionado.setText("Pesa");
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }

    public void metCambPila(){
        imagenSelecccionada.setImage(pilaEnTienda.getImage());
        NumCosteObjetoSeleccionado.setText("150");
        NombreObjetoSeleccionado.setText("Pila");
        SelecTipoPokeball.setDisable(true);
        SelecTipoPokeball.setVisible(false);
    }



}
