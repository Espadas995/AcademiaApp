package logica;

public class Alumno {

     // Atributos de clase
     private String nombre;
     private String apellidos;
     private int edad;
     private int numeroAlumno;
     private String ciclo;
     private int curso;

     // Constructores
     public Alumno() {
     }
     
     public Alumno(String nombre, String apellidos, int edad, int numeroAlumno, String ciclo, int curso){
	  this.nombre = nombre;
	  this.apellidos = apellidos;
	  this.edad = edad;
	  this.numeroAlumno = numeroAlumno;
	  this.ciclo = ciclo;
	  this.curso = curso;
     }
}
