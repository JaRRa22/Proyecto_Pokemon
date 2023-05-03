package org.Proyecto_Pokemon.model;


class PokemonTest {
    Ataque placaje = new Ataque("Placaje", 30, 20, Tipo.NORMAL, "Fisico" );
    ObjetoEquipable chaleco = new ObjetoEquipable(TipoObjetos.CHALECO);
    Pokemon picachu = new Pokemon("Picachu", 30, 32,31,32,11,11,41,Tipo.ELECTRICO,placaje, chaleco,Sexo.MACHO);


    @org.junit.jupiter.api.Test
    void subirNivel() {
    }

    @org.junit.jupiter.api.Test
    void descansar() {
    }

    @org.junit.jupiter.api.Test
    void tenerHijo() {
    }

    @org.junit.jupiter.api.Test
    void usarMovimiento() {
    }

    @org.junit.jupiter.api.Test
    void sePuedeAprenderMovimiento() {
    }

    @org.junit.jupiter.api.Test
    void reemplazarMovimiento() {
    }
}