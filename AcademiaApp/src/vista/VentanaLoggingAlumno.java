package vista;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import logica.Alumno;

public class VentanaLoggingAlumno extends VentanaLogging {
          
     // Constructor
     public VentanaLoggingAlumno() {
	  super();
     }

     @Override
     public void actionPerformed(ActionEvent ae) {

	  // Creamos un boton que recoja la acción realizada
	  JButton botonPulsado = new JButton();
	  botonPulsado = (JButton) ae.getSource();

	  // Condicionales en función del botón pulsado
	  if (botonPulsado == salir) {
	       this.dispose();
	  }

	  if (botonPulsado == ingresar) {
	       File accesoAlumno = new File("extra/acceso_alumnos.csv");
	       String linea = "";
	       String[] valores = {};
	       String inputUsuario = campoUsuario.getText().trim();
	       String inputContrasena = String.valueOf(campoContrasena.getPassword());

	       try (FileReader fr = new FileReader(accesoAlumno); BufferedReader br = new BufferedReader(fr)) {
		    while ((linea = br.readLine()) != null) {
			 linea = linea.replace("\"", "").trim();
			 valores = linea.split(", ");
			 if (valores[0].equals(inputUsuario)) {
			      if (valores[1].equals(inputContrasena)) {
				   this.acceso = true;
			      }
			 }
		    }
	       } catch (IOException e) {
		    System.out.println("No se ha podido reconocer el archivo de control de acceso");
	       } finally {
		    if (this.acceso == true) {
			 // Nueva ventana de alumno
			 this.dispose();
			 Alumno a = new Alumno("Jose", "Espadas", 29, "Desarrollo de aplicaciones multiplataforma", "Primero");
			 VentanaAlumno va = new VentanaAlumno(a);
			 va.setVisible(true);

		    } else {
			 //JDialog!
			 DialogoErrorLogging dialogo = new DialogoErrorLogging();
			 dialogo.setVisible(true);
		    }
	       }
	  }
     }
}
