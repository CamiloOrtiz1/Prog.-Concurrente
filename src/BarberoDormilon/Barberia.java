package BarberoDormilon;
import java.util.concurrent.Semaphore;

public class Barberia {

    private final Semaphore sillaEspera;
    private final Semaphore barbero;
    private final Semaphore sillon;
    private final Semaphore cliente;

    public Barberia() {
        this.sillaEspera = new Semaphore(5);
        this.barbero = new Semaphore(0);
        this.sillon = new Semaphore(1);
        this.cliente = new Semaphore(1);
    }

    public boolean entrarBarberia(String nombre) {
        boolean exito = false;
        if (sillaEspera.tryAcquire()) {
            System.out.println("El Cliente: " + nombre + " espera en la Barberia");
            exito = true;
        }
        return exito;
    }

    public void despertarBarbero(String nombre) {
        try {
            sillon.acquire();
            System.out.println("El cliente: " + nombre + " se sienta en la silla del barbero");
            System.out.println("El cliente: " + nombre + " despierta al barbero");
            sillaEspera.release();
            barbero.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void barberoCortaPelo() {
        try {
            barbero.acquire();
            System.out.println("El barbero comienza a cortar el pelo del cliente");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void terminarCorte() {
        System.out.println("El cliente se va de la barberia. El barbero se acuesta a dormir");
        sillon.release();
    }

}