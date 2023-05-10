package org.Proyecto_Pokemon.database;

import org.Proyecto_Pokemon.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CRUD {
    public static List<Pokemon> pokedex=new LinkedList<>();
    public static List<Movimiento>listaMovimientos;
    static HashMap<String,Movimiento>dicMovimientos=new HashMap<>();


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
                String estado= resultSet.getString("ESTADO").toUpperCase();

                if (variedadMovimiento.toUpperCase().equals("ATAQUE")) {
                 Ataque ataque = new Ataque(nombreMov,potencia,accuracy,tipo,fisicoOEspecial.toUpperCase())   ;
                listaMovimientos.add(ataque);
                dicMovimientos.put(ataque.getNombre(),ataque);


                } else if (variedadMovimiento.toUpperCase().equals("MEJORA")) {
                    Mejora mejorasMask=new Mejora(nombreMov,porcentajeCambio,duracion,statACambiar,tipo);
                    listaMovimientos.add(mejorasMask);
                    dicMovimientos.put(mejorasMask.getNombre(),mejorasMask);


                }else {

                    if (estado.equalsIgnoreCase("NULL")){
                    MovEstado estadoUnido= new MovEstado(nombreMov,statACambiar,porcentajeCambio,accuracy,duracion,tipo);
                    listaMovimientos.add(estadoUnido);
                    dicMovimientos.put(estadoUnido.getNombre(),estadoUnido);

                }
                    else {
                        MovEstado movEstado=new MovEstado(nombreMov,duracion,accuracy,tipo,Status.valueOf(estado.toUpperCase()));
                    }

            }
    } }catch (SQLException e) {
            throw new RuntimeException(e);
        }}


        public static void insertPokemon() throws SQLException {
        String queryVerPokemon="SELECT NOMBRE_POKEMON AS NOMBRE , TIPO1,TIPO2 FROM pokemon ";
        String queryParaHacerAdd="SELECT NOMBRE_POKEMON AS NOMBRE , TIPO1,TIPO2,NUM_POKEDEX AS NUMPOKEDEX," +
                "VITALIDAD_MAXIMA,STAMINA_MAXIMA,VELOCIDAD,ATAQUE,ATAQUE_ESPECIAL,DEFENSA,DEFENSA_ESPECIAL,NOMBRE_MOVIMIENTO_INICIAL FROM pokedex";
        PreparedStatement preparedStatement=null;

        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(queryParaHacerAdd);
            //preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("NOMBRE");

                String tipo = resultSet.getString("TIPO1").toUpperCase();
                String tipo2 = resultSet.getString("TIPO2").toUpperCase();
                if (tipo2.equalsIgnoreCase("NULL")) {
                    tipo2=null;
                }
                String nombreMovInicial= resultSet.getString("NOMBRE_MOVIMIENTO_INICIAL");
                int numPokedex=resultSet.getInt("NUMPOKEDEX");
                int vitalidadMaxima=resultSet.getInt("VITALIDAD_MAXIMA");
                int  staminaMaxima= resultSet.getInt("STAMINA_MAXIMA");
                int velocidad=resultSet.getInt("VELOCIDAD");
                int ataque=resultSet.getInt("ATAQUE");
                int ataqueEspecial=resultSet.getInt("ATAQUE_ESPECIAL");
                int defensa=resultSet.getInt("DEFENSA");
                int defensaEspecial=resultSet.getInt("DEFENSA_ESPECIAL");
                pokedex.add(new Pokemon(nombre, Tipo.valueOf(tipo),Tipo.valueOf(tipo2),numPokedex,vitalidadMaxima,staminaMaxima,velocidad,ataque,ataqueEspecial,defensa,defensaEspecial,dicMovimientos.get(nombreMovInicial)));}

        }catch (SQLException e){

            }


    }}


