import javax.swing.*;
import java.awt.*;

public class SalaryCalculator extends JFrame {
    private JTextArea displayField;

    public SalaryCalculator() {
        this.setTitle("Salary Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(450, 600);
        this.setLayout(new BorderLayout(10, 10));

        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel employeeForm = new JPanel();
        employeeForm.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel name = new JLabel("Name: ");
        JTextField nameField = new JTextField(30);

        JLabel id = new JLabel("ID: ");
        JTextField idField = new JTextField(30);

        JLabel depart = new JLabel("Department: ");
        JTextField departField = new JTextField(30);
        
        JLabel statusLabel = new JLabel("Employment Status: ");
        String[] status = {"Full Time", "Part Time"};
        JComboBox<String> employmentStatus = new JComboBox<>(status);

        JLabel hoursWorked = new JLabel("Hours Worked: ");
        JTextField hoursWorkedField = new JTextField(30);

        JLabel hourlyRate = new JLabel("Hourly Rate: ");
        JTextField hourlyRateField = new JTextField(30);

        // Submit elements
        JLabel blankSpaceLabel = new JLabel(""); // Visual spacer placeholder for the grid layout
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            this.handleSubmission(nameField, idField, departField, hoursWorkedField, hourlyRateField, employmentStatus);
        });

        // FIXED: Added statusLabel, blankSpaceLabel, and submit into layout population flow
        this.populateEmployeeForm(employeeForm, 
            name, nameField, 
            id, idField, 
            depart, departField, 
            statusLabel, employmentStatus, 
            hoursWorked, hoursWorkedField, 
            hourlyRate, hourlyRateField,
            blankSpaceLabel, submit
        );

        this.displayField = new JTextArea(8, 35);
        this.displayField.setEditable(false);
        this.displayField.setLineWrap(true);
        this.displayField.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(this.displayField);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Calculation Output"));

        // Organize primary layouts
        this.add(employeeForm, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER); 

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public double calculateSalary(int hoursWorked, double hourlyRate) {
        int bonus = 100;
        if (hoursWorked <= 40) {
            return hourlyRate * hoursWorked + bonus;
        }
        double salary = 40 * hourlyRate;
        salary += (hoursWorked - 40) * 1.5 * hourlyRate;
        return salary + bonus;
    }

    public void populateEmployeeForm(JPanel employeeForm, Component... components) {
        for (Component comp : components) {
            employeeForm.add(comp);
        }
    }

    public void resetEmployeeForm(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public void validateFields(String name, String id, String department, String hoursWorked, String hourlyRate) throws Exception {
        if (name == null || name.isBlank() || id == null || id.isBlank() || department == null || department.isBlank()) {
            throw new IllegalArgumentException("All Fields Must be filled!");
        }
        try {
            Integer.valueOf(hoursWorked);
            Double.valueOf(hourlyRate);
        } catch (Exception e) {
            throw new IllegalArgumentException("Hours and Rate must be valid numeric values.");
        }
    }

    public void handleSubmission(JTextField nameField, JTextField idField, JTextField departField, JTextField hoursWorkedField, JTextField hourlyRateField, JComboBox<?> employmentStatus) {
        try {
            this.validateFields(nameField.getText(), idField.getText(), departField.getText(), hoursWorkedField.getText(), hourlyRateField.getText());
            
            // FIXED: Removed "this.add(displayField)" which broke the layout state
            displayField.setText(
                "Name: " + nameField.getText() + "\n" +
                "ID: " + idField.getText() + "\n" +
                "Department: " + departField.getText() + "\n" +
                "Employment Status: " + employmentStatus.getSelectedItem() + "\n" +
                "Hours Worked: " + hoursWorkedField.getText() + "\n" +
                "Hourly Rate: $" + hourlyRateField.getText() + "\n" +
                "Total Salary (incl. Bonus): $" + this.calculateSalary(Integer.valueOf(hoursWorkedField.getText()), Double.valueOf(hourlyRateField.getText()))
            );
            
            this.resetEmployeeForm(nameField, idField, departField, hoursWorkedField, hourlyRateField);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SalaryCalculator::new);
    }
}