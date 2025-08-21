package TP_3;

public class Energia {
    
    private int cantidad;
    
    public Energia(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public synchronized void drenarEnergia() {
        this.cantidad -= 3;
    }
    
    public synchronized void revitalizar() {
        this.cantidad = this.cantidad + 3;
    }
    
    public synchronized int getCantidad() {
        return this.cantidad;
    }
}
