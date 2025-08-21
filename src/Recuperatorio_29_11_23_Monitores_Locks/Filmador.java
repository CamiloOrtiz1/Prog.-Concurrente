package Recuperatorio_29_11_23_Monitores_Locks;

public class Filmador implements Runnable {
    
    private Serie serie;
    
    public Filmador(Serie serie) {
        this.serie = serie;
    } 
    
    @Override
    public void run() {
        try {
            while (true) {
                this.serie.generarCapitulo();
                System.out.println("Se filmo un capitulo. Se espera para el siguiente....");
                Thread.sleep(2000);
            }
        } catch (Exception e) {}
    }
}
