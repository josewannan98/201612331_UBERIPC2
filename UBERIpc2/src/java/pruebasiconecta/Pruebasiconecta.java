/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasiconecta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class Pruebasiconecta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Pruebasiconecta ps = new Pruebasiconecta();
        System.out.println(ps.agregarUsuario("jose", 19, 54951895, "wannan",1));
    }
    public boolean agregarUsuario(String name, int Edad, int Tele, String pass, int idservicio) throws SQLException {
        Connection dbConnection = null;
         PreparedStatement preparedStatement = null;
        //ES PARA DECLARAR SENTENCIAS SQL
        try{
       
        //SQL -- 
        String insertTableSQL = "INSERT INTO CLIENTE(nombre,Edad,Telefono,Contraseña, id_servicio)"
                + "VALUES(?,?,?,?,?)";
            dbConnection = new Conexion().getconexion();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            /* ? */preparedStatement.setString(1, name);
            /* ? */preparedStatement.setInt(2, Edad);  
            /* ? */preparedStatement.setInt(3, Tele);
            /* ? */preparedStatement.setString(4, pass);
            /* ? */preparedStatement.setInt(5, idservicio);
            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            dbConnection.close();
            return true;
    }catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

                 }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    
}
}
         
