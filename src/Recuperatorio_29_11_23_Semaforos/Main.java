package Recuperatorio_29_11_23_Semaforos;

public class Main {
    
    
    public static void main(String[] args) {
        Casa casa = new Casa();
        Thread hiloMayor = new Thread(new AnimalitoMayor(casa),"Animalito Mayor");
        
        for (int i = 1; i <= 6; i++) {
            Thread hiloMenor = new Thread(new AnimalitoMenor(casa),"Animalito Menor " + i);
            hiloMenor.start();
        }
        hiloMayor.start();
    }
}
