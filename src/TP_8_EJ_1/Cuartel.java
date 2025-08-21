package TP_8_EJ_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cuartel {
    
    private final Lock mutex;
    private final Condition mostradorAlmuerzo, abridorGaseosa, mostradorPostre, comedorLleno;
    private int contActualAlmuerzo, contActualGaseosa, contActualPostre, contComedor;
    private final int capacidadComedor = 100, capacidadAlmuerzo = 5, capacidadGaseosa = 5, capacidadPostre = 5;
    
    public Cuartel() {
        this.mutex = new ReentrantLock(true);
        this.mostradorAlmuerzo = mutex.newCondition();
        this.abridorGaseosa = mutex.newCondition();
        this.mostradorPostre = mutex.newCondition();
        this.comedorLleno = mutex.newCondition();
        this.contActualAlmuerzo = 0;
        this.contActualGaseosa = 0;
        this.contActualPostre = 0;
        this.contComedor = 0;
    }
    
    public void entrarRecinto() {
        mutex.lock();
        try {
            if (this.contComedor == this.capacidadComedor) {
                System.out.println(Thread.currentThread().getName() + " COMEDOR LLENO. DEBE DE ESPERAR");
                this.comedorLleno.await();
            }
            this.contComedor++;
            System.out.println(Thread.currentThread().getName() + " ENTRA AL COMEDOR");
        } catch (InterruptedException e) {}
        finally { mutex.unlock(); }
    } 
    
    public void comer(String gaseosa, String postre) {
        mutex.lock();
        try {
            if (this.contActualAlmuerzo == this.capacidadAlmuerzo) {
                System.out.println(Thread.currentThread().getName() + " NO TIENE MOSTRADORES DE ALMUERZO DISPONIBLE");
                this.mostradorAlmuerzo.await();
            } else {
                this.contActualAlmuerzo++;
                System.out.println(Thread.currentThread().getName() + " PIDE EL ALMUERZO DEL MOSTRADOR " + this.contActualAlmuerzo);
            }
            this.contActualAlmuerzo--;
            this.mostradorAlmuerzo.signal();
            if (gaseosa.equalsIgnoreCase("Gaseosa")) {
                if (this.contActualGaseosa == this.capacidadGaseosa) {
                    System.out.println(Thread.currentThread().getName() + " NO TIENE ABRIDORES DE GASEOSA DISPONIBLE");
                    this.abridorGaseosa.await();
                } else {
                    this.contActualGaseosa++;
                    System.out.println(Thread.currentThread().getName() + " UTILIZA EL ABRIDOR DE GASEOSA" + this.contActualGaseosa);
                }
                this.contActualGaseosa--;
                this.abridorGaseosa.signal();
            } else {
                System.out.println(Thread.currentThread().getName() + " TOMA AGUA");
            }
            if (postre.equalsIgnoreCase("Postre")) {
                if (this.contActualPostre == this.capacidadPostre) {
                    System.out.println(Thread.currentThread().getName() + " NO TIENE MOSTRADORES DE POSTRE DISPONIBLES.");
                    this.mostradorPostre.await();
                } else {
                    this.contActualPostre++;
                    System.out.println(Thread.currentThread().getName() + " UTILIZA EL MOSTRADOR DE POSTRE " + this.contActualPostre);
                }
                this.contActualPostre--;
                this.mostradorPostre.signal();
            }
        } catch (InterruptedException e) {}
        finally { mutex.unlock(); }
    }
    
    public void terminarComer() {
        mutex.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " SE RETIRA DEL COMEDOR");
            this.contComedor--;
            this.comedorLleno.signal();
        } finally {
            mutex.unlock();
        }
    }
}
