package TP_4_EJ_7;

public class Mozo implements Runnable {
    
    private final Confiteria confiteria;
    
    public Mozo(Confiteria confiteria) {
        this.confiteria = confiteria;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("El Mozo esta cocinando");
                this.confiteria.atenderEmpleado();
                this.confiteria.servirComida();
                this.confiteria.seguirHobbie();
                Thread.sleep(2000);
                this.confiteria.limpiarMeza();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
