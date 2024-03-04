package EjerciciosExamen.Otros.EjerciciosHTTPGemini;

import EjerciciosExamen.Otros.EjerciciosHTTPGemini.ServidorHTTP.ObservadorHTTPPalabras;

public class ContadorPalabras implements ObservadorHTTPPalabras {
    ServidorHTTP server;
    @Override
    public void actualizar(String info) {
        if(server==null){
        server=new ServidorHTTP();
        }
        String[] frase = info.split("/");
        String[] fraseFinalSeparado = frase[1].split("%20");
        server.lanzarPaginaWeb(fraseFinalSeparado);
    }
}
