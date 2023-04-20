package org.Proyecto_Pokemon.model;

import java.util.HashMap;

public class Tienda {
    private HashMap<TipoObjetos, Integer> productos;
    public Tienda(){
        productos = new HashMap<>();
        productos.put(TipoObjetos.POKEBALL,200);
        productos.put(TipoObjetos.BASTON,300);
        productos.put(TipoObjetos.PESA,300);
        productos.put(TipoObjetos.CHALECO,300);
        productos.put(TipoObjetos.PILAS,300);
        productos.put(TipoObjetos.PLUMA,300);
    }

    public HashMap<TipoObjetos, Integer> getProductos() {
        return productos;
    }
    public boolean comprar(TipoObjetos objeto){
        Pokeball pokeball = new Pokeball(TipoObjetos.POKEBALL, TipoPokeball.POKEBALL);
        ObjetoEquipable baston = new ObjetoEquipable(TipoObjetos.BASTON);
        ObjetoEquipable pesa = new ObjetoEquipable(TipoObjetos.PESA);
        ObjetoEquipable chaleco = new ObjetoEquipable(TipoObjetos.CHALECO);
        ObjetoEquipable pilas = new ObjetoEquipable(TipoObjetos.PILAS);
        ObjetoEquipable pluma = new ObjetoEquipable(TipoObjetos.PLUMA);

        if(Entrenador.getPokedollars() < productos.get(objeto))
            return false;

        if(objeto.equals(TipoObjetos.POKEBALL)){
            Entrenador.introducirElementos(pokeball);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 200);
        }
        if(objeto.equals(TipoObjetos.BASTON)){
            Entrenador.introducirElementos(baston);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        if(objeto.equals(TipoObjetos.PESA)){
            Entrenador.introducirElementos(pesa);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        if(objeto.equals(TipoObjetos.CHALECO)){
            Entrenador.introducirElementos(chaleco);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        if(objeto.equals(TipoObjetos.PILAS)){
            Entrenador.introducirElementos(pilas);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        if(objeto.equals(TipoObjetos.PLUMA)){
            Entrenador.introducirElementos(pluma);
            Entrenador.setPokedollars(Entrenador.getPokedollars() - 300);
        }
        return true;
    }
}
