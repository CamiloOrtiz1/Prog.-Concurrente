package TP_8_EJ_1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Soldado implements Runnable {
    
    private String gaseosa, postre;
    private final Cuartel cuartel;
    private Random r = new Random();
    
    public Soldado(String gaseosa, String postre, Cuartel cuartel) {
        this.gaseosa = gaseosa;
        this.postre = postre;
        this.cuartel = cuartel;
    }
    
    @Override
    public void run() {
        this.cuartel.entrarRecinto();
        this.cuartel.comer(gaseosa, postre);
        try {
            Thread.sleep((r.nextInt(10) + 1) * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Soldado.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cuartel.terminarComer();
    }
}
