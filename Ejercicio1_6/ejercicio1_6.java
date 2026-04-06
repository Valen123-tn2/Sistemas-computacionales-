package Ejercicio1_6;
import java.util.Scanner;

public class ejercicio1_6 {
    public static void main(String[] args) {
        int nota1, nota2, nota3, media;
        Scanner sc = new Scanner(System.in);

        System.out.print("Nota 1: ");
        nota1 = sc.nextInt();
        System.out.print("Nota 2: ");
        nota2 = sc.nextInt();
        System.out.print("Nota 3: ");
        nota3 = sc.nextInt();

        media = (int) ((nota1 + nota2 + nota3)/ 3.0);

        System.out.println("La media es: " + media);
    }
}