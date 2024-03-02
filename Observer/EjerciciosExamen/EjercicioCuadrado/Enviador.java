package EjerciciosExamen.EjercicioCuadrado;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import EjerciciosExamen.EjercicioCuadrado.Receptor.ObservadorCuadrado;

public class Enviador implements ObservadorCuadrado {
    private static DatagramSocket socket;
    private int  puertoEnviador;

    public Enviador(int puertoEnviador){
        this.puertoEnviador=puertoEnviador;
    }


    public void EnviadorPorUDP(String cuadrado) {
        if (socket == null) {
            try {
                socket = new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
        byte[] datos = cuadrado.getBytes();
        try {
            DatagramPacket dPacket = new DatagramPacket(datos, datos.length, 
                    InetAddress.getByName("192.168.0.255"), puertoEnviador);
                    try {
                        socket.send(dPacket);
                    } catch (IOException e) {
                    }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actualizar(int alto, int ancho, char letra) {
        String cuadrado= GenerarCuadrado.GenerarCuadradoUDP(alto, ancho, letra);
        EnviadorPorUDP(cuadrado);
    }
}
