package TP_3.EJ_4;

public class Area {
    
    private final Espacio[] espacios;
    
    public Area() {
        this.espacios = new Espacio[10];
    }
    
    public void reservar(int i, String nombre) {
        if (this.espacios[i] == null) {
            Espacio es = new Espacio();
            this.espacios[i] = es;
            this.espacios[i].reservar(nombre,i);
        }
    }
    
    public int getEspacios() {
        return this.espacios.length;
    }
    
    public Espacio[] getArreglo() {
        return this.espacios;
    }
}
