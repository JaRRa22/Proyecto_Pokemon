package org.Proyecto_Pokemon.model;

import java.util.*;

public class Pokemon {
    private  int estaminaActual;
    private  int estaminaMaxima;
    private  String nombre;

    private int experiencia;
    //private final int ID;

    private String mote;
    private int vitalidadMaxima;
    private int velocidad;
    private int ataque;
    private int ataqueEspecial;
    private int defensa;
    private int defensaEspecial;
    private int stamina;
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
    public Pokemon(String nombre,  int ataque, int vitalidadMaxima, int estamina, int velocidad, int ataqueEspecial, int defensa, int defensaEspecial, Tipo tipo, Movimiento primerMovimiento, Objeto objetoEquipable, Sexo sexo){
        this.nivel = 1;
        this.tipos=new ArrayList<>();
        movimientosAprendibles = new LinkedList<>();
        this.ataque = ataque;
        this.mote = nombre;
        this.nombre = nombre;
        this.defensa = defensa;
        this.objetoEquipado = objetoEquipable;
        this.sexo = sexo;
        this.defensaEspecial = defensaEspecial;
        this.ataqueEspecial = ataqueEspecial;
        this.estaminaMaxima = estamina;
        this.estaminaActual = estamina;
        this.velocidad = velocidad;
        this.vitalidadMaxima = vitalidadMaxima;
        this.vitalidadActual = vitalidadMaxima;
        this.fertilidad = 5;
        this.movimientosActivos = new Movimiento[4];
        movimientosActivos[0] = primerMovimiento;
        tipos.add(tipo);
        this.status = Status.NORMAL;
        this.experiencia=0;
    }


    public Pokemon(String nombre, int ataque, int vitalidad, int estamina, int velocidad, int ataqueEspecial, int defensa, int defensaEspecial, Movimiento primerMovimiento, Tipo tipo1, Tipo tipo2, Objeto objetoEquipable, Sexo sexo){
        this.nivel = 1;
        this.tipos=new ArrayList<>();
        this.mote = nombre;
        movimientosAprendibles = new LinkedList<>();
        this.ataque = ataque;
        this.nombre = nombre;
        this.defensa = defensa;
        this.objetoEquipado = objetoEquipable;
        this.sexo = sexo;
        this.defensaEspecial = defensaEspecial;
        this.ataqueEspecial = ataqueEspecial;
        this.estaminaMaxima = estamina;
        this.estaminaActual = estamina;
        this.velocidad = velocidad;
        this.vitalidadMaxima = vitalidad;
        this.vitalidadActual = vitalidad;
        this.fertilidad = 5;
        this.movimientosActivos = new Movimiento[4];
        movimientosActivos[0] = primerMovimiento;
        tipos.add(tipo1);
        tipos.add(tipo2);
        this.status = getStatus();
        this.experiencia=0;
    }

    public void subirNivel(){
        if (this.getExperiencia()>=this.getNivel()*10){
        Random rd = new Random();
        int mejora = rd.nextInt(1, 6);
        vitalidadMaxima += mejora;
        ataque += mejora;
        defensa += mejora;
        ataqueEspecial += mejora;
        defensaEspecial += mejora;
        velocidad += mejora;
    }}

    public void descansar(){
        estaminaActual = estaminaMaxima;
    }
    public boolean tenerHijo(Pokemon pareja){
        return true;
    }
    public boolean usarMovimiento(Movimiento mov,Pokemon target){
        if (this.getEstaminaActual()-mov.costeEstamina >=0){
            mov.usarMov(target,this);
            return true;
        }
        this.descansar();
        return false;
    }





    public boolean sePuedeAprenderMovimiento(){
        if (this.getNivel()%3==0){

            preguntarSiQuiereAprenderMovimiento();


            return true;
        }
        return false;
    }

    public String preguntarSiQuiereAprenderMovimiento(){
        String nombreMovimiento=this.getMovimientosAprendibles().get((getNivel()/3)-1).getNombre();
        return "¿Quieres reemplazar alguno de tus movimientos por "  + nombreMovimiento + "?";
    }

    public void reemplazarMovimiento(int indiceMovimiento){
        try{
            Movimiento[] arrayReemplazado=this.getMovimientosActivos();
            arrayReemplazado[indiceMovimiento]=movimientosAprendibles.get((this.getNivel()/3)-1);
            this.setMovimientosActivos(arrayReemplazado);


        }catch (IndexOutOfBoundsException ignored){

        }
    }

    public int getEstaminaActual() {
        return estaminaActual;
    }

    public void setEstaminaActual(int estaminaActual) {
        this.estaminaActual = estaminaActual;
    }

    public int getEstaminaMaxima() {
        return estaminaMaxima;
    }

    public void setEstaminaMaxima(int estaminaMaxima) {
        this.estaminaMaxima = estaminaMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getVitalidadMaxima() {
        return vitalidadMaxima;
    }

    public void setVitalidadMaxima(int vitalidadMaxima) {
        this.vitalidadMaxima = vitalidadMaxima;
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

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
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

    public int getVitalidadActual() {
        return vitalidadActual;
    }

    public void setVitalidadActual(int vitalidadActual) {
        this.vitalidadActual = vitalidadActual;
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

    @Override
    public String toString() {
        return "Pokemon{" +
                "estaminaActual=" + estaminaActual +
                ", estaminaMaxima=" + estaminaMaxima +
                ", nombre='" + nombre + '\'' +
                ", experiencia=" + experiencia +
                ", mote='" + mote + '\'' +
                ", vitalidadMaxima=" + vitalidadMaxima +
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