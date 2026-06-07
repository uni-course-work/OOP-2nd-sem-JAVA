import javax.swing.*;
import java.awt.*;

public class DistanceConverter extends JFrame {
    public DistanceConverter () {
        this.setSize(300, 300);
        this.setLayout(new GridLayout(0, 2));

        JTextField input = new JTextField(20);
        String [] options = {"Meters", "KiloMeters", "Miles"};
        JComboBox<String> inputType = new JComboBox<String>(options);
        JComboBox<String> outputType = new JComboBox<String>(options);
        JButton convert = new JButton("Convert");
        JLabel output = new JLabel("");
        convert.addActionListener(e -> {
            try {
                double value = this.convert(input.getText(), inputType.getSelectedItem().toString(), outputType.getSelectedItem().toString());
                input.setText("");
                output.setText(String.format("%.4f", value));
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

    public double convert (String value, String inputType, String outputType)  throws Exception{
        try {
            double newValue = Double.valueOf(value);
            if (inputType.equals("Meters") && outputType.equals("KiloMeters")) {
                return newValue / 1000;
            }
            if (inputType.equals("Meters") && outputType.equals("Miles")) {
                return newValue / (1000 * 1.61);
            }
            if (inputType.equals("KiloMeters") && outputType.equals("Meters")) {
                return newValue * 1000;
            }
            if (inputType.equals("KiloMeters") && outputType.equals("Miles")) {
                return newValue / 1.61;
            }
            if (inputType.equals("Miles") && outputType.equals("KiloMeters")) {
                return newValue * 1.61;
            }
            if (inputType.equals("Miles") && outputType.equals("Meters")) {
                return newValue * 1000 * 1.61;
            }
            return newValue;
        } catch (Exception e) {
            throw e;
        }
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DistanceConverter::new);
    }
}
