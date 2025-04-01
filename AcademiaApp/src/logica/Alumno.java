package logica;

import java.util.ArrayList;

public class Alumno {

     // Atributos de clase
     private String nombre;
     private String apellidos;
     private int edad;
     private int numeroAlumno;
     private String ciclo;
     private int curso;
     private ArrayList<Modulo> modulos;

     // Constructores (vacio, modulos por defecto del curso y ciclo, personalizable)
     public Alumno() {
     }

     public Alumno(String nombre, String apellidos, int edad, int numeroAlumno, String ciclo, int curso) {
	  this.nombre = nombre;
	  this.apellidos = apellidos;
	  this.edad = edad;
	  this.numeroAlumno = numeroAlumno;
	  this.ciclo = ciclo;
	  this.curso = curso;
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

     public int getCurso() {
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

     public void setCurso(int curso) {
	  this.curso = curso;
     }

     // Método toString()
     @Override
     public String toString() {
	  return "Alumno -> " + "nombre: " + nombre + ", apellidos: " + apellidos
	      + "\nEdad:" + edad + "años\nNumero de alumno -> " + numeroAlumno
	      + "\nCiclo: " + ciclo + ", Curso:" + curso + "\nModulos: " + modulos + '}';
     }
     
     /* 
     Si al construir el Alumno, se da un curso y ciclo por defecto
     Se utilizará el siguiente método para construir el array de Módulos
     */
     public ArrayList <Modulo> setModulosDefecto (String ciclo, int curso) {
	  ArrayList <Modulo> modulos = new ArrayList();
	  
	  return modulos;
     }

}
