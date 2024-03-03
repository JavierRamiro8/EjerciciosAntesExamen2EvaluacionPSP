package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorSpam {
    private String archivoMensajes;
    private String archivoCorreos;

    public LectorSpam(String archivoMensajes, String archivoCorreos) {
        this.archivoCorreos = archivoCorreos;
        this.archivoMensajes = archivoMensajes;
    }

    public interface ObservadorCorreos {
        void actualizar(String mensaje, String correo);
    }

    private List<ObservadorCorreos> observadores = new ArrayList<>();

    public void agregarObservador(ObservadorCorreos observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorCorreos observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String mensaje, String correo) {
        for (ObservadorCorreos observador : observadores) {
            observador.actualizar(mensaje, correo);
        }
    }

    public void leerArchivos() {
        try {
            BufferedReader lectorCorreos = new BufferedReader(new FileReader(archivoCorreos));
            BufferedReader lectorMensajes = new BufferedReader(new FileReader(archivoMensajes));
            try {
                while (lectorCorreos.readLine() != null && lectorMensajes.readLine() != null) {
                    String cuentaCorreo = lectorCorreos.readLine().toString();
                    String mensajes = lectorMensajes.readLine().toString();
                    notificarObservadores(mensajes, cuentaCorreo);
                }
                lectorCorreos.close();
                lectorMensajes.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
