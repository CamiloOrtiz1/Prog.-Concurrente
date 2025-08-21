package Recuperatorio_29_11_23_Monitores_Locks;

public class Main {
    
    public static void main(String[] args) {
        Serie serie = new Serie();
        Thread filmador = new Thread(new Filmador(serie),"Filmador");
        filmador.start();
        Thread ingles = new Thread(new Traductor('I',serie), "Traductor Ingles");
        Thread espaniol = new Thread(new Traductor('E',serie),"Traductor Español");
        ingles.start();
        espaniol.start();
        char tipo;
        for (int i = 1; i < 20; i++) {
            tipo = (i % 2 == 0) ? 'I' : 'E';
            Thread hilo = new Thread(new Socio(tipo,serie),"Socio " + i);
            hilo.start();
        }
    }
}
