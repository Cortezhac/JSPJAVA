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
    
    public boolean actualizarDatos(Persona Useredit, String dui , boolean editdui){
        try{
            String queryStatement;
            if(editdui == true){
                queryStatement = "UPDATE tb_persona SET tb_persona.dui_persona = *" + Useredit.getDui() + "' WHERE tb_persona.apellidos_persona = '" + getApellidos() + "';";
            }else{
                queryStatement = "UPDATE tb_persona SET apellidos_persona = '" + Useredit.getApellidos() + "', nombre_persona = '" + Useredit.getNombre() 
                    + "' WHERE dui_persona='" + dui + "';";
            }
            statement = con.createStatement();
            int estado = 0;
            System.out.println("SQL " + queryStatement);
            estado = statement.executeUpdate(queryStatement);

            if(estado == 1){
                return true;
            }
        }catch(SQLException ex){
            System.out.println("" + ex);
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
    
    /**
     * Busca un registro en la base de datos y lo retorna en un objeto 
     * @param dui
     * @return Resultado
     */
    public Persona buscarRegistro(String dui){
        Persona Resultado = null;
        try {
            String sqlQueryStatement = "SELECT * FROM tb_persona WHERE dui_persona = '" + dui + "' ;";
            statement = con.createStatement();
            miResultSet = statement.executeQuery(sqlQueryStatement);
            miResultSet.next();
            Resultado = new Persona(miResultSet.getString("dui_persona"),
                                    miResultSet.getString("apellidos_persona"),
                                    miResultSet.getString("nombre_persona"));
        } catch (SQLException e) {
            System.out.println("Error buscarDatos " + getClass() + " " + e);
        }
        return Resultado;
    }
    
    public boolean eliminarRegistro(String dui){
        try {
            
        } catch (Exception e) {
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
