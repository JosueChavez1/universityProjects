/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm401.sicefa.controller;


import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import org.utl.dsm401.sicefa.bd.ConexionMySQL;
import org.utl.dsm401.sicefa.model.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.CallableStatement;
import org.utl.dsm401.sicefa.model.Persona;
import org.utl.dsm401.sicefa.model.Sucursal;
import org.utl.dsm401.sicefa.model.Usuario;
import java.sql.Types;

/**
 *
 * @author josue
 */
public class ControllerEmpleado {

    /**
     * Metodo que devuelve todos los registros de empelados No recive parametros
     *
     * @return:Lista de objetos Empleado
     */
    public List<Empleado> getAll() {
        //Aqui va ña primera parte del paso 6
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {
            //1) Crear la setencia SQL
            String query = "SELECT * FROM v_empleado";
            //2) Se establece la conexion con la base de datos
            ConexionMySQL connMySQL = new ConexionMySQL();
            //3) Se abre la conexion y devuelve un tipo conexion
            Connection conn = connMySQL.open();
            //4) Se genera el statement para enviar la consulta
            PreparedStatement pstm = conn.prepareStatement(query);
            //5.Se prepara un ResultSet para obtener la respuesta de la BD
            ResultSet rs = pstm.executeQuery();
            //6) Recorrer el rs y extraer los datos

            while (rs.next()) {
                Usuario u = new Usuario(rs.getInt("idUsuario"), rs.getString("nombreUsuario"),
                        rs.getString("contrasenia"), rs.getString("rol"));

                Sucursal s = new Sucursal();
                s.setCiudad(rs.getString("ciudad"));
                s.setCodigoPostal(rs.getString("cp_sucursal"));
                s.setColonia(rs.getString("colonia_sucursal"));
                s.setDomicilio(rs.getString("domicilioSucursal"));
                s.setEstado(rs.getString("estado_sucursal"));
                s.setEstatus(rs.getInt("estatus_sucursal"));
                s.setIdSucursal(rs.getInt("idSucursal"));
                s.setLatitud(rs.getString("latitudSucursal"));
                s.setLongitud(rs.getString("longitudSucursal"));
                s.setNombre(rs.getString("nombreSucursal"));
                s.setRfc(rs.getString("rfcSucursal"));
                s.setTelefono(rs.getString("telefono_sucursal"));
                s.setTitular(rs.getString("titularSucursal"));

                Persona p = new Persona();
                p.setIdPersona(rs.getInt("idPersona"));
                p.setFoto(rs.getString("fotoPersona"));
                p.setFechaNacimiento(rs.getString("fechaNacimientoPersona"));
                p.setTelefono(rs.getString("telefonoPersona"));
                p.setDomicilio(rs.getString("domicilioPersona"));
                p.setCodigoPostal(rs.getString("codigoPostalPersona"));
                p.setCiudad(rs.getString("ciudad"));
                p.setEstado(rs.getString("estadoPersona"));
                p.setNombre(rs.getString("nombrePersona"));
                p.setApellidoPaterno(rs.getString("apellidoPaternoPersona"));
                p.setApellidoMaterno(rs.getString("apellidoMaternoPersona"));
                p.setGenero(rs.getString("generoPersona"));
                p.setCurp(rs.getString("curpPersona"));
                p.setRfc(rs.getString("rfcPersona"));

                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setCodigo(rs.getString("codigo"));
                e.setFechaIngreso(rs.getString("fechaIngreso"));
                e.setPuesto(rs.getString("puesto"));
                e.setSalarioBruto(rs.getFloat("salarioBruto"));
                e.setActivo(rs.getInt("empleadoActivo"));
                e.setEmail(rs.getString("email"));

                e.setUsuario(u);
                e.setSucursal(s);
                e.setPersona(p);

                listaEmpleados.add(e);
            }
            //7) Cerrar todos los objetos
            rs.close();
            pstm.close();
            conn.close();
            connMySQL.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //8) Devolver la informacion
        return listaEmpleados;
    }

    public void delete(int idEmpleado) throws SQLException {
        //1.- Crear la sentencia SQL
        String query = "UPDATE empleado SET activo=0 WHERE idEmpleado=" + idEmpleado + ";";
        //2.- Crear un objeto para la conexion con mySql
        ConexionMySQL conMySQL = new ConexionMySQL();
        //3. Se abre la conexion
        Connection conn = conMySQL.open();
        //4.- Crear un statement para enviar la query
        Statement stmt = conn.createStatement();
        //5.- Ejecutar la sentencia
        stmt.execute(query);
        //6.- Cerrar los objetos
        stmt.close();
        conn.close();
        conMySQL.close();
    }
    
     public void reactivar(int idEmpleado) throws SQLException {
        //1.- Crear la sentencia SQL
        String query = "UPDATE empleado SET activo=1 WHERE idEmpleado=" + idEmpleado + ";";
        //2.- Crear un objeto para la conexion con mySql
        ConexionMySQL conMySQL = new ConexionMySQL();
        //3. Se abre la conexion
        Connection conn = conMySQL.open();
        //4.- Crear un statement para enviar la query
        Statement stmt = conn.createStatement();
        //5.- Ejecutar la sentencia
        stmt.execute(query);
        //6.- Cerrar los objetos
        stmt.close();
        conn.close();
        conMySQL.close();
    }
     

    public int insert(Empleado e) throws SQLException {
        //1.- Generar la sentencia SQL
        String query = "{call insertarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        //2.- Crear la conexion a la BD
        ConexionMySQL conMySQL = new ConexionMySQL();
        //3.- Se abre la conexion
        Connection conn = conMySQL.open();
        //4.- Crear un statement que llevara la consulta   prepareStatement, Statement y calleblestatement
        CallableStatement cstm = conn.prepareCall(query);
        //5.- Llenar todos los parametros de la llamada al procedure
        cstm.setString(1, e.getPersona().getNombre());
        cstm.setString(2, e.getPersona().getApellidoPaterno());
        cstm.setString(3, e.getPersona().getApellidoMaterno());
        cstm.setString(4, e.getPersona().getGenero());
        cstm.setString(5, e.getPersona().getFechaNacimiento());
        cstm.setString(6, e.getPersona().getRfc());
        cstm.setString(7, e.getPersona().getCurp());
        cstm.setString(8, e.getPersona().getDomicilio());
        cstm.setString(9, e.getPersona().getCodigoPostal());
        cstm.setString(10, e.getPersona().getCiudad());
        cstm.setString(11, e.getPersona().getEstado());
        cstm.setString(12, e.getPersona().getTelefono());
        cstm.setString(13, e.getPersona().getFoto());

        cstm.setInt(14, e.getSucursal().getIdSucursal());
        cstm.setString(15, e.getUsuario().getNombreUsuario());
        cstm.setString(16, e.getUsuario().getContrasenia());

        cstm.setString(17, e.getUsuario().getRol());

        cstm.setString(18, e.getEmail());

        cstm.setString(19, e.getPuesto());

        cstm.setFloat(20, e.getSalarioBruto());

        cstm.registerOutParameter(21, Types.INTEGER);
        cstm.registerOutParameter(22, Types.INTEGER);
        cstm.registerOutParameter(23, Types.INTEGER);
        cstm.registerOutParameter(24, Types.VARCHAR);

        //6.- Ejecutar la sentencia
        cstm.execute();
        //7.- Obtener todos los parametros de retorno
        e.getPersona().setIdPersona(cstm.getInt(21));
        e.getUsuario().setIdUsuario(cstm.getInt(22));
        e.setIdEmpleado(cstm.getInt(23));
        e.setCodigo(cstm.getString(24));
        //8.- Cerrar los objetos
        cstm.close();
        conn.close();
        conMySQL.close();
        return e.getIdEmpleado();
    }
    
     public List<Sucursal> getAllSucursal() throws SQLException{
        List<Sucursal> listaSucursales = new ArrayList<>();
        //1. Crear la sentencia SQL
        String query = "SELECT * FROM sucursal";
        //2. Se establece la conexion con la BD
        ConexionMySQL connMySQL = new ConexionMySQL();
        //3. Se abre la conexion
        Connection conn = connMySQL.open();
        //4. Se genera el statement para enviar la consulta
        PreparedStatement pstmt = conn.prepareStatement(query);
        //5. Se prepara un ResultSet para obtener la respuesta de la BD
        ResultSet rs = pstmt.executeQuery();
        //6. Recorrer el rs y extraer los datos
        while (rs.next())
        {
            Sucursal s = new Sucursal();
            s.setIdSucursal(rs.getInt("idSucursal"));
            s.setNombre(rs.getString("nombre"));
            s.setTitular(rs.getString("titular"));
            s.setCiudad(rs.getString("ciudad"));
            s.setCodigoPostal(rs.getString("codigoPostal"));
            s.setColonia(rs.getString("colonia"));
            s.setDomicilio(rs.getString("domicilio"));
            s.setEstado(rs.getString("estado"));
            s.setEstatus(rs.getInt("estatus"));
            s.setLatitud(rs.getString("latitud"));
            s.setLongitud(rs.getString("longitud"));
            s.setRfc(rs.getString("rfc"));
            s.setTelefono(rs.getString("telefono"));    
            
            listaSucursales.add(s);
        }
        //7. Cerrar todos los objetos
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.close();
        //8. Devolver la informacion
        return listaSucursales;
    }

}
