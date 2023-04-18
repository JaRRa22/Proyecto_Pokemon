package org.Proyecto.Pokemon.model;

public class MovEstado extends Movimiento {

    private float porcentajeCambio;
    private int precision;
    private int numTurnos;
    private Status estadoInflingible;

    public MovEstado(String nom, float cantidadAcambiar, int duracionTurnos, Tipo tipo) {
        this.porcentajeCambio = cantidadAcambiar;
        this.numTurnos = duracionTurnos;
        this.nombre=nom;
        this.tipo=tipo;
        this.costeStamina=numTurnos*10;

    }
    public MovEstado(String nom,float cantidadAcambiar, int duracionTurnos,Tipo tipo,Status estado) {
        this.porcentajeCambio = cantidadAcambiar;
        this.numTurnos = duracionTurnos;
        this.nombre=nom;
        this.tipo=tipo;
        this.costeStamina=numTurnos*10;
        this.estadoInflingible=estado;
    }






    public void aplicar(Pokemon objetivo) {

    }
}
