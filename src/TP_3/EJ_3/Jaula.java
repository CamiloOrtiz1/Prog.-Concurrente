package TP_3.EJ_3;

public class Jaula {
    
    private Plato plato;
    private Rueda rueda;
    private Hamaca hamaca;
    
    public Jaula() {
        this.plato = new Plato();
        this.rueda = new Rueda();
        this.hamaca = new Hamaca();
    }
    
    public void comer(String nombre) {
        this.plato.comer(nombre);
    }
    
    public void correr(String nombre) {
        this.rueda.correr(nombre);
    }
    
    public void descansar(String nombre) {
        this.hamaca.descansar(nombre);
    }
}
