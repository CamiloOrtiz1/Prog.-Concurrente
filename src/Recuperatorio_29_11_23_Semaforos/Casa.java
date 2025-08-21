package Recuperatorio_29_11_23_Semaforos;

import java.util.concurrent.Semaphore;

public class Casa {
    
    // RECURSO COMPARTIDO
    
    private Semaphore banquitos, mayor, comer, mutex;
    private int esperando, comiendo, capacidad;
    
    public Casa() {
        this.banquitos = new Semaphore(4,true);
        this.mayor = new Semaphore(0);
        this.comer = new Semaphore(0,true);
        this.mutex = new Semaphore(1,true);
        this.esperando = 0;
        this.comiendo = 0;
        this.capacidad = 4;
        
    }
    
    public void verificarBanquito() throws InterruptedException {
        this.mutex.acquire();
        if (this.comiendo == this.capacidad) {
            this.mutex.release();
            this.esperar();
        } else {
            this.mutex.release();
            this.empezarAComer();
        }
    }
    
    private void esperar() throws InterruptedException {
        this.mutex.acquire();
        this.esperando++;
        System.out.println(Thread.currentThread().getName() + " Espera por un banquito");
        this.mutex.release();
        this.banquitos.acquire(); // Se bloquea
        this.mutex.acquire();
        this.esperando--;
        this.mutex.release();
        this.empezarAComer();
    }
    
    public void empezarAComer() throws InterruptedException {
        this.mutex.acquire();
        this.comiendo++;
        System.out.println(Thread.currentThread().getName() + " Avisa a Animalito Mayor que ya esta sentado y espera la comida.");
        this.mayor.release();
        this.mutex.release();
        this.comer.acquire();
        System.out.println(Thread.currentThread().getName() + " Esta comiendo!");
    }
    
    public void terminarDeComer() throws InterruptedException {
        this.mutex.acquire();
        this.comiendo--;
        System.out.println(Thread.currentThread().getName() + " Termina de comer y deja el banquito libre.");
        this.banquitos.release();
        this.mutex.release();
    }
    
    public void darComida() throws InterruptedException {
        System.out.println(".... Animalito Mayor esta dibujando ....");
        this.mayor.acquire();
        System.out.println("Animalito Mayor sirve la comida y avisa que puede comer");
        this.comer.release();
    }
}
