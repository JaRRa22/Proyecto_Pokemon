package org.Proyecto_Pokemon.model;

import junit.framework.TestCase;

public class TiendaTest extends TestCase {

    /**
     * El método testComprarObjeto
     * Comprueba si el valor del tipo de objeto es mayor que los pokedollars del entrenador**/
    public void testComprarObjeto() {
        Tienda Tienda = new Tienda();
        Entrenador e = new Entrenador("Test");
        int valorBaston = Tienda.getObjetos().get(TipoObjetos.BASTON);
        if(valorBaston < Entrenador.getPokedollars()){
            assertTrue(Tienda.comprarObjeto(TipoObjetos.BASTON, 1));
        }
        else{
            assertFalse(Tienda.comprarObjeto(TipoObjetos.BASTON, 1));
        }
    }

    /**
     * El método testComprarPokeball
     * Comprueba si el valor del tipo de pokeball es mayor que los pokedollars del entrenador **/
    public void testComprarPokeball() {
        Tienda Tienda = new Tienda();
        Entrenador e = new Entrenador("Test");
        int valorMasterball = Tienda.getPokeballs().get(TipoPokeball.MASTERBALL);
        if(valorMasterball < Entrenador.getPokedollars()){
            assertTrue(Tienda.comprarPokeball(TipoPokeball.MASTERBALL, 1));
        }
        else{
            assertTrue(Tienda.comprarPokeball(TipoPokeball.MASTERBALL, 1));
        }
    }
}