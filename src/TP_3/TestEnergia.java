package TP_3;

public class TestEnergia {
    
    public static void main(String[] args) {
        Energia energia = new Energia(10);
        
        Thread criatura = new Thread(new CriaturaOscura(energia),"Criatura Oscura");
        Thread sanador = new Thread(new Sanador(energia),"Sanador");
        
        criatura.start();
        sanador.start();
        /*
        try {
            criatura.join();
            sanador.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        */
    }
    
}
