package TP_6_Ej_1_Semaforos;

public class Auto implements Runnable {
    
    private final String nombre;
    private final char direccion;
    private final GestionTrafico gestor;
    
    public Auto(String nombre, GestionTrafico gestor, char direccion) {
        this.nombre = nombre;
        this.gestor = gestor;
        this.direccion = direccion;
    }
    
     @Override
    public void run() {
        try {
            if (this.direccion == 'N') {
                this.gestor.EntrarCocheDelNorte(nombre);
                Thread.sleep(500);
                this.gestor.SalirCocheDelNorte(nombre);
            } else {
                this.gestor.EntrarCocheDelSur(nombre);
                Thread.sleep(500);
                this.gestor.SalirCocheDelSur(nombre);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
