package logica;

import java.util.Scanner;

public class AcademiaApp {

     public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  
	  System.out.println("Ciclo: ");
	  String ciclo = sc.nextLine();
	  
	  System.out.println("Curso: ");
	  String curso = sc.nextLine();
	  
	  Alumno a = new Alumno("Jose", "Espadas", 29, 1, ciclo, curso);
	  System.out.println(a.toString());
     }

}
