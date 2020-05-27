/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Persona {
    private String dui;
    private String apellidos;
    private String nombre;
    Connection con;
    Statement statement;
    ResultSet miResultSet;
    
    public Persona(){
        try {
            Class.forName("com.mysql.jdbc.Driver");// Driver jdbc
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_recursos_humanos?zeroDateTimeBehavior=convertToNull","root","");// url de la BD, user , password
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean insertarDatos(){
        try {
            String queryStatement = "INSERT INTO tb_persona VALLUES('"+ dui + "','" + apellidos + "','" + nombre + "');";
            int estado = 0; // Estado de la insercion
            statement = con.createStatement();
            estado = statement.executeUpdate(queryStatement);
            if(estado == 1){
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }
    
    // Getter y Setter
    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
