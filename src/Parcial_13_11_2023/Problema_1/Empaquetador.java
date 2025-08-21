package Parcial_13_11_2023.Problema_1;

public class Empaquetador implements Runnable {
    
    private Fabrica fabrica;
    
    public Empaquetador(Fabrica fabrica) {
        this.fabrica = fabrica;
    } 
    
    public void run() {
        try {
            while (true) {
                this.fabrica.empaquetar();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
    }
}
