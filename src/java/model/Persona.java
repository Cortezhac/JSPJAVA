/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Persona {
    String dui;
    String apellidos;
    String nombre;
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

    public Persona(String dui, String apellido, String nombre){
        this.dui = dui;
        this.apellidos = apellido;
        this.nombre = nombre;
    }
    
    public boolean insertarDatos(){
        try {
            String queryStatement = "INSERT INTO tb_persona VALUES('"+ dui + "','" + apellidos + "','" + nombre + "');";
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
    
    public ArrayList<Persona> consultarRegistros(){
        ArrayList<Persona> persona = new ArrayList();
        try {
            String sqlQueryStatement = "SELECT * FROM tb_persona";
            statement = con.createStatement(); // Preparar el objeto statement
            miResultSet = statement.executeQuery(sqlQueryStatement); // ejecutar sentencia SQL
            while(miResultSet.next()){
                
                persona.add(new Persona(
                        miResultSet.getString("dui_persona"),
                        miResultSet.getString("apellidos_persona"),
                        miResultSet.getString("nombre_persona")
                    )
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE,null,e);
        }
        return persona;
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
