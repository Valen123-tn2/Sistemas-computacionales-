package Ejercicio1_5;
import java.util.Scanner;

public class ejercicio1_5 {
    public static void main(String[] args) {
        int nota1, nota2;
        double media;
        Scanner sc = new Scanner(System.in);

        System.out.print("Nota 1: ");
        nota1 = sc.nextInt();
        System.out.print("Nota 2: ");
        nota2 = sc.nextInt();

        media = (nota1 + nota2)/ 2.0;

        System.out.println("La media es: " + media);
    }
}
