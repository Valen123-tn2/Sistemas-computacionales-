//Queremos desarrollar una aplicación que nos ayude a gestionar las notas de un centro 
//educativo. Cada grupo (o clase) está compuesto por 5 alumnos. Se pide leer las notas 
//(números enteros) del primer, segundo y tercer trimestre de un grupo. 
//Debemos mos­trar al final la nota promedio del grupo en cada trimestre, y la nota 
//promedio del alumno que se encuentra en la posición "pos" (que se lee por teclado).

package Ejercicio5_9;
import javax.swing.*;

public class ejercicio5_9 extends JFrame {

    private int[] trimestre1 = new int[5];
    private int[] trimestre2 = new int[5];
    private int[] trimestre3 = new int[5];
    private int cantidad = 0;
    private int etapa = 1;

    public ejercicio5_9() {

        setTitle("Ejercicio 5.9");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {

            try {
                int nota = Integer.parseInt(inputField.getText());
                if (etapa == 1) {
                    trimestre1[cantidad] = nota;
                    cantidad++;
                    if (cantidad == 5) {
                        etapa = 2;
                        cantidad = 0;
                        resultLabel.setText("Ingrese las 5 notas del segundo trimestre.");
                    }
                } else if (etapa == 2) {
                    trimestre2[cantidad] = nota;
                    cantidad++;
                    if (cantidad == 5) {
                        etapa = 3;
                        cantidad = 0;
                        resultLabel.setText("Ingrese las 5 notas del tercer trimestre.");
                    }
                } else if (etapa == 3) {
                    trimestre3[cantidad] = nota;
                    cantidad++;
                    if (cantidad == 5) {
                        etapa = 4;
                        resultLabel.setText("Ingrese la posición del alumno (1 a 5).");
                    }
                } else {
                    int pos = nota;
                    if (pos < 1 || pos > 5) {
                        resultLabel.setText("La posición debe estar entre 1 y 5.");
                        inputField.setText("");
                        return;
                    }
                    double promedio1 = promedio(trimestre1);
                    double promedio2 = promedio(trimestre2);
                    double promedio3 = promedio(trimestre3);
                    double promedioAlumno = (trimestre1[pos - 1] + trimestre2[pos - 1] + trimestre3[pos - 1]) / 3.0;
                    resultLabel.setText( "Promedio 1° trimestre: " + promedio1 + "Promedio 2° trimestre: " + promedio2 + "Promedio 3° trimestre: " + promedio3 + "Promedio del alumno " + pos + ": " + promedioAlumno);
                    submitButton.setEnabled(false);
                    inputField.setEnabled(false);
                }
                inputField.setText("");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida.");
            }
        });

        JPanel panel = new JPanel();

        panel.add(new JLabel("Numeros: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public double promedio(int[] trimestre) {
        int suma = 0;
        for (int i = 0; i < 5; i++) {
            suma += trimestre[i];
        }
        return (double) suma / 5;
    }

    public String mostrar(int[] t, int cantidad) {
        String texto = "";
        for (int i = 0; i < cantidad; i++) {
            texto += t[i] + " ";
        }
        return texto;
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ejercicio5_9 ejercicio = new ejercicio5_9();
            ejercicio.setVisible(true);
        });

    }
}