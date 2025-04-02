package logica;

import vista.VentanaLogging;
import vista.VentanaPrincipal;

public class AcademiaApp {

     public static void main(String[] args) {
	  VentanaPrincipal vp = new VentanaPrincipal();
	  vp.setVisible(true);
	  VentanaLogging vl = new VentanaLogging();
	  if(vl.acceso == true){
	       vp.dispose();
	  }
     }

}
