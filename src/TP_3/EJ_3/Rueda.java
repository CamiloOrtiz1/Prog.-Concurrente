package TP_3.EJ_3;

public class Rueda {
    
    public synchronized void correr(String nombre) {
        System.out.println(nombre + " Esta corriendo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(nombre + " Deja de correr");
    }
}
