package Capitulo_7.Ejercicio7_9;

public class Bombilla {

    static boolean interruptorGeneral = true;
    boolean interruptorParticular;

    public Bombilla() {
        this.interruptorParticular = false;
    }

    public void encender() {
        this.interruptorParticular = true;
    }

    public void apagar() {
        this.interruptorParticular = false;
    }

    public static void cortarLuzGeneral() {
        interruptorGeneral = false;
    }

    public static void reponerLuzGeneral() {
        interruptorGeneral = true;
    }

    public boolean estaEncendida() {
        return interruptorGeneral && interruptorParticular;
    }
}