package Practica_Recuperatorio_Concurrente_Semaforos.TP_8.EJ_4;

public class Main {
    
    public static void main(String[] args) {
        CentroHemoterapia centro = new CentroHemoterapia();
        for (int i = 1; i < 20; i++) {
            Thread hilo = new Thread(new Donante(centro), "Donante " +i);
            hilo.start();
        }
    }
}
