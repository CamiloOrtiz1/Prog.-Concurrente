package Parcial_13_11_2023.Problema_1;

import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        Random r = new Random();
        Fabrica fabrica = new Fabrica();
        Thread empaquetador = new Thread(new Empaquetador(fabrica));
        Thread transportador = new Thread(new Transportador(fabrica));
        char tipo;
        for (int i = 1; i <= 20; i++) {
            tipo = (r.nextInt(2) == 1) ? 'V' : 'A';
            Thread embotellador = new Thread(new Embotellador(tipo,fabrica),"Embotellador " + i);
            embotellador.start();
        }
        
        empaquetador.start();
        transportador.start();
    }
    
}
