package Capitulo_7.Ejercicio7_16;
import Capitulo_7.Lista;

public class ColaLista {

    Lista lista;

    public ColaLista() {
        lista = new Lista();
    }

    public void encolar(Integer elemento) {
        lista.insertarFinal(elemento);
    }

    public Integer desencolar() {
        if (lista.getNumElementos() == 0) {
            return null;
        }
        return lista.eliminar(0);
    }

    public String mostrarInformacion() {
        return lista.mostrarInformacion();
    }
}