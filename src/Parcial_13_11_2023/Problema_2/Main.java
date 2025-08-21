package Parcial_13_11_2023.Problema_2;

public class Main {
    
    public static void main(String[] args) {
        Espacio espacio = new Espacio();
        for (int i = 1; i <= 30; i++) {
            if (i % 2  == 0) {
                Thread h1 = new Thread(new Oxigeno(espacio), "Oxigeno " + i);
                h1.start();
            } else {
                Thread h2 = new Thread(new Hidrogeno(espacio), "Hidrogeno " + i);
                h2.start();
            }
        }
    }
}
