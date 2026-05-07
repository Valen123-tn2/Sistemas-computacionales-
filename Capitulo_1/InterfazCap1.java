import javax.swing.*; //Libreria necesaria para swing
import java.awt.*; // Libreria necesaria para los layouts

import Ejercicio1_7.ejercicio1_7;  //Importa los ejercicios desde la carpeta 
import Ejercicio1_8.ejercicio1_8;  //para que los pueda usar
import Ejercicio1_9.ejercicio1_9;
import EjercicioAd2_1.ejercicioAd2_1;
import EjercicioAd2_2.ejercicioAd2_2;
import EjercicioAd2_4.ejercicioAd2_4;
import Ejercicio1_10.ejercicio1_10;
import EjercicioAd_1.ejercicioAd_1;
import EjercicioAd_2.ejercicioAd_2;
import EjercicioAd_3.ejercicioAd_3;

public class InterfazCap1 extends JFrame {
    // Se Crean los botones que van a ir en la interfaz, se les pone un nombre y el texto que se va a mostrar
    JButton btnRedondeo = new JButton("Redondeo");   
    JButton btnCalculoVentasFijos = new JButton("Cálculo de ventas (valores fijos)");
    JButton btnCalculoVentasVariables = new JButton("Cálculo de ventas (valores variables)");
    JButton btnCalculoCircunferencia = new JButton("Cálculo de circunferencia");
    JButton btnConversiónTemperatura = new JButton("Conversión de temperatura");
    JButton btnConversiónVelocidad = new JButton("Conversión de velocidad");
    JButton btnCalculoHipotenusa = new JButton("Cálculo de hipotenusa");
    JButton btnÁreaTriángulo  = new JButton("Área de triángulo");
    JButton btnDescomposiciónNúmero = new JButton("Descomposición de número");
    JButton btnNúmeroSuerte = new JButton("Número de la suerte");

    public InterfazCap1() {
        setTitle("Capitulo 1"); // Se le pone un titulo
        setLayout(new BorderLayout(10,10)); //Se divide la ventana en secciones ara poder modificar las ubicaciones

        JPanel panelBotones = new JPanel(new GridLayout(2, 5, 5, 5));  //Se crea un panel para los botones y el texto, se seleccionan la cantidad de filas y columnas, y la separacion que van a tener
        panelBotones.add(btnRedondeo);   //Se añaden los botones a la interfaz
        panelBotones.add(btnCalculoVentasFijos);
        panelBotones.add(btnCalculoVentasVariables);
        panelBotones.add(btnCalculoCircunferencia);
        panelBotones.add(btnConversiónTemperatura);
        panelBotones.add(btnConversiónVelocidad);
        panelBotones.add(btnCalculoHipotenusa);
        panelBotones.add(btnÁreaTriángulo);
        panelBotones.add(btnDescomposiciónNúmero);
        panelBotones.add(btnNúmeroSuerte);
        add(panelBotones, BorderLayout.CENTER); //se le dice al panel en que parte de la ventana tiene que estar

        btnRedondeo.addActionListener(e -> {
            ejercicio1_7 ventana = new ejercicio1_7();  //Se llama al archivo cuandos se apreta el boton 
            ventana.setVisible(true);                   //se abre y muestra el codigo del ejercicio 
        });                                             //en otra ventana en la pantalla 

        btnCalculoVentasFijos.addActionListener(e -> {
            ejercicio1_8 ventana = new ejercicio1_8();
            ventana.setVisible(true);
        });

        btnCalculoVentasVariables.addActionListener(e -> {
            ejercicio1_9 ventana = new ejercicio1_9();
            ventana.setVisible(true);
        });

        btnCalculoCircunferencia.addActionListener(e -> {
            ejercicio1_10 ventana = new ejercicio1_10();
            ventana.setVisible(true);
        });

        btnConversiónTemperatura.addActionListener(e -> {
            ejercicioAd_1 ventana = new ejercicioAd_1();
            ventana.setVisible(true);
        });

        btnConversiónVelocidad.addActionListener(e -> {
             ejercicioAd_2 ventana = new  ejercicioAd_2();
            ventana.setVisible(true);
        });

        btnCalculoHipotenusa.addActionListener(e -> {
            ejercicioAd_3 ventana = new ejercicioAd_3();
            ventana.setVisible(true);
        });

        btnÁreaTriángulo.addActionListener(e -> {
            ejercicioAd2_1 ventana = new  ejercicioAd2_1();
            ventana.setVisible(true);
        });

        btnDescomposiciónNúmero.addActionListener(e -> {
            ejercicioAd2_2 ventana = new ejercicioAd2_2();
            ventana.setVisible(true);
        });

        btnNúmeroSuerte.addActionListener(e -> {
            ejercicioAd2_4 ventana = new ejercicioAd2_4();
            ventana.setVisible(true);
        });

        setSize(600, 200);  //se decide el tamaño de la interfaz
        setLocationRelativeTo(null); //Donde va a ir ubicada la ventana al abrirse
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ordena que se cierre todo el programa al apretar x 
        setVisible(true); //Permite que se vea la ventana
    }

    public static void main(String[] args) {
        new InterfazCap1();
    }
}