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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/GYMASTER", "GYMASTER",
                    "GYM");
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found " + e);
        } catch (SQLException e){
            System.err.println("Error while connecting to the Database: " + e);
        }
        System.out.println("Database connection successfuly stablished");

    }

    /**
     * Carga la lista de clientes del gimnasio a la memoria principal
     *
     * @param clientes
     */
    public void cargarClientes(List<Cliente> clientes) {

        try {
            
            String sqlStatement = "SELECT * FROM CLIENTE";
            Statement statementt = connection.createStatement();
            ResultSet resultSet = statementt.executeQuery(sqlStatement);

            // Handle the result set
            Cliente c;
            while (resultSet.next()) {

                String id, nombre, apellido, direccion;
                int epsId;
                Date fechaNacimiento;
                boolean genero;

                // Getting separate attributes
                id = resultSet.getString(ID);
                nombre = resultSet.getString(NOMBRE);
                apellido = resultSet.getString(APELLIDO);
                direccion = resultSet.getString(DIRECCION);
                fechaNacimiento = resultSet.getDate(FECHA_NACIMIENTO);
                genero = resultSet.getBoolean(GENERO);

                // Getting telephone information
                List<String> telephones = new ArrayList<String>();
                String telephoneSqlStatement = "SELECT TELEPHONE FROM TELEPHONE WHERE CLIENT = '" + id + "'";
                Statement telephonesQueryStatement = connection.createStatement();
                ResultSet telephonesQueryResultSet = telephonesQueryStatement.executeQuery(telephoneSqlStatement);
                while (telephonesQueryResultSet.next()) {
                    telephones.add(telephonesQueryResultSet.getString("TELEPHONE"));
                }

                // Getting EPS information
                epsId = resultSet.getInt(EPS);
                String epsSqlStatement = "SELECT NOMBRE FROM EPS WHERE ID = '" + epsId + "'";
                Statement epsQueryStatment = connection.createStatement();
                ResultSet epsQueryResult = epsQueryStatment.executeQuery(epsSqlStatement);
                epsQueryResult.next();
                EPS eps = new EPS(epsId, epsQueryResult.getString("NOMBRE"));

                // Getting Blood type information
                TipoSangre tipoSange = new TipoSangre(resultSet.getShort(TIPO_SANGRE), resultSet.getBoolean(RH));

                // Constructing Cliente object
                c = new Cliente(id, nombre, apellido, genero, tipoSange, fechaNacimiento, direccion, telephones, eps);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception occured:" + e);
        }

    }
    
    /**
     * Registra un nuevo cliente
     * @param cliente Cliente a registrar
     */
    public void registrarCliente(Cliente cliente){
        try {
            String sqlClientInsert = "INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement clientInsertStatement = connection.prepareStatement(sqlClientInsert);
            clientInsertStatement.setString(1, cliente.getId());
            clientInsertStatement.setString(2, cliente.getNombre());
            clientInsertStatement.setString(3, cliente.getApellido());
            clientInsertStatement.setString(4, cliente.getDireccion());
            clientInsertStatement.setBoolean(5, cliente.getGenero());
            clientInsertStatement.setDate(6, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            clientInsertStatement.setShort(7, cliente.getTipoSangre().getTipo());
            clientInsertStatement.setBoolean(8, cliente.getTipoSangre().getRh());
            clientInsertStatement.setInt(9, cliente.getEPS().getId());
            
            for(String telefono : cliente.getTelefonos()){
                registrarTelefono(cliente, telefono);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception occured:" + e);
        }
    }
    
    /**
     * Agrega un telefono a la lista de telefonos del cliente
     * @param cliente Cliente a quien se le agrega el telefono
     * @param telefono Telefono a agregar
     * @return El ID generado para el nuevo telefono
     */
    public int registrarTelefono(Cliente cliente, String telefono){
        try{
            String sqlStatement = "INSERT INTO TELEFONO (CLIENTE, TELEFONO) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, cliente.getId());
            preparedStatement.setString(2, telefono);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            return resultSet.getInt("ID");
        } catch (SQLException e) {
            System.err.println("SQL exception occured:" + e);
        }
        return 0;
    }

    /**
     * Carga la lista de servicios de un cliente a la memoria principal
     *
     * @param cliente Cliente al cual se le cargaran los servicios
     */
    public void cargarServicios(Cliente cliente) {
        List<Servicio> servicios = cliente.getServicios();

        try {
            String sqlStatement = "SELECT ID, DESCRIPCION FROM SERVICIO WHERE CLIENTE = '" + cliente.getId() + "'";
            Statement serviceQueryStatement = connection.createStatement();
            ResultSet serviceQueryResultSet = serviceQueryStatement.executeQuery(sqlStatement);
            Servicio servicio;
            while (serviceQueryResultSet.next()) {
                servicio = new Servicio(serviceQueryResultSet.getInt("ID"), serviceQueryResultSet.getString("DESCRIPCION"));
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception occured:" + e);
        }
    }
    
    /**
     * Registra un nuevo servicio a un cliente
     * @param cliente Cliente a quien se le registra el nuevo servicio
     * @param servicio Nuevo servicio a registrar
     * @return El ID generado para el nuevo servicio
     */
    public int registrarServicio(Cliente cliente, Servicio servicio){
        
        try{
            String sqlStatement = "INSERT INTO SERVICIO (CLIENTE, DESCRIPCION) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, cliente.getId());
            preparedStatement.setString(2, servicio.getDescripcion());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            return resultSet.getInt("ID");
        } catch (SQLException e) {
            System.err.println("SQL exception occured:" + e);
        }
        return 0;
    }
    
    

    /**
     * Carga la lista de ejercicios de un cliente a la memoria principal
     * 
     * @param cliente Cliente a quien se le van a cargar todas las rutinas
     */
    public void cargarRutinasYEjercicios(Cliente cliente) {
        Rutina[] rutinas = cliente.getRutinas();
       

        try {
            String sqlStatement = "SELECT * FROM EJERCICIO WHERE CLIENTE = '" + cliente.getId() + "'";
            Statement exerciseQueryStatement = connection.createStatement();
            ResultSet exerciseQueryResultSet = exerciseQueryStatement.executeQuery(sqlStatement);

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
            System.err.println("SQL exception occured:" + e);
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
    public void registrarEjercicio(Cliente cliente, Ejercicio ejercicio, int dia) {
        try {

            String sqlStatement = "INSERT INTO EJERCICIO "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
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
            System.err.println("SQL exception occured:" + e);
        }

    }
    
    /**
     * Obtiene una lista de fechas en las que se han
     * tomado medidas del cliente
     * @param cliente Cliente de quien se han tomado medidas
     * @return Lista de fechas
     */
    public List<Date> obtenerFechasHistoricoMedidasCorporales(Cliente cliente){
        List<Date> fechas = new ArrayList<Date>();
        try {
            String sql = "SELECT * FROM MEDIDAS_CORPORALES "
                    + "WHERE CLIENTE = '" + cliente.getId() + "' "
                    + "ORDER BY FECHA_REGISTRO DESC";
            Statement bodyMeasurementsQuery = connection.createStatement();
            ResultSet bodyMeasurementsResultSet = bodyMeasurementsQuery.executeQuery(sql);
            while(bodyMeasurementsResultSet.next()){
                fechas.add(bodyMeasurementsResultSet.getDate("FECHA_REGISTRO"));
            }
        } catch (Exception e) {
            System.err.println("SQL exception occured:" + e);
        }
        return fechas;
    }
    /**
     * Este metodo carga las medidas corporales de un cliente dada la fecha
     * en que se tomaron
     * @param cliente Cliente de quien se cargan las medidas
     * @param fechaRegistro Fecha en la que se registraron las medidas
     */
    public void cargarMedidasCorporales(Cliente cliente, Date fechaRegistro){
        MedidasCorporales medidasCorporales = new MedidasCorporales();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(fechaRegistro);
            String sql = "SELECT * FROM MEDIDAS_CORPORALES "
                    + "WHERE CLIENTE = '" + cliente.getId() + "' AND "
                    + "FECHA_REGISTRO = '" + formattedDate + "'";
            Statement bodyMeasurementsQuery = connection.createStatement();
            ResultSet bodyMeasurementsResultSet = bodyMeasurementsQuery.executeQuery(sql);
            if(bodyMeasurementsResultSet.next()){
                medidasCorporales.setPeso(bodyMeasurementsResultSet.getDouble("PESO"));
                medidasCorporales.setEstatura(bodyMeasurementsResultSet.getDouble("ESTATURA"));
                medidasCorporales.setCintura(bodyMeasurementsResultSet.getDouble("CINTURA"));
                medidasCorporales.setCadera(bodyMeasurementsResultSet.getDouble("CADERA"));
                medidasCorporales.setPiernaI(bodyMeasurementsResultSet.getDouble("PIERNA_I"));
                medidasCorporales.setPiernaD(bodyMeasurementsResultSet.getDouble("PIERNA_D"));
                medidasCorporales.setBrazoI(bodyMeasurementsResultSet.getDouble("BRAZO_I"));
                medidasCorporales.setBrazoD(bodyMeasurementsResultSet.getDouble("BRAZO_D"));
                medidasCorporales.setGluteoI(bodyMeasurementsResultSet.getDouble("GLUTEO_I"));
                medidasCorporales.setGluteoD(bodyMeasurementsResultSet.getDouble("GLUTEO_D"));
                medidasCorporales.setGemeloI(bodyMeasurementsResultSet.getDouble("GEMELO_I"));
                medidasCorporales.setGemeloD(bodyMeasurementsResultSet.getDouble("GEMELO_D"));
                medidasCorporales.setCuello(bodyMeasurementsResultSet.getDouble("CUELLO"));
                medidasCorporales.setHombroI(bodyMeasurementsResultSet.getDouble("HOMBRO_I"));
                medidasCorporales.setHombroD(bodyMeasurementsResultSet.getDouble("HOMBRO_D"));
                medidasCorporales.setEspalda(bodyMeasurementsResultSet.getDouble("ESPALDA"));
            }
            cliente.setMedidasCorporales(medidasCorporales);
        } catch (Exception e) {
            System.err.println("SQL exception occured:" + e);
        }
        
    }
    
    /**
     * Registra las medidas corporales de un cliente con la fecha actual
     * @param cliente Cliente a quien se le registran las medidas corporales
     */
    public void registrarMedidasCorporales(Cliente cliente){
        MedidasCorporales medidasCorporales = cliente.getMedidasCorporales();
        try {
            
            String sqlStatement = "INSERT INTO MEDIDAS_CORPORALES VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, cliente.getId());
            preparedStatement.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            preparedStatement.setDouble(3, medidasCorporales.getPeso());
            preparedStatement.setDouble(4, medidasCorporales.getEstatura());
            preparedStatement.setDouble(5, medidasCorporales.getCintura());
            preparedStatement.setDouble(6, medidasCorporales.getCadera());
            preparedStatement.setDouble(7, medidasCorporales.getPiernaI());
            preparedStatement.setDouble(8, medidasCorporales.getPiernaD());
            preparedStatement.setDouble(9, medidasCorporales.getBrazoI());
            preparedStatement.setDouble(10, medidasCorporales.getBrazoD());
            preparedStatement.setDouble(11, medidasCorporales.getGluteoI());
            preparedStatement.setDouble(12, medidasCorporales.getGluteoD());
            preparedStatement.setDouble(13, medidasCorporales.getCuello());
            preparedStatement.setDouble(14, medidasCorporales.getHombroI());
            preparedStatement.setDouble(15, medidasCorporales.getHombroD());
            preparedStatement.setDouble(16, medidasCorporales.getEspalda());
            
            preparedStatement.executeUpdate();
            
                        
        } catch (SQLException e) {
            System.err.println("SQL exception occured:" + e);
        }
    }

    /**
     * Agrega una nueva EPS
     * @param nombre Nombre de la ESP agregada
     * @return ID de la nueva EPS
     * @throws Exception 
     */
    public int registrarEPS(String nombre) throws Exception{
        try {
            String sqlStatement = "INSERT INTO EPS (NAME) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, nombre);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            return resultSet.getInt("ID");
        } catch (SQLException e) {
            System.err.println("SQL exception occured:" + e);
        }
        return 0;
    }
}

