package TP_8_EJ_1;

import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        Cuartel cuartel = new Cuartel();
        Random r = new Random();
        String gaseosa, postre;
        
        for (int i = 1; i <= 120; i++) {
           gaseosa = (r.nextInt(2) == 0) ? "Gaseosa" : "Agua";
           postre = (r.nextInt(2) == 0) ? "Postre" : "Nada";
           Thread hilo = new Thread(new Soldado(gaseosa,postre,cuartel), "Soldado " + i);
           hilo.start();
        }
    }
}
