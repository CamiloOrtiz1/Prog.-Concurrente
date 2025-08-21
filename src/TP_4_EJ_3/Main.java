package TP_4_EJ_3;

public class Main {
    
    public static void main(String[] args) {
        Organizador organizador = new Organizador(); 
        Thread p1 = new Thread(new Proceso("P1",organizador));
        Thread p2 = new Thread(new Proceso("P2",organizador));
        Thread p3 = new Thread(new Proceso("P3",organizador));
        
        p1.start();
        p2.start();
        p3.start();
    }
}
