package TP_4_EJ_3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Proceso implements Runnable {
    
    private final String nombre;
    private final Organizador organizador;
    
    public Proceso(String nombre, Organizador organizador) {
        this.nombre = nombre;
        this.organizador = organizador;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                this.organizador.iniciarProceso(this.nombre);
                System.out.println("Proceso " + this.nombre + " Ejecutando");
                Thread.sleep(2000);
                this.organizador.procesoTerminado(this.nombre);
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
