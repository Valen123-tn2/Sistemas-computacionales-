package Capitulo_7.Ejercicio7_15;
import java.util.Arrays;

public class ColaTabla {

    Integer[] tabla;
    int numElementos;

    public ColaTabla() {
        tabla = new Integer[10];
        numElementos = 0;
    }

    public void encolar(Integer elemento) {
        if (numElementos == tabla.length) {
            tabla = Arrays.copyOf(tabla, tabla.length + 10);
        }
        tabla[numElementos] = elemento;
        numElementos++;
    }

    public Integer desencolar() {
        if (numElementos == 0) {
            return null;
        }
        Integer primero = tabla[0];
        for (int i = 0; i < numElementos - 1; i++) {
            tabla[i] = tabla[i + 1];
        }
        tabla[numElementos - 1] = null;
        numElementos--;
        return primero;
    }

    public String mostrarInformacion() {
        return Arrays.toString(Arrays.copyOf(tabla, numElementos));
    }
}