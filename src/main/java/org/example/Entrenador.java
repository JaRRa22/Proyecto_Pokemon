package org.example;

public class Entrenador {
    private String nombre;
    //private Pokemon[]equipoPK;
    //private Pokemon[]equipoPK2;
    //private PC pc;
    private int pokedollars;
    private Mochila mochila;

    public Entrenador(String nombre){
        this.nombre = nombre;
       this.pokedollars = 0;
       this.mochila = new Mochila();
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

    public boolean añadir(ObjetoEquipable objeto, int posi1, int posi2){
        if(posi1 <= 5 && posi1 >=0 && posi2 <=5 && posi2 >=0) {
            boolean prueba = mochila.introducirObjeto(objeto, posi1, posi2);
            return prueba;
        }
        return false;
    }
    public boolean sacar(int posi1, int posi2){
        if(posi1 <= 5 && posi1 >=0 && posi2 <=5 && posi2 >=0) {
            boolean prueba = mochila.eliminarObjeto(posi1,posi2);
            return prueba;
        }
        else
            return false;
    }
    public Mochila saberMochila(){
        return mochila;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.pokedollars + " " + this.mochila;
    }
}
