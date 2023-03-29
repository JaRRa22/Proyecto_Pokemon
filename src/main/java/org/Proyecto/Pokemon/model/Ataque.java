package org.Proyecto.Pokemon.model;

import java.util.LinkedList;
import java.util.List;

public class Ataque extends Movimiento {
    private int potencia;
    private int precision;
    private String variedad;//FIsico O Especial Si el Pokemon ataca con el cuerpo, el Ataque será fisico. Si no Será especial. Por ejemplo, puño fuego sería físico, impactrueno sería especial

    public Ataque(String nombre, int potencia, int precision, Tipo tipo, String var) {
        this.variedad=var.toUpperCase();
        this.potencia = potencia;
        this.precision = precision;
        this.nombre=nombre;
        this.costeStamina=potencia/2;
        this.tipo=tipo;

    }

    //TODO
    public int calcularDanyo(Pokemon usuario, Pokemon objetivo){
        if (usuario.getStamina()-this.getCosteStamina()>=0){

        if(this.variedad.equalsIgnoreCase("FISICO")){
         int dmg= (this.potencia*usuario.getAtaque())/objetivo.getDefensa();
         if (dmg<0){
             dmg=1;
         }
         return dmg;
    }
        if(this.variedad.equalsIgnoreCase("ESPECIAL")){
            int dmg= (this.potencia*usuario.getAtaqueEspecial())/objetivo.getDefensaEspecial();
            if (dmg<0){
                dmg=1;
            }
            return dmg;
        }
    } return 0;}





    public void atacar(Pokemon objetivo, Pokemon usuario) {

        calcularDanyo(usuario,objetivo);
        objetivo.setVitalidad(objetivo.getVitalidad());

    }}

