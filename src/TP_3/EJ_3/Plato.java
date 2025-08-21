package TP_3.EJ_3;

public class Plato {
    
    public synchronized void comer(String nombre) {
        System.out.println(nombre + " Esta comiendo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(nombre + " Deja de comer");
    }
}
