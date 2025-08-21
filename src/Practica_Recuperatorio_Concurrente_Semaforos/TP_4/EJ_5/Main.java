package Practica_Recuperatorio_Concurrente_Semaforos.TP_4.EJ_5;

import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        GestorImpresora gestor = new GestorImpresora(4,2);
        Random r = new Random();
        for (int i = 1; i <= 20; i++) {
            char tipo = (r.nextInt(2) == 0) ? 'A' : 'B';
            Thread hilo = new Thread(new Cliente(gestor,tipo),"Cliente " + i);
            hilo.start();
        }
    }
}
