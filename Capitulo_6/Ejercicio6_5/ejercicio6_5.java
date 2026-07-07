//Pedir el nombre completo (nombre y apellidos) al usuario. 
//El programa debe eliminar cualquier vocal del nombre. 
//Por ejemplo, "Álvaro Pérez" se mostrará "lvr Prz". 
//Solo se eliminan las vocales (mayúsculas, minúsculas y acentuadas). 
//El resto de caracteres no se modifican.

package Ejercicio6_5;
import javax.swing.*;

public class ejercicio6_5 extends JFrame {

    public ejercicio6_5() {

        setTitle("Ejercicio 6.5");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(20);
        JButton submitButton = new JButton("Eliminar vocales");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            String nombre = inputField.getText();
            if (nombre.isEmpty()) {
                resultLabel.setText("Debe ingresar un nombre.");
                return;
            }
            String resultado = "";

            for (int i = 0; i < nombre.length(); i++) {
                char letra = nombre.charAt(i);
                if (letra != 'a' && letra != 'A' &&
                    letra != 'e' && letra != 'E' &&
                    letra != 'i' && letra != 'I' &&
                    letra != 'o' && letra != 'O' &&
                    letra != 'u' && letra != 'U' &&
                    letra != 'á' && letra != 'Á' &&
                    letra != 'é' && letra != 'É' &&
                    letra != 'í' && letra != 'Í' &&
                    letra != 'ó' && letra != 'Ó' &&
                    letra != 'ú' && letra != 'Ú') {
                    resultado += letra;
                }
            }
            resultLabel.setText(resultado);
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nombre: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(700, 120);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_5 ejercicio = new ejercicio6_5();
            ejercicio.setVisible(true);
        });
    }
}