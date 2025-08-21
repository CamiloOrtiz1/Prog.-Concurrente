package TP_3.EJ_5;

import java.util.Random;

public class Tanque {
    
    private int combustible = 100;
    private final Random random = new Random();
    
    public Tanque() {}
    
    public void consumir() {
        int aleatorio = this.random.nextInt(20);
        this.combustible = this.combustible - aleatorio;
    } 
    
    public int getCombustible() {
        return this.combustible;
    }
}
