package TermometroUniThread;

public class MainTermometro {
    public static void main(String[] args) {
        ManejadorObserverTermometro termometro=new ManejadorObserverTermometro();
        actualizadorTermometro escuchador=new actualizadorTermometro();
        termometro.agregarObservador(escuchador);
        termometro.setTemperatura(90);
    }
}
