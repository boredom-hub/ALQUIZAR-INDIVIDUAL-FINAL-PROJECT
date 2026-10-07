import javax.swing.*;

public class AgeCheck {

    JFrame frame;
    JTextField txtAge;
    JLabel lblResult;

    public AgeCheck() {

        frame = new JFrame("Age Check");
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblAge = new JLabel("Please enter your age: ");
        lblAge.setBounds(50, 30, 250, 30);

        txtAge = new JTextField();
        txtAge.setBounds(50, 65, 150, 30);

        JButton btnCheck = new JButton("Check");
        btnCheck.setBounds(220, 65, 100, 30);

        lblResult = new JLabel("");
        lblResult.setBounds(50, 120, 250, 30);

        btnCheck.addActionListener(e -> checkAge());

        frame.add(lblAge);
        frame.add(txtAge);
        frame.add(btnCheck);
        frame.add(lblResult);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void checkAge() {
        int age;
        try {
            age = Integer.parseInt(txtAge.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a whole number.");
            return;
        }

        if (age >= 18) {
            lblResult.setText("Allowed.");
        } else {
            lblResult.setText("Not Allowed.");
        }
    }
}
