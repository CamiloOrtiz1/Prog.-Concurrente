package BarberoDormilon;

public class Main {
    
    public static void main(String[] args) {



        Barberia barberia = new Barberia();
        Barbero barbero = new Barbero(barberia);
        Thread barberoThread = new Thread(barbero);
        barberoThread.start();

        for (int i = 0; i < 8; i++) {
            Cliente cliente = new Cliente(barberia, i + "");
            Thread clienteThread = new Thread(cliente);
            clienteThread.start();
        }
    } 
}
