package TermometroUniThread;

import TermometroUniThread.ManejadorObserverTermometro.Observador;

public class actualizadorTermometro implements Observador {
    @Override
    public void actualizar(int temperatura) {
        System.out.println("El termometro marca "+temperatura+"ºC");
    }
    
}
