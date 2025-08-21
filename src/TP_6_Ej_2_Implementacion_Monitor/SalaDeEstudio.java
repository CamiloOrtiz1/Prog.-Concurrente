package TP_6_Ej_2_Implementacion_Monitor;

public class SalaDeEstudio {
    
    private int mesas;
    
    public SalaDeEstudio(int mesas) {
        this.mesas = mesas;
    }
    
    public synchronized void ocuparMesa(String nombre) throws InterruptedException {
        while (this.mesas == 0) {
            System.out.println(nombre + ". Todas las mesas estan ocupadas, entonces espera por una mesa");
            this.wait();
        }
        this.mesas--;
        System.out.println(nombre + ". Ocupa una mesa para estudiar");
    }
    
    public synchronized void liberarMesa(String nombre) throws InterruptedException {
        this.mesas++;
        System.out.println(nombre + ". Libera una mesa");
        this.notifyAll();
    }
}
