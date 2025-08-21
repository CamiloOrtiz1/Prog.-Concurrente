package TP_6_Ej_7;

public class Main {
    
    public static void main(String[] args) {
        Ferry ferry = new Ferry(20);
        
        for (int i = 1; i < 25; i++) {
            Auto auto = new Auto("Auto " + i, ferry);
            Pasajero pasajero = new Pasajero("Pasajero " + i, ferry);
            Thread hAuto = new Thread(auto);
            Thread hPasajero = new Thread(pasajero);
            hAuto.start();
            hPasajero.start();
        }
    }
    
}
