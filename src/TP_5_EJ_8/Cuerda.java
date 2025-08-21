package TP_5_EJ_8;

import java.util.concurrent.Semaphore;
/*
public class Cuerda {
    
    // Recurso compartido
    
    private Semaphore izquierdo = new Semaphore(5, true);
    private Semaphore derecho = new Semaphore(5, true);
    private Semaphore exclusion = new Semaphore(1);
    private char tipo = '-';
    private int cantDI = 0, cantID = 0, esperandoI = 0, esperandoD = 0, capacidad  = 5, ocupados = 0;
    
    public Cuerda(){
        
    }
    
    public void esperar() throws InterruptedException{
        System.out.print(Thread.currentThread().getName()+ " ESPERA...");
        if (this.tipo == 'D') {
            System.out.println(" DESDE LA DERECHA...");
            esperandoD++;
            exclusion.release();
            derecho.acquire(); // Queda bloqueado
            // ACA VUELVE CUANDO SALE DEL BLOQUEO
            exclusion.acquire();
            System.out.println(Thread.currentThread().getName()+ " SE LIBERA DE LA ESPERA Y COMENZO A CRUZAR...");
            ocupados--;
            cantDI++;
            exclusion.release();
        }else{
            System.out.println(" desde la izquierda...");
            esperandoI++;
            exclusion.release();
            izquierdo.acquire(); // Queda bloqueado
            // ACA VUELVE CUANDO SALE DEL BLOQUEO
            exclusion.acquire();
            System.out.println(Thread.currentThread().getName()+ " SE LIBERA DE LA ESPERA Y COMENZO A CRUZAR...");
            ocupados--;
            cantID++;
            exclusion.release();
        }
    }
    
    public void cruzar(char lugar) throws InterruptedException{
        exclusion.acquire();
        if (this.tipo == '-') { // primera vez
            this.tipo = lugar;
            System.out.print(Thread.currentThread().getName()+ " COMENZO A CRUZAR...");
            if (lugar == 'D') {
                System.out.println(" DESDE LA DERECHA...");
                cantDI++;
                derecho.acquire();
                izquierdo.acquire(this.capacidad);
            }else{
                System.out.println(" desde la izquierda...");
                cantID++;
                derecho.acquire(this.capacidad);
                izquierdo.acquire();
            }
            ocupados++;
            exclusion.release();
        }else{
            if (this.tipo == lugar && ocupados < capacidad) {
                System.out.print(Thread.currentThread().getName()+ " COMENZO A CRUZAR...");
                if (lugar == 'D') {
                    System.out.println(" DESDE LA DERECHA...");
                    cantDI++;
                    derecho.acquire();
                }else{
                    System.out.println(" desde la izquierda...");
                    cantID++;
                    izquierdo.acquire();
                }
                ocupados++;
                exclusion.release();
            }else{
                this.esperar();
            }
        }
    }
    
    public void ultimo(){
        if (this.tipo == 'D') {
            System.out.println(Thread.currentThread().getName()+ " ULTIMO DERECHO...");
            this.tipo = 'I';
            esperandoI = 0;
            this.izquierdo.release(capacidad);
        }else{
            System.out.println(Thread.currentThread().getName()+ " ultimo izquierdo...");
            this.tipo = 'D';
            esperandoD = 0;
            this.derecho.release(capacidad);
        }
    }
    
    public void salir() throws InterruptedException{
        exclusion.acquire();
        ocupados--;
        System.out.print(Thread.currentThread().getName()+ " TERMINO DE CRUZAR ");
        if (this.tipo == 'D') {
            if (ocupados == 0 && esperandoI > 0) {
                // Realizo el cambio
                this.ultimo();
            }else{
                System.out.println(" DESDE LA DERECHA...");
                this.derecho.release(this.capacidad);
            }
        }else{
            if (ocupados == 0 && esperandoD > 0) {
                // Realizo el cambio
                this.ultimo();
            }else{
                System.out.println(" desde la izquierda...");
                this.izquierdo.release(this.capacidad);
            }
        }
        exclusion.release();
    }
    
}
*/


