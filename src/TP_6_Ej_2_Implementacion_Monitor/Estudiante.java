package TP_6_Ej_2_Implementacion_Monitor;

public class Estudiante implements Runnable {
    
    private final String nombre;
    private final SalaDeEstudio sala;
    
    public Estudiante(String nombre, SalaDeEstudio sala) {
        this.nombre = nombre;
        this.sala = sala;
    }
    
    @Override
    public void run() {
        try {
            this.sala.ocuparMesa(nombre);
            Thread.sleep(2000);
            this.sala.liberarMesa(nombre);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
