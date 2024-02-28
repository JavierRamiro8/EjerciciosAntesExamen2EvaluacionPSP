package Termometro;

public class MainTermometro {
    public static void main(String[] args) {
        TermometroDigital termometroDigital=new TermometroDigital();
        actualizadorTermometro escuchador=new actualizadorTermometro();
        termometroDigital.agregarObservador(escuchador);
        termometroDigital.setTemperatura(40);
    }
}
