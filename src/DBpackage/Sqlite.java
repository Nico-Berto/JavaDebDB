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
    String nombreTabla,nombre,apellido,nota;
    int id;
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
         try{
            sentencia = c.createStatement();
        /* Delete table if it's was create */
        String sqlComand = "DROP TABLE IF EXISTS "+nombreTabla+"";
        sentencia.execute(sqlComand);
        sentencia.close();
        /* Create a table*/
        sqlComand =  "CREATE TABLE "+nombreTabla+" "+
                "(ID INT PRIMARY KEY NOT NULL, "+
                " Nombre TEXT NOT NULL, "+
                " Apellido TEXT NOT NULL, "+
                " Nota TEXT NOT NULL)";
        sentencia.execute(sqlComand);
        sentencia.close();
        c.close();
        System.out.println("Tabla creada");
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
    /*Create insertDatos method*/
    public void insertarDatos(int id, String nombre, String apellido, String nota){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
        
        /*Insert into table*/
        String sqlComand = "INSERT INTO "+nombreTabla+"(id, nombre, apellido, nota)"+
                "VALUES("+id+",'"+nombre+"','"+apellido+"','"+nota+"');";
        try{
            conectar();
            sentencia = c.createStatement();
            sentencia.executeUpdate(sqlComand);
            sentencia.close();
            c.close();
            System.out.println("Datos insertados");
        }catch (Exception e){
            System.out.println("Error al insertar datos en la tabla");
        }
    }
}
