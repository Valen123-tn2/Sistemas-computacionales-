package Capitulo_7.Ejercicio7_14;
import Capitulo_7.Lista;

public class PilaLista {

    private Lista lista;

    public PilaLista() {
        lista = new Lista();
    }

    public void apilar(Integer elem) {
        lista.insertarFinal(elem);
    }

    public Integer desapilar() {
        if (lista.getNumElementos() == 0) {
            return null;
        }
        return lista.eliminar(lista.getNumElementos() - 1);
    }

    public String mostrarInformacion() {
        StringBuilder sb = new StringBuilder("Cima -> [");
        for (int i = lista.getNumElementos() - 1; i >= 0; i--) {
            sb.append(lista.obtener(i));
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}