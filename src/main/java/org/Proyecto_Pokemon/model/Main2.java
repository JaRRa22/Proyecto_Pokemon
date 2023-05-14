package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.database.CRUD;

import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        CRUD.insertPokemon();
        System.out.println(CRUD.sacarEjemplarPokemonPokedex(1));
    }
}
