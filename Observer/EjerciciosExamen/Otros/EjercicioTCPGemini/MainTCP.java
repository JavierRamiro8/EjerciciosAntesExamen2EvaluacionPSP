package EjerciciosExamen.Otros.EjercicioTCPGemini;

public class MainTCP {
    public static void main(String[] args) {
        int puerto=Integer.parseInt(args[0]);
        ServidorTCP server=new ServidorTCP(puerto);
        ClienteTCP cliente=new ClienteTCP();
        server.agregarObservador(cliente);
        server.servidor();
    }
}
