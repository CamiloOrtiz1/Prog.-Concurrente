package TP_6_Ej_1_Monitores;

public class MonitorGestionTrafico {
    
    private int autosNorte;
    private int autosSur;
    private int contAutos;
    private char direccion;
    
    public MonitorGestionTrafico() {
        this.autosNorte = 0;
        this.autosSur = 0;
        this.contAutos = 0;
        this.direccion = ' '; 
    }
    
    public synchronized void EntrarCocheDelNorte(String nombre) throws InterruptedException {
        while (this.direccion == 'S' || (this.contAutos == 10 && this.autosSur > 0)) {
            this.wait();
        }
        
        if (this.direccion == ' ') {
            this.direccion = 'N';
        }
        this.autosNorte++;
        this.contAutos++;
        System.out.println(nombre + "   -> Cruza el puente desde el Norte");
    }
    
    public synchronized void SalirCocheDelNorte(String nombre) {
        this.autosNorte--;
        System.out.println(nombre + "   -> Termina de cruzar desde el Norte");
        if (this.autosNorte == 0 || this.contAutos >= 10) {
            this.direccion = 'S';
            this.contAutos = 0;
        }
        this.notifyAll();
    }
    
    public synchronized void EntrarCocheDelSur(String nombre) throws InterruptedException {
        while (this.direccion == 'N' || (this.contAutos >= 10 && this.autosNorte > 0)) {
            this.wait();
        }
        
        if (this.direccion == ' ') {
            this.direccion = 'S';
        }
        this.autosSur++;
        this.contAutos++;
        System.out.println(nombre + "   -> Cruza el puente desde el Sur");
    }
    
    public synchronized void SalirCocheDelSur(String nombre) {
        this.autosSur--;
        System.out.println(nombre + "   -> Termina de cruzar desde el Sur");
        if (this.autosSur == 0 || this.contAutos == 10) {
            this.direccion = 'N';
            this.contAutos = 0;
        }
        this.notifyAll();
    }
}
