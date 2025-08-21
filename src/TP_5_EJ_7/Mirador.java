package TP_5_EJ_7;

import java.util.concurrent.Semaphore;

public class Mirador {
    
    private final Semaphore tobogan1;
    private final Semaphore tobogan2;
    
    public Mirador() {
        this.tobogan1 = new Semaphore(0);
        this.tobogan2 = new Semaphore(0);
    }
}
