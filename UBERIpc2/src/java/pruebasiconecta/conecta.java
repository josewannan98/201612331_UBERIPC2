/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasiconecta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class conecta {
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
 public boolean agregarVehiculo(String matricula, String Modelo, int idvehiculo, int idasociado) throws SQLException {
        Connection dbConnection = null;
         PreparedStatement preparedStatement = null;
        //ES PARA DECLARAR SENTENCIAS SQL
        try{
       
        //SQL -- 
        String insertTableSQL = "INSERT INTO VEHICULO(matricula,modelo,id_tipovehiculo,id_asociado)"
                + "VALUES(?,?,?,?)";
            dbConnection = new Conexion().getconexion();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            /* ? */preparedStatement.setString(1, matricula);
            /* ? */preparedStatement.setString(2, Modelo);  
            /* ? */preparedStatement.setInt(3, idvehiculo);
            /* ? */preparedStatement.setInt(4, idasociado);
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
public String getPilotoporvehiculo(String matricula){
           Connection dbConnection = null;
           String usuario="";
        PreparedStatement preparedStatement = null;
        //ArrayList a[] = new ArrayList[2];

        String selectSQL = "SELECT *FROM asociado as A, Vehiculo as V where V.matricula =? AND V.id_asociado = A.id_asociado";
        try {
            dbConnection = new Conexion().getconexion();

            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, matricula);

            ResultSet rs;
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                usuario+="ID: "+rs.getInt("id_asociado")+", Piloto: "+rs.getString("nombre_asociado")+", Descripcion: "+rs.getString("descripcion");
                return usuario;
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }// NADA NO HACE NADA
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
       }
        return usuario;
       }
 public String getUsuarioVIP(){
           Connection dbConnection = null;
           String usuario="";
        PreparedStatement preparedStatement = null;
        //ArrayList a[] = new ArrayList[2];
        String servicio = String.valueOf('"')+ "UberX"+String.valueOf('"');
        String selectSQL = "SELECT DISTINCT *FROM CLIENTE as U, SERVICIO as S where S.nombre = ? and U.id_servicio=S.id_servicio";
        try {
            dbConnection = new Conexion().getconexion();

            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setString(1, "UberX");

            ResultSet rs;
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                usuario+="ID: "+rs.getInt("id_usuario")+", Piloto: "+rs.getString("nombre")+", Edad: "+rs.getInt("Edad")+", Contraseña: "+rs.getString("Contraseña")+", Servicio: "+rs.getString(8);
                return usuario;
            }
            
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }// NADA NO HACE NADA
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
       }
        return usuario;
       }
 public boolean agregarViaje(int idcliente, String Localizacion, int Costo, int idservicio) throws SQLException {
        Connection dbConnection = null;
         PreparedStatement preparedStatement = null;
        //ES PARA DECLARAR SENTENCIAS SQL
        try{
       
        //SQL -- 
        String insertTableSQL = "INSERT INTO DETALLE_SERVICIO(id_cliente,localizacion,costo_del_servicio, id_detallesocio)"
                + "VALUES(?,?,?,?)";
            dbConnection = new Conexion().getconexion();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            /* ? */preparedStatement.setInt(1, idcliente);
            /* ? */preparedStatement.setString(2, Localizacion);  
            /* ? */preparedStatement.setInt(3, Costo);
            /* ? */preparedStatement.setInt(4, idservicio);
            
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
       
//SELECT *FROM asociado as A, Vehiculo as V where V.matricula = "BMP-0999" AND V.id_asociado = A.id_asociado
//SELECT *FROM CLIENTE as U, SERVICIO as S where S.nombre = "UberX" and U.id_servicio=S.id_servicio
}
