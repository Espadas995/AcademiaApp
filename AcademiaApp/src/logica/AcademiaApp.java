package logica;

import java.sql.*;
import vista.VentanaLogging;
import vista.VentanaPrincipal;

public class AcademiaApp {

     public static void main(String[] args) throws SQLException {
	  
	  VentanaPrincipal vp = new VentanaPrincipal();
	  vp.setVisible(true);	  
	  
	  // Conexion a BBDD, usar un try-catch para cerrar la conexion y no usar con.close();
	  Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/project", "user", "password");
     }

}
