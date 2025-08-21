package TP_6_Ej_7;

public class Ferry {
   
    private int capacidadFerry, contador;
    private boolean enViaje, desembarcar;
    
    public Ferry(int capacidad) {
        this.capacidadFerry = capacidad;
        this.contador = 0;
        this.enViaje = false;
        this.desembarcar = false;
    }
    
    public synchronized void embarcar(char tipo, String nombre) throws InterruptedException {
        while (this.contador == this.capacidadFerry || this.enViaje || (tipo == 'A' && this.contador + 3 > this.capacidadFerry) || this.desembarcar || (tipo == 'P' && this.contador + 1 > this.capacidadFerry)) {
            this.wait();
        }
        
        if (tipo == 'P') {
            this.contador++;
        } else {
            this.contador += 3;
        }
        System.out.println("Embarco el " + nombre + " al Ferry. Contador Ferry: " + this.contador);
        if (this.contador == this.capacidadFerry) {
            this.viajar();
        }
        this.notifyAll();
    }
    
    public synchronized void desembarcar(char tipo, String nombre) throws InterruptedException {
        while (this.contador == 0 || this.enViaje || !this.desembarcar) {
            this.wait();
        }
        
        if (tipo == 'P') {
            this.contador--;
        } else {
            this.contador -= 3;
        }
        
        if (this.contador == 0) {
            this.desembarcar = false;
        }
        System.out.println("Desembarco el " + nombre + " del Ferry. Contador Ferry: " + this.contador);
        this.notifyAll();
    }
    
    private synchronized void viajar() throws InterruptedException {
        this.enViaje = true;
        System.out.println("\nEl Ferry comienza su viaje!");
        Thread.sleep(1000);
        System.out.println("Finaliza el viaje del Ferry\n");
        this.enViaje = false;
        this.desembarcar = true;
        this.notifyAll();
    }
}
