package TP_6_Ej_2_Implementacion_Monitor;

public class Main {
    
    public static void main(String[] args) {
        SalaDeEstudio sala = new SalaDeEstudio(5);
        for (int i = 1; i < 20; i++) {
            Estudiante estudiante = new Estudiante("Estudiante " + i, sala);
            Thread hilo = new Thread(estudiante);
            hilo.start();
        }
    }
    
}
