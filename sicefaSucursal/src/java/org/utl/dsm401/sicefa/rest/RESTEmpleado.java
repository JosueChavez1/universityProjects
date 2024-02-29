package org.utl.dsm401.sicefa.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm401.sicefa.controller.ControllerEmpleado;
import org.utl.dsm401.sicefa.model.Empleado;
import org.utl.dsm401.sicefa.model.Sucursal;
/**
 *
 * @author josue
 */

//http://localhost:8080/sicefaSucursal/api/empleado/getAll
@Path("empleado")
public class RESTEmpleado {
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        
        ControllerEmpleado objCE= new ControllerEmpleado();
        List<Empleado> listaEmpleados = objCE.getAll();
        Gson objGS= new Gson();
        String out=objGS.toJson(listaEmpleados);
        return Response.ok(out).build();
    }
    @Path("delete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("idE") @DefaultValue("0") String idE){
       String out="";
        try {
             ControllerEmpleado objCE=new ControllerEmpleado();
            objCE.delete(Integer.parseInt(idE));
            out="""
                {"result":"Empleado eliminado exitosamente"}
                """;
        } catch (SQLException ex) {
            out="""
                {"error":"Hubo un error en la eliminacion"}
                """;
        }
        return Response.ok(out).build();
    }
    
    @Path("reactivar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response reactivar(@QueryParam("idE") @DefaultValue("0") String idE){
       String out="";
        try {
             ControllerEmpleado objCE=new ControllerEmpleado();
            objCE.reactivar(Integer.parseInt(idE));
            out="""
                {"result":"Empleado reactivado exitosamente"}
                """;
        } catch (SQLException ex) {
            out="""
                {"error":"Hubo un error en la reactivacion"}
                """;
        }
        return Response.ok(out).build();
    }
    
    
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("e") @DefaultValue("") String empleado){
        Gson objGson = new Gson();
        //System.out.println("Impreso"+empleado);
        Empleado e= objGson.fromJson(empleado, Empleado.class);
        
        String out="";
        
        ControllerEmpleado objCE= new ControllerEmpleado();
        try{
            int idEmpleadoGenerado=objCE.insert(e);
            out="""
                 {"result":"Empleado insertado exitosamente con id %s" }
               
                """;
            out= String.format(out, idEmpleadoGenerado);
        }catch(SQLException ex){
            ex.printStackTrace();
            out="""
                 {"error":"Error al insertar empleado" }
               
                """;
        }
        return Response.ok(out).build();
    }
    
    @Path("getAllSuc")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSucursales(){
         
       String out="";
        try{
             ControllerEmpleado objCE= new ControllerEmpleado();
             List<Sucursal> listaSuc=objCE.getAllSucursal();
             Gson objGson=new Gson();
             out=objGson.toJson(listaSuc);
        }catch(SQLException ex){
            out="""
                 {"error":"No se pudo cargar la informacion, consulta el area del sistema" }
               
                """;
        }
        return Response.ok(out).build();
    }
}