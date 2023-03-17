package org.example;

public class Mochila {
    private ObjetoEquipable[][] elementosMochila;

    public Mochila(){
        super();
    }

    public ObjetoEquipable[][] getElementosMochila() {
        return elementosMochila;
    }

    public void setElementosMochila(ObjetoEquipable[][] elementosMochila) {
        this.elementosMochila = elementosMochila;
    }

    public boolean introducirObjeto(){
        return true;
    }
    public boolean eliminarObjeto(){
        return true;
    }

}
