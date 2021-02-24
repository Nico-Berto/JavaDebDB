package DBpackage;

import java.sql.SQLException;



public class Main {
    public static void main (String[] args) {
        Sqlite myDb = new Sqlite();
        myDb.conectar();
        try {
            myDb.crearTabla("prueba");
        } catch (SQLException e) {
            System.out.println("Error");;
        }
    }
    
}
