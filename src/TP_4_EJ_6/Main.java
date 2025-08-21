package TP_4_EJ_6;

public class Main {
    
    public static void main(String[] args) {
        
        Taxi taxi = new Taxi();
        Taxista taxista = new Taxista("Taxista",taxi);
        Pasajero pasajero = new Pasajero("Pasajero",taxi);
        Thread h1 = new Thread(pasajero);
        Thread h2 = new Thread(taxista);
        h1.start();
        h2.start();
    }
    
}
