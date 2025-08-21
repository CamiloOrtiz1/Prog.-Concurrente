package Practica_Recuperatorio_Concurrente_Semaforos.TP_4.EJ_5;

import java.util.concurrent.Semaphore;

public class GestorImpresora {
    
    private final Semaphore impresoraA, impresoraB;
    private final Semaphore mutexA, mutexB;
    private char tipo;
    
    public GestorImpresora(int cantA, int cantB) {
        this.impresoraA = new Semaphore(cantA,true);
        this.impresoraB = new Semaphore(cantB,true);
        this.mutexA = new Semaphore(1);
        this.mutexB = new Semaphore(1);
        this.tipo = '-';
    }
    
    public void empezarImprimir(char tipo, String nombre) throws InterruptedException {
        if (tipo == 'A') {
            System.out.println(nombre + " INTENTA IMPRIMIR EN LA IMPRESORA A");
            this.mutexA.acquire();
            this.impresoraA.acquire();
            System.out.println(nombre + " empieza a imprimir en A");
        } else {
            System.out.println(nombre + " INTENTA IMPRIMIR EN LA IMPRESORA B");
            this.mutexB.acquire();
            this.impresoraB.acquire();
            System.out.println(nombre + " empieza a imprimir en B");
        }
    }
    
    public void terminarImprimir(char tipo, String nombre) {
        if (tipo == 'A') {
            System.out.println(nombre + " termina de imprimir en la impresora A");
            this.impresoraA.release();
            this.mutexA.release();
        } else {
            System.out.println(nombre + " termina de imprimir en la impresora B");
            this.impresoraB.release();
            this.mutexB.release();
        }
    }
}
