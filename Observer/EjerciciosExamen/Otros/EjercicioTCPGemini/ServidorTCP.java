package EjerciciosExamen.Otros.EjercicioTCPGemini;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorTCP {
    private final String ZUMBIDO = "BZZZZ MIRA EL MOVIL";
    private int puerto;

    public ServidorTCP(int puerto) {
        this.puerto = puerto;
    }

    public interface ObservadorTCP {
        void actualizar(String zumbido);
    }

    private List<ObservadorTCP> observadores = new ArrayList<>();

    public void agregarObservador(ObservadorTCP observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorTCP observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String zumbido) {
        for (ObservadorTCP observador : observadores) {
            observador.actualizar(zumbido);
        }
    }

    public void servidor() {
        try {
            ServerSocket serverSocket = new ServerSocket(puerto);
                Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    String recibido = in.readLine();
                    System.out.println("El cliente ha hablado, ha dicho: " + recibido+"\n");
                    out.writeUTF("Recibido: " + recibido+"\n");
                    notificarObservadores(ZUMBIDO);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}