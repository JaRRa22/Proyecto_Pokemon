package org.Proyecto_Pokemon.model;

public abstract class Movimiento {

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
}






