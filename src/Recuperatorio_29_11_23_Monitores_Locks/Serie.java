package Recuperatorio_29_11_23_Monitores_Locks;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Serie {

    private ReentrantLock cerrojo;
    private Condition espaniol, ingles, filmador, socio;
    private int capitulos, capitulosIngles, capitulosEspaniol, contEspaniol;
    private Random random = new Random();

    public Serie() {
        this.cerrojo = new ReentrantLock(true);
        this.espaniol = cerrojo.newCondition();
        this.ingles = cerrojo.newCondition();
        this.socio = cerrojo.newCondition();
        this.capitulos = 0;
        this.capitulosEspaniol = 0;
        this.capitulosIngles = 0;
        this.contEspaniol = 0;
    }

    public void generarCapitulo() {
        cerrojo.lock();
        try {
            this.capitulos++;
            this.capitulosEspaniol++;
            this.contEspaniol++;
            System.out.println("Se filmo el capitulo " + this.capitulos + " de la Serie.");
            this.ingles.signal();
            this.socio.signal();

        } catch (Exception e) {
        } finally {
            cerrojo.unlock();
        }
    }

    public void traducir() {
        cerrojo.lock();
        try {
            while (this.contEspaniol == 0) {
                System.out.println("NO HAY CAPITULOS POR TRADUCIR");
                this.ingles.await();
            }
            this.capitulosIngles++;
            this.contEspaniol--;
            this.socio.signal();
            this.espaniol.signal();
        } catch (InterruptedException e) {
        } finally {
            cerrojo.unlock();
        }
    }

    public void verCapitulo(char tipo) {
        cerrojo.lock();
        try {
            if (tipo == 'I') {
                while (this.capitulosIngles == 0) {
                    System.out.println(Thread.currentThread().getName() + " Espera por ver un capitulo en ingles ");
                    this.socio.await();
                }
                int i = this.random.nextInt(this.capitulosIngles) + 1;
                System.out.println(Thread.currentThread().getName() + " Vio el capitulo " + i + " en ingles.");
            } else {
                while (this.capitulosEspaniol == 0) {
                    System.out.println(Thread.currentThread().getName() + " Espera por ver un capitulo en Español");
                    this.socio.await();
                }
                int j = this.random.nextInt(this.capitulosEspaniol) + 1;
                System.out.println(Thread.currentThread().getName() + " Vio el capitulo " + j + " en Español");
            }
            this.ingles.signal();
            this.espaniol.signal();
        } catch (InterruptedException e) {
        } finally {
            cerrojo.unlock();
        }
    }
}
    /*
    /************* MONITOR ****************** /
    private int capitulos, capituloIngles, capituloEspaniol, contIngles, contEspaniol;
    private Random random = new Random();

    public Serie() {
        this.capitulos = 0;
        this.capituloIngles = 0;
        this.capituloEspaniol = 0;
        this.contIngles = 0;
        this.contEspaniol = 0;
    }
    
    public synchronized void generarCapitulo() {
        this.capitulos++;
        System.out.println("Se genero el capitulo " + this.capitulos + " de la Serie.");
        this.capituloEspaniol++;
        this.contEspaniol++;
        this.notifyAll();
    }
    
    public synchronized void traducir() throws InterruptedException {
        while (this.contEspaniol == 0) {
            System.out.println("No hay nada para traducir. ESPERAR...");
            this.wait();
        }
        this.capituloIngles++;
        System.out.println("Se tradujo el capitulo " + this.contEspaniol + " del español");
        this.contEspaniol--;
        this.notifyAll();
    }
    
    public synchronized void verCapitulo(char tipo) throws InterruptedException {
        if (tipo == 'I') {
            while (this.capituloIngles == 0) {
                System.out.println(Thread.currentThread().getName() + " Espera por ver un capitulo en ingles");
                this.wait();
            }
            int i = this.random.nextInt(this.capituloIngles) + 1;
            System.out.println(Thread.currentThread().getName() + " Vio el capitulo " + i + " en ingles.");
        } else {
            while (this.capituloEspaniol == 0) {
                System.out.println(Thread.currentThread().getName() + " Espera por ver un capitulo en Español");
                this.wait();
            }
            int j = this.random.nextInt(this.capituloEspaniol) + 1;
            System.out.println(Thread.currentThread().getName() + " Vio el capitulo " + j + " en Español");
        }
        this.notifyAll();
    }
    
    public synchronized void avisarFilmador() throws InterruptedException {
        while (this.contEspaniol != 0) {
            this.wait();
        }
        System.out.println("Traductor Español avisa a filmador");
        this.notifyAll();
    }
}
*/
