package concurrente.TP2_Thread_Runnable;

public class TesteoRecurso {
    
    public static void main(String[] args) {
        Cliente juan = new Cliente();
        juan.setName("Juan Lopez");
        Cliente ines = new Cliente();
        ines.setName("Ines Garcia");
        juan.start();
        ines.start();
        Recurso.uso();
    }
}
