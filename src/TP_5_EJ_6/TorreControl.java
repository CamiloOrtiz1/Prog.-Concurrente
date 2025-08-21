package TP_5_EJ_6;

import java.util.concurrent.Semaphore;

public class TorreControl {
    
    /*
     * Numero maximo de aviones utilizando la pista es de 1.
     * Los que quieran aterrizar tienen prioridad.
     * La torre prioriza el despegue despues de 10 aterrizajes.
     */
    
    private final Semaphore pista;
    private final Semaphore mutex;
    private final Semaphore aterrizar;
    private final Semaphore despegar;
    private int contAterrizaje;
    private int contDespeje;
    
    public TorreControl() {
        this.pista = new Semaphore(1);
        this.mutex = new Semaphore(1);
        this.aterrizar = new Semaphore(10);
        this.despegar = new Semaphore(0);
        this.contAterrizaje = 0;
        this.contDespeje = 0;
    }
    
    public void aterrizar(String nombre) throws InterruptedException {
        // Obtengo el permiso para aterrizar
        this.aterrizar.acquire();
        // Obtengo el permiso de la pista
        this.pista.acquire();
        // Seccion critica
        this.mutex.acquire();
        this.contAterrizaje++;
        System.out.println(nombre + " Aterrizo en la pista, cantidad de Aterrizajes: " + this.contAterrizaje);
        Thread.sleep(2000);
        // Verifico si el avion que llega es el numero 10 de aterrizajes
        if (this.contAterrizaje == 10) {
            System.out.println("SE COMPLETO EL CICLO DE 10 ATERRIZAJES");
            this.contAterrizaje = 0;
            this.despegar.release(5);
        }
        this.mutex.release();
        this.pista.release();
    }
    
    public void despegar(String nombre) throws InterruptedException {
        // Obtengo el permiso para despegar
        this.despegar.acquire();
        // Obtengo el permiso de la pista
        this.pista.acquire();
        // Seccion critica
        this.mutex.acquire();
        this.contDespeje++;
        System.out.println(nombre + " Despega de la pista, cantidad de Despegues: " + this.contDespeje);
        if (this.contDespeje == 5) {
            System.out.println("SE COMPLETO EL CICLO DE DESPEGUES");
            this.contDespeje = 0;
            this.aterrizar.release(10);
        }
        this.mutex.release();
        this.pista.release();
     }
}
