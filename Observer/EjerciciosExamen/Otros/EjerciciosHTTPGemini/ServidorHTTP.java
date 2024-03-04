package EjerciciosExamen.Otros.EjerciciosHTTPGemini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorHTTP {
    private static final int RESOURCE_POSITION = 1;
    private static Socket connCliente;

    public interface ObservadorHTTPPalabras {
        void actualizar(String info);
    }

    private List<ObservadorHTTPPalabras> observadores = new ArrayList<>();

    public void agregarObservador(ObservadorHTTPPalabras observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorHTTPPalabras observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String info) {
        for (ObservadorHTTPPalabras observador : observadores) {
            observador.actualizar(info);
        }
    }

    public void recogerGETHTTP() {
        int puerto = 8877;
        try {
            while (true) {
                ServerSocket serverSocket;
                serverSocket = new ServerSocket(puerto);
                connCliente = serverSocket.accept();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                connCliente.getInputStream()));
                String header = reader.readLine();
                System.out.println(header);
                // GET ________ HTTP/1.1
                String info = extraeInformacion(header);
                notificarObservadores(info);
                connCliente.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String extraeInformacion(String header) {
        return header.split(" ")[RESOURCE_POSITION];
    }

    public void lanzarPaginaWeb(String[] palabras) {
        String paginaWeb = crearPaginaWeb(palabras);
        try {
            OutputStream out = connCliente.getOutputStream();
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: " + paginaWeb.length() + "\r\n\r\n";
            out.write(response.getBytes());
            out.write(paginaWeb.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String crearPaginaWeb(String[] datosRecibidos) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>");
        html.append("<html>");
        html.append("<head>");
        html.append("<title>Números Primos</title>");
        html.append("</head>");
        html.append("<body>");
        html.append("<h1>Números Primos</h1>");
        html.append("<ul>");
        for (String frase : datosRecibidos) {
            html.append("<li>" + frase + "</li>");
        }
        html.append("<br><b>numero de palabras contadas: </b><br>");
        html.append("<li>" + datosRecibidos.length + "</li>");
        html.append("</ul>");
        html.append("</body>");
        html.append("</html>");
        return html.toString();
    }
}
