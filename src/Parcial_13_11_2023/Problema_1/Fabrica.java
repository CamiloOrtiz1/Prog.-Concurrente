package Parcial_13_11_2023.Problema_1;

import java.util.concurrent.Semaphore;

public class Fabrica {
    
    private final Semaphore mutexVino, mutexAgua, cajaVino, cajaAgua, almacen, camion, empaquetador; 
    private int contVino, contAgua, capacidad, contAlmacen;
    
    public Fabrica() {
        this.mutexVino = new Semaphore(1,true);
        this.mutexAgua = new Semaphore(1,true);
        this.cajaVino = new Semaphore(10);
        this.cajaAgua = new Semaphore(10);
        this.almacen = new Semaphore(10);
        this.camion = new Semaphore(0);
        this.empaquetador = new Semaphore(0);
        this.contAgua = 0;
        this.contVino = 0;
        this.capacidad = 10;
        this.contAlmacen = 0;
    }
    
    public void prepararBotellaVino() throws InterruptedException {
        this.mutexVino.acquire();
        if (this.contVino == this.capacidad) {
            System.out.println("CAJA DE VINO LLENA. ContVino: " +this.contVino);
            this.empaquetador.release();
        } else {
            this.cajaVino.acquire();
            this.contVino++;
            System.out.println(Thread.currentThread().getName() + " PREPARA BOTELLA DE VINO. ContVino: " + this.contVino);
            this.mutexVino.release();
        }
    }
    
    public void prepararBotellaAgua() throws InterruptedException {
        this.mutexAgua.acquire();
        if (this.contAgua == this.capacidad) {
            System.out.println("CAJA DE AGUA LLENA. ContAgua: " + this.contAgua);
            this.empaquetador.release();
        } else {
            this.cajaAgua.acquire();
            this.contAgua++;
            System.out.println(Thread.currentThread().getName() + " PREPARA BOTELLA DE AGUA. ContAgua: " + this.contAgua);
            this.mutexAgua.release();
        }
    }
    
    public void empaquetar() throws InterruptedException {
        this.empaquetador.acquire();
        if (this.contAlmacen == this.capacidad) {
            System.out.println("ALMACEN LLENO. ContAlmacen: " + this.contAlmacen);
            this.camion.release();
        } else {
            this.contAlmacen++;
            if (this.contVino == this.capacidad) {
                System.out.println("SE EMPAQUETA UNA CAJA DE VINO");
                this.almacen.acquire();
                this.contVino = 0;
                this.cajaVino.release(10);
                this.mutexVino.release();
            } else if (this.contAgua == this.capacidad ) {
                System.out.println("SE EMPAQUETA UNA CAJA DE AGUA");
                this.almacen.acquire();
                this.contAgua = 0;
                this.cajaAgua.release(10);
                this.mutexAgua.release();
            }
        }
    }
    
    public void repartir() throws InterruptedException {
        this.camion.acquire();
        System.out.println("EL TRANSPORTADOR SALE DE REPARTO");
        this.contAlmacen = 0;
        this.almacen.release(10);
    }
}
