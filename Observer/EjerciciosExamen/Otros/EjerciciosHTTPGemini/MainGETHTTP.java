package EjerciciosExamen.Otros.EjerciciosHTTPGemini;

public class MainGETHTTP {

    public static void main(String[] args) {
        ServidorHTTP server=new ServidorHTTP();
        ContadorPalabras contadorPalabras=new ContadorPalabras();
        server.agregarObservador(contadorPalabras);
        server.recogerGETHTTP();
    }

}
