package TP_6_Ej_7;

public class Auto implements Runnable {
    private String nombre;
    private char tipo;
    private Ferry ferry;
    
    public Auto(String nombre, Ferry ferry) {
        this.nombre = nombre;
        this.tipo = 'A';
        this.ferry = ferry;
    }
    
    @Override
    public void run() {
        try {
           this.ferry.embarcar(tipo, nombre);
           Thread.sleep(1000);
           this.ferry.desembarcar(tipo, nombre);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
