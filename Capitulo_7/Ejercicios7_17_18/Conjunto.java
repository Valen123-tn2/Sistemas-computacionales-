package Capitulo_7.Ejercicios7_17_18;
import Capitulo_7.Lista;

public class Conjunto {

    Lista lista;

    public Conjunto() {
        lista = new Lista(10);
    }

    public Conjunto(int capacidadInicial) {
        lista = new Lista(capacidadInicial);
    }

    public int getNumElementos() {
        return lista.getNumElementos();
    }

    public boolean pertenece(Integer elemento) {
        return lista.buscar(elemento) != -1;
    }

    public boolean insertar(Integer elemento) {
        if (!pertenece(elemento)) {
            lista.insertarFinal(elemento);
            return true;
        }
        return false;
    }

    public void añadirConjunto(Conjunto otro) {
        for (int i = 0; i < otro.lista.getNumElementos(); i++) {
            insertar(otro.lista.obtener(i));
        }
    }

    public boolean eliminar(Integer elemento) {
        int idx = lista.buscar(elemento);
        if (idx != -1) {
            lista.eliminar(idx);
            return true;
        }
        return false;
    }

    public void eliminarConjunto(Conjunto otro) {
        for (int i = 0; i < otro.lista.getNumElementos(); i++) {
            eliminar(otro.lista.obtener(i));
        }
    }

    public String mostrarInformacion() {
        return lista.mostrarInformacion();
    }

    // Métodos Estáticos (Ejercicio 7.18)
    public static boolean incluido(Conjunto c1, Conjunto c2) {
        for (int i = 0; i < c1.lista.getNumElementos(); i++) {
            if (!c2.pertenece(c1.lista.obtener(i))) {
                return false;
            }
        }
        return true;
    }

    public static Conjunto union(Conjunto c1, Conjunto c2) {
        Conjunto resultado = new Conjunto();
        resultado.añadirConjunto(c1);
        resultado.añadirConjunto(c2);
        return resultado;
    }

    public static Conjunto interseccion(Conjunto c1, Conjunto c2) {
        Conjunto resultado = new Conjunto();
        for (int i = 0; i < c1.lista.getNumElementos(); i++) {
            Integer elem = c1.lista.obtener(i);
            if (c2.pertenece(elem)) {
                resultado.insertar(elem);
            }
        }
        return resultado;
    }

    public static Conjunto diferencia(Conjunto c1, Conjunto c2) {
        Conjunto resultado = new Conjunto();
        for (int i = 0; i < c1.lista.getNumElementos(); i++) {
            Integer elem = c1.lista.obtener(i);
            if (!c2.pertenece(elem)) {
                resultado.insertar(elem);
            }
        }
        return resultado;
    }
}