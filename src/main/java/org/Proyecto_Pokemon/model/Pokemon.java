package org.Proyecto_Pokemon.model;

import java.util.*;

public class  Pokemon {
    private  int estaminaActual;
    private  int estaminaMaxima;
    private  String nombre;
    private int experiencia;
    private  int id;
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

    public Pokemon(String nombre){
        this.nombre=nombre;
        this.mote=nombre;
    }

    public Pokemon(){
        this.mote=nombre;
        movimientosAprendibles = new LinkedList<>();
    }
    //Constructor usado en el crud
    public Pokemon(String nombre,Tipo tipo1,Tipo tipo2,int id,int vitalidadMaxima,int estaminaMaxima,int velocidad,int ataque,int ataqueEspecial,int defensa,int defensaEspecial, Movimiento movimientoInical){
        this.nombre=nombre;
        tipos=new ArrayList<>();
        tipos.add(tipo1);
        if (tipo2!=null){
            tipos.add(tipo2);
        }
        this.id=id;
        this.vitalidadMaxima=vitalidadMaxima;
        this.vitalidadActual=vitalidadMaxima;
        this.estaminaMaxima=estaminaMaxima;
        this.velocidad=velocidad;
        this.ataque=ataque;
        this.ataqueEspecial=ataqueEspecial;
        this.defensa=defensa;
        this.defensaEspecial=defensaEspecial;
        movimientosActivos=new Movimiento[4];
        this.movimientosActivos[0]=movimientoInical;

    }
    public Pokemon(String nombre,  int ataque, int vitalidadMaxima, int estamina, int velocidad, int ataqueEspecial, int defensa, int defensaEspecial, Tipo tipo, Movimiento primerMovimiento, Objeto objetoEquipable, Sexo sexo){
        this.nivel = 1;
        this.tipos=new ArrayList<>();
        movimientosAprendibles = new LinkedList<>();
        this.ataque = ataque;

        this.nombre = nombre;
        this.setMote(nombre);
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

        setStatus(Status.NORMAL);
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
/**
 * El metodo comprueba si tiene experiencia suficiente para subir de nivel,
 * y si la tiene te sube todas las stats aleatoriamente del 1 al 6
 * **/
    public void subirNivel(){
        if (this.getExperiencia()>=this.getNivel()*10){
        Random rd = new Random();

        vitalidadMaxima += rd.nextInt(1,6);
        ataque +=  rd.nextInt(1,6);
        defensa +=  rd.nextInt(1,6);
        ataqueEspecial +=  rd.nextInt(1,6);
        defensaEspecial +=  rd.nextInt(1,6);
        velocidad +=  rd.nextInt(1,6);
        setNivel(getNivel()+1);
    }}

/**
 * Este metodo  recpera la stamina del pokemon. Se puede hacer manualmente, o automaticamente al intentar usar un movimiento sin stamina**/
    public void descansar(){
      setEstaminaActual(this.getEstaminaMaxima());
    }

    //TODO Implementar bien crianza cuando estén todos los mínimos cubiertos

    public boolean tenerHijo(Pokemon pareja){
        return true;
    }

    /**
     * Usa un movimiento de cualquiera de las 3 variables posibles.
     * Para ello recibe un objetivo y un movimiento
     * Si no tiene estamina descansa.
     * @param mov
     * @param target
     **/

    public boolean usarMovimiento(Movimiento mov,Pokemon target){
        if ((this.getEstaminaActual()-mov.costeEstamina) >=0){
            mov.usarMov(target,this);
            return true;
        }
        this.descansar();
        return false;
    }

    //TODO IMplementar graficamente si da tiempo
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

        if (status!=null){

        return status;}
        return Status.NORMAL;

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
        return nombre;
    }
}