package TP_6_Ej_4;

import java.util.Random;

public class Productor implements Runnable {
    
    private Buffer almacen;
    private Random random;
    
    public Productor(Buffer almacen) {
        this.almacen = almacen;
        this.random = new Random();
    }
    
    @Override 
    public void run() {
        int i;
        while (true) {
            try {
                i = this.random.nextInt(10) + 1;
                this.almacen.producir(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
