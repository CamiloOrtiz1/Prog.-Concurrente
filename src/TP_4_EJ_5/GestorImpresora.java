package TP_4_EJ_5;

public class GestorImpresora {
    
    private final Impresora[] impresoras;
    private final Impresora[] tipoA;
    private final Impresora[] tipoB;
    
    public GestorImpresora(int tipoA, int tipoB) {
        this.impresoras = new Impresora[4];
        this.tipoA = new Impresora[tipoA];
        this.tipoB = new Impresora[tipoB];
        
        // Inicializar las impresoras
        for (int i = 0; i < this.impresoras.length; i++) {
            this.impresoras[i] = new Impresora(i+1);
        }
        
        for (int j = 0; j < tipoA; j++) {
            this.tipoA[j] = new Impresora(j+1);
        }
        int aux = tipoA;
        for (int i = 0; i < tipoB; i++) {
            this.tipoB[i] = new Impresora(aux+1);
            aux++;
        }
    } 
    
    public Impresora iniciarImpresion(String nombre) throws InterruptedException {
        int cantImpresoras = this.impresoras.length;
        int i = 0;
        boolean salir = false;
        Impresora aux = null;
        
        while (i < cantImpresoras && !salir) {
            if (this.impresoras[i].getEstado()) {
                salir = true;
                this.impresoras[i].utilizarImpresora();
                System.out.println(nombre + " Inicia impresion con la Impresora " + this.impresoras[i].getId());
                aux = this.impresoras[i];
            }
            i++;
            
            if (i == cantImpresoras) {
                i = 0;
            }
        }
       
        return aux;
    }
    
    public void terminarImpresion(Impresora aux, String nombre) throws InterruptedException {
        System.out.println(nombre + " Finaliza impresion con la Impresora " +aux.getId());
        aux.finalizarImpresora();
    }   
}