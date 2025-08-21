package Recuperatorio_29_11_23_Monitores_Locks;

public class Socio implements Runnable {
    
    private Serie serie;
    private char tipo;
    
    public Socio(char tipo, Serie serie) {
        this.serie = serie;
        this.tipo = tipo;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                this.serie.verCapitulo(tipo);
                System.out.println(Thread.currentThread().getName() + " Ya vio un capitulo, se duerme....");
                Thread.sleep(4000);
            }
        } catch (Exception e) {}
    }
}
