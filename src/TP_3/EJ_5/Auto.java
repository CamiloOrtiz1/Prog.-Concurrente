package TP_3.EJ_5;

import java.util.Random;

public class Auto extends Vehiculo{
    
    private int tanque;
    private final Surtidor surtidor;
    private final Random random = new Random();

    public Auto() {
        this.surtidor = new Surtidor();
        this.tanque = 100;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (this.tanque > 0) {
                // Simula el recorrer
                int aleatorio = this.random.nextInt(50);
                this.tanque = this.tanque - aleatorio;
                // Si el tanque < 40 debe de cargar combustible
                if (this.tanque < 10) {
                    this.surtidor.cargar(Thread.currentThread().getName());
                }
            }
            try { 
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
