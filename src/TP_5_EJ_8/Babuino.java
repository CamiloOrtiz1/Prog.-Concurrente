package TP_5_EJ_8;
/*
public class Babuino implements Runnable{
    
    private Cuerda soga;
    private char comienzo;
    
    public Babuino(Cuerda c, char desde){
        this.soga = c;
        this.comienzo = desde;
    }
    
    public void cruzando(){
        try{
            System.out.println(Thread.currentThread().getName() + " cruzando");
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            
        }
    }
    
    public void run(){
        while(true){
            try{
                soga.cruzar(this.comienzo);
                this.cruzando();
                soga.salir();
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                
            }
        }
    }
}
*/



public class Babuino implements Runnable {
    
    private final String nombre;
    private final char lado;
    private final Cuerda puente;
    
    public Babuino(String nombre, char lado, Cuerda puente) {
        this.nombre = nombre;
        this.lado = lado;
        this.puente = puente;
    }
    
    @Override
    public void run() {
        try {
            if (this.lado == 'I') {
                Thread.sleep(500);
                this.puente.cruzarIzquierda(nombre);
                System.out.println(nombre + " ESTA CRUZANDO.............");
                Thread.sleep(2000);
                this.puente.salirIzquierda(nombre);
            } else {
                Thread.sleep(500);
                this.puente.cruzarDerecha(nombre);
                System.out.println(nombre + " ESTA CRUZANDO................");
                Thread.sleep(2000);
                this.puente.salirDerecha(nombre);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

