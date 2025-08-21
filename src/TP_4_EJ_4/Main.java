package TP_4_EJ_4;

public class Main {
    
    
    public static void main(String[] args) {
        GestorImpresora gestor = new GestorImpresora();
        Thread c1 = new Thread(new Cliente("Cliente 1",gestor));
        Thread c2 = new Thread(new Cliente("Cliente 2",gestor));
        Thread c3 = new Thread(new Cliente("Cliente 3",gestor));
        Thread c4 = new Thread(new Cliente("Cliente 4",gestor));
        Thread c5 = new Thread(new Cliente("Cliente 5",gestor));
        Thread c6 = new Thread(new Cliente("Cliente 6",gestor));
        
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
    }
    
}
