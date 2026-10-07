import javax.swing.*;

public class vendingdraft1 {

    JFrame frame;
    JTextArea screen;
    JTextField txtMora;
    JTextField txtChoice;
    JTextArea output;

    String[] itemNames = {
        "Harbinger of Dawn",
        "Sunsettia (x20)",
        "Slime Condensate",
        "Qingxin Flower"
    };

    int[] itemPrices = {50, 30, 10, 20};

    public vendingdraft1() {

        frame = new JFrame("Vending Draft");
        frame.setSize(450, 420);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String items = "| TEYVAT VENDING MACHINE |\n\n";
        for (int i = 0; i < itemNames.length; i++) {
            items = items + (i + 1) + " - " + itemNames[i] + " | Price: " + itemPrices[i] + " Mora\n";
        }

        screen = new JTextArea(items);
        screen.setEditable(false);
        screen.setBounds(20, 20, 400, 110);

        JLabel lblMora = new JLabel("Insert Mora: ");
        lblMora.setBounds(20, 145, 170, 30);
        txtMora = new JTextField();
        txtMora.setBounds(195, 145, 100, 30);

        JLabel lblChoice = new JLabel("Choose an item (1-" + itemNames.length + "): ");
        lblChoice.setBounds(20, 185, 170, 30);
        txtChoice = new JTextField();
        txtChoice.setBounds(195, 185, 100, 30);

        JButton btnBuy = new JButton("Buy");
        btnBuy.setBounds(150, 235, 110, 35);

        output = new JTextArea();
        output.setEditable(false);
        output.setBounds(20, 290, 400, 70);

        btnBuy.addActionListener(e -> buy());

        frame.add(screen);
        frame.add(lblMora);
        frame.add(txtMora);
        frame.add(lblChoice);
        frame.add(txtChoice);
        frame.add(btnBuy);
        frame.add(output);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buy() {
        int balance;
        int choice;

        try {
            balance = Integer.parseInt(txtMora.getText().trim());
            choice = Integer.parseInt(txtChoice.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Numbers only please.");
            return;
        }

        if (choice >= 1 && choice <= itemNames.length) {
            int index = choice - 1;

            if (balance >= itemPrices[index]) {
                int change = balance - itemPrices[index];
                output.setText("You got a " + itemNames[index] + "! Enjoy, Traveler.\nChange: " + change + " Mora");
            } else {
                output.setText("Not enough Mora! You need " + (itemPrices[index] - balance) + " more.");
            }

        } else {
            output.setText("Invalid choice.");
        }
    }
}
