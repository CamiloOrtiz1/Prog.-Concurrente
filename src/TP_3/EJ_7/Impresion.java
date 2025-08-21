package TP_3.EJ_7;

public class Impresion implements Runnable {
    
    private String letra;
    private int repeticion;
    private int turno;
    private static int turnoActual = 1;
    
    public Impresion(String letra, int repeticion, int turno) {
        this.letra = letra;
        this.repeticion = repeticion;
        this.turno = turno;
    }
    
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (this.verificarTurno()) {
                for (int j = 0; j < repeticion; j++) {
                    System.out.print(this.letra);
                }
            } else {
                this.turnoActual = (this.turnoActual + 1) % 3;
            }
        }
    }
    
    public synchronized boolean verificarTurno() {
        return this.turno == this.turnoActual;
    }
}
