package TP_3.EJ_6;

public class SumaArreglo implements Runnable {
    
    private final int[] arreglo;
    private final int inicio;
    private final int fin;
    private int resultado;

    public SumaArreglo(int[] arreglo, int inicio, int fin) {
        this.arreglo = arreglo;
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public synchronized int getResultado() {
        return this.resultado;
    }
    
    @Override
    public void run() {
        this.resultado = 0;
        for (int i = 0; i < arreglo.length; i++) {
            this.resultado += this.arreglo[i];
        }
    }
}
