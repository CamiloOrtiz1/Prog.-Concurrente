package TP_3.EJ_3;

public class Main {
    
    public static void main(String[] args) {
        
        Jaula jaula = new Jaula();
        Thread hamster1 = new Thread(new Hamster("Hamster 1",jaula),"Hamster 1");
        Thread hamster2 = new Thread(new Hamster("Hamster 2",jaula),"Hamster 2");
        Thread hamster3 = new Thread(new Hamster("Hamster 3",jaula),"Hamster 3");
        Thread hamster4 = new Thread(new Hamster("Hamster 4",jaula),"Hamster 4");
        Thread hamster5 = new Thread(new Hamster("Hamster 5",jaula),"Hamster 5");
        
        hamster1.start();
        hamster2.start();
        hamster3.start();
        hamster4.start();
        hamster5.start();
        /*
        try {
            hamster1.join();
            hamster2.join();
            hamster3.join();
            hamster4.join();
            hamster5.join();
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        */
    }
    
}
