package TP_3.EJ_5;

import java.util.Random;

public class Combustible {
    
    private int maximo = 300;
    private final Random random = new Random();
    
    public Combustible() {}
    
    public synchronized void cargarCombustible(String nombre) {
        System.out.println(nombre + " Pasa a cargar combustible");
        int aleatorio = this.random.nextInt(100);
        if (this.maximo > aleatorio) {
            this.maximo = this.maximo - aleatorio;
            System.out.println(nombre + " Termina de cargar. Estado actual Surtidor: " + this.maximo);
        } else {
            System.out.println(nombre + " No pudo cargar Combustible");
        }
    }
}
