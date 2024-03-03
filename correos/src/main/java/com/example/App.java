package com.example;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args)throws IOException {

        String archivoMensajes=args[0];
        String archivoCorreos=args[1];
        String usuario=args[2];
        String contrasena=args[3];

        LectorSpam lectorSpam=new LectorSpam(archivoMensajes,archivoCorreos);
        EnviadorSpam enviadorSpam=new EnviadorSpam(usuario,contrasena);
        lectorSpam.agregarObservador(enviadorSpam);
        lectorSpam.leerArchivos();
    }
}