package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.database.CRUD;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AtaqueTest {

    //Funciona pero hay que quitar el Log

    @Test
    void calcularDanyo() {
    }

    @Test
    void usarMov() {
    }

    @Test
    void calcularDebilidad() throws IOException {
        Ataque ataque=new Ataque("HidroBomba",40,100,Tipo.AGUA,"Especial");
        Pokemon pokemon= new Pokemon("Geopibe",Tipo.TIERRA,Tipo.ROCA,22,20,99,99,99,99,99,99,ataque);
        assertEquals(ataque.calcularDebilidad(pokemon),4);
    }
}