package TP_5_EJ_5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlTren implements Runnable{
    
    private final Tren tren;
    
    public ControlTren(Tren tren) {
        this.tren = tren;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                this.tren.iniciarRecorrido();
                Thread.sleep(2000);
                this.tren.finalizarRecorrido();
            }catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
