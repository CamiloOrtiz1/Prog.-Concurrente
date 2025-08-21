package TP_6_Ej_1_Semaforos;

import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        
        GestionTrafico gestor = new GestionTrafico();
        Random a = new Random();
        int random;
        char lado;
        
        for (int i = 1; i <= 30; i++) {
            random = a.nextInt(2);
            lado = (random == 0) ? 'N' : 'S';
            Auto auto = new Auto("Auto " + i,gestor,lado);
            Thread hilo = new Thread(auto);
            hilo.start();
        }
       
    }
    
}
