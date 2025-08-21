package TP_5_EJ_5;

import java.util.concurrent.Semaphore;

public class Ticket {
    
    private final Tren tren;
    private final Semaphore tickets;
    
    public Ticket(Tren tren) {
        this.tren = tren;
        this.tickets = new Semaphore(50);
    }
}
