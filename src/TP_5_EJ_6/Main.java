package TP_5_EJ_6;

public class Main {
    
    public static void main(String[] args) {
        TorreControl torre = new TorreControl();
        for (int i = 1; i < 30; i++) {
            Avion avion = new Avion("Avion " +(i),torre);
            Thread hilo = new Thread(avion);
            hilo.start();
        }
    }
    
}
