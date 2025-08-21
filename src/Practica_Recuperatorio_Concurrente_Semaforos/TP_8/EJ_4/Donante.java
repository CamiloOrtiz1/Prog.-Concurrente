package Practica_Recuperatorio_Concurrente_Semaforos.TP_8.EJ_4;

import java.util.Random;

public class Donante implements Runnable {
    
    private final CentroHemoterapia centro;
    private final Random r = new Random();
    
    public Donante(CentroHemoterapia centro) {
        this.centro = centro;
    }
    
    @Override
    public void run() {
        try {
            this.centro.empezarDonarSangre(Thread.currentThread().getName());
            Thread.sleep((r.nextInt(10) + 1) * 1000);
            this.centro.terminarDonarSangre(Thread.currentThread().getName());
        } catch (InterruptedException e) {}
    }
}
