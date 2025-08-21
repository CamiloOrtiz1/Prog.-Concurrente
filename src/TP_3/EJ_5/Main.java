package TP_3.EJ_5;

public class Main {
    
    public static void main(String[] args) {
        
        Thread auto1 = new Thread(new Auto(),"Auto 1");
        Thread auto2 = new Thread(new Auto(),"Auto 2");
        Thread auto3 = new Thread(new Auto(),"Auto 3");
        Thread auto4 = new Thread(new Auto(),"Auto 4");
        Thread auto5 = new Thread(new Auto(),"Auto 5");
        
        auto1.start();
        auto2.start();
        auto3.start();
        auto4.start();
        auto5.start();
    }
}
