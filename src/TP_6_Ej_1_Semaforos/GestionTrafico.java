package TP_6_Ej_1_Semaforos;

import java.util.concurrent.Semaphore;

public class GestionTrafico {
    
    private Semaphore semNorte;
    private Semaphore semSur;
    private Semaphore mutex;
    private int autosNorte;
    private int autosSur;
    private char direccion;
    
    public GestionTrafico() {
        this.semNorte = new Semaphore(0,true);
        this.semSur = new Semaphore(0,true);
        this.mutex = new Semaphore(1);
        this.autosNorte = 0;
        this.autosSur = 0;
        this.direccion = ' ';
    }
    
    public void EntrarCocheDelNorte(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.autosNorte++;
        if (this.direccion == ' ') {
            this.direccion = 'N';
            this.semNorte.release();
        }
        this.mutex.release();
        this.semNorte.acquire();
        System.out.println("[" + this.direccion + "] " + nombre + " Esta cruzando el puente");
    }
    
    public void SalirCocheDelNorte(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.autosNorte--;
        if (this.autosNorte == 0) {
            this.direccion = ' ';
            System.out.println("Cambio de direccion desde Norte a Sur, cambia a Sur a norte");
            this.semSur.release();
        } else {
            System.out.println("[" + this.direccion + "] " + nombre + " Termina de cruzar el puente");
            this.semNorte.release();
        }
        this.mutex.release();
    }
    
    public void EntrarCocheDelSur(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.autosSur++;
        if (this.direccion == ' ') {
            this.direccion = 'S';
            this.semSur.release();
        }
        this.mutex.release();
        this.semSur.acquire();
        System.out.println("[" + this.direccion + "] " + nombre + " Esta cruzando el puente");
    }
    
    public void SalirCocheDelSur(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.autosSur--;
        if (this.autosSur == 0) {
            this.direccion = ' ';
            System.out.println("Cambio de direccion, hacia Norte a Sur");
            this.semNorte.release();
        } else {
            System.out.println("[" + this.direccion + "] " + nombre + " Termina de cruzar el puente");
            this.semSur.release();
        }
        this.mutex.release();
    }
}
