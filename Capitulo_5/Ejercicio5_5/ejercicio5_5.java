//Desarrollar el juego la cámara secreta, que consiste abrir una cámara mediante 
//su combinación secreta, que está formado por una combinación de dígitos del uno 
//al cinco. El jugador especificará cuál es la longitud de la combinación, 
//a mayor longitud mayor será la dificultad del juego. La aplicación genera, 
//de forma aleatoria, una combinación secreta que el usuario tendrá que acertar. 
//En cada intento se muestra como pista, para cada dígito de la combinación 
//introducido por el jugador, si es mayor, menor o igual que el correspondiente en la 
//combinación secreta.

package Ejercicio5_5;
import javax.swing.*;
import java.util.Random;

public class ejercicio5_5 extends JFrame {

    private int cantidad = 0;
    private int[] secreto;
    private int[] intento;
    private boolean generado = false;

    public ejercicio5_5() {

        setTitle("Ejercicio 5.5");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {

            try {
                if (!generado) {
                    cantidad = Integer.parseInt(inputField1.getText());
                    if (cantidad <= 0) {
                        resultLabel.setText("La longitud debe ser mayor que 0.");
                        return;
                    }
                    secreto = new int[cantidad];
                    intento = new int[cantidad];
                    generar();  
                    generado = true;
                    inputField1.setEnabled(false);
                }
                String numero = inputField2.getText();

                if (numero.length() != cantidad) {
                    resultLabel.setText("Debe ingresar " + cantidad + " dígitos.");
                    return;
                }
                boolean gano = true;
                String pista = "";

                for (int i = 0; i < cantidad; i++) {
                    intento[i] = Character.getNumericValue(numero.charAt(i));
                    if (intento[i] < 1 || intento[i] > 5) {
                        resultLabel.setText("Solo se permiten números del 1 al 5.");
                        return;
                    }
                    if (intento[i] > secreto[i]) {
                        pista += "Posición " + (i + 1) + ": El número secreto es Menor. ";
                        gano = false;
                    } else if (intento[i] < secreto[i]) {
                        pista += "Posición " + (i + 1) + ": El número secreto es Mayor. ";
                        gano = false;
                    } else {
                        pista += "Posición " + (i + 1) + ": Igual. ";
                    }
                }

                if (gano) {
                    resultLabel.setText("¡Abriste la cámara secreta!");
                    submitButton.setEnabled(false);
                } else {
                    resultLabel.setText(pista);
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida.");
            }

        });

        JPanel panel = new JPanel();

        panel.add(new JLabel("Longitud: "));
        panel.add(inputField1);
        panel.add(new JLabel("Intento: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);

        setSize(600, 200);
        setLocationRelativeTo(null);
    }

    public void generar() {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            secreto[i] = random.nextInt(5) + 1;
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ejercicio5_5 ejercicio = new ejercicio5_5();
            ejercicio.setVisible(true);
        });

    }
}