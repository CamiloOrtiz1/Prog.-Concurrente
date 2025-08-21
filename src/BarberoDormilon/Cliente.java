package BarberoDormilon;

public class Cliente implements Runnable {

    private Barberia barberia;
    private String nombre;

    public Cliente(Barberia barberia, String nombre) {
        this.barberia = barberia;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        if (barberia.entrarBarberia(nombre)) {
            barberia.despertarBarbero(nombre);
        } else {
            System.out.println("La Barberia esta llena, el Cliente: " + nombre + " no puede cortarse el pelo");
        }
    }
}