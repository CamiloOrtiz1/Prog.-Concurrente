package TP_3.EJ_3;

public class Hamaca {
     
    public synchronized void descansar(String nombre) {
        System.out.println(nombre + " Esta descansando");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(nombre + " Deja de descansar");
    }
}
