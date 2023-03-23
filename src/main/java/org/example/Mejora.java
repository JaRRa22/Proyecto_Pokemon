package org.example;

public class Mejora extends Movimiento{
private float cantidadAcambiar;
private int duracionMejora;

    public Mejora(String nom,float cantidadAcambiar, int duracionMejora,Tipo tipo) {
        this.cantidadAcambiar = cantidadAcambiar;
        this.duracionMejora = duracionMejora;
        this.nombre=nom;
        this.tipo=tipo;
        this.costeStamina=duracionMejora*10;



    }

    @Override
    public void aplicar() {

    }
}
