package TP_7_EJ_1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona implements Runnable {
    
    private final String nombre;
    private final char tipo;
    private final GestorSala sala;
    
    public Persona(String nombre, char tipo, GestorSala sala) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.sala = sala;
    }
    
    @Override 
    public void run() {
        try {
            if (tipo == 'P') {
                this.sala.entrarSala(nombre);
            } else {
                this.sala.entrarSalaJubilado(nombre);
            }
            Thread.sleep(2000);
            this.sala.salirSala(nombre);
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
