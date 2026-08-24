package Capitulo_7.Ejercicio7_13;
import java.util.Arrays;

public class PilaTabla {

    private Integer[] tabla;
    private int numElementos;

    public PilaTabla() {
        tabla = new Integer[10];
        numElementos = 0;
    }

    public void apilar(Integer elem) {
        if (numElementos == tabla.length) {
            tabla = Arrays.copyOf(tabla, tabla.length + 10);
        }
        tabla[numElementos] = elem;
        numElementos++;
    }

    public Integer desapilar() {
        if (numElementos == 0) {
            return null;
        }
        numElementos--;
        Integer elem = tabla[numElementos];
        tabla[numElementos] = null;
        return elem;
    }

    public String mostrarInformacion() {
        StringBuilder sb = new StringBuilder("Cima -> [");
        for (int i = numElementos - 1; i >= 0; i--) {
            sb.append(tabla[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}