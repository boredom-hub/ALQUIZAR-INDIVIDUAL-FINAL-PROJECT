import javax.swing.*;

public class HighandLowVAL {

    JFrame frame;
    JTextField txtNumbers;
    JTextArea output;

    public HighandLowVAL() {

        frame = new JFrame("Highest & Lowest Value Finder");
        frame.setSize(450, 330);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNumbers = new JLabel("Enter the numbers (separated by spaces): ");
        lblNumbers.setBounds(20, 20, 400, 25);

        txtNumbers = new JTextField();
        txtNumbers.setBounds(20, 50, 400, 30);

        JButton btnFind = new JButton("Find");
        btnFind.setBounds(165, 95, 110, 35);

        output = new JTextArea();
        output.setEditable(false);
        output.setBounds(20, 150, 400, 100);

        btnFind.addActionListener(e -> find());

        frame.add(lblNumbers);
        frame.add(txtNumbers);
        frame.add(btnFind);
        frame.add(output);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void find() {
        String text = txtNumbers.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter some numbers.");
            return;
        }

        String[] parts = text.split("[ ,]+");
        int n = parts.length;

        int[] numbers = new int[n];

        try {
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Numbers only please.");
            return;
        }

        int highest = numbers[0];
        int lowest = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > highest) {
                highest = numbers[i];
            }
            if (numbers[i] < lowest) {
                lowest = numbers[i];
            }
        }

        output.setText("=== Results ===\n"
                + "Highest value: " + highest + " (winnah)\n"
                + "Lowest value: " + lowest + " (losserrrrr)\n\n"
                + "Program finished.");
    }
}
