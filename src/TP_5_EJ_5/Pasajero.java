package TP_5_EJ_5;

public class Pasajero implements Runnable {
    
    private final Tren tren;
    private final String nombre;
    
    public Pasajero(String nombre, Tren tren) {
        this.tren = tren;
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        try {
            this.tren.comprarTicket(nombre);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