public class Cuerda {
   
    private final Semaphore izquierda, derecha, mutex;
    private int izquierdaEsperando, derechaEsperando, cruzando, babuinosIzq, babuinosDer;
    private char lado;
    private static final int CAPACIDAD = 5;
    
    public Cuerda() {
        this.izquierda = new Semaphore(0,true);
        this.derecha = new Semaphore(0,true);
        this.mutex = new Semaphore(1);
        this.izquierdaEsperando = 0;
        this.derechaEsperando = 0;
        this.babuinosDer = 0;
        this.babuinosIzq = 0;
        this.cruzando = 0;
        this.lado = ' ';
    }
    
    public void cruzarIzquierda(String nombre) throws InterruptedException {
        System.out.println(nombre + " intenta cruzar desde izquierda");
        this.mutex.acquire();
        if (this.lado == ' ' || this.lado == 'I') {
            if (this.lado == ' ') {
                System.out.println("PRIMERO EN LLEGAR DESDE IZQUIERDA. " + nombre);
                this.izquierda.release(CAPACIDAD);
                this.lado = 'I';
            }
            this.cruzando++;
            System.out.println("Cruza desde izquierda: " + nombre);
            this.mutex.release();
            this.izquierda.acquire();
        } else {
            this.izquierdaEsperando++;
            System.out.println(nombre + " ESPERA PARA CRUZAR DESDE IZQUIERDA");
            this.mutex.release();
            this.izquierda.acquire();
            this.mutex.acquire();
            this.izquierdaEsperando--;
            this.cruzando++;
            System.out.println(nombre + " cruza desde izquierda");
            this.mutex.release();
        }
    }

    public void salirIzquierda(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.cruzando--;
        System.out.println(nombre + " Sale desde izquierda. Babuinos cruzando: " + this.cruzando);
        if (this.cruzando == 0) {
            this.lado = 'D';
            System.out.println("CAMBIANDO LADO A: " + this.lado);
    
                this.derecha.release(Math.min(this.derechaEsperando, CAPACIDAD));
                System.out.println("Liberando permisos para derecha: " + Math.min(this.derechaEsperando, CAPACIDAD));
    
        } else {
            this.izquierda.release();
        }
        this.mutex.release();
    }

    public void cruzarDerecha(String nombre) throws InterruptedException {
        System.out.println(nombre + " intenta cruzar desde derecha");
        this.derecha.acquire();
        this.mutex.acquire();
        if (this.lado == ' ' || this.lado == 'D') {
            if (this.lado == ' ') {
                System.out.println("PRIMERO EN LLEGAR DESDE DERECHA. " + nombre);
                this.derecha.release(CAPACIDAD);
                this.lado = 'D';
            }
            this.cruzando++;
            System.out.println("Cruza desde derecha: " + nombre);
        } else {
            this.derechaEsperando++;
            System.out.println(nombre + " ESPERA DESDE DERECHA");
            this.mutex.release();
            this.derecha.acquire();
            this.mutex.acquire();
            this.derechaEsperando--;
            this.cruzando++;
            System.out.println(nombre + " Cruza desde derecha");
        }
        this.mutex.release();
    }

