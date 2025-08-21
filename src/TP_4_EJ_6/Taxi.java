package TP_4_EJ_6;

import java.util.concurrent.Semaphore;

public class Taxi {
    
    private final Semaphore taxista;
    private final Semaphore pasajero;
    
    public Taxi() {
        this.taxista = new Semaphore(0);
        this.pasajero = new Semaphore(0);
    }
    
    public void iniciarViaje() throws InterruptedException {
        this.taxista.acquire();
        System.out.println("Taxista comienza el Viaje!");
    }
    
    public void finalizarViaje() {
        System.out.println("Finaliza el viaje con el Taxista y se vuelve a dormir");
        this.pasajero.release();
    }
    
    public void subirAlTaxi(String pasajero) {
        System.out.println(pasajero + " Despierta al Taxista!");
        this.taxista.release();
    }
    
    public void bajarseDelTaxi(String pasajero) throws InterruptedException {
        this.pasajero.acquire();
        System.out.println(pasajero + " Deja el taxi!");
    }
}
