package Parcial_2024_Fabrica_Automoviles;

public class Main {
    
    public static void main(String[] args) {
        
        Fabrica fabrica = new Fabrica(3,2,1);
        Thread equipo4 = new Thread(new Equipo4(fabrica));
        
        for (int i = 1; i < 10; i++) {
            Thread hilo = new Thread(new Equipo1(fabrica),"Equipo 1 - " +i);
            hilo.start();
        }
        equipo4.start();
        
        for (int i = 1; i < 6; i++) {
            Thread hilo = new Thread(new Equipo2(fabrica),"Equipo 2 - " + i);
            hilo.start();
        }
        
        for (int i = 1; i < 5; i++) {
            Thread hilo = new Thread(new Equipo3(fabrica),"Equipo 3 - " +i);
            hilo.start();
        }
    }
    
}
