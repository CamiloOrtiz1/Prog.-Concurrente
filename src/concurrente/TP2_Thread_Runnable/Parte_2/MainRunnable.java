package concurrente.TP2_Thread_Runnable.Parte_2;

public class MainRunnable {
    
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] {2,2,1,5,2,3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[] {1,3,5,1,1});
        CajeroRunnable cajero1 = new CajeroRunnable("Cajero 1",cliente1);
        CajeroRunnable cajero2 = new CajeroRunnable("Cajero 2",cliente2);
        Thread hilo1 = new Thread(cajero1);
        Thread hilo2 = new Thread(cajero2);
        hilo1.start();
        hilo2.start();
    }
    
}
