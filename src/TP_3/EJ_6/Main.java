package TP_3.EJ_6;

import java.util.Random;

public class Main {
    
    
    public static void main(String[] args) throws InterruptedException {
        int[] arreglo = new int[50000];
        Random random = new Random();
        
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextInt(10) + 1;
        }
        
        int k = 4;
        Thread[] hilos = new Thread[k];
        SumaArreglo[] sumaParcial = new SumaArreglo[k];
        
        int segmento = arreglo.length / k;
        
        for (int i = 0; i < k; i++) {
            int inicio = i * segmento;
            int fin = (i == k - 1) ? arreglo.length : inicio + segmento;
            sumaParcial[i] = new SumaArreglo(arreglo,inicio,fin);
            hilos[i] = new Thread(sumaParcial[i]);
            hilos[i].start();
        }
        
        for (int i = 0; i < k; i++) {
            hilos[i].join();
        }
        
        int sumaTotal = 0;
        for (int i = 0; i < k; i++) {
            sumaTotal += sumaParcial[i].getResultado();
        }
        
        System.out.println("La suma total del arreglo es: " +sumaTotal);
    }
}
