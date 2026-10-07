import javax.swing.*;

public class Agefinder {

    JFrame frame;
    JTextField txtAges;
    JTextArea output;

    public Agefinder() {

        frame = new JFrame("Age Finder");
        frame.setSize(450, 330);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblAges = new JLabel("Enter the ages (separated by spaces): ");
        lblAges.setBounds(20, 20, 400, 25);

        txtAges = new JTextField();
        txtAges.setBounds(20, 50, 400, 30);

        JButton btnFind = new JButton("Find Lowest Age");
        btnFind.setBounds(135, 95, 160, 35);

        output = new JTextArea();
        output.setEditable(false);
        output.setBounds(20, 150, 400, 80);

        btnFind.addActionListener(e -> findLowest());

        frame.add(lblAges);
        frame.add(txtAges);
        frame.add(btnFind);
        frame.add(output);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void findLowest() {
        String text = txtAges.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter some ages.");
            return;
        }

        String[] parts = text.split("[ ,]+");
        int totalAges = parts.length;

        int[] ages = new int[totalAges];

        try {
            for (int i = 0; i < totalAges; i++) {
                ages[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Numbers only please.");
            return;
        }

        int lowestAge = ages[0];
        for (int i=1; i<ages.length; i++)
            if (ages[i] < lowestAge) {
                lowestAge = ages[i];
            }

        output.setText("========================================\n"
                + "Lowest age among the entered ages is: " + lowestAge + "\n"
                + "========================================");
    }
}
