package org.Proyecto_Pokemon.model;

import com.google.protobuf.Empty;
import org.Proyecto_Pokemon.database.CRUD;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EntrenadorTest {

    @Test
    void cambiarEquipo() {
    }

    @Test
    void anadirAEquipo() throws SQLException {
        Entrenador uno = new Entrenador("JaRRa");
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Pokemon prueba = CRUD.sacarEjemplarPokemonPokedex(1);
        Entrenador.anadirAEquipo(prueba);
        Pokemon[] equipoPrueba = new Pokemon[6];
        equipoPrueba[0] = prueba;

        Pokemon [] equipo = Entrenador.getEquipoPK();
        Pokemon [] equipo2 = Entrenador.getEquipoPK2();

        assertArrayEquals(equipoPrueba, equipo);
    }

    @Test
    void anadirAEquipo2PK2() {
    }

    @Test
    void introducirObjetos() {
        Entrenador e = new Entrenador("JaRRa");
        Entrenador.introducirObjetos(TipoObjetos.BASTON, 1);
        assertEquals(1, Entrenador.getBaston()  .getCantidad());
    }

    @Test
    void introducirPokeballs() {
        Entrenador e = new Entrenador("JaRRa");
        Entrenador.introducirPokeballs(TipoPokeball.SUPERBALL, 1);
        assertEquals(1, Entrenador.getSuperball().getCantidad());
    }

    @Test
    void anadirACaja() {
    }

    @Test
    void curarEquipos() {
    }

    @Test
    void capturar() throws SQLException, IOException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Tienda tienda = new Tienda();
        Pokemon prueba = CRUD.sacarEjemplarPokemonPokedex(1);
        Entrenador e = new Entrenador("JaRRa");
        tienda.comprarPokeball(TipoPokeball.MASTERBALL, 1);
        Entrenador.capturar(Entrenador.getMasterball(), prueba);
        assertEquals(0, Entrenador.getMasterball().getCantidad());
    }

    @Test
    void entrenar() throws SQLException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Pokemon prueba = CRUD.sacarEjemplarPokemonPokedex(1);
        int ataqueAntesEntrenamiento = prueba.getAtaque();
        int ataqueEspecialAntesEntrenamiento = prueba.getAtaqueEspecial();
        int velocidadAntesEntrenamiento = prueba.getVelocidad();

        Entrenador e = new Entrenador("JaRRa");
        Entrenador.entrenar(prueba, Entrenar.FURIOSO);
        assertNotEquals(ataqueAntesEntrenamiento, prueba.getAtaque());
        assertNotEquals(ataqueEspecialAntesEntrenamiento, prueba.getAtaqueEspecial());
        assertNotEquals(velocidadAntesEntrenamiento, prueba.getVelocidad());
    }

    @Test
    void criar() {

    }
}