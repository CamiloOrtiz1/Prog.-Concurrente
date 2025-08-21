package Recuperatorio_29_11_23_Semaforos;

public class AnimalitoMayor implements Runnable {
    
    private final Casa casa;
    
    public AnimalitoMayor(Casa casa) {
        this.casa = casa;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                this.casa.darComida();
            }
        } catch (InterruptedException e) {}
    }
}
