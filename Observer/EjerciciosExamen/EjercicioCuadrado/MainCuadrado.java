package EjerciciosExamen.EjercicioCuadrado;

public class MainCuadrado {
    public static void main(String[] args) {
        int puertoReceptor=4567;
        int puertoEnviador=7654;
        Receptor receptor=new Receptor(puertoReceptor);
        Enviador enviador=new Enviador(puertoEnviador);
        receptor.agregarObservador(enviador);
        receptor.ReceptorDatagramas();
    }
}
