package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.controller.CriarController;
import org.Proyecto_Pokemon.database.CRUD;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EntrenadorTest {

    @Test
    void cambiarEquipo() throws SQLException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Entrenador entrenador = new Entrenador("Paspi");
        Pokemon poke1 = CRUD.sacarEjemplarPokemonPokedex(1);
        Pokemon poke2 = CRUD.sacarEjemplarPokemonPokedex(2);
        Pokemon poke3 = CRUD.sacarEjemplarPokemonPokedex(3);
        Pokemon poke4 = CRUD.sacarEjemplarPokemonPokedex(4);
        Pokemon poke5 = CRUD.sacarEjemplarPokemonPokedex(5);
        Pokemon poke6 = CRUD.sacarEjemplarPokemonPokedex(6);
        Entrenador.getEquipoPK()[0] = poke1;
        Entrenador.getEquipoPK()[1] = poke2;
        Entrenador.getEquipoPK()[2] = poke3;
        Entrenador.getEquipoPK()[3] = poke4;
        Entrenador.getEquipoPK()[4] = poke5;
        Entrenador.getEquipoPK()[5] = poke6;

        Pokemon poke7 = CRUD.sacarEjemplarPokemonPokedex(7);
        Pokemon poke8 = CRUD.sacarEjemplarPokemonPokedex(8);
        Pokemon poke9 = CRUD.sacarEjemplarPokemonPokedex(9);
        Pokemon poke10 = CRUD.sacarEjemplarPokemonPokedex(10);
        Pokemon poke11 = CRUD.sacarEjemplarPokemonPokedex(11);
        Pokemon poke12 = CRUD.sacarEjemplarPokemonPokedex(12);
        Entrenador.getEquipoPK2()[0] = poke7;
        Entrenador.getEquipoPK2()[1] = poke8;
        Entrenador.getEquipoPK2()[2] = poke9;
        Entrenador.getEquipoPK2()[3] = poke10;
        Entrenador.getEquipoPK2()[4] = poke11;
        Entrenador.getEquipoPK2()[5] = poke12;

        Assert.assertTrue(Entrenador.cambiarEquipo());

    }

    @Test
    void curarEquipos() throws SQLException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Entrenador entrenador = new Entrenador("Paspi");
        Pokemon poke1 = CRUD.sacarEjemplarPokemonPokedex(1);
        Pokemon poke2 = CRUD.sacarEjemplarPokemonPokedex(2);
        Pokemon poke3 = CRUD.sacarEjemplarPokemonPokedex(3);
        Pokemon poke4 = CRUD.sacarEjemplarPokemonPokedex(4);
        Pokemon poke5 = CRUD.sacarEjemplarPokemonPokedex(5);
        Pokemon poke6 = CRUD.sacarEjemplarPokemonPokedex(6);
        poke1.setVitalidadActual(0);
        poke2.setVitalidadActual(0);
        poke3.setVitalidadActual(0);
        poke4.setVitalidadActual(0);
        poke5.setVitalidadActual(0);
        poke6.setVitalidadActual(0);
        Entrenador.getEquipoPK()[0] = poke1;
        Entrenador.getEquipoPK()[1] = poke2;
        Entrenador.getEquipoPK()[2] = poke3;
        Entrenador.getEquipoPK()[3] = poke4;
        Entrenador.getEquipoPK()[4] = poke5;
        Entrenador.getEquipoPK()[5] = poke6;
        Assert.assertTrue(Entrenador.curarEquipos());
    }

    @Test
    void anadirAEquipo() {
    }

    @Test
    void anadirAEquipo2PK2() throws SQLException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Entrenador entrenador = new Entrenador("Paspi");
        Pokemon poke = CRUD.sacarEjemplarPokemonPokedex(1);
        Assert.assertTrue(Entrenador.anadirAEquipo2PK2(poke));

    }

    @Test
    void anadirACaja(Pokemon pokemon) throws SQLException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Entrenador entrenador = new Entrenador("Paspi");
        Pokemon poke1 = CRUD.sacarEjemplarPokemonPokedex(1);
        Entrenador.anadirACaja(poke1);
        assertEquals(1,entrenador.getCajaPoke().size());
    }

    @Test
    void introducirObjetos() {
    }

    @Test
    void introducirPokeballs() {
    }

    @Test
    void anadirACaja() {
    }

    @Test
    void capturar() {
    }

    @Test
    void entrenar() {
    }

    @Test
    void criar() throws SQLException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Entrenador entrenador = new Entrenador("Paspi");
        Pokemon padre = CRUD.sacarEjemplarPokemonPokedex(1);
        Pokemon madre = CRUD.sacarEjemplarPokemonPokedex(1);
        padre.setSexo(Sexo.MACHO);
        madre.setSexo(Sexo.HEMBRA);
        Assert.assertTrue(Entrenador.criar(padre,madre));
    }
}