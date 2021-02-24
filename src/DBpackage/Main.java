package DBpackage;

import java.sql.SQLException;



public class Main {
    public static void main (String[] args) throws SQLException {
        Sqlite myDb = new Sqlite();
        myDb.conectar();
        myDb.crearTabla("prueba");
        myDb.insertarDatos(0, "Nicolas", "Berto", "10");
    }
    
}
