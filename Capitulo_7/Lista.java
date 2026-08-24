package Capitulo_7;
import java.util.Arrays;

public class Lista {

    Integer[] tabla;
    int numElementos;

    public Lista() {
        this(10);
    }

    public Lista(int capacidadInicial) {
        tabla = new Integer[capacidadInicial];
        numElementos = 0;
    }

    public int getNumElementos() {
        return numElementos;
    }

    private void redimensionar() {
        if (numElementos == tabla.length) {
            tabla = Arrays.copyOf(tabla, tabla.length + 10);
        }
    }

    public void insertarFinal(Integer elem) {
        redimensionar();
        tabla[numElementos] = elem;
        numElementos++;
    }

    public void insertarPrincipio(Integer elem) {
        insertarEnIndice(0, elem);
    }

    public boolean insertarEnIndice(int indice, Integer elem) {
        if (indice < 0 || indice > numElementos) {
            return false;
        }
        redimensionar();
        System.arraycopy(tabla, indice, tabla, indice + 1, numElementos - indice);
        tabla[indice] = elem;
        numElementos++;
        return true;
    }

    public void agregarLista(Lista otraLista) {
        for (int i = 0; i < otraLista.numElementos; i++) {
            insertarFinal(otraLista.obtener(i));
        }
    }

    public Integer eliminar(int indice) {
        if (indice < 0 || indice >= numElementos) {
            return null;
        }
        Integer elem = tabla[indice];
        System.arraycopy(tabla, indice + 1, tabla, indice, numElementos - indice - 1);
        numElementos--;
        tabla[numElementos] = null;
        return elem;
    }

    public Integer obtener(int indice) {
        if (indice < 0 || indice >= numElementos) {
            return null;
        }
        return tabla[indice];
    }

    public int buscar(Integer elem) {
        for (int i = 0; i < numElementos; i++) {
            if (tabla[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    public String mostrarInformacion() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numElementos; i++) {
            sb.append(tabla[i]);
            if (i < numElementos - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}