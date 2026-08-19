package Capitulo_7.Ejercicio7_10;

public class Locomotora {

    public String matricula;
    public int potencia;
    public int anioFabricacion;
    public Mecanico mecanicoAsignado;

    public Locomotora(String matricula, int potencia, int anioFabricacion, Mecanico mecanico) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.anioFabricacion = anioFabricacion;
        this.mecanicoAsignado = mecanico;
    }
}