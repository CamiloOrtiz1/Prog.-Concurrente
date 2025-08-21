package concurrente.TP2_Thread_Runnable.Parte_2;

public class TestCorredor {
    
    public static void main(String[] args) {
        
        Corredor[] corredores = new Corredor[3];
        Thread[] hiloCorredor = new Thread[3];
        for (int i = 0; i < corredores.length; i++) {
            corredores[i] = new Corredor("#"+(i+1));
        }
        
        for (int i = 0; i < hiloCorredor.length; i++) {
            hiloCorredor[i] = new Thread(corredores[i]);
            hiloCorredor[i].start();
        }
        
        for (Thread hiloCorredor1 : hiloCorredor) {
            try {
                hiloCorredor1.join();
            }catch (InterruptedException ex) {
                System.out.println("Error: " +ex.getMessage());
            }
        }
        
        int maxDistancia = 0, mayor = 0;
        for (int i = 0; i < corredores.length; i++) {
            if (corredores[i].getDistanciaRecorrida() > maxDistancia) {
                maxDistancia = corredores[i].getDistanciaRecorrida();
                mayor = i;
            }
        }
        System.out.println("La mayor distancia es del corredor: " +corredores[mayor].getNombre());
    }
    
}
