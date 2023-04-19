package org.Proyecto_Pokemon.model;

public class MovEstado extends Movimiento {

    private float porcentajeCambio;
    private int precision;
    private int numTurnos;
    private Status estadoInflingible;
    private String statACambiar;
    public MovEstado(String nom,String statACambiar ,float cantidadAcambiar, int duracionTurnos, Tipo tipo) {
        this.porcentajeCambio = cantidadAcambiar;
        this.numTurnos = duracionTurnos;
        this.nombre = nom;
        this.tipo = tipo;
        this.costeStamina = numTurnos * 10;
        this.statACambiar=statACambiar;
    }

    public MovEstado(String nom, int duracionTurnos, Tipo tipo, Status estado) {
        this.numTurnos = duracionTurnos;
        this.nombre = nom;
        this.tipo = tipo;
        this.costeStamina = numTurnos * 10;
        this.estadoInflingible = estado;
    }


    public boolean aplicarDebuff(Pokemon objetivo,Pokemon usuario) {
        if (usuario.getStamina() - this.getCosteStamina() >= 0) {
            usuario.setStamina(usuario.getStamina() - this.getCosteStamina());

            if (statACambiar.equals("ataque")) {
                objetivo.setAtaque((int) (objetivo.getAtaque() / porcentajeCambio));
            } else if (statACambiar.equalsIgnoreCase("ataque especial")) {
                objetivo.setAtaqueEspecial((int) (objetivo.getAtaqueEspecial() / porcentajeCambio));
            } else if (statACambiar.equalsIgnoreCase("defensa especial")) {
                objetivo.setDefensaEspecial((int) (objetivo.getDefensaEspecial() / porcentajeCambio));
            } else if (statACambiar.equalsIgnoreCase("defensa")) {
                objetivo.setDefensa((int) (objetivo.getDefensa() / porcentajeCambio));
            } else if (statACambiar.equalsIgnoreCase("velocidad")) {
                objetivo.setVelocidad((int) (objetivo.getVelocidad() / porcentajeCambio));


            }

            return true;}
        return false;
    }

    public boolean aplicar(Pokemon objetivo, Pokemon usuario){
        if (usuario.getStamina() - this.getCosteStamina() >= 0) {
            usuario.setStamina(usuario.getStamina() - this.getCosteStamina());
        objetivo.setStatus(this.estadoInflingible);
       return true; }
        return false;

    }

    public float getPorcentajeCambio() {
        return porcentajeCambio;
    }

    public void setPorcentajeCambio(float porcentajeCambio) {
        this.porcentajeCambio = porcentajeCambio;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getNumTurnos() {
        return numTurnos;
    }

    public void setNumTurnos(int numTurnos) {
        this.numTurnos = numTurnos;
    }

    public Status getEstadoInflingible() {
        return estadoInflingible;
    }

    public void setEstadoInflingible(Status estadoInflingible) {
        this.estadoInflingible = estadoInflingible;
    }

    public String getStatACambiar() {
        return statACambiar;
    }

    public void setStatACambiar(String statACambiar) {
        this.statACambiar = statACambiar;
    }
}
