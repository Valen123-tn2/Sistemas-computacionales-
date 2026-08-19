package Capitulo_7.Ejercicio7_6;

public class Texto {

    String cadena;
    int longitudMax;

    public Texto(int longitudMax) {
        this.cadena = "";
        this.longitudMax = longitudMax;
    }

    public boolean adicionarCaracterPrincipio(char c) {
        if (cadena.length() + 1 <= longitudMax) {
            cadena = c + cadena;
            return true;
        }
        return false;
    }

    public boolean adicionarCaracterFinal(char c) {
        if (cadena.length() + 1 <= longitudMax) {
            cadena = cadena + c;
            return true;
        }
        return false;
    }

    public boolean adicionarCadenaPrincipio(String subcadena) {
        if (cadena.length() + subcadena.length() <= longitudMax) {
            cadena = subcadena + cadena;
            return true;
        }
        return false;
    }

    public boolean adicionarCadenaFinal(String subcadena) {
        if (cadena.length() + subcadena.length() <= longitudMax) {
            cadena = cadena + subcadena;
            return true;
        }
        return false;
    }

    public int contarVocales() {
        int contador = 0;
        String vocales = "aeiouAEIOUáéíóúÁÉÍÓÚ";
        for (int i = 0; i < cadena.length(); i++) {
            if (vocales.indexOf(cadena.charAt(i)) != -1) {
                contador++;
            }
        }
        return contador;
    }

    public String getCadena() {
        return cadena;
    }
}