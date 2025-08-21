package TP_4_EJ_5;

public class Cliente implements Runnable {
    
    private final String nombre;
    private final GestorImpresora gestorImpresora;
    
    public Cliente(String nombre, GestorImpresora impresora) {
        this.nombre = nombre;
        this.gestorImpresora = impresora;
    }
    
    @Override
    public void run() {
        //for (int i = 0; i < 15; i++) {
            try {
                Impresora aux = this.gestorImpresora.iniciarImpresion(this.nombre);
                Thread.sleep(2000);
                if (aux != null ){ 
                    this.gestorImpresora.terminarImpresion(aux, this.nombre);
                } else {
                    System.out.println(this.nombre + " No pudo imprimir!");
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        //}
    }    
}
    
