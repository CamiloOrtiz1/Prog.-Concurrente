package TP_7_EJ_1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Temperatura implements Runnable {
    
    private final GestorSala sala;
    private final Random random;
    
    public Temperatura(GestorSala sala) {
        this.sala = sala;
        this.random = new Random();
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                int temperatura = this.random.nextInt(20, 40);
                this.sala.notificarTemperatura(temperatura);
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
