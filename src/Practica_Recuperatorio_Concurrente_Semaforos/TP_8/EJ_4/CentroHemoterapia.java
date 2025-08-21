package Practica_Recuperatorio_Concurrente_Semaforos.TP_8.EJ_4;

import java.util.concurrent.Semaphore;

public class CentroHemoterapia {
    
    private final Semaphore camillas, revistas, mutex;
    private int contCamillas;
    
    public CentroHemoterapia() {
        this.camillas = new Semaphore(4,true);
        this.revistas = new Semaphore(9,true);
        this.mutex = new Semaphore(1,true);
        this.contCamillas = 4;
    }
    
    public void empezarDonarSangre(String nombre) throws InterruptedException {
        this.mutex.acquire();
        if (this.contCamillas == 0) {
            this.mutex.release();
            this.leerRevista(nombre);
        } else {
            this.camillas.acquire();
            this.contCamillas--;
            System.out.println(nombre + " Tomo una camilla, se saca sangre!");
            this.mutex.release();
        }
    }
    
    public void terminarDonarSangre(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.contCamillas++;
        System.out.println(nombre + " -----------------------------> Termina de donar sangre");
        this.camillas.release();
        this.mutex.release();
    }
    
    private void leerRevista(String nombre) throws InterruptedException {
        System.out.println("No hay camillas libre, espera: " + nombre);
        this.revistas.acquire();
        System.out.println(nombre + " Esta leyendo una revista");
        
        this.camillas.acquire();
        this.revistas.release();
        
        this.mutex.acquire();
        this.contCamillas--;
        System.out.println(nombre + " Termina de leer la revista ");
        System.out.println(nombre + " Termina de leer la revista, tiene una camilla libre");
        System.out.println(nombre + " Tiene una camilla libre, se saca sangre");
        this.revistas.release();
    }
}
