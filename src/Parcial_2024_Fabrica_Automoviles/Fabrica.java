package Parcial_2024_Fabrica_Automoviles;

import java.util.concurrent.Semaphore;

public class Fabrica {
    
    private final int CAPACIDAD_RUEDAS, CAPACIDAD_PUERTAS, CAPACIDAD_CARROCERIAS;
    private final Semaphore cajaRuedas, cajaPuertas, cajaCarrocerias, mutexRuedas, mutexPuertas, mutexCarrocerias;
    private final Semaphore ruedasEnsamblador, puertasEnsamblador, carroceriasEnsamblador;
    private int contAutos, contRuedas, contPuertas, contCarrocerias;
    
    public Fabrica(int ruedas, int puertas, int carrocerias) {
        this.CAPACIDAD_RUEDAS = ruedas;
        this.CAPACIDAD_PUERTAS = puertas;
        this.CAPACIDAD_CARROCERIAS = carrocerias;
        this.cajaRuedas = new Semaphore(ruedas);
        this.cajaPuertas = new Semaphore(puertas);
        this.cajaCarrocerias = new Semaphore(carrocerias);
        this.mutexRuedas = new Semaphore(1);
        this.mutexPuertas = new Semaphore(1);
        this.mutexCarrocerias = new Semaphore(1);
        this.puertasEnsamblador = new Semaphore(0);
        this.ruedasEnsamblador = new Semaphore(0);
        this.carroceriasEnsamblador = new Semaphore(0);
        this.contAutos = 0;
        this.contRuedas = 0;
        this.contPuertas = 0;
        this.contCarrocerias = 0;
    }
    
    public void producirRuedas(String nombre) throws InterruptedException {
        this.mutexRuedas.acquire();
        if (this.contRuedas == CAPACIDAD_RUEDAS) {
            System.out.println(nombre + " - Caja llena, no puede producir mas RUEDAS.");
            this.mutexRuedas.release(); // Libero el mutex
            this.cajaRuedas.acquire(); // Una manera de bloquearlo
            this.contRuedas++;
            this.ruedasEnsamblador.release();
            System.out.println(nombre + " Produjo una rueda.");
        } else {
            this.cajaRuedas.acquire();
            this.contRuedas++;
            this.ruedasEnsamblador.release();
            System.out.println(nombre + " Produjo una rueda.");
            this.mutexRuedas.release();
        }
    }
    
    public void producirPuertas(String nombre) throws InterruptedException {
        this.mutexPuertas.acquire();
        if (this.contPuertas == CAPACIDAD_PUERTAS) {
            System.out.println(nombre + " - Caja llena, no puede producir mas PUERTAS.");
            this.mutexPuertas.release();
            this.cajaPuertas.acquire();
            this.contPuertas++;
            this.puertasEnsamblador.release();
            System.out.println(nombre + " Produjo una puerta.");
        } else {
            this.cajaPuertas.acquire();
            this.contPuertas++;
            this.puertasEnsamblador.release();
            System.out.println(nombre + " Produjo una puerta.");
            this.mutexPuertas.release();
        }
    }
    
    public void producirCarrocerias(String nombre) throws InterruptedException {
        this.mutexCarrocerias.acquire();
        if (this.contCarrocerias == CAPACIDAD_CARROCERIAS) {
            System.out.println(nombre + " - Caja llena, no puede producir mas CARROCERIAS.");
            this.mutexCarrocerias.release();
            this.cajaCarrocerias.acquire();
            this.contCarrocerias++;
            this.carroceriasEnsamblador.release();
            System.out.println(nombre + " Produjo una Carrroceria.");
        } else {
            this.cajaCarrocerias.acquire();
            this.contCarrocerias++;
            this.carroceriasEnsamblador.release();
            System.out.println(nombre + " produjo una carroceria.");
            this.mutexCarrocerias.release();
        }
    }
    
    public void ensamblar() throws InterruptedException {
        this.ruedasEnsamblador.acquire(4);
        System.out.println("ENSAMBLADOR TOMA 4 RUEDAS Y LIBERA 4 RUEDAS AL EQUIPO 1");
        this.cajaRuedas.release(4);
        this.puertasEnsamblador.acquire(2);
        System.out.println("ENSAMBLADOR TOMA 2 PUERTAS Y LIBERA 2 PUERTAS AL EQUIPO 2");
        this.cajaPuertas.release(2);
        this.carroceriasEnsamblador.acquire();
        System.out.println("ENSAMBLADOR TOMA 1 CARROCERIA Y LIBERA 1 CARROCERIA AL EQUIPO 3.");
        this.cajaCarrocerias.release();
        this.contAutos++;
        System.out.println("El equipo 4 - Ensamblo un AUTO");
        if (this.contAutos == 5) {
            System.out.println("Equipo 4 empaqueta 5 autos.");
        }
    }
}
