package TP_3.EJ_5;

import java.util.Random;

public class Surtidor {
    
    private final Random random = new Random();
    private Combustible maximo = new Combustible();
    
    public Surtidor() {}
    
    public void cargar(String nombre) {
        this.maximo.cargarCombustible(nombre);
    }
}
