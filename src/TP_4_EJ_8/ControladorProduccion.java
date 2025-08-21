package TP_4_EJ_8;

import java.util.concurrent.Semaphore;

public class ControladorProduccion {
    
    private final Semaphore electrico;
    private final Semaphore mecanico;
    
    public ControladorProduccion() {
        this.electrico = new Semaphore(0);
        this.mecanico = new Semaphore(0);
    }
    
    
    
}
