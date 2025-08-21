package TP_3;

public class CriaturaOscura implements Runnable {
    
    private Energia energia;
    
    public CriaturaOscura(Energia energia) {
        this.energia = energia;
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.energia.drenarEnergia();
            System.out.println(Thread.currentThread().getName() + " --> Drena energia. Energia actual: " + this.energia.getCantidad());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