    public void salirDerecha(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.cruzando--;
        System.out.println(nombre + " Sale desde derecha. Babuinos cruzando: " + this.cruzando);
        if (this.cruzando == 0) {
            this.lado = 'I';
            System.out.println("CAMBIANDO DE LADO A: " + this.lado);
            if (this.izquierdaEsperando > 0) {
                this.izquierda.release(Math.min(this.izquierdaEsperando, CAPACIDAD));
                System.out.println("Liberando permisos para izquierda: " + Math.min(this.izquierdaEsperando, CAPACIDAD));
            }
        } else {
            this.derecha.release();
        }
        this.mutex.release();
    }
}

    /*
    HACER UN METODO QUE REALICE LA ESPERA O VER. RECORDARRRRRRRRRRRRRRRRRRRRRRRRRRRR
    */
    /*
    public void cruzarIzquierda(String nombre) throws InterruptedException {
        this.mutex.acquire();
        // Verifico si el hiloBabuino es el primero en llegar
        if (this.lado == ' ' || this.lado == 'I') {
            if (this.lado == ' ') {
                // Libera 5 permisos para el semaforo de izquierda
                System.out.println("PRIMERO EN LLEGAR DESDE IZQUIERDA. " + nombre);
                this.izquierda.release(CAPACIDAD);
                this.lado = 'I';
            }
            this.izquierda.acquire();
            this.babuinosIzq++;
            this.cruzando++;
            System.out.println("Cruza desde izquierda: " + nombre);
            this.mutex.release();
        } else {
            this.izquierdaEsperando++;
            System.out.println(nombre + " ESPERA PARA CRUZAR DESDE IZQUIERDA");
            this.mutex.release();
            this.izquierda.acquire();
            this.mutex.acquire();
            this.izquierdaEsperando--;
            this.cruzando++;
            System.out.println(nombre + " cruza desde izquierda");
            this.mutex.release();
        }
    }
    
    public void salirIzquierda(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.cruzando--;
        System.out.println(nombre + " Sale desde izquierda");
        if (this.cruzando == 0) {
            this.lado = 'D';
            if (this.derechaEsperando > 0) {
                if (this.derechaEsperando < 5) {
                    this.derecha.release(this.derechaEsperando);
                } else {
                    this.derecha.release(CAPACIDAD);
                }
            }
        } else {
            this.izquierda.release();
        }
        this.mutex.release();
    }
    
    public void cruzarDerecha(String nombre) throws InterruptedException {
        this.mutex.acquire();
        if (this.lado == ' ' || this.lado == 'D') {
            if (this.lado == ' ') {
                // Libera 5 permisos para el semaforo de derecha
                System.out.println("PRIMERO EN LLEGAR DESDE DERECHA. " + nombre);
                this.derecha.release(CAPACIDAD);
                this.lado = 'D';
            }
            this.derecha.acquire();
            this.babuinosDer++;
            this.cruzando++;
            System.out.println("Cruza desde derecha: " + nombre);
            this.mutex.release();
        } else {
            this.derechaEsperando++;
            System.out.println(nombre + " ESPERA DESDE DERECHA");
            this.mutex.release();
            this.derecha.acquire();
            this.mutex.acquire();
            this.derechaEsperando--;
            this.cruzando++;
            System.out.println(nombre + " Cruza desde derecha");
            this.mutex.release();
        }
    }
    
    public void salirDerecha(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.cruzando--;
        if (this.cruzando == 0) {
            if (this.izquierdaEsperando > 0) {
                if (this.izquierdaEsperando < 5) {
                    this.izquierda.release(this.izquierdaEsperando);
                } else {
                    this.izquierda.release(CAPACIDAD);
                }
            }
        } else {
            this.derecha.release();
        }
        this.mutex.release();
    }
}


 /*   
    private final Semaphore cuerda, mutex, semEsperaIzq, semEsperaDer;
    private int contBabuinosIzq, contBabuinosDer, babuinosCruzando;
    private char lado;
    private int contCruzados;
    
    public Cuerda() {
        this.cuerda = new Semaphore(5,true);
        this.mutex = new Semaphore(1);
        this.semEsperaIzq = new Semaphore(0);
        this.semEsperaDer = new Semaphore(0);
        this.contBabuinosDer = 0;
        this.contBabuinosIzq = 0;
        this.babuinosCruzando = 0;
        this.contCruzados = 0;
        this.lado = ' ';
    }
    
    public void cruzarIzquierda(String nombre, char lado) throws InterruptedException {
        System.out.println(nombre + " ESPERA SEMAFORO MUTEX ------ " + lado);
        this.mutex.acquire();
        System.out.println(nombre + " OBTIENE PERMISO MUTEX ------ " + lado);
        if (this.lado == ' ' || this.lado == 'I') {
            this.lado = 'I';
        } else {
            System.out.println(nombre + " LIBERA MUTEX, YA QUE NO ES EL TURNO TODAVIA ------- " +lado);
            this.mutex.release();
            System.out.println(nombre + " ANTES DE BLOQUEARSE CON SEMAFORO ESPERA IZQUIERDA ------ " + lado);
            this.semEsperaIzq.acquire();
            System.out.println(nombre + " ADQUIERE PERMISO SEMAFORO ESPERA IZQUIERDA ------- " + lado);
            this.mutex.acquire();
            System.out.println(nombre + " OBTIENE PERMISO MUTEX ------- " + lado);
        }
        System.out.println(nombre + " ANTES DE OBTENER PERMISO DE CUERDA ------- " + lado);
        this.cuerda.acquire();
        System.out.println(nombre + " DESPUES DE OBTENER PERMISO DE CUERDA ------ " + lado);
        this.contCruzados++;
        this.babuinosCruzando++;
        System.out.println("[I] - " + nombre + " Esta cruzando el puente.");
        System.out.println(nombre + " LIBERA PERMISO MUTEX ----- " + lado);
        this.mutex.release();
    }
    
    public void salirIzquierda(String nombre, char lado) throws InterruptedException {
        System.out.println(nombre + " ESPERA MUTEX ------- " + lado);
        this.mutex.acquire();
        System.out.println(nombre + " OBTIENE MUTEX ------ " + lado);
        this.babuinosCruzando--;
        this.contBabuinosIzq++;
        System.out.println("Babuinos cruzando: " +this.babuinosCruzando);
        if (this.babuinosCruzando == 0) {
        //if (this.contCruzados == 5 || this.babuinosCruzando == 0 || (this.contCruzados <= 5 && this.babuinosCruzando == 0)) {
            System.out.println("Se libera la cuerda. Ya cruzaron todos los babuinos del lado Izquierdo.");
            this.lado = ' ';
            this.contCruzados = 0;
            System.out.println(nombre + " LIBERA PERMISO ESPERA DERECHA. DESDE METODO salirIzquierda() ------- " + lado);
            this.semEsperaDer.release();
            this.cuerda.release(5);
        }
        System.out.println("[I] - " + nombre + " Termina de cruzar el puente.");
        System.out.println(nombre + " LIBERA CUERDA --------- " + lado);
        //this.cuerda.release();
        System.out.println(nombre + " LIBERA MUTEX -------- " + lado);
        this.mutex.release();
    }
    
    public void cruzarDerecha(String nombre, char lado) throws InterruptedException {
        System.out.println(nombre + " ESPERA MUTEX --------- " + lado);
        this.mutex.acquire();
        System.out.println(nombre + " OBTIENE MUTEX -------- " + lado);
        if (this.lado == ' ' || this.lado == 'D') {
            this.lado = 'D';
        } else {
            System.out.println(nombre + " LIBERA MUTEX ------- " + lado);
            this.mutex.release();
            System.out.println(nombre + " ESPERA PERMISO ESPERA DERECHA ------- " + lado);
            this.semEsperaDer.acquire();
            System.out.println(nombre + " OBTIENE PERMISO ESPERA DERECHA --------- " + lado);
            System.out.println(nombre + " ESPERA MUTEX ------- " + lado);
            this.mutex.acquire();
            System.out.println(nombre + " OBTIENE MUTEX --------- " + lado);
        }
        System.out.println(nombre + " ESPERA PERMISO CUERDA -------- " + lado);
        this.cuerda.acquire();
        System.out.println(nombre + " OBTIENE PERMISO CUERDA ------- " + lado);
        this.babuinosCruzando++;
        this.contCruzados++;
        System.out.println("[D] - " + nombre + " Esta cruzando el puente.");
        System.out.println(nombre + " LIBERA MUTEX ------- " + lado);
        this.mutex.release();
    }
    
    public void salirDerecha(String nombre, char lado) throws InterruptedException {
        System.out.println(nombre + " ESPERA MUTEX ---------- " + lado);
        this.mutex.acquire();
        System.out.println(nombre + " OBTIENE MUTEX --------- " + lado);
        this.babuinosCruzando--;
        this.contBabuinosDer++;
        System.out.println("Babuinos cruzando: " + this.babuinosCruzando);
        if (this.babuinosCruzando == 0) {
        //if (this.contCruzados == 5 || this.babuinosCruzando == 0 || (this.contCruzados <= 5 && this.babuinosCruzando == 0)) {
            System.out.println("Se libera la cuerda. Ya cruzaron todos los babuinos del lado Derecho.");
            this.lado = ' ';
            this.contCruzados = 0;
            System.out.println(nombre + " LIBERA PERMISO ESPERA IZQUERDA. LO LIBERA DESDE EL METODO salirDerecha() --------- " + lado);
            this.semEsperaIzq.release();
            this.cuerda.release(5);
        }
        System.out.println("[D] - " + nombre + " Termina de cruzar el puente.");
        System.out.println(nombre + " LIBERA PERMISO CUERDA ---------- " + lado);
        //this.cuerda.release();
        System.out.println(nombre + " LIBERA MUTEX ---------- " + lado);
        this.mutex.release();
    }
}
    
    /*
    private Semaphore cuerda;
    private Semaphore mutex;
    private Semaphore puedenCruzar;
    private int babuinosCruzando;
    private int babuinosIzq;
    private int babuinosDer;
    private char lado;
    
    public Cuerda() {
        this.cuerda = new Semaphore(5);
        this.mutex = new Semaphore(1);
        this.puedenCruzar = new Semaphore(1);
        this.babuinosCruzando = 0;
        this.babuinosIzq = 0;
        this.babuinosDer = 0;
        this.lado = ' ';
    }
    
    public void cruzarIzquierda(String nombre) throws InterruptedException {
        this.mutex.acquire();
        if (this.lado == ' ' || this.lado == 'D') {
            this.lado = 'I';
            this.puedenCruzar.acquire();
        }
        this.cuerda.acquire();
        this.babuinosCruzando++;
        this.babuinosIzq++;
        System.out.println(nombre + " Esta cruzando la cuerda desde el lado " + this.lado + ". Babuinos cruzando: " + this.babuinosCruzando);
        this.mutex.release();
    }
    
    public void salirIzquierda(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.babuinosCruzando--;
        if (this.babuinosCruzando == 0) {
            System.out.println("SE LIBERA LA CUERDA. YA CRUZARON TODOS LOS BABUINOS DEL LADO " + this.lado);
            this.lado = ' ';
            this.puedenCruzar.release();
        }
        this.mutex.release();
        this.cuerda.release();
    } 
    
    public void cruzarDerecha(String nombre) throws InterruptedException {
        this.mutex.acquire();
        if (this.lado == ' ' || this.lado == 'I') {
            this.lado = 'D';
        }
        this.cuerda.acquire();
        this.babuinosCruzando++;
        this.babuinosDer++;
        System.out.println(nombre + " Esta cruzando la cuerda desde el lado " + this.lado + ". Babuinos cruzando: " + this.babuinosCruzando);
        this.mutex.release();
    }
    
    public void salirDerecha(String nombre) throws InterruptedException {
        this.mutex.acquire();
        this.babuinosCruzando--;
        if (this.babuinosCruzando == 0) {
            System.out.println("SE LIBERA LA CUERDA. YA CRUZARON TODOS LOS BABUINOS DEL LADO " + this.lado);
            this.lado = ' ';
            this.puedenCruzar.release();
        }
        this.mutex.release();
        this.cuerda.release();
    }
    
}

*/