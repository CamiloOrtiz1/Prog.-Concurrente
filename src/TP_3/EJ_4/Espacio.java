package TP_3.EJ_4;

public class Espacio {
    
    private boolean disponible;
  
    public Espacio() {
        this.disponible = true;
    }
    
    public synchronized void reservar(String nombre, int i) {
        System.out.println("Espacio reservado para el " + nombre + ", en la posicion: " + i);
        this.disponible = false;
    }
    
    public synchronized boolean verificarEspacio() {
        return this.disponible;
    }
    
    public synchronized void setEspacio() {
        this.disponible = false;
    }
}
