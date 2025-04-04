package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;

public class VentanaLoggingProfesor extends VentanaLogging {

     // Constructor
     public VentanaLoggingProfesor() {
	  super();
     }

     @Override
     public void actionPerformed(ActionEvent ae) {

	  // Creamos un boton que recoja la acción realizada
	  JButton botonPulsado = new JButton();
	  botonPulsado = (JButton) ae.getSource();

	  // Condicionales en función del botón pulsado
	  if (botonPulsado == this.salir) {
	       this.dispose();
	  }

	  if (botonPulsado == this.ingresar) {
	       File accesoProfesores = new File("extra/acceso_profesores.csv");
	       String linea = "";
	       String[] valores = {};
	       String inputUsuario = campoUsuario.getText().trim();
	       String inputContrasena = String.valueOf(campoContrasena.getPassword());

	       try (FileReader fr = new FileReader(accesoProfesores); BufferedReader br = new BufferedReader(fr)) {
		    while ((linea = br.readLine()) != null) {
			 linea = linea.replace("\"", "").trim();
			 valores = linea.split(", ");
			 if (inputUsuario.equalsIgnoreCase(valores[0])) {
			      if (inputContrasena.equalsIgnoreCase(valores[1])) {
				   acceso = true;
			      }
			 }
		    }
	       } catch (IOException e) {
		    System.out.println("No se ha podido reconocer el archivo de control de acceso");
	       } finally {
		    if (this.acceso == true) {
			 // Nueva ventana de profesor
			 this.dispose();
			 VentanaProfesor vp = new VentanaProfesor();
			 vp.setVisible(true);

		    } else {
			 //JDialog!
			 DialogoErrorLogging dialogo = new DialogoErrorLogging();
			 dialogo.setVisible(true);
		    }
	       }
	  }
     }
}
