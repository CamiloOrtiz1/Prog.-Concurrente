package BarberoDormilon;

public class Barbero implements Runnable{

    private Barberia barberia;

    public Barbero(Barberia barberia){
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while(true){
            barberia.barberoCortaPelo();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            barberia.terminarCorte();
        }
    }
}
