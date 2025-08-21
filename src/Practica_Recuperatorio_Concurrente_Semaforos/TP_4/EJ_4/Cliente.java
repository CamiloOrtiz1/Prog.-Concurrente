package Practica_Recuperatorio_Concurrente_Semaforos.TP_4.EJ_4;

import java.util.Random;

public class Cliente implements Runnable {
    
    private GestorImpresora gestor;
    private Random r = new Random();
    
    public Cliente(GestorImpresora gestor) {
        this.gestor = gestor;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                this.gestor.empezarImprimir(Thread.currentThread().getName());
                Thread.sleep((r.nextInt(10) + 1) * 1000);
                this.gestor.terminarImprimir(Thread.currentThread().getName());
            }
        } catch(InterruptedException e) {}
    }
}
