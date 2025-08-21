package Practica_Recuperatorio_Concurrente_Semaforos.TP_4.EJ_4;

public class Main {
    
    public static void main(String[] args) {
        GestorImpresora gestor = new GestorImpresora(2);
        for (int i = 1; i <= 20; i++) {
            Thread hilo = new Thread(new Cliente(gestor),"Cliente " + i);
            hilo.start();
        }
    }
}
