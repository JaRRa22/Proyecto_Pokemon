package org.Proyecto_Pokemon.model;

import org.Proyecto_Pokemon.Logger;

import java.io.IOException;
import java.util.Random;

public class Ataque extends Movimiento {
    Random rnd= new Random();
    private int potencia;
    private int precision;

    /**
     * La String variedad determina si un movimiento es fisico o especial y lo usa para calcular daño
     * **/
    private String variedad;

    public Ataque(String nombre, int potencia, int precision, Tipo tipo, String var) {
        this.variedad = var.toUpperCase();
        this.potencia = potencia;
        this.precision = precision;
        this.nombre = nombre;
        this.costeEstamina = potencia / 2;
        this.tipo = tipo;

    }

    /**
     * @param usuario
     * @param objetivo
     * @return dmg
     * El metodo incluye u multiplicador por Stab y un condicional que cambia la formula dependiendo si el ataque usado es fisico o especial.
     * La formula esta copiada desde la wiki. Llama al metodo de calcular la debilidad para que aumente o disminuya el daño
     * En caso de que el daño inflingido sea 0 o menor, devuelve 1
     *
     *
     * **/
    public int calcularDanyo(Pokemon usuario, Pokemon objetivo) throws IOException {
        float stab= 1.0f;

            if (usuario.getTipos().contains(this.tipo)) stab=1.5f;
            if (this.variedad.equalsIgnoreCase("FISICO")) {
                int dmg = (int) (stab*(this.potencia * usuario.getAtaque()) * calcularDebilidad(objetivo) / objetivo.getDefensa());

                if (dmg < 0) {
                    dmg = 1;
                }
                return dmg;
            }
            if (this.variedad.equalsIgnoreCase("ESPECIAL")) {
                int dmg = (int) ((int) stab* (this.potencia * usuario.getAtaqueEspecial()) *calcularDebilidad(objetivo) / objetivo.getDefensaEspecial());
                if (dmg < 0) {
                    dmg = 1;
                }
                return dmg;
            }

        return 0;
    }


/**
 * @param objetivo
 * el enemigo que va a recibir el daño
 * @param usuario
 * Usuario es añadido para que los metodos sean compatibles entree todos los movimientos
 * El movimiento comprueba  si es usable y si acierta.
 * En caso de que acierte reduce la vida del rival en funcion del daño que haga el ataque
 * **/
    public boolean usarMov(Pokemon objetivo, Pokemon usuario) throws IOException {

            if (usuario.getEstaminaActual()-this.getCosteEstamina()>=0){
                //Esto calcula si se salta el turno por estar paralizado
                if (usuario.getStatus().equals(Status.PARALIZADO) && rnd.nextInt(3)==0) return false;
                if (this.precision-rnd.nextInt(101)>0){
                    usuario.setEstaminaActual(usuario.getEstaminaActual()- this.getCosteEstamina());
                    int dmg = calcularDanyo(usuario, objetivo);
                    objetivo.setVitalidadActual(objetivo.getVitalidadActual() - dmg);
                    return true;
        }}
            Logger.write("El movimiento ha fallado");
        return false;
    }

/**
 * Puede ser optimizado.
 * Este metodo recorre la lista de tipos del objetivo y dependiendo de las debilidades o resistencias devuelve un multiplicador
 * **/
    public float calcularDebilidad(Pokemon objetivo) throws IOException {
        float multiplicadorDmg = 1;
        for (Tipo tipo : objetivo.getTipos()) {
            if (this.tipo.equals(Tipo.AGUA)) {
                if (tipo.equals(Tipo.TIERRA) || tipo.equals(Tipo.FUEGO) || tipo.equals(Tipo.ROCA)) {
                    multiplicadorDmg *= 2;
                } else if (tipo.equals(Tipo.AGUA) || tipo.equals(Tipo.DRAGON) || tipo.equals(Tipo.PLANTA)) {
                    multiplicadorDmg *= 0.5f;
                }
            } else if (this.tipo.equals(Tipo.NORMAL)) {
                if (tipo.equals(Tipo.FANTASMA)) {
                    return 0;
                } else if (tipo.equals(Tipo.ROCA) || tipo.equals(Tipo.ACERO)) multiplicadorDmg *= 0.25f;

            } else if (this.tipo.equals(Tipo.VOLADOR)) {
                if (tipo.equals(Tipo.BICHO) || tipo.equals(Tipo.LUCHA) || tipo.equals(Tipo.PSIQUICO))
                    multiplicadorDmg *= 2;
                else if (tipo.equals(Tipo.ROCA) || tipo.equals(Tipo.ACERO) || tipo.equals(Tipo.ELECTRICO)) {
                    multiplicadorDmg *= 0.5f;
                }
            } else if (this.tipo.equals(Tipo.ROCA)) {
                if (tipo.equals(Tipo.BICHO) || tipo.equals(Tipo.FUEGO) || tipo.equals(Tipo.VOLADOR) || tipo.equals(Tipo.HIELO))
                    multiplicadorDmg *= 2;
                else if (tipo.equals(Tipo.LUCHA) || tipo.equals(Tipo.ACERO) || tipo.equals(Tipo.SINIESTRO)) {
                    multiplicadorDmg *= 0.5f;
                }
            } else if (this.tipo.equals(Tipo.LUCHA)) {
                if (tipo.equals(Tipo.ROCA) || tipo.equals(Tipo.ACERO) || tipo.equals(Tipo.SINIESTRO) || tipo.equals(Tipo.HIELO) || tipo.equals(Tipo.NORMAL))
                    multiplicadorDmg *= 2;
                else if (tipo.equals(Tipo.VOLADOR) || tipo.equals(Tipo.PSIQUICO) || tipo.equals(Tipo.VENENO) || tipo.equals(Tipo.BICHO)) {
                    multiplicadorDmg *= 0.5f;
                } else if (tipo.equals(Tipo.FANTASMA)) {
                    return 0;
                }
            } else if (this.tipo.equals(Tipo.TIERRA)) {
                if (tipo.equals(Tipo.ROCA) || tipo.equals(Tipo.ACERO) || tipo.equals(Tipo.SINIESTRO) || tipo.equals(Tipo.VENENO) || tipo.equals(Tipo.ELECTRICO))
                    multiplicadorDmg *= 2;
                else if (tipo.equals(Tipo.BICHO) || tipo.equals(Tipo.PLANTA)) {
                    multiplicadorDmg *= 0.5f;
                } else if (tipo.equals(Tipo.VOLADOR)) {
                    return 0;
                }
            } else if (this.tipo.equals(Tipo.VENENO)) {
                if (tipo.equals(Tipo.PLANTA))
                    multiplicadorDmg *= 2;
                else if (tipo.equals(Tipo.FANTASMA) || tipo.equals(Tipo.ROCA) || tipo.equals(Tipo.TIERRA) || tipo.equals(Tipo.VENENO)) {
                    multiplicadorDmg *= 0.5f;
                } else if (tipo.equals(Tipo.ACERO)) {
                    return 0;
                }
            } else if (this.tipo.equals(Tipo.FANTASMA)) {
                if (tipo.equals(Tipo.FANTASMA))
                    multiplicadorDmg *= 2;
                else if (tipo.equals(Tipo.SINIESTRO)) {
                    multiplicadorDmg *= 0.5f;
                } else if (tipo.equals(Tipo.NORMAL)) {
                    return 0;
                }
            } else if (this.tipo.equals(Tipo.ELECTRICO)) {
                if (tipo.equals(Tipo.AGUA) || tipo.equals(Tipo.VOLADOR))
                    multiplicadorDmg *= 2;
                else if (tipo.equals(Tipo.DRAGON) || tipo.equals(Tipo.ELECTRICO) || tipo.equals(Tipo.PLANTA)) {
                    multiplicadorDmg *= 0.5f;
                } else if (tipo.equals(Tipo.TIERRA)) {
                    return 0;
                }
            } else if (this.tipo.equals(Tipo.PLANTA)) {
                if (tipo.equals(Tipo.TIERRA) || tipo.equals(Tipo.AGUA) || tipo.equals(Tipo.ROCA)) {
                    multiplicadorDmg *= 2;
                } else if (tipo.equals(Tipo.ACERO) || tipo.equals(Tipo.DRAGON) || tipo.equals(Tipo.PLANTA) || tipo.equals(Tipo.FUEGO) || tipo.equals(Tipo.BICHO) || tipo.equals(Tipo.VENENO) || tipo.equals(Tipo.VOLADOR)) {
                    multiplicadorDmg *= 0.5f;
                }
            } else if (this.tipo.equals(Tipo.FUEGO)) {
                if (tipo.equals(Tipo.PLANTA) || tipo.equals(Tipo.HIELO) || tipo.equals(Tipo.BICHO) || tipo.equals(Tipo.ACERO)) {
                    multiplicadorDmg *= 2;
                } else if (tipo.equals(Tipo.AGUA) || tipo.equals(Tipo.DRAGON) || tipo.equals(Tipo.FUEGO) || tipo.equals(Tipo.ROCA)) {
                    multiplicadorDmg *= 0.5f;
                }
            } else if (this.tipo.equals(Tipo.PSIQUICO)) {
                if (tipo.equals(Tipo.VENENO) || tipo.equals(Tipo.LUCHA))
                    multiplicadorDmg *= 2;
                else if (tipo.equals(Tipo.ACERO) || tipo.equals(Tipo.PSIQUICO)) {
                    multiplicadorDmg *= 0.5f;
                } else if (tipo.equals(Tipo.SINIESTRO)) {
                    return 0;
                }
            } else if (this.tipo.equals(Tipo.SINIESTRO)) {
                if (tipo.equals(Tipo.PSIQUICO) || tipo.equals(Tipo.FANTASMA)) {
                    multiplicadorDmg *= 2;
                } else if (tipo.equals(Tipo.LUCHA) || tipo.equals(Tipo.ROCA)) {
                    multiplicadorDmg *= 0.5f;
                }
            } else if (this.tipo.equals(Tipo.ACERO)) {
                if (tipo.equals(Tipo.HIELO) || tipo.equals(Tipo.ROCA)) {
                    multiplicadorDmg *= 2;
                } else if (tipo.equals(Tipo.ACERO) || tipo.equals(Tipo.AGUA) || tipo.equals(Tipo.ELECTRICO) || tipo.equals(Tipo.FUEGO)) {
                    multiplicadorDmg *= 0.5f;
                }
            } else if (this.tipo.equals(Tipo.DRAGON)) {
                if (tipo.equals(Tipo.DRAGON)) {
                    multiplicadorDmg *= 2;
                } else if (tipo.equals(Tipo.ACERO)) {
                    multiplicadorDmg *= 0.5f;
                }
            } else if (this.tipo.equals(Tipo.BICHO)) {
                if (tipo.equals(Tipo.PSIQUICO) || tipo.equals(Tipo.PLANTA) || tipo.equals(Tipo.SINIESTRO)) {
                    multiplicadorDmg *= 2;
                } else if (tipo.equals(Tipo.ACERO) || tipo.equals(Tipo.FANTASMA) || tipo.equals(Tipo.LUCHA) || tipo.equals(Tipo.FUEGO) || tipo.equals(Tipo.VOLADOR) || tipo.equals(Tipo.VENENO)) {
                    multiplicadorDmg *= 0.5f;
                }
            } else if (this.tipo.equals(Tipo.HIELO)) {
                if (tipo.equals(Tipo.DRAGON) || tipo.equals(Tipo.PLANTA) || tipo.equals(Tipo.SINIESTRO)) {
                    multiplicadorDmg *= 2;
                } else if (tipo.equals(Tipo.ACERO) || tipo.equals(Tipo.AGUA) || tipo.equals(Tipo.HIELO) || tipo.equals(Tipo.FUEGO)) {
                    multiplicadorDmg *= 0.5f;
                }
            }}
            if (multiplicadorDmg<1){
                Logger.write("Es poco eficaz\n");
            }else if (multiplicadorDmg>1){
                Logger.write("Es super eficaz\n");

            }


            return multiplicadorDmg;}
}
