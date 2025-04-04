package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

     // Definimos los elementos que tendrá la ventana principal: bienvenida y segundo contenedor
     JPanel panelPrincipal = new JPanel();
     JPanel panelAcceso = new JPanel();
     JLabel bienvenida = new JLabel();
     ImageIcon imagenInstituto = new ImageIcon("extra/imagenes/instituto.png");
     JLabel labelInstituto = new JLabel();

     // Sección alumno
     ImageIcon imagenAlumno = new ImageIcon("extra/imagenes/alumno.png");
     JButton botonAlumno = new JButton();

     // Sección profesor
     ImageIcon imagenProfesor = new ImageIcon("extra/imagenes/profesor.png");
     JButton botonProfesor = new JButton();

     // Construimos la ventana
     public VentanaPrincipal() {

	  // Definimos elementos generales
	  this.setSize(550, 400);
	  this.setLocationRelativeTo(null);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setContentPane(panelPrincipal);
	  panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
	  panelAcceso.setLayout(new FlowLayout());

	  // Contruimos nuestros elementos definidos más arriba: bienvenida
	  bienvenida.setText("Bienvenidos a Clara del Rey!");
	  bienvenida.setFont(new Font("Iosevka", Font.BOLD, 26));
	  bienvenida.setPreferredSize(new Dimension(50, 50));
	  bienvenida.setAlignmentX(CENTER_ALIGNMENT);
	  labelInstituto.setIcon(imagenInstituto);
	  labelInstituto.setPreferredSize(new Dimension(100, 100));
	  labelInstituto.setAlignmentX(CENTER_ALIGNMENT);
	  panelAcceso.setAlignmentX(CENTER_ALIGNMENT);

	  // Seccion alumno
	  botonAlumno.setIcon(imagenAlumno);
	  botonAlumno.setPreferredSize(new Dimension(200, 200));
	  botonAlumno.setBorder(BorderFactory.createTitledBorder("Acceso Alumnos"));
	  botonAlumno.addActionListener(this);

	  // Seccion profesor
	  botonProfesor.setIcon(imagenProfesor);
	  botonProfesor.setBorder(BorderFactory.createTitledBorder("Acceso Profesores"));
	  botonProfesor.setPreferredSize(new Dimension(200, 200));
	  botonProfesor.addActionListener(this);

	  // Añadimos los elementos del panel de acceso
	  panelAcceso.add(botonAlumno);
	  panelAcceso.add(botonProfesor);

	  // Añadimos los elementos al panel principal
	  panelPrincipal.add(bienvenida);
	  panelPrincipal.add(labelInstituto);
	  panelPrincipal.add(panelAcceso);

     }

     @Override
     public void actionPerformed(ActionEvent ae) {

	  // Generamos un boton que tome la fuente de la accion
	  JButton botonPulsado = new JButton();
	  botonPulsado = (JButton) ae.getSource();

	  // Condicionales en funcion de que boton sea pulsado}
	  if (botonPulsado == botonAlumno) {
	       VentanaLogging vl = new VentanaLogging();
	       vl.setVisible(true);
	       vl.setAlwaysOnTop(true);
	       this.dispose();
	  }

	  if (botonPulsado == botonProfesor) {
	       VentanaLogging vl = new VentanaLogging();
	       vl.setVisible(true);
	       vl.setAlwaysOnTop(true);
	       this.dispose();
	  }
     }
}
