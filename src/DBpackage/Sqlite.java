/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

DOCUMENTATION: 
https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
 */
package DBpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Sqlite {
    /* Atributes*/
    Connection c = null;
    Statement sentencia = null; /*A Statement is a interfaz that represent a SQL
    instruction*/
    String nombreTabla;
    /* Conected method*/
    public void conectar(){
    try{
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:test.db");
        System.out.println("Exito al conectar con la base de datos");
    }catch(Exception e){
        System.out.println("Error al conectar con la base de datos");
    }
}
    /* Create table method */
    public void crearTabla (String nombreTabla) throws SQLException{
        this.nombreTabla = nombreTabla;
        /* Delete table if it's was create */
        String sqlComand = "DROP TABLE IF EXISTS ;"+nombreTabla+"";
        sentencia.execute(sqlComand);
        /* Create a table*/
        sqlComand =  "CREATE TABLE "+nombreTabla+" "+
                "(ID INT PRIMARY KWY NOT NULL)";
        sentencia.execute(sqlComand);
        try{
            
        }catch(Exception e){
            
        }
    }
}
