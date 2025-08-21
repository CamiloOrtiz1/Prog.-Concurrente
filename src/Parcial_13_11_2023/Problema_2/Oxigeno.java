package Parcial_13_11_2023.Problema_2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Oxigeno implements Runnable {
    
    private Espacio espacio;
    
    public Oxigeno(Espacio espacio) {
        this.espacio = espacio;
    }
    
    public void run() {
        try {
            this.espacio.Olisto();
        } catch (InterruptedException ex) {
            Logger.getLogger(Oxigeno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
