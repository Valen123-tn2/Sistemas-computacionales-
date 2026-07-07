//Introducir por teclado una frase palabra a palabra, y mostrar la frase 
//completa se­ parando las palabras introducidas con espacios en blanco. 
//Terminar de leer la frase cuando alguna de las palabras introducidas sea la 
//cadena «fin» escrita con cualquier combinación de mayúsculas/minúsculas. 
//La cadena «fin» no aparecerá en la frase final.

package Ejercicio6_3;
import javax.swing.*;

public class ejercicio6_3 extends JFrame {

    private String frase = "";

    public ejercicio6_3() {

        setTitle("Ejercicio 6.3");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(15);
        JButton submitButton = new JButton("Agregar");
        JLabel resultLabel = new JLabel("Ingrese una palabra.");

        submitButton.addActionListener(e -> {
            String palabra = inputField.getText().trim();
            if (palabra.isEmpty()) {
                resultLabel.setText("Debe ingresar una palabra.");
                return;
            }
            if (palabra.equalsIgnoreCase("fin")) {
                resultLabel.setText("Frase: " + frase);
                submitButton.setEnabled(false);
                inputField.setEnabled(false);
                return;
            }

            frase += palabra + " ";
            resultLabel.setText("Frase actual: " + frase);
            inputField.setText("");
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Palabra: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(700, 120);
        setLocationRelativeTo(null);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_3 ejercicio = new ejercicio6_3();
            ejercicio.setVisible(true);
        });
    }
}