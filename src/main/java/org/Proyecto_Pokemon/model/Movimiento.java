package org.Proyecto_Pokemon.model;

public abstract class Movimiento {

 protected Tipo tipo;
protected String nombre;
protected int costeStamina;

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

 public int getCosteStamina() {
  return costeStamina;
 }

 public void setCosteStamina(int costeStamina) {
  this.costeStamina = costeStamina;
 }
}






