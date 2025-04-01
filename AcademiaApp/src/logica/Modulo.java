package logica;

public class Modulo {
     // Atributos de la clase: notas
     private String nombre;
     private int nota1;
     private int nota2;
     private int nota3;

     // Constructores posibles (por defecto se crea el Alumno sin notas)
     public Modulo() {
     }

     // Getters
     public String getNombre(){
	  return this.nombre;
     }
     public int getNota1() {
	  return this.nota1;
     }
     public int getNota2() {
	  return this.nota2;
     }
     public int getNota3() {
	  return this.nota3;
     }

     // Setters
     public void setNombre(String nombre){
	  this.nombre = nombre;
     }
     public void setNota1(int nota1) {
	  this.nota1 = nota1;
     }
     public void setNota2(int nota2) {
	  this.nota2 = nota2;
     }
     public void setNota3(int nota3) {
	  this.nota3 = nota3;
     }

     // Metodo toString
     public String toString() {
	  return "\nNota 1: " + this.nota1 + "\nNota 2: " + this.nota2 + "\nNota 3: " + this.nota3;
     }

     // Metodo para devolver la nota final (no puedo hacerlo con null???)
     public String notaFinal() {
	  if ((this.nota1 != 0) && (this.nota2 != 0) && (this.nota3 != 0)) {
	       float resultado = (nota1 + nota2 + nota3) / 3;
	       return "La nota final es: " + resultado;
	  } else {
	       return "Aún no ha finalizado el curso";
	  }
     }
}
