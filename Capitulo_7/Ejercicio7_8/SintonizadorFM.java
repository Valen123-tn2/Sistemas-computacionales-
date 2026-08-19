package Capitulo_7.Ejercicio7_8;

public class SintonizadorFM {

    double frecuencia;

    public SintonizadorFM() {
        this.frecuencia = 80.0;
    }

    public SintonizadorFM(double frecuencia) {
        if (frecuencia < 80.0) {
            this.frecuencia = 80.0;
        } else if (frecuencia > 108.0) {
            this.frecuencia = 108.0;
        } else {
            this.frecuencia = frecuencia;
        }
    }

    public void up() {
        this.frecuencia += 0.5;
        if (this.frecuencia > 108.0) {
            this.frecuencia = 80.0;
        }
    }

    public void down() {
        this.frecuencia -= 0.5;
        if (this.frecuencia < 80.0) {
            this.frecuencia = 108.0;
        }
    }

    public double getFrecuencia() {
        return frecuencia;
    }
}