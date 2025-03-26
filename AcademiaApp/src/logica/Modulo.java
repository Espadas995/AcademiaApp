package logica;

public class Modulo {
    // Atributos de la clase: notas
    private int nota1;
    private int nota2;
    private int nota3;
    
    // Constructores posibles (por defecto se crea el Alumno sin notas)
    public Modulo(){}
    
    // Getters
    public int getNota1(){
        return this.nota1;
    }
    public int getNota2(){
        return this.nota2;
    }
    public int getNota3(){
        return this.nota3;
    }
    
    // Setters
    public void setNota1(int nota1){
        this.nota1 = nota1;
    }
    public void setNota2(int nota2){
        this.nota2 = nota2;
    }
    public void setNota3(int nota3){
        this.nota3 = nota3;
    }
    
    // Metodo toString
    public String toString(){
        return "Nota 1: " + this.nota1 + "\nNota 2: " + this.nota2 + "Nota 3: " + this.nota3;
    }
    
    // Metodo para devolver la nota final
    public String notaFinal(){
        if((this.nota1  null) && (this.nota2 != null) && (this.nota3 != null)){
            float resultado = (nota1 + nota2 + nota3) / 3;
            return "La nota final es: " + resultado;
        } else {
            return "Aún no ha finalizado el curso";
        }
    }
}
