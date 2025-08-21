package TP_4_EJ_5;

import java.util.concurrent.Semaphore;

public class Impresora {
    
    private final Semaphore impresora;
    private final Semaphore estado;
    private final int id;
    
    public Impresora(int id) {
        this.estado = new Semaphore(1);
        this.impresora = new Semaphore(1);
        this.id = id;
    }
    
    public boolean getEstado() throws InterruptedException {
        return this.estado.tryAcquire();
    }
    
    public void setEstado() throws InterruptedException {
        this.estado.release();
    }
    
    public void utilizarImpresora() throws InterruptedException {
        this.impresora.acquire();
    }
    
    public void finalizarImpresora() throws InterruptedException {
        this.impresora.release();
        this.estado.release();
    }
    
    public int getId() {
        return this.id;
    }
}