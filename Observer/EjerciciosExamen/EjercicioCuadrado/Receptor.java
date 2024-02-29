package EjerciciosExamen.EjercicioCuadrado;

import java.util.ArrayList;
import java.util.List;

public class Receptor {

    public interface ObservadorCuadrado {
        void actualizar();
    }

    private List<ObservadorCuadrado> observadores = new ArrayList<>();

    public void agregarObservador(ObservadorCuadrado observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorCuadrado observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (ObservadorCuadrado observador : observadores) {
            observador.actualizar();
        }
    }

}
