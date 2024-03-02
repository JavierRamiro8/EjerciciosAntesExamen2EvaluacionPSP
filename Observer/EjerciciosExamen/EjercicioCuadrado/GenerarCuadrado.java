package EjerciciosExamen.EjercicioCuadrado;

public class GenerarCuadrado {

    public static String GenerarCuadradoUDP(int alto, int ancho, char letra) {
        StringBuilder cuadrado = new StringBuilder();

        // Generar la base del cuadrado
        for (int i = 0; i < alto; i++) {
            // Si es la primera o última fila
            if (i == 0 || i == alto- 1) {
                for (int j = 0; j < ancho; j++) {
                    cuadrado.append(letra);
                }
            } else {
                // Agregar letra al inicio y al final
                cuadrado.append(letra);
                // Agregar espacios en el medio
                for (int j = 1; j < ancho - 1; j++) {
                    cuadrado.append(" ");
                }
                // Agregar letra al final
                cuadrado.append(letra);
            }
            cuadrado.append("\n");
        }
        return cuadrado.toString();
    }
}
