package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import logica.Alumno;

public class Altas extends JFrame implements ActionListener {

     // Declaramos los paneles que va a tener esta ventana
     JPanel panelPrincipal = new JPanel();
     JPanel panelNombre = new JPanel();
     JPanel panelApellidos = new JPanel();
     JPanel panelEdad = new JPanel();
     JPanel panelCiclo = new JPanel();
     JPanel panelCurso = new JPanel();
     JPanel panelBotones = new JPanel();

     // Declaramos los campos
     JLabel labelNombre = new JLabel();
     JTextField campoNombre = new JTextField();
     JLabel labelApellidos = new JLabel();
     JTextField campoApellidos = new JTextField();
     JLabel labelEdad = new JLabel();
     JTextField campoEdad = new JTextField();
     JLabel labelCiclo = new JLabel();
     JTextField campoCiclo = new JTextField();
     JLabel labelCurso = new JLabel();
     JTextField campoCurso = new JTextField();
     JButton botonAlta = new JButton();
     JButton botonSalir = new JButton();

     // Constructor
     public Altas() {
	  // Características generales
	  this.setSize(450, 300);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setContentPane(panelPrincipal);
	  panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

	  // Caracteristicas de cada panel
	  panelNombre.setLayout(new FlowLayout());
	  panelApellidos.setLayout(new FlowLayout());
	  panelEdad.setLayout(new FlowLayout());
	  panelCiclo.setLayout(new FlowLayout());
	  panelCurso.setLayout(new FlowLayout());
	  panelBotones.setLayout(new FlowLayout());

	  // Caracteristicas de cada subelemento
	  labelNombre.setText("Nombre:    ");
	  campoNombre.setColumns(20);
	  labelApellidos.setText("Apellidos: ");
	  campoApellidos.setColumns(20);
	  labelEdad.setText("Edad          ");
	  campoEdad.setColumns(5);
	  labelCiclo.setText("Ciclo:     ");
	  campoCiclo.setColumns(20);
	  labelCurso.setText("Curso:   ");
	  campoCurso.setColumns(20);
	  botonAlta.setText("Resgistrar");
	  botonAlta.addActionListener(this);
	  botonSalir.setText("Salir");
	  botonSalir.addActionListener(this);

	  // Añadimos cada subelemento a su panel
	  panelNombre.add(labelNombre);
	  panelNombre.add(campoNombre);
	  panelApellidos.add(labelApellidos);
	  panelApellidos.add(campoApellidos);
	  panelEdad.add(labelEdad);
	  panelEdad.add(campoEdad);
	  panelCiclo.add(labelCiclo);
	  panelCiclo.add(campoCiclo);
	  panelCurso.add(labelCurso);
	  panelCurso.add(campoCurso);
	  panelBotones.add(botonAlta);
	  panelBotones.add(botonSalir);

	  // Añadimos todo al panel principal
	  panelPrincipal.add(panelNombre);
	  panelPrincipal.add(panelApellidos);
	  panelPrincipal.add(panelEdad);
	  panelPrincipal.add(panelCiclo);
	  panelPrincipal.add(panelCurso);
	  panelPrincipal.add(panelBotones);
     }

     @Override
     public void actionPerformed(ActionEvent ae) {

	  // Generamos un boton que recoja el evento
	  JButton botonPulsado = new JButton();
	  botonPulsado = (JButton) ae.getSource();

	  // Condicionales
	  if (botonPulsado == botonSalir) {
	       this.dispose();
	  }

	  if (botonPulsado == botonAlta) {
	       String nombreAlumno = campoNombre.getText();
	       String apellidosAlumno = campoApellidos.getText();
	       int edadAlumno = Integer.parseInt(campoEdad.getText());
	       String cicloAlumno = campoCiclo.getText();
	       String cursoAlumno = campoCurso.getText();
	       Alumno a = new Alumno(nombreAlumno, apellidosAlumno, edadAlumno, cicloAlumno, cursoAlumno);

	       // Codigo para fichero
	       File f = new File("extra/alumno_generado.txt");
	       try (FileWriter fw = new FileWriter(f); BufferedWriter bw = new BufferedWriter(fw)) {
		    bw.write(a.toString());
		    bw.flush();
	       } catch (IOException ex) {
	       }

	       // Codigo para BBDD
	       try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/project", "user", "password");) {
		    Statement st = con.createStatement();
		    st.executeUpdate("INSERT INTO alumno VALUES(" + nombreAlumno + ", " + apellidosAlumno + ", " + edadAlumno + ", " +
			cicloAlumno + ", " + cursoAlumno + ")");
	       } catch (SQLException ex) {
		    Logger.getLogger(Altas.class.getName()).log(Level.SEVERE, null, ex);
	       }

	       this.dispose();
	  }
     }
}
