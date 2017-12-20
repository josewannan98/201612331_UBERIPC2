/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasiconecta;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pruebasiconecta.*;
/**
 *
 * @author jose
 */
@WebService(serviceName = "uber")
public class uber {
conecta conect;


    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarVehiculo")
    public Boolean agregarVehiculo(@WebParam(name = "matricula") String matricula, @WebParam(name = "modelo") String modelo, @WebParam(name = "id_vehiculo") int id_vehiculo, @WebParam(name = "id_asociado") int id_asociado) {
        //TODO write your implementation code here:
        try{
            conect = new conecta();
        Boolean respuesta = conect.agregarVehiculo(matricula, modelo, id_vehiculo, id_asociado);
        return respuesta;
        }catch (Exception e){
            
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarPilotoporVehiculoMatricula")
    public String buscarPilotoporVehiculoMatricula(@WebParam(name = "matricula") String matricula) {
        //TODO write your implementation code here:
        try{
            conect = new conecta();
        String respuesta = conect.getPilotoporvehiculo(matricula);
        return respuesta;
        }catch (Exception e){
            
        }
        return "Error";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AgregarUsuario")
    public Boolean AgregarUsuario(@WebParam(name = "nombre") String nombre, @WebParam(name = "Edad") int Edad, @WebParam(name = "Telefono") int Telefono, @WebParam(name = "Contrase\u00f1a") String Contraseña, @WebParam(name = "idservicio") int idservicio) {
        //TODO write your implementation code here:
        try{
            conect = new conecta();
        Boolean respuesta = conect.agregarUsuario(nombre, Edad, Telefono, Contraseña, idservicio);
        return respuesta;
        }catch (Exception e){
            
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsuariosVIP")
    public String getUsuariosVIP() {
        //TODO write your implementation code here:
       try{
            conect = new conecta();
        String respuesta = conect.getUsuarioVIP();
        return respuesta;
        }catch (Exception e){
            
        }
        return "Error";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarViaje")
    public Boolean agregarViaje(@WebParam(name = "id_cliente") int id_cliente, @WebParam(name = "localizacion") String localizacion, @WebParam(name = "costo_del_servicio") int costo_del_servicio, @WebParam(name = "id_detallesocio") int id_detallesocio) {
        //TODO write your implementation code here:
       try{
            conect = new conecta();
        Boolean respuesta = conect.agregarViaje(id_cliente, localizacion, costo_del_servicio, id_detallesocio);
        return respuesta;
        
        }catch (Exception e){
            
        }
        return false;
    }

}
