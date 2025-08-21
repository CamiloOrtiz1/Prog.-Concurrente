package Recuperatorio_29_11_23_Monitores_Locks;

public class Traductor implements Runnable { 
    
    private char tipo;
    private Serie serie;
    
    public Traductor(char tipo, Serie serie) {
        this.tipo = tipo;
        this.serie = serie;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                if (this.tipo == 'I') {
                    this.serie.traducir();
                
                }
            }
        } catch (Exception e) {}
    }
    
}
