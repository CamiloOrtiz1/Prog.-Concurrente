package TP_4_EJ_6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pasajero implements Runnable {
    
    private final String nombre;
    private Taxi taxi;
    
    public Pasajero(String nombre, Taxi taxi) {
        this.nombre = nombre;
        this.taxi = taxi;
    }
    
    @Override
    public void run() {
        
        while (true) {
            try {
                this.taxi.subirAlTaxi(nombre);
                Thread.sleep(2000);
                this.taxi.bajarseDelTaxi(nombre);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
