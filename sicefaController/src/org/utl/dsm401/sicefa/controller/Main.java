
package org.utl.dsm401.sicefa.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm401.sicefa.model.Empleado;
import org.utl.dsm401.sicefa.model.Persona;
import org.utl.dsm401.sicefa.model.Sucursal;
import org.utl.dsm401.sicefa.model.Usuario;

/**
 *
 * @author josue
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    //http://localhost:8080/sicefaSucursal/api/empleado/delete?idE=1
    //http://localhost:8080/sicefaSucursal/api/empleado/reactivar?idE=1
    public static void main(String[] args) {
       //delete();
       insert();
       //reactivar();
       //getAll();
       //Para checar que si sale la sucursal
       //http://localhost:8080/sicefaSucursal/api/empleado/getAllSuc
       try{
             ControllerEmpleado objCE= new ControllerEmpleado();
             List<Sucursal> listaSuc=objCE.getAllSucursal();
            for(Sucursal suc:listaSuc){
                System.out.println(suc.toString());
            }
        }catch(SQLException ex){
           Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }
       
    }
    
    public static void insert(){
        Usuario u = new Usuario("hola","12345","EMPS");
        Sucursal s= new Sucursal();
        s.setIdSucursal(1);
        Persona p= new Persona("123","02/10/2000","4774338811","Blvd.Nauatl 342","37485",
                "Leon","Guanajuato","Masiel","Barrera","Vallejo",
                "H","MAGJSA","BAVM001002TW6");
        
        Empleado e = new Empleado("","31/10/2023", "EMPS", 17000, 1, "mmario@gmail.com", s, u, p);
        ControllerEmpleado objCE= new ControllerEmpleado();
        try{
            objCE.insert(e);
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        System.out.println(e.toString());
                
    }
    
    public static void delete(){
        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            
            objCE.delete(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
   public static void reactivar() {
    ControllerEmpleado objCE = new ControllerEmpleado();
    try {
        objCE.reactivar(0); 
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
   
    
    
    public static void getAll(){
          ControllerEmpleado objCE = new ControllerEmpleado();
        List<Empleado>  lista=objCE.getAll();
        
        for (Empleado empleado : lista) {
            System.out.println(empleado.toString());
        }
    }
    
      
    }
