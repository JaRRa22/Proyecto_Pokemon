package org.example;

public class Entrenador {
    private String nombre;
    //private Pokemon[]equipoPK;
    //private Pokemon[]equipoPK2;
    //private PC pc;
    private int pokedollars;
    private Mochila mochila;

    public Entrenador(){
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPokedollars() {
        return pokedollars;
    }

    public void setPokedollars(int pokedollars) {
        this.pokedollars = pokedollars;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public void setMochila(Mochila mochila) {
        this.mochila = mochila;
    }

    public boolean cambiarEquipo(){
        return true;
    }
    public boolean añadirAEquipo(){
        return true;
    }
    public boolean sacarDeEquipo(){
        return true;
    }
    public boolean añadirACaja(){
        return true;
    }
    public boolean utilizarCajaMeter(){
        return true;
    }
    public boolean utilizarCajaSacar(){
        return true;
    }
    public boolean comprarTienda(){
        return true;
    }
    public boolean entrenar(){
        return true;
    }
    public boolean capturar(){
        return true;
    }
    public boolean combatir(){
        return true;
    }
    public boolean ponerACriar(){
        return true;
    }
    public boolean usarObjeto(){
        return true;
    }








}
