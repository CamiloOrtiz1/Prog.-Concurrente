package TP_5_EJ_5;

import java.util.concurrent.Semaphore;

public class Tren {
    
    private final Semaphore asientos;
    private final Semaphore mutex;
    private final Semaphore permisoRecorrido;
    private int pasajerosActuales;
    
    public Tren() {
        this.asientos = new Semaphore(5);
        this.mutex = new Semaphore(1);
        this.permisoRecorrido = new Semaphore(0);
        this.pasajerosActuales = 0;
    }
    
    public void iniciarRecorrido() throws InterruptedException {
        this.permisoRecorrido.acquire();
        System.out.println("Inicio del recorrido del Tren!");
    }
    
    public void finalizarRecorrido() throws InterruptedException {
        this.mutex.acquire();
        // Reseteo la variable contadora de pasajerosActuales
        this.pasajerosActuales = 0;
        System.out.println("Finaliza el recorrido del Tren. Todos los pasajeros bajan!");
        this.asientos.release(5);
        this.mutex.release();
    }
    
    public void comprarTicket(String nombre) throws InterruptedException {
        this.asientos.acquire(); // El pasajero obtiene un ticket
        this.mutex.acquire(); // Protejo la seccion critica, la variable contadora
        this.pasajerosActuales++;
        System.out.println(nombre + " Compro un ticket y subio al tren. Pasajeros actuales del Tren: " + this.pasajerosActuales);
        
        if (this.pasajerosActuales == 5) {
            System.out.println("El tren esta lleno, puede iniciar el recorrido!");
            this.permisoRecorrido.release();
        }
        this.mutex.release();
    }
}
