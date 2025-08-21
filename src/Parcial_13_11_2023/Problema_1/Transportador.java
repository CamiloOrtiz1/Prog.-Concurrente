package Parcial_13_11_2023.Problema_1;

public class Transportador implements Runnable {
    
    private Fabrica fabrica;
    
    public Transportador(Fabrica fabrica) {
        this.fabrica = fabrica;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                this.fabrica.repartir();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {}
    }
}
