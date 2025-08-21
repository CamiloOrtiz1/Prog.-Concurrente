package TP_3;

public class Sanador implements Runnable {
    
    private Energia energia;
    
    public Sanador(Energia energia) {
        this.energia = energia;
    }
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.energia.revitalizar();
            System.out.println(Thread.currentThread().getName() + " --> Revitaliza energia. Energia actual: " + this.energia.getCantidad());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}