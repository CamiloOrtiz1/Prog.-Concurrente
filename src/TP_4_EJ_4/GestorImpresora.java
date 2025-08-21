package TP_4_EJ_4;

public class GestorImpresora {
    
    private final Impresora[] impresoras;
    
    public GestorImpresora() {
        this.impresoras = new Impresora[4];
        
        // Inicializar las impresoras
        for (int i = 0; i < this.impresoras.length; i++) {
            this.impresoras[i] = new Impresora(i+1);
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
