package TP_5_EJ_6;

public class Avion implements Runnable {
    
    private final String nombre;
    private final TorreControl torre;
    
    public Avion(String nombre, TorreControl torre) {
        this.nombre = nombre;
        this.torre = torre;
    }
    
    @Override
    public void run() {
            try {
                this.torre.aterrizar(nombre);
                Thread.sleep(2000);
                this.torre.despegar(nombre);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
    }
    
}
