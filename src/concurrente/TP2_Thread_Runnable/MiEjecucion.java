package concurrente.TP2_Thread_Runnable;

public class MiEjecucion extends Thread {
    
    @Override
    public void run() {
        ir();
    }    
    
    public void ir() {
        hacerMas();
    }
    
    public void hacerMas() {
        System.out.println("En la pila");
    }
}
