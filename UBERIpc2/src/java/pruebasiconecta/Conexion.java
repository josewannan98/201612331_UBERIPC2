/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasiconecta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class Conexion {
    private static final String DB_DRIVER= "org.mariadb.jdbc.Driver";
    private static final String cHost = "localhost";
    private static final String cPort = "3306";
    private static final String cDataBase = "EJEMPLO_WS";
    
    private static final String user = "root";
    private static final String pass = "wannan98";
    
    private static final String DBConnection = "jdbc:mariadb://"+cHost+":"+cPort+"/"+cDataBase+"";
    
    public Connection getconexion(){
        Connection dbconnection = null;
        try{
            Class.forName(DB_DRIVER);
            
        }catch(ClassNotFoundException es){
            System.out.println("error"+es);
        }
        try{
          dbconnection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/UBER","root","wannan98");
            return dbconnection;
        }catch(SQLException e){
            System.out.println("Error"+e);
        }
        return dbconnection;
    }
}
