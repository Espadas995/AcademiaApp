package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DialogoErrorLogging extends JDialog implements ActionListener{

     // Declaro los elementos del dialogo
     Container contenedor = new Container();
     JLabel advertencia = new JLabel();
     JButton repetir = new JButton();

     // Construyo el JDialog
     public DialogoErrorLogging() {

	  // Elementos generales
	  contenedor = getContentPane();
	  contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
	  this.setContentPane(contenedor);
	  this.setSize(250, 75);
	  this.setAlwaysOnTop(true);
	  this.setLocationRelativeTo(null);

	  // Retocamos los subelementos
	  advertencia.setText("Error en los datos de acceso!");
	  advertencia.setFont(new Font("Iosevka", Font.BOLD, 14));
	  advertencia.setAlignmentX(CENTER_ALIGNMENT);
	  repetir.setText("Vuelve a intentarlo");
	  repetir.setFont(new Font("Iosevka", Font.BOLD, 14));
	  repetir.setAlignmentX(CENTER_ALIGNMENT);
	  repetir.addActionListener(this);

	  // Añadimos los subelementos
	  contenedor.add(advertencia);
	  contenedor.add(repetir);
     }

     @Override
     public void actionPerformed(ActionEvent ae) {
	  // Generamos un boton de recepcion de evento
	  JButton botonPulsado = new JButton();
	  botonPulsado = (JButton) ae.getSource();
	  
	  // Condicional
	  if (botonPulsado == repetir){
	       this.dispose();
	  }
     }
}
