import javax.swing.*;
import java.awt.*;

public class ProductStatus extends JFrame{
    public ProductStatus () {
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ((JPanel) this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));

        JTextField name = new JTextField(20);
        JTextField id = new JTextField(20);
        JTextField stockQuantity = new JTextField(20);
        JTextField condition = new JTextField(20);
        JTextArea summaryTextArea = new JTextArea(10, 20);
        summaryTextArea.setEditable(false);

        form.add(new JLabel("Name: "));
        form.add(name);
        form.add(new JLabel("ID: "));
        form.add(id);
        form.add(new JLabel("Stock Quantity: "));
        form.add(stockQuantity);
        form.add(new JLabel("Condition: "));
        form.add(condition);

        JCheckBox electronic = new JCheckBox("Electronic");
        JCheckBox clothing = new JCheckBox("Clothing");
        JCheckBox furniture = new JCheckBox("Furniture");
        JCheckBox stationary = new JCheckBox("Stationary");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(electronic);
        buttonGroup.add(clothing);
        buttonGroup.add(furniture);
        buttonGroup.add(stationary);


        form.add(new JLabel("Category: "));
        form.add(new JLabel(""));

        form.add(electronic);
        form.add(clothing);
        form.add(furniture);
        form.add(stationary);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            try {
                this.validateFields(name.getText(), id.getText(), stockQuantity.getText(), condition.getText());
                this.validateCheckBoxes(electronic, furniture, clothing, stationary);
                StringBuilder checkBoxString = new StringBuilder();
                if (electronic.isSelected()) checkBoxString.append(electronic.getText());
                else if (clothing.isSelected()) checkBoxString.append(clothing.getText());
                else if (furniture.isSelected()) checkBoxString.append(furniture.getText());
                else if (stationary.isSelected()) checkBoxString.append(stationary.getText());


                StringBuilder summary = new StringBuilder();
                summary.append("Name: ").append(name.getText()).append('\n');
                summary.append("ID: ").append(id.getText()).append('\n');
                summary.append("Stock Quantity: ").append(stockQuantity.getText()).append('\n');
                summary.append("Condition: ").append(condition.getText()).append('\n');
                summary.append("Category: ").append(checkBoxString.toString());

                summaryTextArea.setText(summary.toString());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(this, error.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        JButton clear = new JButton("Clear");
        clear.addActionListener(e -> {
            name.setText("");
            id.setText("");
            stockQuantity.setText("");
            condition.setText("");
        });

        form.add(submit);
        form.add(clear);
        this.add(form, BorderLayout.NORTH);
        this.add(summaryTextArea, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void validateFields (String name,String id, String stockQuantity, String condition) {
        if (name == null || id == null || stockQuantity == null || condition == null 
            || name.isBlank() || id.isBlank() || stockQuantity.isBlank() || condition.isBlank()) {
            throw new IllegalArgumentException("All Fields must be filled");
        }

        try {
            Double.valueOf(stockQuantity);
        } catch (Exception e) {
            throw new IllegalArgumentException("Stock Quantity must be numeric");
        }
    }

    public void validateCheckBoxes (JCheckBox... boxes) {
        for (JCheckBox box : boxes) {
            if (box.isSelected()) {
                return;
            }
        }
        throw new IllegalStateException("Must Choose at least one category");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductStatus::new);
    }
}
