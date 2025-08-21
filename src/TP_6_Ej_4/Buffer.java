package TP_6_Ej_4;

public class Buffer {
    
    private int capacidad, sigProductor, sigConsumidor, contador;
    private int[] buffer;

    
    public Buffer(int capacidad) {
        this.buffer = new int[capacidad];
        this.capacidad = capacidad;
        this.sigProductor = 0;
        this.sigConsumidor = 0;
        this.contador = 0;
    }
    
    public synchronized void producir(int i) throws InterruptedException {
        while (this.contador == this.capacidad) {
            this.wait();
        }
        this.buffer[this.sigProductor] = i;
        System.out.println("Se agrego el item: " + i + " al Buffer");
        this.sigProductor = (this.sigProductor + 1) % this.capacidad;
        this.contador++;
        this.notifyAll();
    }
    
    public synchronized int consumir() throws InterruptedException {
        while (this.contador == 0) {
            this.wait();
        }
        int item = this.buffer[this.sigConsumidor];
        this.sigConsumidor = (this.sigConsumidor + 1) % this.capacidad;
        this.contador--;
        System.out.println("Se consumio el item: " + item);
        this.notifyAll();
        return item;
    }
}
