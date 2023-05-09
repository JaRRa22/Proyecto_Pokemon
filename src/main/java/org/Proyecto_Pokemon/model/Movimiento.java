package org.Proyecto_Pokemon.model;

import java.util.Random;

public abstract class Movimiento {

 protected Random rnd=new Random();

 protected Tipo tipo;
protected String nombre;
protected int costeEstamina;

 public Tipo getTipo() {
  return tipo;
 }

 public void setTipo(Tipo tipo) {
  this.tipo = tipo;
 }

 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public int getCosteEstamina() {
  return costeEstamina;
 }

 public void setCosteEstamina(int costeEstamina) {
  this.costeEstamina = costeEstamina;
 }


 /**
  * Metodo común que heredaran las clases hijas de Movimiento
  *
  * @param target
  * @param pokemon
  * @return
  */
 public abstract boolean usarMov(Pokemon target, Pokemon pokemon) ;
}






