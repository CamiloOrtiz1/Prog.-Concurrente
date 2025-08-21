package Practica_Recuperatorio_Concurrente_Semaforos.TP_4.EJ_5;

import java.util.Random;

public class Cliente implements Runnable {

    private GestorImpresora gestor;
    private Random r = new Random();
    private char tipo;

    public Cliente(GestorImpresora gestor, char tipo) {
        this.gestor = gestor;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.gestor.empezarImprimir(this.tipo, Thread.currentThread().getName());
                Thread.sleep((r.nextInt(10) + 1) * 1000);
                this.gestor.terminarImprimir(this.tipo,Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {}
    }
}
