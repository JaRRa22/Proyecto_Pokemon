package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.database.CRUD;
import org.Proyecto_Pokemon.database.MySQLConnection;

import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        System.out.println(MySQLConnection.getConnection());
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        System.out.println(CRUD.sacarEjemplarPokemonPokedex(5));
    }
}
