/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class DBConnection {
    
    private Connection c;

    public DBConnection() {

        try {   // cargar el driver de conexión con la base de datos adecuada
            // y obtener la conexión a través de la IP, nombre de base de datos,
            // usuario y contraseña
            Class.forName("org.mariadb.jdbc.Driver");
            this.c = DriverManager.getConnection(
                    "jdbc:mariadb://192.168.1.50:3306/tienda_deportes",
                    "user", "pass"
            );
        } catch (SQLException | ClassNotFoundException ex) {
            this.c = null;
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("conn: " + c);  // para la verificación en consola
    }
    
     public int insertCliente(String nombre, String apellido, String direccion,
                                String correo, String telefono) {
         
        String sqlSentence = "INSERT INTO CLIENTES (nombre, apellido, direccion, "
                + "correo_electronico, telefono) VALUES ('" + nombre + "', '" 
                + apellido + "', '" + direccion + "', '" + correo + "', '" + telefono + "');";
        
        System.out.println("Sentence: " + sqlSentence);  // verificación en consola
        
        Statement st;
        int n = -1;
        try {
            st = this.c.createStatement();
            n = st.executeUpdate(sqlSentence);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
     
     public int insertProducto(String nombre, String descripcion, String precio,
                                String stock) {
         
        String sqlSentence = "INSERT INTO PRODUCTOS (nombre, descripcion, precio, "
                + "stock) VALUES ('" + nombre + "', '" 
                + descripcion + "', '" + precio + "', '" + stock + "');";
        
        System.out.println("Sentence: " + sqlSentence);  // verificación en consola
        
        Statement st;
        int n = -1;
        try {
            st = this.c.createStatement();
            n = st.executeUpdate(sqlSentence);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
