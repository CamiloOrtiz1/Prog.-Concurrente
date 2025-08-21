package TP_7_EJ_2;

public class Main {
    
    public static void main(String[] args) {
        GestorRecurso gestor = new GestorRecurso(20, 10);
        for (int i = 1; i < 40; i++) {
            Programador programador = new Programador("Programador " + i,gestor);
            Thread hilo = new Thread(programador);
            hilo.start();
        }
    }
    
}
