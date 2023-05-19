package org.Proyecto_Pokemon.database;

import org.Proyecto_Pokemon.controller.InicioController;
import org.Proyecto_Pokemon.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public  class  CRUD {
    public  static PreparedStatement ps = null;
    public static String nombre = "";
    public static String contrasena = "";


    public static HashMap<String,String>usuarioContraseña = new HashMap<>();
    public static List<Movimiento>listaMovimientos=new LinkedList<>();
     public static HashMap<String,Movimiento>dicMovimientos=new HashMap<>();
    public static HashMap<Integer,Pokemon>pokedex=new HashMap<>();
    public static Pokemon sacarEjemplarPokemonPokedex(int id){
     return pokedex.get(id).crearEspecimenConVariabilidad();
    }
    //Ya funciona
    public static void insertarPokemonsDelEquipoEnBaseDeDatos(Pokemon pokemon) throws SQLException {
        MySQLConnection.getConnection();//
        ps = MySQLConnection.getConnection().prepareStatement("INSERT INTO POKEMON(ID_ENTRENADOR,ID_POKEMON,NOMBRE_POKEMON,VITALIDAD_MAXIMA,VELOCIDAD,ATAQUE,ATAQUE_ESPECIAL,DEFENSA,DEFENSA_ESPECIAL,STAMINA_MAXIMA," +
                "NOMBRE_MOVIMIENTO_INICIAL,TIPO1,TIPO2)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1,Entrenador.getId());
        ps.setInt(2,pokemon.getId());
        ps.setString(3,pokemon.getNombre());
        ps.setInt(4,pokemon.getVitalidadMaxima());
        ps.setInt(5,pokemon.getVelocidad());
        ps.setInt(6,pokemon.getAtaque());
        ps.setInt(7,pokemon.getAtaqueEspecial());
        ps.setInt(8,pokemon.getDefensa());
        ps.setInt(9,pokemon.getDefensaEspecial());
        ps.setInt(10,pokemon.getEstaminaMaxima());
        ps.setString(11,pokemon.getMovimientosActivos()[0].getNombre());
        int indice=12;
        if (pokemon.getTipos().size()>1){
            //No funciona
            ps.setString(12,pokemon.getTipos().get(0).toString());
            ps.setString(13,pokemon.getTipos().get(1).toString());
        }else {
            ps.setString(12,pokemon.getTipos().get(0).toString());
            ps.setString(13,"No");
        }







        ps.executeUpdate();}
    //TODO completar para que te guarde en el equipo
    public void insertarPokemonsEnEquipo(int idEntrenador) throws SQLException {
        String query="SELECT ID_ENTRENADOR,ID_POKEMON,NOMBRE_POKEMON,VITALIDAD_MAXIMA,VELOCIDAD,ATAQUE,ATAQUE_ESPECIAL,DEFENSA,DEFENSA_ESPECIAL,STAMINA_MAXIMA,NOMBRE_MOVIMIENTO_INICIAL,TIPO1,TIPO2 FROM POKEMON WHERE" +
                " ID_ENTRENADOR= '" +idEntrenador +"'";
        PreparedStatement datosStatment = null;
        datosStatment = MySQLConnection.getConnection().prepareStatement(query);
        ResultSet resultSet = datosStatment.executeQuery();
        int i=0;

        while(resultSet.next()){

            Entrenador.getEquipoPK()[i]=
            String contrasena = resultSet.getString("CONTRASENA");
            String nombre = resultSet.getString("NOMBRE");
            int pokedollars = resultSet.getInt("POKEDOLLAR");
            int id =  resultSet.getInt("ID");
            usuarioContraseña.put(nombre,contrasena);

        }





    }





    public static int leerIdEntrenadorBBDDD(String nombreEntrenador) throws SQLException {
        String miCuenta =  "SELECT ID FROM entrenador WHERE NOMBRE='" +nombreEntrenador +"'" ;
        PreparedStatement datosStatment = null;
        datosStatment = MySQLConnection.getConnection().prepareStatement(miCuenta);
        ResultSet resultSet = datosStatment.executeQuery();


        while(resultSet.next()){
         int id=resultSet.getInt("ID");
         return id;


    }return 0;}
    public static void leerUsuarioDDBB() throws SQLException {
        String miCuenta =  "SELECT NOMBRE,CONTRASENA ,POKEDOLLAR,ID FROM entrenador";
        PreparedStatement datosStatment = null;
        datosStatment = MySQLConnection.getConnection().prepareStatement(miCuenta);
        ResultSet resultSet = datosStatment.executeQuery();


        while(resultSet.next()){
            String contrasena = resultSet.getString("CONTRASENA");
            String nombre = resultSet.getString("NOMBRE");
            int pokedollars = resultSet.getInt("POKEDOLLAR");
            int id =  resultSet.getInt("ID");
            usuarioContraseña.put(nombre,contrasena);
        }

    }

    public static void addUsuario() throws SQLException {
        MySQLConnection.getConnection();
       ps = MySQLConnection.getConnection().prepareStatement("INSERT INTO entrenador(NOMBRE,CONTRASENA)VALUES(?,?)");
       ps.setString(1,InicioController.nombre);
       ps.setString(2,InicioController.contrasenaElegida);
       ps.executeUpdate();
   }



    public static void addNombreYContrasena(String nom, String contra) throws SQLException {
        String miNombre = "SELECT NOMBRE, CONTRASENA FROM entrenador WHERE NOMBRE =" + "'" + nom + "'" + "AND CONTRASENA =" + "'" + contra + "'";
        PreparedStatement nombrePreparedStatement=null;
        nombrePreparedStatement=MySQLConnection.getConnection().prepareStatement(miNombre);
        ResultSet resultSet=nombrePreparedStatement.executeQuery();
        while(resultSet.next()){
            nombre = resultSet.getString("NOMBRE");
            contrasena = resultSet.getString("CONTRASENA");
        }

    }


    public static void addMovimientosInsert() {
        String queryParaCrearMovimiento="SELECT NOMBRE,DURACION,TIPO,COSTE_STAMINA,POTENCIA,accuracy,ESTADO,PORCENTAJE_CAMBIO,VARIEDAD_MOVIMIENTO,FISICO_ESPECIAL,STAT_A_CAMBIAR FROM movimiento";
        PreparedStatement movimientoPreparedStatement=null;
        try {
            movimientoPreparedStatement=MySQLConnection.getConnection().prepareStatement(queryParaCrearMovimiento);
            ResultSet resultSet=movimientoPreparedStatement.executeQuery();
            while (resultSet.next()) {



                String nombreMov=resultSet.getString("NOMBRE");


                int duracion=resultSet.getInt("DURACION");
                Tipo tipo=Tipo.valueOf( resultSet.getString("TIPO").toUpperCase());
                int costeStam=resultSet.getInt("COSTE_STAMINA");
                int potencia=resultSet.getInt("POTENCIA");
                int accuracy=resultSet.getInt("accuracy");

                float porcentajeCambio= resultSet.getFloat("PORCENTAJE_CAMBIO");
                String variedadMovimiento=resultSet.getString("VARIEDAD_MOVIMIENTO");
                String fisicoOEspecial=resultSet.getString("FISICO_ESPECIAL");
                String statACambiar=resultSet.getString("STAT_A_CAMBIAR");
                String estado= resultSet.getString("ESTADO");

                if (variedadMovimiento.toUpperCase().equals("ATAQUE")) {
                 Ataque ataque = new Ataque(nombreMov,potencia,accuracy,tipo,fisicoOEspecial.toUpperCase())   ;
                listaMovimientos.add(ataque);
                dicMovimientos.put(ataque.getNombre(),ataque);


                } else if (variedadMovimiento.toUpperCase().equals("MEJORA")) {
                    Mejora mejorasMask=new Mejora(nombreMov,porcentajeCambio,duracion,statACambiar,tipo);
                    listaMovimientos.add(mejorasMask);
                    dicMovimientos.put(mejorasMask.getNombre(),mejorasMask);


                }else {






                    if (estado.equalsIgnoreCase("NO")){
                    MovEstado estadoUnido= new MovEstado(nombreMov,statACambiar,porcentajeCambio,accuracy,duracion,tipo);
                    listaMovimientos.add(estadoUnido);
                    dicMovimientos.put(estadoUnido.getNombre(),estadoUnido);

                }
                    else {
                        MovEstado movEstado=new MovEstado(nombreMov,duracion,accuracy,tipo,Status.valueOf(estado.toUpperCase()));
                        listaMovimientos.add(movEstado);
                        dicMovimientos.put(movEstado.getNombre(),movEstado);
                    }

            }
    } }catch (SQLException e) {
            throw new RuntimeException(e);
        }}


        public static void insertPokemon() throws SQLException {


        String queryParaHacerAdd="SELECT NOMBRE_POKEMON, TIPO1,TIPO2,ID_POKEMON," +
                "VITALIDAD_MAXIMA,STAMINA_MAXIMA,VELOCIDAD,ATAQUE,ATAQUE_ESPECIAL,DEFENSA,DEFENSA_ESPECIAL,NOMBRE_MOVIMIENTO_INICIAL FROM POKEDEX";
        PreparedStatement preparedStatement=null;

        try {
            preparedStatement = MySQLConnection.getConnection().prepareStatement(queryParaHacerAdd);
            //preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("NOMBRE_POKEMON");
                int id = resultSet.getInt("ID_POKEMON");

                Tipo tipo = Tipo.valueOf(resultSet.getString("TIPO1").toUpperCase());
                Tipo segundoTipo;
                String tipo2 = resultSet.getString("TIPO2").toUpperCase();
                if (tipo2.equalsIgnoreCase("NO")) {
                 segundoTipo=null;

                }else {
                    segundoTipo=Tipo.valueOf(tipo2);
                }
                String nombreMovInicial = resultSet.getString("NOMBRE_MOVIMIENTO_INICIAL");
                int numPokedex = resultSet.getInt("ID_POKEMON");
                int vitalidadMaxima = resultSet.getInt("VITALIDAD_MAXIMA");
                int staminaMaxima = resultSet.getInt("STAMINA_MAXIMA");
                int velocidad = resultSet.getInt("VELOCIDAD");
                int ataque = resultSet.getInt("ATAQUE");
                int ataqueEspecial = resultSet.getInt("ATAQUE_ESPECIAL");
                int defensa = resultSet.getInt("DEFENSA");
                int defensaEspecial = resultSet.getInt("DEFENSA_ESPECIAL");

                pokedex.put( id,new Pokemon(nombre,tipo, segundoTipo, numPokedex, vitalidadMaxima, staminaMaxima, velocidad, ataque, ataqueEspecial, defensa, defensaEspecial, dicMovimientos.get(nombreMovInicial)));

            }

        }catch (SQLException e){

            }}
}





