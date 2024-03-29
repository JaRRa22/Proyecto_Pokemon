package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.database.CRUD;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    /**
     * Los test funcionan, pero como los metodos escriben en Logger , salta excepción y los verifica a false
     * @throws SQLException
     */



    @Test
    void crearEspecimenConVariabilidad() throws SQLException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Pokemon pokemon1=CRUD.pokedex.get(9);
        //Este metodo llama a al de crearEspecimen
        Pokemon pokemon2=CRUD.sacarEjemplarPokemonPokedex(9);

        assertNotEquals(pokemon1, pokemon2);



    }

    @Test
    void subirNivel() {
            try {


                CRUD.addMovimientosInsert();
                CRUD.insertPokemon();

                Pokemon pokemon = CRUD.sacarEjemplarPokemonPokedex(2);

                Pokemon pokemon1 = CRUD.sacarEjemplarPokemonPokedex(2);
                int ataque = pokemon.getAtaque();
                pokemon.setExperiencia(400);
                pokemon.subirNivel();


                assertNotEquals(ataque, pokemon.getAtaque());
                assertNotEquals(pokemon.getNivel(), pokemon1.getNivel());
            }catch (Exception ignored){}
        }



    @Test
    void descansar() throws IOException, SQLException {
        CRUD.addMovimientosInsert();
        CRUD.insertPokemon();
        Pokemon pokemon= CRUD.sacarEjemplarPokemonPokedex(2);
        Pokemon pokemon2= CRUD.sacarEjemplarPokemonPokedex(2);
        int stamina=pokemon.getEstaminaActual();
        pokemon.usarMovimiento(pokemon.getMovimientosActivos()[0],pokemon2);
        assertEquals(stamina,pokemon.getEstaminaActual());
    }

    @Test
    void usarMovimiento() throws SQLException, IOException {
            CRUD.addMovimientosInsert();
            CRUD.insertPokemon();


            Pokemon pokemon= CRUD.sacarEjemplarPokemonPokedex(2);
            Movimiento[] movimientosPkmn1= new Movimiento[4];



            Pokemon pokemon2= CRUD.sacarEjemplarPokemonPokedex(3);
            pokemon.setEstaminaActual(9999);
            int ataquePrevioADanzaEspada=pokemon.getAtaque();

            Mejora danzaEspada=new Mejora("danza espada",2.0f,2,"ataque",Tipo.NORMAL);
            movimientosPkmn1[1]=danzaEspada;
            pokemon.usarMovimiento(movimientosPkmn1[1],pokemon2);
            assertNotEquals(ataquePrevioADanzaEspada, pokemon.getAtaque());

            //Esto comprueba que le ha cambiado el ataque


            movimientosPkmn1[2]=(new Ataque("Impactrueno",70,95,Tipo.ELECTRICO,"Especial"));
            int vidaAntesDeImpactrueno =pokemon2.getVitalidadActual();
            pokemon.usarMovimiento(movimientosPkmn1[2],pokemon2);
            assertNotEquals(vidaAntesDeImpactrueno,pokemon2.getVitalidadActual());
            //Esto comprueba que los ataques hacen daño

            movimientosPkmn1[3]=new MovEstado("Latigo","defensa",1.45f,100,2,Tipo.NORMAL);
            int defensaAntesDeLatigo=pokemon2.getDefensa();
            pokemon.usarMovimiento(movimientosPkmn1[3],pokemon2);


            assertNotEquals(defensaAntesDeLatigo,pokemon2.getDefensa());


            movimientosPkmn1[0]=new MovEstado("envenenar",2,100,Tipo.VENENO,Status.ENVENENADO);
            pokemon.usarMovimiento(movimientosPkmn1[0],pokemon2);
            assertEquals(Status.ENVENENADO,pokemon2.getStatus());



            }

    @Test
    void sePuedeAprenderMovimiento() {

        Pokemon pokemon =new Pokemon("Pepe");
        pokemon.setNivel(6);
        assertTrue(pokemon.sePuedeAprenderMovimiento());

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
        assertNotEquals(Arrays.toString(arrMov), Arrays.toString(pokemon.getMovimientosActivos()));

    }
    }
