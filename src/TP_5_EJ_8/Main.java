package TP_5_EJ_8;

import java.util.Random;
/*
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Cuerda soga = new Cuerda();
        Babuino[] babuinos = new Babuino[20];
        Thread[] hilos = new Thread[5];
        cargarRunnables(babuinos, soga);
        cargarHilos(hilos, babuinos, 0);
        arrancarHilos(hilos);
    }

    public static void cargarRunnables(Babuino[] babuinos, Cuerda cuerda) {
        Random random = new Random();
        for (int i = 0; i < babuinos.length; i++) {
            int a = random.nextInt(2);
            char lado;
            if (a == 1) {
                lado = 'I';
            } else {
                lado = 'D';
            }
            babuinos[i] = new Babuino(cuerda,lado);
        }
    }

    public static void cargarHilos(Thread[] hilos, Babuino[] babuinos, int n) {
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(babuinos[i], "#B" + (i + n) + " Babuino " + (i+n));
        }
    }

    public static void arrancarHilos(Thread[] hilos) {
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}
*/


public class Main {

    public static void main(String[] args) {
        Cuerda puente = new Cuerda();
        Random random = new Random();
        char lado;
        int aleatorio;

        for (int i = 1; i < 15; i++) {
            aleatorio = random.nextInt(2);
            if (aleatorio == 1) {
                lado = 'I';
            } else { 
                lado = 'D';
            }
            Babuino babuino = new Babuino("Babuino " + i,lado,puente);
            Thread hilo = new Thread(babuino);
            hilo.start();
        }
    }

}