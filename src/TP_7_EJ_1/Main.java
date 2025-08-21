package TP_7_EJ_1;

import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        Random random = new Random();
        int j;
        char tipo;
        GestorSala sala = new GestorSala();
        Thread hiloTemp = new Thread(new Temperatura(sala));
        hiloTemp.start();
        for (int i = 1; i < 70; i++) {
            j = random.nextInt(2) + 1;
            tipo = (j == 1) ? 'P' : 'J';
            if (tipo == 'P') {
                Persona persona = new Persona("Persona " + i,tipo,sala);
                Thread hiloPersona = new Thread(persona);
                hiloPersona.start();
            } else {
                Persona persona = new Persona("Jubilada " + i,tipo,sala);
                Thread hiloJubilado = new Thread(persona);
                hiloJubilado.start();
            }
        }
    }
    
}
