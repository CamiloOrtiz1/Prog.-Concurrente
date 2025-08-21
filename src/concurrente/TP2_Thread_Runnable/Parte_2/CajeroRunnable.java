package concurrente.TP2_Thread_Runnable.Parte_2;

public class CajeroRunnable implements Runnable { 
    
    private final String nombre;
    private Cliente cliente;
    private long initialTime;
    
    public CajeroRunnable(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = System.currentTimeMillis();
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public long getInitialTime() {
        return this.initialTime;
    }
    
    @Override
    public void run() {
        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + this.cliente.getNombre() +
                " EN EL TIEMPO: " +(System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesando el producto " + (i+1) + " del cliente " +this.cliente.getNombre() + 
                    "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }
        
        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + this.cliente.getNombre() +
                " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }
    
    public void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch(InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
