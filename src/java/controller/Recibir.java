/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Persona;

/**
 *
 * @author Admin
 */
public class Recibir extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        
    }
    
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{
        
        String dui = request.getParameter("txtDui");
        String apellido = request.getParameter("txtApellidos");
        String nombre = request.getParameter("txtNombre");
        
        Persona persona = new Persona();
        
        persona.setDui(dui);
        persona.setApellidos(apellido);
        persona.setNombre(nombre);
        
        if(persona.insertarDatos() == true){
            request.getRequestDispatcher("exito.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("noexito.jsp").forward(request, response);
        }
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo(){
        return "Short Description";
    }
}
