package org.Proyecto_Pokemon.model;

public class ObjetoEquipable extends Objeto{
    public ObjetoEquipable(TipoObjetos tipo) {
        super(tipo);
    }

    @Override
    public TipoObjetos getTipo() {
        return super.getTipo();
    }

    @Override
    public int getCantidad() {
        return super.getCantidad();
    }

    @Override
    public void setCantidad(int cantidad) {
        super.setCantidad(cantidad);
    }
}
