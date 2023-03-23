package org.example;

public abstract class Movimiento {

 protected Tipo tipo;
protected String nombre;
protected int costeStamina;





 public abstract void aplicar(Pokemon objetivo);
}
