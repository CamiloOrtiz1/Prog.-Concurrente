package concurrente.TP2_Thread_Runnable;

public class Recurso {
    
    static void uso() {
        Thread t = Thread.currentThread();
        System.out.println("En Recurso: Soy " +t.getName());
    }
}
