package TP_6_Ej_4;

public class Consumidor implements Runnable {
    
    private Buffer almacen;
    
    public Consumidor(Buffer almacen) {
        this.almacen = almacen;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                this.almacen.consumir();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
