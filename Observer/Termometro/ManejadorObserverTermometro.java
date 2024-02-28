package Termometro;
import java.util.ArrayList;
import java.util.List;

public abstract class ManejadorObserverTermometro {

    public interface Observador {

        void actualizar(int temperatura);
    }

    private List<Observador> observadores = new ArrayList<>();
    private int temperatura;

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(temperatura);
        }
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }

    public int getTemperatura() {
        return temperatura;
    }
}
