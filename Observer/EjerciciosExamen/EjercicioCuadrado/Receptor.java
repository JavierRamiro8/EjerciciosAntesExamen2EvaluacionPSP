package EjerciciosExamen.EjercicioCuadrado;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Receptor {
    private DatagramSocket socket;
    private int puerto;


    public Receptor(int puerto) {
        this.puerto = puerto;
    }

    public interface ObservadorCuadrado {
        void actualizar(int alto,int ancho,char letra);
    }

    private List<ObservadorCuadrado> observadores = new ArrayList<>();

    public void agregarObservador(ObservadorCuadrado observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorCuadrado observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(int alto, int ancho, char letraRecibida) {
        for (ObservadorCuadrado observador : observadores) {
            observador.actualizar(alto,ancho,letraRecibida);
        }
    }

    public void ReceptorDatagramas() {
        try {
            if (socket == null) {
                socket = new DatagramSocket(puerto);
            }
            byte[] paquete = new byte[1024];
            DatagramPacket dPacket = new DatagramPacket(paquete, paquete.length);
            while (true) {
                try {
                    socket.receive(dPacket);
                    String mensaje = new String(dPacket.getData(), 0, dPacket.getLength());
                    String mensajeDividido[] = mensaje.split(" ");
                    int alto = Integer.parseInt(mensajeDividido[0]);
                    int ancho = Integer.parseInt(mensajeDividido[1]);
                    char letraRecibida = mensajeDividido[2].charAt(0);

                    notificarObservadores(alto,ancho,letraRecibida);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
