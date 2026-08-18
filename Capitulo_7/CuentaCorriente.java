package Capitulo_7;

public class CuentaCorriente {

    double saldo;
    String nombre;
    String dni;
    double limite;

    public CuentaCorriente(String nombre, String dni) {

        saldo = 0;
        this.nombre = nombre;
        this.dni = dni;
        limite = -50;
    }

    public boolean egreso(double cant) {

        if ((saldo - cant) >= limite) {
            saldo -= cant;
            return true;

        } else {
            return false;
        }
    }

    public void ingreso(double cant) {
        saldo += cant;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre
                + "\nDNI: " + dni
                + "\nSaldo: $" + String.format("%.2f", saldo)
                + "\nLímite descubierto: $" + String.format("%.2f", limite);
    }
}