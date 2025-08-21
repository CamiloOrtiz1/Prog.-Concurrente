package TP_7_EJ_1;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorSala {
    
    private static final int MAX_CAPACIDAD = 50, LIMITE_CAPACIDAD = 35;
    private int contSala, temperatura, contJubilados;
    private final Lock mutex = new ReentrantLock(true);
    private final Condition salaLlena;
    private final Random random = new Random();
    private boolean umbral;
    
    /*
    CORRECION 4/11/24
    DEBE DE HABER 2 CONDITION, 1 PARA LOS JUBILADOS Y OTRO PARA LOS NO JUBILADOS 
    */
    
    public GestorSala() {
        this.contSala = 0;
        this.salaLlena = mutex.newCondition();
        this.temperatura = this.random.nextInt(20, 40);
        this.umbral = this.temperatura > 30;
    }
    
    public void entrarSala(String nombre) {
        // Se invoca cuando una persona quiere entrar en la sala.
        mutex.lock();
        try {
            while (this.contSala == MAX_CAPACIDAD || (this.umbral && this.contSala == LIMITE_CAPACIDAD)) {
                if (this.umbral) {
                    System.out.println("LA TEMPERATURA ES MAYOR A 30 Y LA CANTIDAD DE PERSONAS EN LA SALA ES MAYOR A 35, DEBE DE ESPERAR. Contador Sala: " + this.contSala);
                } else {
                    System.out.println("SALA LLENA, " + nombre + " DEBE DE ESPERAR. Contador Sala: " + this.contSala);
                }
                this.salaLlena.await();
            }
            if (this.contJubilados != 0) {
                System.out.println("DEBE DE ESPERAR, YA QUE HAY JUBILADOS ESPERANDO");
                salaLlena.await();
            }
            this.contSala++;
            System.out.println("Ingreso la " + nombre + " a la Sala. Contador Sala: " + this.contSala);
            this.salaLlena.signalAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
        }        
        finally { mutex.unlock(); }
    }
    
    public void entrarSalaJubilado(String nombre) {
        // Se invoca cuando una persona jubilada quiere entrar en la sala.
        mutex.lock();
        this.contJubilados++;
        try {
            while (this.contSala == MAX_CAPACIDAD || (this.umbral && this.contSala == LIMITE_CAPACIDAD)) {
                if (this.umbral) {
                    System.out.println("LA TEMPERATURA ES MAYOR A 30 Y LA CANTIDAD DE PERSONAS EN LA SALA ES MAYOR A 35, DEBE DE ESPERAR. Contador Sala: " + this.contSala);
                } else {
                    System.out.println("SALA LLENA, " + nombre + " DEBE DE ESPERAR. Contador Sala: " + this.contSala);
                }
                salaLlena.await();
            }
            this.contJubilados--;
            this.contSala++;
            System.out.println("Ingreso la " + nombre + " a la Sala. Contador Sala: " + this.contSala);
            salaLlena.signalAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally { mutex.unlock(); }
    }
    
    public void salirSala(String nombre) {
        // Se invoca cuando una persona, jubilada o no, quiere salir de la sala.
        mutex.lock();
        try {
            while (this.contSala == 0) {
                salaLlena.await();
            }
            this.contSala--;
            System.out.println("Se fue la " + nombre + " de la Sala.");
            salaLlena.signalAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally { mutex.unlock(); }
    }
    
    public void notificarTemperatura(int temperatura) {
        // Se invoca la hebra que mide la temperatura de la sala para indicar el ultimo valor medido.
        mutex.lock();
        try {
            this.temperatura = temperatura;
            this.umbral = this.temperatura > 30;
            System.out.println("LA NUEVA TEMPERATURA MEDIDA ES DE: " + this.temperatura);
            salaLlena.signalAll();
        } finally { mutex.unlock(); }
    }
    
}
