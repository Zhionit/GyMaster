/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import gym.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Michael
 */
public class PersistenciaCliente {

    private static final String ID = "ID";
    private static final String NOMBRE = "NOMBRE";
    private static final String APELLIDO = "APELLIDO";
    private static final String DIRECCION = "DIRECCION";
    private static final String GENERO = "GENERO";
    private static final String FECHA_NACIMIENTO = "FECHA_NACIMIENTO";
    private static final String TIPO_SANGRE = "TIPO_SANGRE";
    private static final String RH = "RH";
    private static final String EPS = "EPS";
    
    private Connection con;

    public PersistenciaCliente() {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        System.out.println("JDBC Class found");
        
        

    }

    public void cargarClientes(List<Cliente> clientes) {
        
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/GYMASTER", "GYMASTER",
                    "GYM");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTE");
            
            // Handle the result set
            Cliente c;
            while (rs.next()) {
                
                String id, nombre, apellido, direccion, epsId;
                Date fechaNacimiento;
                boolean genero;
                
                // Getting separate attributes
                id = rs.getString(ID);
                nombre = rs.getString(NOMBRE);
                apellido = rs.getString(APELLIDO);
                direccion = rs.getString(DIRECCION);
                fechaNacimiento = rs.getDate(FECHA_NACIMIENTO);
                genero = rs.getBoolean(GENERO);
                
                
                // Getting EPS information
                epsId = rs.getString(EPS);
                Statement epsQueryStatment = con.createStatement();
                ResultSet epsQueryResult = epsQueryStatment.executeQuery("SELECT * FROM EPS WHERE ID = '" + epsId + "'" );
                epsQueryResult.next();
                EPS eps = new EPS(epsQueryResult.getString(1), epsQueryResult.getString(2));
                
                // Getting Blood type information
                TipoSangre tipoSange = new TipoSangre(rs.getByte(TIPO_SANGRE), rs.getBoolean(RH));
             
                // Constructing Cliente object
                c = new Cliente(id, nombre, apellido, genero, tipoSange, fechaNacimiento, direccion, eps);
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
        
    }
    
    public static void main (String[] args){
        List<Cliente> clientes = new ArrayList<Cliente>();
        PersistenciaCliente p = new PersistenciaCliente();
        p.cargarClientes(clientes);
        System.out.println(clientes.get(0).getNombre());
    }

}
