package TP_4_EJ_3;

import java.util.concurrent.Semaphore;

public class Organizador {
    
    private final Semaphore semaforoP1;
    private final Semaphore semaforoP2;
    private final Semaphore semaforoP3;
    
    public Organizador() {
        this.semaforoP1 = new Semaphore(1);
        this.semaforoP2 = new Semaphore(0);
        this.semaforoP3 = new Semaphore(0);
    }
    
    public void procesoTerminado(String nombre) {
        switch (nombre) {
            case "P1" -> {
                this.semaforoP3.release();
            }
            case "P3" -> {
                this.semaforoP2.release();
            }
            case "P2" -> {
                this.semaforoP1.release();
            }
            default -> {}
        }
    }
    
    public void iniciarProceso(String nombre) throws InterruptedException {
        switch (nombre) {
            case "P1" -> {
                this.semaforoP1.acquire();
            }
            case "P3" -> {
                this.semaforoP3.acquire();
            }
            case "P2" -> {
                this.semaforoP2.acquire();
            }
            default -> {}
        }
    }
}
