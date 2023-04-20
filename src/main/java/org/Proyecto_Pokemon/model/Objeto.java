package org.Proyecto_Pokemon.model;

public abstract class  Objeto{
    private TipoObjetos tipo;
    private int cantidad;

    public Objeto(TipoObjetos tipo){
        this.tipo = tipo;
    }

    public TipoObjetos getTipo() {
        return tipo;
    }

    public void setTipo(TipoObjetos tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "" + this.getTipo();
    }
}

