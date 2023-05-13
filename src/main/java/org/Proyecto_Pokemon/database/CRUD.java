package org.Proyecto_Pokemon.database;

import org.Proyecto_Pokemon.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class CRUD {
    public static HashMap<Integer,String> idPokemonFilePathImagen=new HashMap<>();

    public static void addFilePathOfImagesToHashmap(){
        idPokemonFilePathImagen.put(3,"src/main/resources/imagenes/carreroBlanco.jpeg");
        idPokemonFilePathImagen.put(1,"src/main/resources/imagenes/bulba001.png");
        idPokemonFilePathImagen.put(2,"src/main/resources/imagenes/002.png");
        idPokemonFilePathImagen.put(4,"src/main/resources/imagenes/charmander04.png");
        idPokemonFilePathImagen.put(5,"src/main/resources/imagenes/rataAmarilla05.png");
        idPokemonFilePathImagen.put(6,"src/main/resources/imagenes/capullo06.png");
        idPokemonFilePathImagen.put(7,"src/main/resources/imagenes/vamoAcalmarno07.png");
        idPokemonFilePathImagen.put(8,"src/main/resources/imagenes/pajarofeo08.png");
        idPokemonFilePathImagen.put(9,"src/main/resources/imagenes/caterpie09.png");
        idPokemonFilePathImagen.put(10,"src/main/resources/imagenes/Dragonite10.png");
        idPokemonFilePathImagen.put(11,"src/main/resources/imagenes/jiggy.png");
        idPokemonFilePathImagen.put(12,"src/main/resources/imagenes/Ponyta12.png");
        idPokemonFilePathImagen.put(13,"src/main/resources/imagenes/geodude13.png");
        idPokemonFilePathImagen.put(14,"src/main/resources/imagenes/magnemite14.png");
        idPokemonFilePathImagen.put(15,"src/main/resources/imagenes/snorlax15.png");
        idPokemonFilePathImagen.put(16,"src/main/resources/imagenes/flareon16.png");
        idPokemonFilePathImagen.put(17,"src/main/resources/imagenes/vaporeon17.png");
        idPokemonFilePathImagen.put(18,"src/main/resources/imagenes/evee18.png");
        idPokemonFilePathImagen.put(19,"src/main/resources/imagenes/lapras19.png");
        idPokemonFilePathImagen.put(20,"src/main/resources/imagenes/Magikarp20.png");



    }




    public static List<Movimiento>listaMovimientos=new LinkedList<>();
     static HashMap<String,Movimiento>dicMovimientos=new HashMap<>();
    public static HashMap<Integer,Pokemon>pokedex=new HashMap<>();
    public static Pokemon sacarEjemplarPokemonPokedex(int id){
     return pokedex.get(id).crearEspecimenConVariabilidad();
    }


    public static void addMovimientosInsert() {
        String queryParaCrearMovimiento="SELECT NOMBRE,DURACION,TIPO,COSTE_STAMINA,POTENCIA,accuracy,ESTADO,PORCENTAJE_CAMBIO,VARIEDAD_MOVIMIENTO,FISICO_ESPECIAL,STAT_A_CAMBIAR FROM movimiento";
        PreparedStatement movimientoPreparedStatement=null;
        try {
            movimientoPreparedStatement=MySQLConnection.getConnection().prepareStatement(queryParaCrearMovimiento);
            ResultSet resultSet=movimientoPreparedStatement.executeQuery();
            while (resultSet.next()) {



                String nombreMov=resultSet.getString("NOMBRE");


                int duracion=resultSet.getInt("DURACION");
                Tipo tipo=Tipo.valueOf( resultSet.getString("TIPO").toUpperCase());
                int costeStam=resultSet.getInt("COSTE_STAMINA");
                int potencia=resultSet.getInt("POTENCIA");
                int accuracy=resultSet.getInt("accuracy");

                float porcentajeCambio= resultSet.getFloat("PORCENTAJE_CAMBIO");
                String variedadMovimiento=resultSet.getString("VARIEDAD_MOVIMIENTO");
                String fisicoOEspecial=resultSet.getString("FISICO_ESPECIAL");
                String statACambiar=resultSet.getString("STAT_A_CAMBIAR");
                String estado= resultSet.getString("ESTADO");

                if (variedadMovimiento.toUpperCase().equals("ATAQUE")) {
                 Ataque ataque = new Ataque(nombreMov,potencia,accuracy,tipo,fisicoOEspecial.toUpperCase())   ;
                listaMovimientos.add(ataque);
                dicMovimientos.put(ataque.getNombre(),ataque);


                } else if (variedadMovimiento.toUpperCase().equals("MEJORA")) {
                    Mejora mejorasMask=new Mejora(nombreMov,porcentajeCambio,duracion,statACambiar,tipo);
                    listaMovimientos.add(mejorasMask);
                    dicMovimientos.put(mejorasMask.getNombre(),mejorasMask);


                }else {






                    if (estado.equalsIgnoreCase("NO")){
                    MovEstado estadoUnido= new MovEstado(nombreMov,statACambiar,porcentajeCambio,accuracy,duracion,tipo);
                    listaMovimientos.add(estadoUnido);
                    dicMovimientos.put(estadoUnido.getNombre(),estadoUnido);

                }
                    else {
                        MovEstado movEstado=new MovEstado(nombreMov,duracion,accuracy,tipo,Status.valueOf(estado.toUpperCase()));
                        listaMovimientos.add(movEstado);
                        dicMovimientos.put(movEstado.getNombre(),movEstado);
                    }

            }
    } }catch (SQLException e) {
            throw new RuntimeException(e);
        }}


        public static void insertPokemon() throws SQLException {


        String queryParaHacerAdd="SELECT NOMBRE_POKEMON, TIPO1,TIPO2,ID_POKEMON," +
                "VITALIDAD_MAXIMA,STAMINA_MAXIMA,VELOCIDAD,ATAQUE,ATAQUE_ESPECIAL,DEFENSA,DEFENSA_ESPECIAL,NOMBRE_MOVIMIENTO_INICIAL FROM POKEDEX";
        PreparedStatement preparedStatement=null;

        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(queryParaHacerAdd);
            //preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("NOMBRE_POKEMON");
                int id = resultSet.getInt("ID_POKEMON");

                Tipo tipo = Tipo.valueOf(resultSet.getString("TIPO1").toUpperCase());
                Tipo segundoTipo;
                String tipo2 = resultSet.getString("TIPO2").toUpperCase();
                if (tipo2.equalsIgnoreCase("NO")) {
                 segundoTipo=null;

                }else {
                    segundoTipo=Tipo.valueOf(tipo2);
                }
                String nombreMovInicial = resultSet.getString("NOMBRE_MOVIMIENTO_INICIAL");
                int numPokedex = resultSet.getInt("ID_POKEMON");
                int vitalidadMaxima = resultSet.getInt("VITALIDAD_MAXIMA");
                int staminaMaxima = resultSet.getInt("STAMINA_MAXIMA");
                int velocidad = resultSet.getInt("VELOCIDAD");
                int ataque = resultSet.getInt("ATAQUE");
                int ataqueEspecial = resultSet.getInt("ATAQUE_ESPECIAL");
                int defensa = resultSet.getInt("DEFENSA");
                int defensaEspecial = resultSet.getInt("DEFENSA_ESPECIAL");

                pokedex.put( id,new Pokemon(nombre,tipo, segundoTipo, numPokedex, vitalidadMaxima, staminaMaxima, velocidad, ataque, ataqueEspecial, defensa, defensaEspecial, dicMovimientos.get(nombreMovInicial)));

            }

        }catch (SQLException e){

            }}
}





