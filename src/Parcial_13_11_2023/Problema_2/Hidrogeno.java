package Parcial_13_11_2023.Problema_2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hidrogeno implements Runnable {
    
    private Espacio espacio;
    
    public Hidrogeno(Espacio espacio) {
        this.espacio = espacio;
    }
    
    public void run() {
        try {
            this.espacio.Hlisto();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hidrogeno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
