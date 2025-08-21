package TP_3.EJ_4;

public class Main {
    
    public static void main(String[] args) {
        Area area = new Area();
        Thread vis1 = new Thread(new Visitante(area),"Visitante 1");
        Thread vis2 = new Thread(new Visitante(area),"Visitante 2");
        Thread vis3 = new Thread(new Visitante(area),"Visitante 3");
        Thread vis4 = new Thread(new Visitante(area),"Visitante 4");
        Thread vis5 = new Thread(new Visitante(area),"Visitante 5");
        
        System.out.println("Cantidad de espacios disponibles: " + area.getEspacios());
        
        vis1.start();
        vis2.start();
        vis3.start();
        vis4.start();
        vis5.start();
    }
}
