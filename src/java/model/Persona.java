/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;

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
        Class.forName("");// Driver jdbc
        con = DriverManager.getConnection("","","");// url de la BD, user , password
    }

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
