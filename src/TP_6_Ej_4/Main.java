package TP_6_Ej_4;

public class Main {
    
    public static void main(String[] args) {
        Buffer almacen = new Buffer(5);
        Productor productor = new Productor(almacen);
        Consumidor consumidor = new Consumidor(almacen);
        Thread hiloProductor = new Thread(productor);
        Thread hiloConsumidor = new Thread(consumidor);
        hiloProductor.start();
        hiloConsumidor.start();
    }
    
}
