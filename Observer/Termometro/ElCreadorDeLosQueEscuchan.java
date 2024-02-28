package Termometro;

import Termometro.EjemploObserverTermometro.Observador;

public class ElCreadorDeLosQueEscuchan implements Observador {
    @Override
    public void actualizar(int temperatura) {
        System.out.println("El termometro marca "+temperatura+"ºC");
    }
    
}
