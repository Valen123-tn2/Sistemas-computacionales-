package EjercicioAd2_4;
import javax.swing.*;

public class ejercicioAd2_4 extends JFrame {

    public ejercicioAd2_4() {
        setTitle("Ejercicios Adicionales 2.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField d = new JTextField(10);
        JTextField m = new JTextField(10);
        JTextField a = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int dia = Integer.parseInt(inputField.getText());
                int mes = Integer.parseInt(inputField.getText());
                int año = Integer.parseInt(inputField.getText());
                int nac = dia + mes + año;
                int c1 = (nac / 1000) % 10;
                int c2 = (nac / 100) % 10;
                int c3 = (nac / 10) % 10;
                int c4 = nac % 10;
                int total = c1 + c2 + c3 + c4;
                resultLabel.setText( "Su Numero de la Suerte es: " + total );
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el Dia de su Cumpleaños: "));
        panel.add(d);
        panel.add(new JLabel("Escriba el Mes de su Cumpleaños: "));
        panel.add(m);
        panel.add(new JLabel("Escriba el Año de su Cumpleaños: "));
        panel.add(a);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicioAd2_4 ejercicio = new ejercicioAd2_4();
            ejercicio.setVisible(true);
        });
    }
}
    