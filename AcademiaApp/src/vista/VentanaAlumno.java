package vista;

import java.awt.*;
import javax.swing.*;
import logica.Alumno;

public class VentanaAlumno extends JFrame{
     
     // Elementos de la ventana
     JPanel panelPrincipal = new JPanel();
     
     // Constructor 
     public VentanaAlumno(Alumno alumno){
	  
	  // Configuracion general
	  this.setSize(600,800);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setContentPane(panelPrincipal);
	  panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
	  
	  // Generar paneles por modulo del alumno
	  for (int x = 0; x < alumno.getModulos().size(); x++){
	       
	       // Defino los elementos necesarios
	       JPanel panelModulo = new JPanel();
	       JLabel nombreModulo = new JLabel();
	       JLabel nota1Modulo = new JLabel();
	       JLabel nota2Modulo = new JLabel();
	       JLabel nota3Modulo = new JLabel();
	       
	       // Configuro sus caracteristicas 
	       panelModulo.setLayout(new FlowLayout());
	       nombreModulo.setText(alumno.getModulos().get(x).getNombre());
	       nota1Modulo.setText(String.valueOf(alumno.getModulos().get(x).getNota1()));
	       nota2Modulo.setText(String.valueOf(alumno.getModulos().get(x).getNota2()));
	       nota3Modulo.setText(String.valueOf(alumno.getModulos().get(x).getNota3()));
	       
	       // Añado los label al panel
	       panelModulo.add(nombreModulo);
	       panelModulo.add(nota1Modulo);
	       panelModulo.add(nota2Modulo);
	       panelModulo.add(nota3Modulo);
	       
	       // Añado este panel al principal
	       panelPrincipal.add(panelModulo);
	       
	  }
     }
     
}
