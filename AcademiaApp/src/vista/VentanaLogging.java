package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class VentanaLogging extends JFrame implements ActionListener {

     // Definimos una variable de acceso concedido o rechazado
     protected boolean acceso = false;

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
	  
     }

     
}
