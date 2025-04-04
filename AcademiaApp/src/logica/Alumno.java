package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Alumno {

     // Atributos de clase
     private String nombre;
     private String apellidos;
     private int edad;
     private int numeroAlumno; // Se debe implementar de forma automatica !! Static?
     private static int contadorNumeroAlumno = 0;
     private String ciclo;
     private String curso;
     private ArrayList<Modulo> modulos;

     // Constructores (vacio, modulos por defecto del curso y ciclo, personalizable)
     public Alumno() {
     }

     public Alumno(String nombre, String apellidos, int edad, String ciclo, String curso) {
	  this.nombre = nombre;
	  this.apellidos = apellidos;
	  this.edad = edad;
	  this.numeroAlumno = generarIdAlumno();
	  this.ciclo = ciclo;
	  this.curso = curso;
	  this.modulos = getModulosDefecto(ciclo, curso);
     }
     
     public Alumno(String nombre, String apellidos, int edad, 
	 String ciclo, String curso, ArrayList <Modulo> modulosPersonalizados) {
	  this.nombre = nombre;
	  this.apellidos = apellidos;
	  this.edad = edad;
	  this.numeroAlumno = generarIdAlumno();
	  this.ciclo = ciclo;
	  this.curso = curso;
	  this.modulos = modulosPersonalizados;
     }

     // Getters
     public String getNombre() {
	  return nombre;
     }

     public String getApellidos() {
	  return apellidos;
     }

     public int getEdad() {
	  return edad;
     }

     public int getNumeroAlumno() {
	  return numeroAlumno;
     }

     public String getCiclo() {
	  return ciclo;
     }

     public String getCurso() {
	  return curso;
     }

     // Setters
     public void setNombre(String nombre) {
	  this.nombre = nombre;
     }

     public void setApellidos(String apellidos) {
	  this.apellidos = apellidos;
     }

     public void setEdad(int edad) {
	  this.edad = edad;
     }

     public void setNumeroAlumno(int numeroAlumno) {
	  this.numeroAlumno = numeroAlumno;
     }

     public void setCiclo(String ciclo) {
	  this.ciclo = ciclo;
     }

     public void setCurso(String curso) {
	  this.curso = curso;
     }

     // Método toString()
     @Override
     public String toString() {
	  return "Alumno -> " + "Nombre, Apellidos: " + nombre + " " + apellidos
	      + "\nEdad:" + edad + " años\nNúmero de alumno -> " + numeroAlumno
	      + "\nCiclo: " + ciclo + ", Curso: " + curso + "\n\nModulos: " + modulos.toString() +"\n";
     }

     /* 
     Si al construir el Alumno, se da un curso y ciclo por defecto
     Se utilizará el siguiente método para construir el array de Módulos
     Usaremos ArrayList porque se va a iterar sobre el array, no añadir y eliminar
      */
     public ArrayList<Modulo> getModulosDefecto(String ciclo, String curso) {
	  ArrayList<Modulo> modulos = new ArrayList();
	  File modulosCurso = new File("extra/modulos_por_curso.csv");
	  String lineaDatos = "";
	  String [] datosCiclo = {};
	  try (FileReader fr = new FileReader(modulosCurso); 
	      BufferedReader br = new BufferedReader(fr)) {
	       while((lineaDatos = br.readLine()) != null){
		    lineaDatos = lineaDatos.replace("\"", "");
		    datosCiclo = lineaDatos.split(", ");
		    if(datosCiclo[0].equalsIgnoreCase(ciclo) && datosCiclo[1].equalsIgnoreCase(curso)){
			 for(int x=2; x<datosCiclo.length; x++){
			      modulos.add(new Modulo(datosCiclo[x]));
			 }
			 break;
		    }
	       }
	  } catch (IOException e) {
	       System.out.println("No se ha podido leer el archivo CSV");
	  }
	  return modulos;
     }
     
     // Generamos un metodo para autogenerar el numero de id del alumno
     public int generarIdAlumno(){
	  contadorNumeroAlumno++;
	  return contadorNumeroAlumno;
     }

}
