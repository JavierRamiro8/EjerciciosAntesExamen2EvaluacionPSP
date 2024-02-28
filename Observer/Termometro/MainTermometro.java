package Termometro;

public class MainTermometro {
    public static void main(String[] args) {
        TermometroDigital termometroDigital=new TermometroDigital();
        ElCreadorDeLosQueEscuchan escuchador=new ElCreadorDeLosQueEscuchan();
        termometroDigital.agregarObservador(escuchador);
        termometroDigital.setTemperatura(40);
    }
}
