package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class VentanaLogging extends JFrame implements ActionListener {
     
     // Definimos una variable de acceso concedido o rechazado
     public boolean acceso = false;

     // Definimos los elementos que tendrá la ventana de logging: paneles
     JPanel panelLogging = new JPanel();
     JPanel datosUsuario = new JPanel();
     JPanel datosContrasena = new JPanel();
     JPanel botonesLogging = new JPanel();

     // Elementos de los paneles
     JLabel usuario = new JLabel();
     JLabel contrasena = new JLabel();
     JTextField campoUsuario = new JTextField();
     JPasswordField campoContrasena = new JPasswordField();
     JButton ingresar = new JButton();
     JButton salir = new JButton();

     // Construimos la ventana
     public VentanaLogging() {
	  // Definimos los elementos generales
	  this.setSize(350, 175);
	  this.setLocationRelativeTo(null);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setContentPane(panelLogging);
	  panelLogging.setLayout(new BoxLayout(panelLogging, BoxLayout.Y_AXIS));
	  datosUsuario.setLayout(new FlowLayout());
	  datosContrasena.setLayout(new FlowLayout());
	  botonesLogging.setLayout(new FlowLayout());

	  // Construimos los elementos definidos arriba
	  usuario.setText("Usuario:        ");
	  usuario.setFont(new Font("Iosevka", Font.BOLD, 14));
	  contrasena.setText("Contraseña: ");
	  contrasena.setFont(new Font("Iosevka", Font.BOLD, 14));
	  campoUsuario.setColumns(15);
	  campoContrasena.setColumns(15);
	  ingresar.setText("Ingresar");
	  ingresar.addActionListener(this);
	  salir.setText("Salir");
	  salir.addActionListener(this);

	  // Alineaciones y tamaños
	  datosUsuario.setAlignmentX(CENTER_ALIGNMENT);
	  datosContrasena.setAlignmentX(CENTER_ALIGNMENT);
	  botonesLogging.setAlignmentX(CENTER_ALIGNMENT);

	  // Añadimos los elementos a sus respectivos paneles
	  datosUsuario.add(usuario);
	  datosUsuario.add(campoUsuario);
	  datosContrasena.add(contrasena);
	  datosContrasena.add(campoContrasena);
	  botonesLogging.add(ingresar);
	  botonesLogging.add(salir);

	  // Añadimos los subpaneles al superior
	  panelLogging.add(datosUsuario);
	  panelLogging.add(datosContrasena);
	  panelLogging.add(botonesLogging);
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
	       File acceso = new File("extra/acceso.csv");
	       String linea = "";
	       String [] valores = {};
	       String tipoAcceso = "";
	       String inputUsuario = campoUsuario.getText().trim();
	       String inputContrasena = String.valueOf(campoContrasena.getPassword());
	       System.out.println(inputUsuario);
	       System.out.println(inputContrasena);
	       
	       boolean flag = false;
	       try (FileReader fr = new FileReader(acceso); BufferedReader br = new BufferedReader(fr)) {
		    while((linea = br.readLine()) != null){
			 linea = linea.replace("\"", "");
			 valores = linea.split(", ");
			 if (valores[0].equals(inputUsuario)){
			      if(valores[1].equals(inputContrasena)){
				   flag = true;
				   tipoAcceso = valores[2];
			      }
			 }
		    }
	       } catch (IOException e) {
		    System.out.println("No se ha podido reconocer el archivo de control de acceso");
	       } finally {
		    if (flag == true){
			 if(tipoAcceso.equals("profesor")){
			      // Nueva ventana de profesor
			      this.acceso = true;
			      this.dispose();
			      VentanaProfesores vp = new VentanaProfesores();
			      vp.setVisible(true);
			 }
			 else {
			      // Nueva ventana de alumno
			      this.acceso = true;
			      this.dispose();
			 }
		    } else {
			 //JDialog!
			 DialogoErrorLogging dialogo = new DialogoErrorLogging();
			 dialogo.setVisible(true);
		    }
	       }
	  }
     }
}
