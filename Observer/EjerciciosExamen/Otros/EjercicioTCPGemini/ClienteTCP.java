package EjerciciosExamen.Otros.EjercicioTCPGemini;

import EjerciciosExamen.Otros.EjercicioTCPGemini.ServidorTCP.ObservadorTCP;

public class ClienteTCP implements ObservadorTCP {

    @Override
    public void actualizar(String zumbido) {
        System.out.println(zumbido+"\n");
    }
    
}
