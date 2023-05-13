package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.database.CRUD;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    void subirNivel() {
    }

    @Test
    void usarMovimiento() {
    }

    @Test
    void sePuedeAprenderMovimiento() throws SQLException {

        Pokemon pokemon =new Pokemon("Pepe");
        pokemon.setNivel(6);
        assertEquals(true,pokemon.sePuedeAprenderMovimiento());

    }

    @Test
    void preguntarSiQuiereAprenderMovimiento() {
    }

    @Test
    void reemplazarMovimiento() {
    }
}