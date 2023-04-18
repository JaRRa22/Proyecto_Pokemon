package org.Proyecto_Pokemon.model;

public class Mejora extends Movimiento {
private float cantidadAcambiar;
private int duracionMejora;
private String statACambiar;

    public Mejora(String nom, float cantidadAcambiar, int duracionMejora, String stat,Tipo tipo) {
        this.cantidadAcambiar = cantidadAcambiar;
        this.duracionMejora = duracionMejora;
        this.nombre=nom;
        this.tipo=tipo;
        this.costeStamina=duracionMejora*10;
        this.statACambiar=stat.toLowerCase();


    }

    public void mejorarStat(Pokemon beneficiario ){
        if (statACambiar.equals("ataque")){
            beneficiario.setAtaque((int) (beneficiario.getAtaque()*cantidadAcambiar));
        } else if (statACambiar.equalsIgnoreCase("ataque especial")) {
            beneficiario.setAtaqueEspecial((int) (beneficiario.getAtaqueEspecial()*cantidadAcambiar));
        }
        else if (statACambiar.equalsIgnoreCase("defensa especial")) {
            beneficiario.setDefensaEspecial((int) (beneficiario.getDefensaEspecial()*cantidadAcambiar));
        }
        else if (statACambiar.equalsIgnoreCase("defensa")) {
            beneficiario.setDefensa((int) (beneficiario.getDefensa()*cantidadAcambiar));
        }
        else if (statACambiar.equalsIgnoreCase("velocidad")) {
            beneficiario.setVelocidad((int) (beneficiario.getVelocidad()*cantidadAcambiar));
        } else if (statACambiar.equalsIgnoreCase("vitalidad")) {
            beneficiario.setVitalidadActual((int) (beneficiario.getVitalidadActual()+ cantidadAcambiar));

        }
    }



    public float getCantidadAcambiar() {
        return cantidadAcambiar;
    }

    public void setCantidadAcambiar(float cantidadAcambiar) {
        this.cantidadAcambiar = cantidadAcambiar;
    }

    public int getDuracionMejora() {
        return duracionMejora;
    }

    public void setDuracionMejora(int duracionMejora) {
        this.duracionMejora = duracionMejora;
    }
}
