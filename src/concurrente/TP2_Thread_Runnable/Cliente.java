package concurrente.TP2_Thread_Runnable;

public class Cliente extends Thread {
    @Override
    public void run() {
        System.out.println("Soy " +Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        };
    }
}
