package Parcial_13_11_2023.Problema_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Espacio {
    
    private final Lock cerrojo = new ReentrantLock(true);
    private final Condition oxigeno = cerrojo.newCondition();
    private final Condition hidrogeno = cerrojo.newCondition();
    private int contadorHidrogeno = 0, contadorOxigeno = 0, contadorRecipiente = 0; 
    private final int capacidadRecipiente = 5;
    
    public Espacio() {}
/*    
    public void Olisto() throws InterruptedException {
        cerrojo.lock();
        try {
            this.contadorOxigeno++;
            while (this.contadorOxigeno < 1) {
                System.out.println(Thread.currentThread().getName() +" FALTAN RECURSOS");
                oxigeno.await();
            }
            this.hacerAgua();
            this.hidrogeno.signal();
            this.hidrogeno.signal();
            this.contadorOxigeno--;
            this.contadorHidrogeno -= 2;
        } finally { cerrojo.unlock(); }
    }
    
    public void Hlisto() throws InterruptedException {
        cerrojo.lock();
        try {
            this.contadorHidrogeno++;
            while (this.contadorOxigeno < 1 || this.contadorHidrogeno < 2) {
                System.out.println(Thread.currentThread().getName() +" FALTAN RECURSOS");
                hidrogeno.await();
            }
            this.hacerAgua();
            this.oxigeno.signal();
            this.hidrogeno.signal();
            this.contadorHidrogeno -= 2;
            this.contadorOxigeno--;
        } finally { cerrojo.unlock(); }
    }
    
    public void hacerAgua() {
        this.contadorRecipiente++;
        if (this.capacidadRecipiente == this.contadorRecipiente) {
            System.out.println("Recipiente lleno, Formo agua");
            this.contadorRecipiente = 0;
        }
    }
}
*/
    
    public void Olisto() throws InterruptedException {
        cerrojo.lock();
        try {
            this.contadorOxigeno++;
            System.out.println(Thread.currentThread().getName() +" Olisto");
            if (this.contadorOxigeno >= 1 && this.contadorHidrogeno >= 2) {
                System.out.println(Thread.currentThread().getName() + " Formo agua");
                this.hacerAgua();
                this.hidrogeno.signal();
                this.hidrogeno.signal();
                this.contadorOxigeno--;
                this.contadorHidrogeno -= 2;
            } else {
                this.oxigeno.await();
            }
        } finally { cerrojo.unlock(); }
    }
    
    public void Hlisto() throws InterruptedException {
        cerrojo.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Hlisto");
            this.contadorHidrogeno++;
            if (this.contadorOxigeno >= 1 && this.contadorHidrogeno >= 2) {
                System.out.println(Thread.currentThread().getName() + " Formo agua");
                this.hacerAgua();
                this.oxigeno.signal();
                this.hidrogeno.signal();
                this.contadorOxigeno--;
                this.contadorHidrogeno -= 2;
            } else {
                this.hidrogeno.await();
            }
        } finally { cerrojo.unlock(); }
    }
    
    public void hacerAgua() {
        this.contadorRecipiente++;
        if (this.capacidadRecipiente == this.contadorRecipiente) {
            System.out.println("Recipiente lleno, Formo agua");
            this.contadorRecipiente = 0;
        }
    }
}
