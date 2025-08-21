package TP_3.EJ_7;

public class Main {
    
    public static void main(String[] args) {
        
        Thread hiloA = new Thread(new Impresion("A",1,1));
        Thread hiloB = new Thread(new Impresion("B",2,2));
        Thread hiloC = new Thread(new Impresion("C",3,2));
        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
    
}
