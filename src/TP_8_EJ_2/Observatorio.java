package TP_8_EJ_2;

import java.util.concurrent.Semaphore;

public class Observatorio {
    
    private Semaphore sala, mutexVisitante, visitanteEspera;
    boolean visitanteSillaRueda,hayVisitante,hayMantenimiento,hayInvestigadores;
    private final int capacidadMax = 50, capacidadMin = 30;
    private int esperaVisitante, contSala;
    
    public Observatorio() {
        this.sala = new Semaphore(50);
        this.mutexVisitante = new Semaphore(1);
        this.visitanteEspera = new Semaphore(0);
        this.visitanteSillaRueda = false;
        this.hayVisitante = false;
        this.hayInvestigadores = false;
        this.hayMantenimiento = false;
        this.esperaVisitante = 0;
        this.contSala = 0;
    }
    
    public void entraVisitante(boolean visSillaRueda,String nombre) throws InterruptedException {
        this.mutexVisitante.acquire();
        this.esperaVisitante++;
        if (!visSillaRueda) {
            if (!visitanteSillaRueda) {
                if (this.contSala < 50) {
                    this.sala.acquire();
                    this.contSala++;
                    this.esperaVisitante--;
                    System.out.println(nombre + " Entro al Observatorio");
                    this.mutexVisitante.release();
                } else {
                    this.mutexVisitante.release();
                    this.visitanteEspera.acquire();
                    this.sala.acquire();
                    this.contSala++;
                    this.esperaVisitante--;
                    System.out.println(nombre + " Entro al Observatorio");
                }
            } else {
                if (this.contSala < 30) {
                    this.sala.acquire();
                    this.contSala++;
                    this.esperaVisitante--;
                    System.out.println(nombre + " Entro al Observatorio");
                    this.mutexVisitante.release();
                } else {
                    this.mutexVisitante.release();
                    this.visitanteEspera.acquire();
                    this.sala.acquire();
                    this.contSala++;
                    this.esperaVisitante--;
                    System.out.println(nombre + " Entro al Observatorio");
                }
            }
        } else {
            this.visitanteSillaRueda = true;
            if (this.contSala < 30) {
                this.sala.acquire();
                this.contSala++;
                this.esperaVisitante--;
                System.out.println(nombre + " Entro al Observatorio en silla de ruedas");
                this.mutexVisitante.release();
            } else {
                this.mutexVisitante.release();
                this.visitanteEspera.acquire();
                this.sala.acquire();
                this.contSala++;
                this.esperaVisitante--;
                System.out.println(nombre + " Entro al Observatorio en silla de ruedas");
            }
        }
    }
    
    
    public void saleVisitante(boolean sillaRuedas,String nombre) {
    }
}
