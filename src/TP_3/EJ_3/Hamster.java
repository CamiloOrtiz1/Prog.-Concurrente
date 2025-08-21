package TP_3.EJ_3;

import java.util.Random;

public class Hamster implements Runnable {
    
    private String nombre;
    private Jaula jaula;
    private Random random = new Random();
    
    public Hamster(String nombre, Jaula jaula) {
        this.nombre = nombre;
        this.jaula = jaula;
    }
    
    
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            int aleatorio = this.random.nextInt(3);
            switch (aleatorio) {
                case 1 -> {
                    this.jaula.comer(nombre);
                }
                case 2 -> {
                    this.jaula.correr(nombre);
                }
                case 3 -> {
                    this.jaula.descansar(nombre);
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
