package TermometroMultiThread;

public class MainTermometroMultiThread {
    public static void main(String[] args) {
        ManejadorObserverTermometroThread termotetroMultiHilo=new ManejadorObserverTermometroThread();
        ActualizadorTermometroMultiThread observador=new ActualizadorTermometroMultiThread();
        termotetroMultiHilo.agregarObservador(observador);
        Thread hiloTermometro=new Thread(termotetroMultiHilo);
        hiloTermometro.start();
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Estoy por obra del guion :)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
