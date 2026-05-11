import javax.swing.*;
import java.awt.*;

public class WorkShop {
    public static void main(String[] args) {

        JFrame frame = new JFrame("WorkShop");
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(0, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel name = new JLabel("Enter Your Name: ");
        JLabel email = new JLabel("Enter Your Email: ");
        JLabel motive = new JLabel("Enter Your Motivation: ");

        JTextField nameField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        JTextArea motivation = new JTextArea(4, 20);
        motivation.setLineWrap(true);
        motivation.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(motivation);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        namePanel.add(name);
        namePanel.add(nameField);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
        emailPanel.add(email);
        emailPanel.add(emailField);

        JPanel motivationPanel = new JPanel();
        motivationPanel.setLayout(new BoxLayout(motivationPanel, BoxLayout.X_AXIS));
        motivationPanel.add(motive);
        motivationPanel.add(scrollPane);

        JRadioButton python = new JRadioButton("Python Programming");
        python.setActionCommand("Python Programming");

        JRadioButton frontEnd = new JRadioButton("Front End Development");
        frontEnd.setActionCommand("Front End Development");

        JRadioButton backEnd = new JRadioButton("Back End Development");
        backEnd.setActionCommand("Back End Development");

        JRadioButton math = new JRadioButton("Math for CS");
        math.setActionCommand("Math for CS");

        JRadioButton dsa = new JRadioButton("DSA");
        dsa.setActionCommand("Data Structures and Algorithms");

        JRadioButton ml = new JRadioButton("Machine Learning with Python");
        ml.setActionCommand("Machine Learning With Python");

        ButtonGroup radioGroup = new ButtonGroup();

        radioGroup.add(python);
        radioGroup.add(frontEnd);
        radioGroup.add(backEnd);
        radioGroup.add(math);
        radioGroup.add(dsa);
        radioGroup.add(ml);

        JPanel radioPanel = new JPanel(new GridLayout(3, 2));

        radioPanel.add(python);
        radioPanel.add(frontEnd);
        radioPanel.add(backEnd);
        radioPanel.add(math);
        radioPanel.add(dsa);
        radioPanel.add(ml);

        JCheckBox confirm = new JCheckBox("Confirm Participation!");

        JButton register = new JButton("Register");
        JButton reset = new JButton("Reset");

        reset.addActionListener(e -> {
            nameField.setText("");
            emailField.setText("");
            motivation.setText("");
            radioGroup.clearSelection();
            confirm.setSelected(false);
        });

        JDialog dialog = new JDialog(frame, "Message", true);
        dialog.setSize(350, 200);
        dialog.setLayout(new GridLayout(0, 1));
        dialog.setLocationRelativeTo(frame);

        JButton ok = new JButton("OK");

        ok.addActionListener(event -> {
            dialog.setVisible(false);
        });

        register.addActionListener(e -> {

            dialog.getContentPane().removeAll();

            if (
                radioGroup.getSelection() == null ||
                nameField.getText().isBlank() ||
                emailField.getText().isBlank() ||
                motivation.getText().isBlank() ||
                !confirm.isSelected()
            ) {

                dialog.add(new JLabel("You must fill the form completely!"));
                dialog.add(ok);

            } else {

                String confirmText =
                        nameField.getText()
                        + " has successfully applied for "
                        + radioGroup.getSelection().getActionCommand();

                JLabel confirmation = new JLabel(confirmText);

                JProgressBar motivationBar = new JProgressBar(0, 100);

                String[] words = motivation.getText().trim().split("\\s+");

                motivationBar.setValue(Math.min(words.length, 100));
                motivationBar.setStringPainted(true);

                dialog.add(confirmation);
                dialog.add(new JLabel("Motivation Strength:"));
                dialog.add(motivationBar);
                dialog.add(ok);
            }

            dialog.revalidate();
            dialog.repaint();

            dialog.setVisible(true);
        });

        frame.add(namePanel);
        frame.add(emailPanel);
        frame.add(motivationPanel);
        frame.add(radioPanel);
        frame.add(confirm);
        frame.add(register);
        frame.add(reset);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}