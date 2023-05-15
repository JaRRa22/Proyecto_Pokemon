package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.database.CRUD;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    void reemplazarMovimiento() throws SQLException {

            CRUD.addMovimientosInsert();
            CRUD.insertPokemon();


            Pokemon pokemon= CRUD.sacarEjemplarPokemonPokedex(2);
            Movimiento[] arrMov= new Movimiento[4];
            arrMov[0]=CRUD.listaMovimientos.get(1);
            arrMov[1]=CRUD.listaMovimientos.get(0);
            arrMov[2]=CRUD.listaMovimientos.get(2);
            arrMov[3]=CRUD.listaMovimientos.get(3);



            pokemon.movimientosActivos[0]=CRUD.listaMovimientos.get(1);
            pokemon.movimientosActivos[1]=CRUD.listaMovimientos.get(0);
            pokemon.movimientosActivos[2]=CRUD.listaMovimientos.get(1);
            pokemon.movimientosActivos[3]=CRUD.listaMovimientos.get(3);
            List<Movimiento> movAprendibles=new ArrayList<>();
            movAprendibles.add(arrMov[2]);
            pokemon.setMovimientosAprendibles(movAprendibles);
            pokemon.setNivel(6);
            pokemon.reemplazarMovimiento(2);
            assertSame(Arrays.toString(arrMov), Arrays.toString(pokemon.getMovimientosActivos()));

        }
    }
