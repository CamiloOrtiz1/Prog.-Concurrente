package TP_7_EJ_2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Programador implements Runnable {

    private final String nombre;
    private final GestorRecurso gestor;

    public Programador(String nombre, GestorRecurso gestor) {
        this.nombre = nombre;
        this.gestor = gestor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.gestor.pedirRecurso(nombre);
                Thread.sleep(2000);
                this.gestor.liberarRecurso(nombre);
            } catch (InterruptedException ex) {
                Logger.getLogger(Programador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

