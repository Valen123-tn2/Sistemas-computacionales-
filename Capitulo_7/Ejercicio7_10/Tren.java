package Capitulo_7.Ejercicio7_10;

public class Tren {

    public Locomotora locomotora;
    public Maquinista maquinistaResponsable;
    Vagon[] vagones;
    int numVagones;

    public Tren(Locomotora locomotora, Maquinista maquinista) {
        this.locomotora = locomotora;
        this.maquinistaResponsable = maquinista;
        this.vagones = new Vagon[5];
        this.numVagones = 0;
    }

    public boolean engancharVagon(double max, double actual, String mercancia) {
        if (numVagones < 5) {
            vagones[numVagones] = new Vagon(max, actual, mercancia);
            numVagones++;
            return true;
        }
        return false;
    }

    public int getNumVagones() {
        return numVagones;
    }
}