package org.Proyecto_Pokemon.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Pokemon {
    private  String nombre;
    //private final int ID;
    private String mote = nombre;
    private int vitalidad;
    private int velocidad;
    private int ataque;
    private int ataqueEspecial;
    private int defensa;
    private int defensaEspecial;
    private int stamina=200;
    private int nivel;

    private List<Tipo> tipos;
    private int fertilidad;

    private Status status;
    private Sexo sexo;
    private int vitalidadActual;
    Movimiento[] movimientosActivos;
    private Objeto objetoEquipado;
    private List<Movimiento> movimientosAprendibles;

    public Pokemon(){
        movimientosAprendibles = new LinkedList<>();
    }
    public Pokemon( int ataque, int vitalida, int velocidad, int ataqueEspecial, int defensa, int defensaEspecial, String nombre,Tipo tipo1){
        this.ataque=ataque;
        tipos=new ArrayList<>();
        this.nombre = nombre;
        this.defensa=defensa;
        this.defensaEspecial=defensaEspecial;
        this.ataqueEspecial=ataqueEspecial;
        this.velocidad=velocidad;
        this.vitalidad=vitalida;
        this.tipos.add(tipo1);
        this.vitalidadActual=vitalidad;

    }

    public Pokemon( int ataque, int vitalida, int velocidad, int ataqueEspecial, int defensa, int defensaEspecial, String nombre,Tipo tipo1,Tipo tipo2){
        tipos=new ArrayList<>();
        this.ataque=ataque;
        this.nombre = nombre;
        this.defensa=defensa;
        this.defensaEspecial=defensaEspecial;
        this.ataqueEspecial=ataqueEspecial;
        this.velocidad=velocidad;
        this.vitalidad=vitalida;
        this.tipos.add(tipo1);
        this.tipos.add(tipo2);

    }
    public boolean tenerHijo(Pokemon pareja){
        return true;
    }
    public boolean atacar(Ataque mov,Pokemon target){
        if (this.getStamina()-mov.costeStamina>=0){
            mov.atacar(target,this);
            return true;
        }
        return false;
    }
    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public void subirNivel(){

    }

    public void descansar(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Movimiento[] getMovimientosActivos() {
        return movimientosActivos;
    }

    public void setMovimientosActivos(Movimiento[] movimientosActivos) {
        this.movimientosActivos = movimientosActivos;
    }

    public Objeto getObjetoEquipado() {
        return objetoEquipado;
    }

    public void setObjetoEquipado(Objeto objetoEquipado) {
        this.objetoEquipado = objetoEquipado;
    }

    public List<Movimiento> getMovimientosAprendibles() {
        return movimientosAprendibles;
    }

    public void setMovimientosAprendibles(List<Movimiento> movimientosAprendibles) {
        this.movimientosAprendibles = movimientosAprendibles;
    }

    public int getVitalidadActual() {
        return vitalidadActual;
    }

    public void setVitalidadActual(int vitalidadActual) {
        this.vitalidadActual = vitalidadActual;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", mote='" + mote + '\'' +
                ", vitalidad=" + vitalidad +
                ", velocidad=" + velocidad +
                ", ataque=" + ataque +
                ", ataqueEspecial=" + ataqueEspecial +
                ", defensa=" + defensa +
                ", defensaEspecial=" + defensaEspecial +
                ", stamina=" + stamina +
                ", nivel=" + nivel +
                ", tipos=" + tipos +
                ", fertilidad=" + fertilidad +
                ", status=" + status +
                ", sexo=" + sexo +
                ", vitalidadActual=" + vitalidadActual +
                ", movimientosActivos=" + Arrays.toString(movimientosActivos) +
                ", objetoEquipado=" + objetoEquipado +
                ", movimientosAprendibles=" + movimientosAprendibles +
                '}';
    }
}