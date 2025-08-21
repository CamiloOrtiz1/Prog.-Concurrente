package TP_4_EJ_7;

import java.util.concurrent.Semaphore;

public class Confiteria {
    
    private final Semaphore mozo;
    private final Semaphore espacio;
    private final Semaphore empleado;
    
    public Confiteria() {
        this.mozo = new Semaphore(0);
        this.espacio = new Semaphore(1);
        this.empleado = new Semaphore(0);
    }
    
    public void pedirMesa(String nombre) throws InterruptedException {
        // El empleado pide una mesa (Metodo de Empleado)
        this.espacio.acquire();
        System.out.println("El " + nombre + " tiene la mesa disponible para comer.");
    }
    
    public void pedirComida(String nombre) throws InterruptedException {
        // El empleado pide comida en la confiteria, le tiene que avisar al mozo que esta sentado
        // (Metodo de Empleado, libera el permiso para mozo, el cual lo utiliza en la clase Mozo    )
        System.out.println("El " + nombre + " avisa al Mozo para que lo atienda");
        this.mozo.release();
    }
    
    public void atenderEmpleado() throws InterruptedException {
        // El mozo atiende al empleado
        this.mozo.acquire();
        System.out.println("El Mozo atiende al Empleado que esta sentado");
    }
    
    public void servirComida() {
        System.out.println("El Mozo sirve la comida");
        this.empleado.release();
    }
    
    public void empezarAComer(String nombre) throws InterruptedException {
        this.empleado.acquire();
        System.out.println("El " + nombre + " empieza a comer");
    }
    
    public void terminarDeComer(String nombre) {
        System.out.println("El " + nombre + " termina de comer y agradece al Mozo");
        this.mozo.release();
    }
    
    public void seguirHobbie() throws InterruptedException {
        this.mozo.acquire();
        System.out.println("El Mozo sigue probando nuevas recetas de pollo!");
        this.mozo.release();
    }
    
    public void limpiarMeza() throws InterruptedException {
        this.mozo.acquire();
        System.out.println("El Mozo limpia la mesa para atender nuevos Empleados");
        this.espacio.release();
    }
}
