import javax.swing.*;
import java.awt.*;
import java.util.function.DoubleBinaryOperator;

public class EIS extends JFrame {
    public EIS () {
        this.setLayout(new GridLayout(0, 2, 10, 10));

        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(16, 16, 16,16));

        this.add(new JLabel("Name: "));
        JTextField nameField = new JTextField(30);
        this.add(nameField);
        this.add(new JLabel("ID: "));
        JTextField idField = new JTextField(30);
        this.add(idField);
        this.add(new JLabel("Department: "));
        JTextField departField = new JTextField(30);
        this.add(departField);
        this.add(new JLabel("Salary for first month: "));
        JTextField salary1 = new JTextField(20);
        this.add(salary1);
        this.add(new JLabel("Salary for second month: "));
        JTextField salary2 = new JTextField(20);
        this.add(salary2);
        this.add(new JLabel("Salary for third month: "));
        JTextField salary3 = new JTextField(20);
        this.add(salary3);

        JRadioButton fullTime = new JRadioButton("Full Time", true);
        JRadioButton partTime = new JRadioButton("Part Time");
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(fullTime);
        buttonGroup.add(partTime);

        JPanel radios = new JPanel(new FlowLayout());
        radios.add(fullTime);
        radios.add(partTime);

        this.add(new JLabel("Employment Status: "));
        this.add(radios);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            try {
                this.validateFields(nameField.getText(), idField.getText(), departField.getText(), salary1.getText(), salary2.getText(), salary3.getText());
                StringBuilder message = new StringBuilder();
                message.append("Name: ").append(nameField.getText()).append('\n');
                message.append("ID: ").append(idField.getText()).append('\n');
                message.append("Department: ").append(departField.getText()).append('\n');
                message.append("Employement Status: ").append(fullTime.isSelected() ? "Full Time\n" : "Part Time\n");
                message.append("Salary Avg: ").append(String.format("%.3f", this.calculateAvgSalary(salary1.getText(), salary2.getText(), salary3.getText())));

                JOptionPane.showMessageDialog(this, message.toString(), "Employee Info", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception error) {
                JOptionPane.showMessageDialog(this, error.getMessage(), "Input Error", JOptionPane.PLAIN_MESSAGE);
            }
        });
        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> {
            nameField.setText("");
            idField.setText("");
            departField.setText("");
            salary1.setText("");
            salary2.setText("");
            salary3.setText("");
        });
        this.add(submit);
        this.add(reset);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setVisible(true);
    }

    public void validateFields (String name, String id, String department, String salary1, String salary2, String salary3 ) {
        if (name == null || id == null || department == null || name.isBlank() || id.isBlank() || department.isBlank() || 
        salary1 == null || salary1.isBlank() || salary2 == null || salary2.isBlank() || salary3 == null || salary3.isBlank()) {
            throw new IllegalArgumentException("All Fields must be filled");
        }

        try {
            Double.valueOf(salary1);
            Double.valueOf(salary2);
            Double.valueOf(salary3);
        } catch (Exception e) {
            throw new IllegalArgumentException("Salaries must have numeric values");
        }
    }

    public double calculateAvgSalary (String salary1, String salary2, String salary3) {
        return (Double.valueOf(salary1) + Double.valueOf(salary2) + Double.valueOf(salary3)) / 3;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EIS::new);
    }
}
