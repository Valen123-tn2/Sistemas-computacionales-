package Capitulo_7.Ejercicios1_2_3_4_5;

public class CuentaCorriente {

    double saldo;
    String nombre;
    String dni;
    double limite;
    static String nombreBanco = "Banco Central";

    public CuentaCorriente(String nombre, String dni) {
        this.saldo = 0;
        this.nombre = nombre;
        this.dni = dni;
        this.limite = -50;
    }

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
        this.nombre = "Sin Nombre";
        this.dni = "Sin DNI";
        this.limite = 0;
    }

    public CuentaCorriente(double saldo, double limite, String dni) {
        this.saldo = saldo;
        this.limite = limite;
        this.dni = dni;
        this.nombre = "Sin Nombre";
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

    public static void setNombreBanco(String nuevoBanco) {
        nombreBanco = nuevoBanco;
    }

    public static String getNombreBanco() {
        return nombreBanco;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre
                + "\nDNI: " + dni
                + "\nBanco: " + nombreBanco
                + "\nSaldo: $" + String.format("%.2f", saldo)
                + "\nLímite descubierto: $" + String.format("%.2f", limite);
    }
}