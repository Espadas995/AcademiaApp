package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaProfesor extends JFrame implements ActionListener {

     // Definimos los elementos que tendrá esta ventana
     JPanel panel = new JPanel();
     JButton alta = new JButton();
     ImageIcon imagenAlta = new ImageIcon("extra/imagenes/alta.png");
     JButton baja = new JButton();
     ImageIcon imagenBaja = new ImageIcon("extra/imagenes/baja.png");
     JButton modificar = new JButton();
     ImageIcon imagenModificar = new ImageIcon("extra/imagenes/modificar.png");
     JButton listar = new JButton();
     ImageIcon imagenListar = new ImageIcon("extra/imagenes/listar.png");

     // Generamos el constructor
     public VentanaProfesor() {

	  // Indicaciones generales
	  this.setContentPane(panel);
	  this.setSize(400, 400);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  panel.setLayout(new GridLayout(2, 2));

	  // Establecemos las caracteristicas de los subelementos: alta
	  alta.setIcon(imagenAlta);
	  alta.setBorder(BorderFactory.createTitledBorder("Dar de alta"));
	  alta.addActionListener(this);

	  // Baja
	  baja.setIcon(imagenBaja);
	  baja.setBorder(BorderFactory.createTitledBorder("Dar de baja"));
	  baja.addActionListener(this);

	  // Modificar
	  modificar.setIcon(imagenModificar);
	  modificar.setBorder(BorderFactory.createTitledBorder("Modificar datos"));
	  modificar.addActionListener(this);

	  // Listar
	  listar.setIcon(imagenListar);
	  listar.setBorder(BorderFactory.createTitledBorder("Listar alumnos"));
	  listar.addActionListener(this);

	  // Añadimos los componentes al panel
	  panel.add(alta);
	  panel.add(baja);
	  panel.add(modificar);
	  panel.add(listar);
     }

     @Override
     public void actionPerformed(ActionEvent ae) {
	  
	  // Generamos un boton que recoja el evento
	  JButton botonPulsado = new JButton();
	  botonPulsado = (JButton) ae.getSource();

	  // Condicionales
	  if (botonPulsado == alta) {
	       Altas alta = new Altas();
	       alta.setVisible(true);
	  }
     }
}
