package concurrente.TP2_Thread_Runnable.Parte_2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor implements Runnable {
    
    private final String nombre;
    private int distanciaRecorrida;
    private int pasos;
    
    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }
    
    @Override
    public void run() {
        try {
            Random random = new Random();
            while (this.distanciaRecorrida <= 100) {
                this.pasos = random.nextInt(10);
                this.distanciaRecorrida += this.pasos;
                System.out.println("Corredor: " + this.nombre + ", Pasos: " + this.pasos);
                if (this.distanciaRecorrida > 100) {
                    System.out.println("Corredor: " + this.nombre + ", Pasos: " + this.pasos + ", Distancia final: " + this.distanciaRecorrida);
                }
                Thread.sleep(100);
            }
            //Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("Error: " +ex.getMessage());
        }
    }
    
    public int getDistanciaRecorrida() {
        return this.distanciaRecorrida;
    }
    
    public String getNombre() {
        return this.nombre;
    }
}
