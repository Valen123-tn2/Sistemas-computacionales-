package Capitulo_7.Ejercicio7_7;

public class Banco {

    final String nombre;
    double capital;
    String direccionCentral;

    public Banco(String nombre, String direccionCentral) {
        this.nombre = nombre;
        this.capital = 5200000.0;
        this.direccionCentral = direccionCentral;
    }

    public Banco(String nombre, double capital, String direccionCentral) {
        this.nombre = nombre;
        this.capital = capital;
        this.direccionCentral = direccionCentral;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre
                + "\nCapital: $" + String.format("%.2f", capital)
                + "\nDirección Central: " + direccionCentral;
    }
}