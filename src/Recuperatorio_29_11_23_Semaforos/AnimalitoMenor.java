package Recuperatorio_29_11_23_Semaforos;

import java.util.Random;

public class AnimalitoMenor implements Runnable {
    
    private final Casa casa;
    private Random r = new Random();
    
    public AnimalitoMenor(Casa casa) {
        this.casa = casa;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                this.jugar();
                this.casa.verificarBanquito();
                this.casa.empezarAComer();
                Thread.sleep((r.nextInt(10) + 1) * 1000);
                this.casa.terminarDeComer();
                Thread.sleep((r.nextInt(10) + 1 ) * 1000);
            }
        } catch (InterruptedException e) {}
    }
    
    private void jugar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Esta jugando....");
        Thread.sleep((r.nextInt(10) + 1) * 1000);
    }
}
