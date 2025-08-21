package TP_5_EJ_5;

public class Main {
    
    public static void main(String[] args) {
        Tren tren = new Tren();
        //VendedorTickets vendedor = new VendedorTickets(tren);
        ControlTren control = new ControlTren(tren);
        //Thread hiloV = new Thread(vendedor);
        Thread hiloC = new Thread(control);
        //hiloV.start();
        hiloC.start();
        
        for (int i = 1; i < 25; i++) {
            Pasajero pasajero = new Pasajero("Pasajero " + i, tren);
            Thread hilo = new Thread(pasajero);
            hilo.start();
        }
    }
    
}
