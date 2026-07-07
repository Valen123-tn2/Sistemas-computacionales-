//Escribir una aplicación que solicite al usuario cuántos números desea introducir. 
// A continuación, se introducirá por teclado esa cantidad de números enteros, 
// y por último, los mostrará en el orden inverso al introducido.

package Ejercicio5_2;
import javax.swing.*;

public class ejercicio5_2 extends JFrame {

    private int cantidad = 0;
    private int[] t;
    private int indice = 0;

    public ejercicio5_2() {
        setTitle("Ejercicio 5.2");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");
        inputField2.setEnabled(false);

        submitButton.addActionListener(e -> {
            try {
                if (t == null){
                    cantidad = Integer.parseInt(inputField1.getText());
                    t = new int[cantidad];
                    inputField1.setEnabled(false);
                    inputField2.setEnabled(true);
                    return;  
                }

                int num = Integer.parseInt(inputField2.getText());
                if (indice < cantidad){
                    t[indice] = num;
                    indice++;
                }
                if (indice == cantidad){
                    String resultado = "Los números en orden inverso son: ";
                    for (int i = cantidad - 1; i >= 0; i--) {
                        resultado += t[i] + " | ";
                    }
                    resultLabel.setText(resultado);
                }                     
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un numero valido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba la Cantidad de Numeros a Introducir: "));
        panel.add(inputField1);
        panel.add(new JLabel("Escriba un numero: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio5_2 ejercicio = new ejercicio5_2();
            ejercicio.setVisible(true);
        });
    }
}



