package TP_5_EJ_1;

import java.util.concurrent.Semaphore;

public class Piscina {
    
    private Semaphore capacidad;
    
    public Piscina() {
        this.capacidad = new Semaphore(10);
    }
    
    public void ingresar(String nombre) throws InterruptedException {
        System.out.println(nombre + " Esta intentando ingresar a la piscina");
        this.capacidad.acquire();
        System.out.println(nombre + " Ingreso a la piscina");
    }
    
    public void salir(String nombre) {
        System.out.println(nombre + " Sale de la piscina y hay un espacio nuevo ahora");
        this.capacidad.release();
    }
}
