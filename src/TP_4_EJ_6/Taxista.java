package TP_4_EJ_6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Taxista implements Runnable {
    
    private final String nombre;
    private Taxi taxi;
    
    public Taxista(String nombre, Taxi taxi) {
        this.nombre = nombre;
        this.taxi = taxi;
    }
    
    @Override
    public void run() {
        
        while (true) {
            try {
                this.taxi.iniciarViaje();
                Thread.sleep(2000);
                this.taxi.finalizarViaje();
            } catch (InterruptedException ex) {
                Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
