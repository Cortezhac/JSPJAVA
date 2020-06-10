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
        String accion = request.getParameter("accion");
        String Ruta = ""; //Ubicacion de la vista JSP
        if(accion.equalsIgnoreCase("edit")){
            String Dui = request.getParameter("dui");
            Persona utilidadesPersona = new Persona();// permite usar sus utilidades
            Persona persona = null; // Objeto que almacenara los valores
            System.out.println("El dui papu " + Dui);
            persona = (Persona) utilidadesPersona.buscarRegistro(Dui); // CastingConversion explicita
            //Preparar las variables para el JSP edit
            System.out.println(persona.getDui());
            System.out.println(persona.getApellidos());
            System.out.println(persona.getNombre());
            
            request.setAttribute("DUI", persona.getDui());
            request.setAttribute("APELLIDO", persona.getApellidos());
            request.setAttribute("NOMBRE", persona.getNombre());
            Ruta = "Editar.jsp";
        }
        request.getRequestDispatcher(Ruta).forward(request, response);// Redirecciona a la vista
        //processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{

        String duisineditar = request.getParameter("dui");
        String dui = request.getParameter("txtDui");
        String apellido = request.getParameter("txtApellidos");
        String nombre = request.getParameter("txtNombre");
        String accion = request.getParameter("accion");
        if(accion == null){accion = "noaccion";} // Por si viene null
        Persona persona = new Persona();
        
        persona.setDui(dui);
        persona.setApellidos(apellido);
        persona.setNombre(nombre);
        System.out.println("accion : " + accion);
        System.out.println(persona.getDui());
        System.out.println(persona.getNombre());
        System.out.println(persona.getApellidos());
        if(accion.equals("actualizar")){
            if(duisineditar.equals(persona.getDui())){// Actualizar solo los nomnres
                persona.actualizarDatos(persona, duisineditar, false);
                request.getRequestDispatcher("mostrar.do").forward(request, response);
            }else{//Actualizar dui
                persona.actualizarDatos(persona, duisineditar, true);
                request.getRequestDispatcher("mostrar.do").forward(request, response);
            }
        }else if(persona.insertarDatos() == true){
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
