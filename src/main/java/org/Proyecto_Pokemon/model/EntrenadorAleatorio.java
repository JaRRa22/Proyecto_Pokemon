package org.Proyecto_Pokemon.model;

public class EntrenadorAleatorio extends Entrenador{
    private int nivelesCopiados;

    public EntrenadorAleatorio(String nombre) {
        super(nombre);
    }

    public int getNivelesCopiados() {
        return nivelesCopiados;
    }

    public void setNivelesCopiados(int nivelesCopiados) {
        this.nivelesCopiados = nivelesCopiados;
    }

    public void copiarNiveles(){

  }
}
