package org.Proyecto_Pokemon.model;

public class Mejora extends Movimiento {
private float cantidadAcambiar;
private int duracionMejora;
private String statACambiar;
private int turnoDeUso;

    public Mejora(String nom, float cantidadAcambiar, int duracionMejora, String stat,Tipo tipo) {
        this.cantidadAcambiar = cantidadAcambiar;
        this.duracionMejora = duracionMejora;
        this.nombre=nom;
        this.tipo=tipo;
        this.costeEstamina =this.duracionMejora*10 ;
        this.statACambiar=stat.toLowerCase();


    }

    public boolean usarMov(Pokemon enemigo,Pokemon beneficiario ) {

        if (beneficiario.getEstaminaActual() - this.getCosteEstamina() >= 0) {
            //Esto calcula si se salta el turno por estar paralizado
            if (beneficiario.getStatus().equals(Status.PARALIZADO) && rnd.nextInt(3)==0) return false;


            beneficiario.setEstaminaActual(beneficiario.getEstaminaActual()-this.getCosteEstamina());
            turnoDeUso=Turno.getTurnoActual();
            if (statACambiar.equals("ataque")) {
                beneficiario.setAtaque((int) (beneficiario.getAtaque() * cantidadAcambiar));
            } else if (statACambiar.equalsIgnoreCase("ataque especial")) {
                beneficiario.setAtaqueEspecial((int) (beneficiario.getAtaqueEspecial() * cantidadAcambiar));
            } else if (statACambiar.equalsIgnoreCase("defensa especial")) {
                beneficiario.setDefensaEspecial((int) (beneficiario.getDefensaEspecial() * cantidadAcambiar));
            } else if (statACambiar.equalsIgnoreCase("defensa")) {
                beneficiario.setDefensa((int) (beneficiario.getDefensa() * cantidadAcambiar));
            } else if (statACambiar.equalsIgnoreCase("velocidad")) {
                beneficiario.setVelocidad((int) (beneficiario.getVelocidad() * cantidadAcambiar));
            } else if (statACambiar.equalsIgnoreCase("vitalidad")) {
                beneficiario.setVitalidadActual((int) (beneficiario.getVitalidadActual() + cantidadAcambiar));

            }
        return true;}
    return false;}

    public void  revertirEfecto(Pokemon beneficiario){
        if (turnoDeUso + duracionMejora== Turno.getTurnoActual() ) {

            if (statACambiar.equals("ataque")) {
                beneficiario.setAtaque((int) (beneficiario.getAtaque() / cantidadAcambiar));
            } else if (statACambiar.equalsIgnoreCase("ataque especial")) {
                beneficiario.setAtaqueEspecial((int) (beneficiario.getAtaqueEspecial() / cantidadAcambiar));
            } else if (statACambiar.equalsIgnoreCase("defensa especial")) {
                beneficiario.setDefensaEspecial((int) (beneficiario.getDefensaEspecial() / cantidadAcambiar));
            } else if (statACambiar.equalsIgnoreCase("defensa")) {
                beneficiario.setDefensa((int) (beneficiario.getDefensa() / cantidadAcambiar));
            } else if (statACambiar.equalsIgnoreCase("velocidad")) {
                beneficiario.setVelocidad((int) (beneficiario.getVelocidad() / cantidadAcambiar));
            }
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
