package concurrente.TP2_Thread_Runnable;

public class RunnableEjemplo implements Runnable {
        
    private String str;
    
    public RunnableEjemplo(String str) {
        this.str = str;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + str);
            System.out.println("Termina Thread " + str);
        }
    }
    
    public static void main(String[] args) {
        
    }
}
