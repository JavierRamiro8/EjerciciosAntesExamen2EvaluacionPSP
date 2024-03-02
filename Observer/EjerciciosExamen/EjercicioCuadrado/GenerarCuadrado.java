package EjerciciosExamen.EjercicioCuadrado;

public class GenerarCuadrado {
    
    public static String GenerarCuadradoUDP(int alto, int ancho, char letra) {
        StringBuilder cubo = new StringBuilder();
    
        // Generar la base del cubo
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                cubo.append(letra);
            }
            cubo.append("\n");
        }
    
        // Generar las caras del cubo
        for (int i = 0; i < alto; i++) {
            cubo.append(letra);
            for (int j = 1; j < ancho - 1; j++) {
                cubo.append(" ");
            }
            cubo.append(letra);
            cubo.append("\n");
        }
    
        return cubo.toString();
    }
    
    
}
