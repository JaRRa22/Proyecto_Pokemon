package org.example;

public class Mochila {
    private ObjetoEquipable[][] elementosMochila;

    public Mochila(){
        elementosMochila = new ObjetoEquipable[5][5];
    }

    public ObjetoEquipable[][] getElementosMochila() {
        return elementosMochila;
    }

    public void setElementosMochila(ObjetoEquipable[][] elementosMochila) {
        this.elementosMochila = elementosMochila;
    }

    public boolean introducirObjeto(ObjetoEquipable objeto , int posi1, int posi2){
       if(elementosMochila[posi1][posi2] == null){
           this.elementosMochila[posi1][posi2] = objeto;
           return true;
       }
       else{
           return false;
        }
    }
    public boolean eliminarObjeto(int posi1, int posi2){
        if(elementosMochila[posi1][posi2] != null){
            elementosMochila[posi1][posi2] = null;
            return true;
        }
        else{
            return false;
        }
    }



}
