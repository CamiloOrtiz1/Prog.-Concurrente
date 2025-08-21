package TP_4_EJ_7;

public class Main {
    
    public static void main(String[] args) {
        
        Confiteria confiteria = new Confiteria();
        Thread mozo = new Thread(new Mozo(confiteria));
        Thread e1 = new Thread(new Empleado("Empleado 1",confiteria));
        Thread e2 = new Thread(new Empleado("Empleado 2",confiteria));
        Thread e3 = new Thread(new Empleado("Empleado 3",confiteria));
        Thread e4 = new Thread(new Empleado("Empleado 4",confiteria));
        
        mozo.start();
        e1.start();
        e2.start();
        e3.start();
        e4.start();
    }
    
}
