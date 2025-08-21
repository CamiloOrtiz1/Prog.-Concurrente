package TP_3.EJ_4;

import java.util.Random;

public class Visitante implements Runnable {
    
    private final Area area;
    private final Random random = new Random();
    
    public Visitante(Area area) {
        this.area = area;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            int aleatorio = this.random.nextInt(10);
            this.area.reservar(aleatorio, Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
