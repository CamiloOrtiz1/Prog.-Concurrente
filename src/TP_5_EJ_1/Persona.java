package TP_5_EJ_1;

public class Persona implements Runnable {
    
    private final String nombre;
    private final Piscina piscina;
    
    public Persona(String nombre, Piscina piscina) {
        this.nombre = nombre;
        this.piscina = piscina;
    }
    
    @Override
    public void run() {
        try { 
            this.piscina.ingresar(nombre);
            Thread.sleep(4000);
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.piscina.salir(nombre);
    }
}
