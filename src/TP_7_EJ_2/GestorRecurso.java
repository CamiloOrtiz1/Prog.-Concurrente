package TP_7_EJ_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorRecurso {
    
    private final int computadoras, libros;
    private final Lock cerrojo = new ReentrantLock(true);
    private final Condition recurso;
    private int contComputadoras, contLibros;
    
    public GestorRecurso(int computadoras, int libros) {
        this.recurso = cerrojo.newCondition();
        this.computadoras = computadoras;
        this.libros = libros;
        this.contComputadoras = 0;
        this.contLibros = 0;
    }
    
    public void pedirRecurso(String nombre) {
        cerrojo.lock();
        try {
            while (this.contComputadoras == this.computadoras || this.contLibros == this.libros) {
                System.out.println(nombre + " Debe de esperar por falta de recursos. ---------- Computadoras: " + this.contComputadoras + "; Libros: " +this.contLibros);
                recurso.await();
            }
            this.contComputadoras++;
            this.contLibros++;
            System.out.println(nombre + " Tiene disponible un Libro y una Computadora.");
            recurso.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally { cerrojo.unlock(); }
    }
    
    public void liberarRecurso(String nombre) {
        cerrojo.lock();
        try {
            while (this.contComputadoras == 0 || this.contLibros == 0) {
                recurso.await();
            }
            this.contComputadoras--;
            this.contLibros--;
            System.out.println(nombre + " Libera los recursos.");
            recurso.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally { cerrojo.unlock(); }
    }
}
