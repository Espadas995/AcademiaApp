package logica;

import org.mariadb.jdbc.Connection;
import vista.VentanaLogging;
import vista.VentanaPrincipal;

public class AcademiaApp {

     public static void main(String[] args) {
	  
	  // Conexion a BBDD
	  //Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/project", "root", "passwd");
	  
	  
	  VentanaPrincipal vp = new VentanaPrincipal();
	  vp.setVisible(true);	  
     }

}
