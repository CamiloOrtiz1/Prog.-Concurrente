package Parcial_2024_Fabrica_Automoviles;

import java.util.Random;

public class Equipo4 implements Runnable {
    
    private Fabrica fabrica;
    private Random r = new Random();
    
    public Equipo4(Fabrica fabrica) {
        this.fabrica = fabrica;
    }
    
    public void run() {
        try {
            while (true) {
                this.fabrica.ensamblar();
                Thread.sleep((r.nextInt(10) + 1) * 1000);
            }
        } catch (InterruptedException e) {}
    }
}