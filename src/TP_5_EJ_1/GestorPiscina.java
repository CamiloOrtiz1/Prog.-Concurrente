package TP_5_EJ_1;

public class GestorPiscina {
    
    public static void main(String[] args) {
        // Recurso Compartido
        Piscina piscina = new Piscina();
        
        for (int i = 0; i < 20; i++) {
            Persona persona = new Persona("Persona " +(i+1),piscina);
            Thread hilo = new Thread(persona);
            hilo.start();
        }
    }
}
