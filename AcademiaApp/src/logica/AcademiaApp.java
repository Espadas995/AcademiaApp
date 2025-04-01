package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AcademiaApp {

     public static void main(String[] args) {
	  File f = new File("extra/modulos_por_curso.csv");
	  String texto = "";
	  String [] dividido = {};
	  String curso = "";
	  try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr);) {
	       texto = br.readLine();
	       texto = texto.replace("\"", "");
	       dividido = texto.split(", ");
	       curso = dividido[0];
	  } catch (Exception e) {
	       System.out.println("No se pudo encontrar el archivo");
	  }
	  System.out.println(texto);
	  System.out.println(curso);
	  System.out.println(dividido[0]);
	  System.out.println(dividido[1]);
     }

}
