package EjerciciosExamen.EjercicioCuadrado;
public class MainCuadrado {
    public static void main(String[] args) {
        int puertoReceptor=Integer.parseInt(args[1]);
        int puertoEnviador=Integer.parseInt(args[2]);
        Receptor receptor=new Receptor(puertoReceptor);
        Enviador enviador=new Enviador(puertoEnviador);
        receptor.agregarObservador(enviador);
        receptor.ReceptorDatagramas();
    }
}
