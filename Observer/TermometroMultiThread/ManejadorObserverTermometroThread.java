package TermometroMultiThread;

import java.util.ArrayList;
import java.util.List;

public class ManejadorObserverTermometroThread implements Runnable {

    public interface ObservadorThread {

        void actualizar(int temperatura);
    }

    private List<ObservadorThread> observadores = new ArrayList<>();
    private int temperatura;

    public void agregarObservador(ObservadorThread observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorThread observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (ObservadorThread observador : observadores) {
            observador.actualizar(temperatura);
        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                temperatura=(int)(Math.random()*100);
                notificarObservadores();
            } catch (InterruptedException e) {
                System.out.println("No ha dormido nada este thread!!");
                e.printStackTrace();
            }
        }
    }
    
}
