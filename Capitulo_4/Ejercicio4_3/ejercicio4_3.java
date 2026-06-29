package Ejercicio4_3;
import javax.swing.*;

public class ejercicio4_3 extends JFrame {

    public ejercicio4_3() {
        setTitle("Ejercicio 4.3");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JTextField inputField3 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                double rad = Double.parseDouble(inputField1.getText());
                double alt = Double.parseDouble(inputField2.getText());
                int tipoc = Integer.parseInt(inputField3.getText());

                areaVolumencilidro(rad, alt, tipoc, resultLabel);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce números.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Introduzca el radio: "));
        panel.add(inputField1);
        panel.add(new JLabel("Introduzca la altura: "));
        panel.add(inputField2);
        panel.add(new JLabel("Introduzca la opcion (1 area, 2 volumen): "));
        panel.add(inputField3);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static void areaVolumencilidro(double radio, double altura, int opcion, JLabel label) {
        String texto = "";
        Double volumen, area;
       switch (opcion) {
        case 1:
            volumen = Math.PI *(radio * radio) * altura;
            texto += "El volumen es de: " + volumen;
            break;
        case 2:
            area = 2 * Math.PI * radio * (altura+radio);
            texto += "El area es de: " + area;
            break;
       }
       label.setText(texto);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_3 ejercicio = new ejercicio4_3();
            ejercicio.setVisible(true);
        });
    }
}