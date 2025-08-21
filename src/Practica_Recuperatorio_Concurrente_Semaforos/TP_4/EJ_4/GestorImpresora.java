package Practica_Recuperatorio_Concurrente_Semaforos.TP_4.EJ_4;

import java.util.concurrent.Semaphore;

public class GestorImpresora {
    
    private final Semaphore impresoras;
    
    public GestorImpresora(int cantImpresoras) {
        this.impresoras = new Semaphore(cantImpresoras,true);
    }
    
    public void empezarImprimir(String nombre) throws InterruptedException {
        System.out.println(nombre + " INTENTA IMPRIMIR");
        this.impresoras.acquire();
        System.out.println(nombre + " esta imprimiendo");
    }
    
    public void terminarImprimir(String nombre) throws InterruptedException {
        System.out.println(nombre + " termina de imprimir");
        this.impresoras.release();
    }
}
