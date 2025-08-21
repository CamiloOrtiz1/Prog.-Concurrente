package TP_4_EJ_7;

public class Empleado implements Runnable {

    private final Confiteria confiteria;
    private final String nombre;
    
    public Empleado(String nombre, Confiteria confiteria) {
        this.nombre = nombre;
        this.confiteria = confiteria;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("El " + this.nombre + " se acerca a la confiteria para comer");
            this.confiteria.pedirMesa(nombre);
            this.confiteria.pedirComida(nombre);
            Thread.sleep(2000);
            this.confiteria.empezarAComer(nombre);
            Thread.sleep(2000);
            this.confiteria.terminarDeComer(nombre);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
