import javax.swing.*;

public class NumberList {

    JFrame frame;
    JTextField txtNumbers;
    JTextArea output;

    public NumberList() {

        frame = new JFrame("Number Lister");
        frame.setSize(450, 380);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNumbers = new JLabel("=== Number Lister === Enter numbers: ");
        lblNumbers.setBounds(20, 20, 400, 25);

        txtNumbers = new JTextField();
        txtNumbers.setBounds(20, 50, 400, 30);

        JButton btnList = new JButton("List Numbers");
        btnList.setBounds(145, 95, 140, 35);

        output = new JTextArea();
        output.setEditable(false);
        output.setBounds(20, 150, 400, 150);

        btnList.addActionListener(e -> listNumbers());

        frame.add(lblNumbers);
        frame.add(txtNumbers);
        frame.add(btnList);
        frame.add(output);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void listNumbers() {
        String text = txtNumbers.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter some numbers.");
            return;
        }
        String[] parts = text.split("[ ,]+");

        int[] numbers = new int[parts.length];
        int count = 0;

        int previousNum = 0;
        boolean hasPrevious = false;

        String result = "";
        int pos = 0;

        try {
            while (pos < parts.length) {
                int num = Integer.parseInt(parts[pos]);
                pos++;

                if (num == 0) {
                    result = result + "Found zero";

                    if (hasPrevious) {
                        result = result + " after " + previousNum;
                    }

                    if (pos < parts.length) {
                        int nextNum = Integer.parseInt(parts[pos]);
                        result = result + " and before " + nextNum;
                    }

                    result = result + ". Stopped the counting.\n";
                    break;
                }

                if (num < 0) {
                    continue;
                }

                numbers[count] = num;
                count++;

                previousNum = num;
                hasPrevious = true;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Numbers only please.");
            return;
        }

        result = result + "\n=== Listed Values ===\n";
        for (int i = 0; i < count; i++) {
            result = result + "Listed values: " + numbers[i] + "\n";
        }

        output.setText(result);
    }
}
