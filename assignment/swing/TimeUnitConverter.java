import javax.swing.*;
import java.awt.*;

public class TimeUnitConverter extends JFrame {
    public TimeUnitConverter () {
        this.setSize(300, 300);
        this.setLayout(new GridLayout(0, 2));

        JTextField input = new JTextField(20);
        String [] options = {"Seconds", "Minutes", "Hours"};
        JComboBox<String> inputType = new JComboBox<String>(options);
        JComboBox<String> outputType = new JComboBox<String>(options);
        JButton convert = new JButton("Convert");
        JLabel output = new JLabel("");
        convert.addActionListener(e -> {
            try {
                double value = this.convert(input.getText(), inputType.getSelectedItem().toString(), outputType.getSelectedItem().toString());
                input.setText("");
                output.setText(String.format("%.2f", value));
            } catch (Exception error) {
                JOptionPane.showMessageDialog(this, error.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.add(new JLabel("Input Value: "));
        this.add(input);
        this.add(new JLabel("Input Type: "));
        this.add(inputType);
        this.add(new JLabel("Output Type: "));
        this.add(outputType);
        this.add(new JLabel(""));
        this.add(convert);
        this.add(new JLabel("Output: "));
        this.add(output);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public double convert (String value, String inputType, String outputType) {
        double newValue = Double.valueOf(value);

        if ((inputType.equals("Seconds") && outputType.equals("Minutes")) ||
            (inputType.equals("Minutes") && outputType.equals("Hours"))) {
            return newValue / 60;
        }
        if ((inputType.equals("Minutes") && outputType.equals("Seconds")) ||
            (inputType.equals("Hours") && outputType.equals("Minutes"))) {
            return newValue * 60;
        }
        if (inputType.equals("Seconds") && outputType.equals("Hours")) {
            return newValue / (60 * 60);
        }
        if (inputType.equals("Hours") && outputType.equals("Seconds")) {
            return newValue * 60 * 60;
        }
        return newValue;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimeUnitConverter::new);
    }
}