package Parcial_13_11_2023.Problema_1;

import java.util.Random;

public class Embotellador implements Runnable {
    
    private char tipo;
    private Fabrica fabrica;
    private Random r = new Random();
    
    public Embotellador(char tipo, Fabrica fabrica) {
        this.tipo = tipo;
        this.fabrica = fabrica;
    }
    
    public void run() {
        try {
            while (true) {
                if (this.tipo == 'V') {
                    this.fabrica.prepararBotellaVino();
                } else {
                    this.fabrica.prepararBotellaAgua();
                }
                Thread.sleep((r.nextInt(10) + 1) * 1000);
            }
        } catch (InterruptedException e) {}
    }
}
