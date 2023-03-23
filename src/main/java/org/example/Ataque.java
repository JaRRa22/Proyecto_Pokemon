package org.example;

public class Ataque extends  Movimiento{
    private int potencia;
    private int precision;

    public Ataque(String nombre,int potencia, int precision,Tipo tipo) {
        this.potencia = potencia;
        this.precision = precision;
        this.nombre=nombre;
        this.costeStamina=potencia/2;
        this.tipo=tipo;

    }

    //TODO
    public int calcularDanyo(){
return 0;
    }



    @Override
    public void aplicar(Pokemon objetivo) {

        objetivo.setVida(objetivo.getVida()-potencia);

    }

}
