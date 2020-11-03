package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Nashiro
 */
public class conexion {

  /*  private final String base = "orcl";
    private final String user = "ADMIN";
    private final String password = "ADMIN"; 
    */
    private Connection con = null;
    //private final String url = "jdbc:oracle:thin:@localhost:1521:";

    public Connection getConexion() {
        /*try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión a la BBDD");
        }

        return con;
        */
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADMIN","ADMIN");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos");
        }
        return null;
         
    }
}


