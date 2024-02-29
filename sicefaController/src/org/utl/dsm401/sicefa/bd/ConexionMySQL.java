/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm401.sicefa.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author josue
 */
public class ConexionMySQL {

    Connection conn;
    //Metodo para abrir una conexion a BD-MySQL y devuelve un objeto tipo Connection
    public Connection open(){
        String user = "Josue";
        String password ="cclab";
        String url = "jdbc:mysql://127.0.0.1:3306/sicefa";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        
    } 
    //Metodo para cerrar una conexion a BD-MySQL existente
    public void close(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
