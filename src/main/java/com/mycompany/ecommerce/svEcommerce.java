/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class svEcommerce extends HttpServlet {

    DBConnection db = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Variables de los formularios 
        String run = request.getParameter("run");
        String task = request.getParameter("task");

        //Tabla Clientes
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        
        //Tabla Productos
        String nombreProducto = request.getParameter("nombreProducto");
        String descripcion = request.getParameter("descripcion");
        String precio = request.getParameter("precio");
        String stock = request.getParameter("stock");

        if (run == null) {  // not first run
            switch (task) {
                case "insert":
                    if (nombre.isBlank()&& apellido.isBlank()&& direccion.isBlank()
                            && correo.isBlank() && telefono.isBlank()) {
                        // do nothing
                    } else {
                        System.out.println("Se mete en la funcion");
                        db.insertCliente(nombre, apellido, direccion, correo, telefono);
                    }
                    response.sendRedirect("formulariosInsercion.jsp");

                    break;
                case "insertProduct":
                    if (nombreProducto.isBlank()&& descripcion.isBlank()&& precio.isBlank()
                            && stock.isBlank() ) {
                        // do nothing
                    } else {
                        System.out.println("Se mete en la funcion");
                        db.insertProducto(nombreProducto, descripcion, precio, stock);
                    }
                    response.sendRedirect("producto.jsp");

                    break;
                default:
                    break;
            }
        } else if (run.equalsIgnoreCase("start")) { // first run from this client
            this.db = new DBConnection();
            response.sendRedirect("formulariosInsercion.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
