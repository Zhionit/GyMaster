/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import gym.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Michael
 */
public class ConexionBaseDatos {

    private static final String ID = "ID";
    private static final String NOMBRE = "NOMBRE";
    private static final String APELLIDO = "APELLIDO";
    private static final String DIRECCION = "DIRECCION";
    private static final String GENERO = "GENERO";
    private static final String FECHA_NACIMIENTO = "FECHA_NACIMIENTO";
    private static final String TIPO_SANGRE = "TIPO_SANGRE";
    private static final String RH = "RH";
    private static final String EPS = "EPS";

    private Connection connection;

    /**
     * Crea la conexión a la base de datos, la instancia creada por este método
     * estará lista para atender todas las necesidades de persistencia en base
     * de datos
     */
    public ConexionBaseDatos() {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        System.out.println("JDBC Class found");

    }

    /**
     * Carga la lista de clientes del gimnasio a la memoria principal
     *
     * @param clientes
     */
    public void cargarClientes(List<Cliente> clientes) {

        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/GYMASTER", "GYMASTER",
                    "GYM");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTE");

            // Handle the result set
            Cliente c;
            while (rs.next()) {

                String id, nombre, apellido, direccion;
                int epsId;
                Date fechaNacimiento;
                boolean genero;

                // Getting separate attributes
                id = rs.getString(ID);
                nombre = rs.getString(NOMBRE);
                apellido = rs.getString(APELLIDO);
                direccion = rs.getString(DIRECCION);
                fechaNacimiento = rs.getDate(FECHA_NACIMIENTO);
                genero = rs.getBoolean(GENERO);

                // Getting telephone information
                List<String> telephones = new ArrayList<String>();
                Statement telephonesQueryStatement = connection.createStatement();
                ResultSet telephonesQueryResultSet = telephonesQueryStatement.executeQuery("SELECT TELEPHONE FROM TELEPHONE WHERE CLIENT = '" + id + "'");
                while (telephonesQueryResultSet.next()) {
                    telephones.add(telephonesQueryResultSet.getString("TELEPHONE"));
                }

                // Getting EPS information
                epsId = rs.getInt(EPS);
                Statement epsQueryStatment = connection.createStatement();
                ResultSet epsQueryResult = epsQueryStatment.executeQuery("SELECT NOMBRE FROM EPS WHERE ID = '" + epsId + "'");
                epsQueryResult.next();
                EPS eps = new EPS(epsId, epsQueryResult.getString("NOMBRE"));

                // Getting Blood type information
                TipoSangre tipoSange = new TipoSangre(rs.getByte(TIPO_SANGRE), rs.getBoolean(RH));

                // Constructing Cliente object
                c = new Cliente(id, nombre, apellido, genero, tipoSange, fechaNacimiento, direccion, telephones, eps);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("SQL exception occured:" + e);
        }

    }

    /**
     * Carga la lista de servicios de un cliente a la memoria principal
     *
     * @param cliente
     */
    public void cargarServicios(Cliente cliente) {
        List<Servicio> servicios = cliente.getServicios();

        try {
            Statement serviceQueryStatement = connection.createStatement();
            ResultSet serviceQueryResultSet = serviceQueryStatement.executeQuery("SELECT ID, DESCRIPCION FROM SERVICIO WHERE CLIENTE = '" + cliente.getId() + "'");
            Servicio servicio;
            while (serviceQueryResultSet.next()) {
                servicio = new Servicio(serviceQueryResultSet.getInt("ID"), serviceQueryResultSet.getString("DESCRIPCION"));
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            System.out.println("SQL exception occured:" + e);
        }
    }

    /**
     * Carga la lista de ejercicios de un cliente a la memoria principal
     * 
     * @param cliente Cliente a quien se le van a cargar todas las rutinas
     */
    public void cargarRutinasYEjercicios(Cliente cliente) {
        Rutina[] rutinas = cliente.getRutinas();
       

        try {
            Statement exerciseQueryStatement = connection.createStatement();
            ResultSet exerciseQueryResultSet = exerciseQueryStatement.executeQuery("SELECT DIA, ORDEN_SECUENCIAL, DESCRIPCION, SERIES,"
                    + " REPETICIONES, PESO FROM EJERCICIO WHERE CLIENTE = '" + cliente.getId() + "'");

            int dia, ordenSecuencial, series, repeticiones, peso;
            String descripcion;
            while (exerciseQueryResultSet.next()) {
                descripcion = exerciseQueryResultSet.getString("DESCRIPCION");
                dia = exerciseQueryResultSet.getInt("DIA");
                ordenSecuencial = exerciseQueryResultSet.getInt("ORDEN_SECUENCIAL");
                series = exerciseQueryResultSet.getInt("SERIES");
                repeticiones = exerciseQueryResultSet.getInt("REPETICIONES");
                peso = exerciseQueryResultSet.getInt("PESO");
                
                rutinas[dia-1].getEjercicios().add(new Ejercicio(descripcion, ordenSecuencial, series, repeticiones, peso));

            }

        } catch (SQLException e) {
            System.out.println("SQL exception occured:" + e);
        }
    }

    /**
     * Agrega un ejercicio presente en memoria principal a la base de datos
     *
     * @param cliente Cliente a quien se le asignó el ejercicio
     * @param ejercicio Ejercicio asignado
     * @param dia Día de la semana a la cual pertenece la rutina en la cual esta
     * presente el ejercicio
     */
    public void agregarEjercicio(Cliente cliente, Ejercicio ejercicio, int dia) {
        try {

            String insertExerciseStatement = "INSERT INTO EJERCICIO "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertExerciseStatement);
            //Setting parameters
            preparedStatement.setString(1, cliente.getId());
            preparedStatement.setInt(2, dia);
            preparedStatement.setInt(3, ejercicio.getOrdenSecuencial());
            preparedStatement.setString(4, ejercicio.getDescripcion());
            preparedStatement.setInt(5, ejercicio.getSeries());
            preparedStatement.setInt(6, ejercicio.getRepeticiones());
            if (ejercicio.getPeso() == 0) {
                preparedStatement.setNull(7, Types.INTEGER);
            } else {
                preparedStatement.setInt(7, ejercicio.getPeso());
            }
            // Insert
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL exception occured:" + e);
        }

    }

}
