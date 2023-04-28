package org.Proyecto_Pokemon.model;

import java.util.Random;

public class MovEstado extends Movimiento {

    private float porcentajeCambio;
    private int precision;
    private int numTurnos;
    private int turnoDeUso;
    private Status estadoInflingible;
    private String statACambiar;
    public MovEstado(String nom,String statACambiar ,float cantidadAcambiar, int duracionTurnos, Tipo tipo) {
        this.porcentajeCambio = cantidadAcambiar;
        this.numTurnos = duracionTurnos;
        this.nombre = nom;
        this.tipo = tipo;
        this.costeEstamina = numTurnos * 10;
        this.statACambiar=statACambiar;
    }

    public void usarMov(String nom, int duracionTurnos, Tipo tipo, Status estado) {
        this.numTurnos = duracionTurnos;
        this.nombre = nom;
        this.tipo = tipo;
        this.costeEstamina = numTurnos * 10;
        this.estadoInflingible = estado;
    }


    public boolean usarMov(Pokemon objetivo,Pokemon usuario) {
        Random  rnd =new Random();
        setTurnoDeUso(Turno.getTurnoActual());
        if (usuario.getEstaminaActual() - this.getCosteEstamina() >= 0) {
            usuario.setStamina(usuario.getEstaminaActual() - this.getCosteEstamina());
            //Esto calcula si se salta el turno por estar paralizado
            if (usuario.getStatus().equals(Status.PARALIZADO) && rnd.nextInt(3)==0) return false;
            if (this.getEstadoInflingible() != null){
                if (this.getPrecision()-rnd.nextInt(101)>0){
                objetivo.setStatus(this.estadoInflingible);
                return true; }
                return false;

            }
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
    public void revertirEfecto(Pokemon objetivo) {
        if (turnoDeUso + numTurnos== Turno.getTurnoActual()){
            if (this.statACambiar == null) {
                objetivo.setStatus(Status.NORMAL);
                return;
            }
            if (statACambiar.equals("ataque")) {
                objetivo.setAtaque((int) (objetivo.getAtaque() * porcentajeCambio));
            } else if (statACambiar.equalsIgnoreCase("ataque especial")) {
                objetivo.setAtaqueEspecial((int) (objetivo.getAtaqueEspecial() * porcentajeCambio));
            } else if (statACambiar.equalsIgnoreCase("defensa especial")) {
                objetivo.setDefensaEspecial((int) (objetivo.getDefensaEspecial() * porcentajeCambio));
            } else if (statACambiar.equalsIgnoreCase("defensa")) {
                objetivo.setDefensa((int) (objetivo.getDefensa() * porcentajeCambio));
            } else if (statACambiar.equalsIgnoreCase("velocidad")) {
                objetivo.setVelocidad((int) (objetivo.getVelocidad() * porcentajeCambio));

            }}

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

    public int getTurnoDeUso() {
        return turnoDeUso;
    }

    public void setTurnoDeUso(int turnoDeUso) {
        this.turnoDeUso = turnoDeUso;
    }
}
