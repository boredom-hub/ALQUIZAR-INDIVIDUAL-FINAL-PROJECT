import javax.swing.*;

public class genshinvendinglol {

    JFrame frame;
    JTextArea screen;
    JTextField txtChoice;
    JTextArea message;

    String[] itemNames = {
        "Harbinger of Dawn",
        "Vision of Anemo (Replica)",
        "Sunsettia (x20)",
        "Primogem (x60)",
        "Slime Condensate",
        "Qingxin Flower"
    };

    int[] itemPrices = {50, 200, 30, 150, 10, 20};
    int[] itemStock = {5, 2, 10, 4, 8, 6};

    int balance = 0;

    public genshinvendinglol() {

        frame = new JFrame("Teyvat Vending Machine");
        frame.setSize(450, 470);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        screen = new JTextArea();
        screen.setEditable(false);
        screen.setBounds(20, 20, 400, 200);

        JLabel lblChoice = new JLabel("Choose: ");
        lblChoice.setBounds(20, 240, 60, 30);

        txtChoice = new JTextField();
        txtChoice.setBounds(85, 240, 100, 30);

        JButton btnEnter = new JButton("Enter");
        btnEnter.setBounds(200, 240, 100, 30);

        message = new JTextArea();
        message.setEditable(false);
        message.setBounds(20, 295, 400, 80);

        btnEnter.addActionListener(e -> choose());
        txtChoice.addActionListener(e -> choose());

        frame.add(screen);
        frame.add(lblChoice);
        frame.add(txtChoice);
        frame.add(btnEnter);
        frame.add(message);

        showMenu();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showMenu() {
        String text = "| TEYVAT VENDING MACHINE |\n";
        text = text + "Your balance: " + balance + " Mora\n\n";

        for (int i = 0; i < itemNames.length; i++) {
            text = text + (i + 1) + " - " + itemNames[i] +
                    " | Price: " + itemPrices[i] + " Mora | Stock: " + itemStock[i] + "\n";
        }

        text = text + (itemNames.length + 1) + " - Insert Mora\n";
        text = text + (itemNames.length + 2) + " - Exit";
        screen.setText(text);
    }

    private void choose() {
        int choice;

        try {
            choice = Integer.parseInt(txtChoice.getText().trim());
        } catch (NumberFormatException ex) {
            message.setText("Invalid choice. Please pick a valid option.");
            return;
        }
        txtChoice.setText("");

        if (choice == itemNames.length + 1) {
            String answer = JOptionPane.showInputDialog(frame, "Insert amount of Mora: ");
            if (answer == null) {
                return;
            }
            try {
                int amount = Integer.parseInt(answer.trim());
                balance += amount;
                message.setText("Balance updated: " + balance + " Mora");
            } catch (NumberFormatException ex) {
                message.setText("Numbers only please.");
            }

        } else if (choice == itemNames.length + 2) {
            String msg = "Thanks for visiting the vending machine, Traveler!";
            if (balance > 0) {
                msg = msg + "\nDon't forget your change: " + balance + " Mora";
            }
            JOptionPane.showMessageDialog(frame, msg);
            frame.dispose();

        } else if (choice >= 1 && choice <= itemNames.length) {
            int index = choice - 1;

            if (itemStock[index] <= 0) {
                message.setText("Sorry, " + itemNames[index] + " is out of stock!");
            } else if (balance < itemPrices[index]) {
                message.setText("Not enough Mora! You need " +
                        (itemPrices[index] - balance) + " more.");
            } else {
                balance -= itemPrices[index];
                itemStock[index]--;
                message.setText("You got a " + itemNames[index] + "! Enjoy, Traveler.\n"
                        + "Remaining balance: " + balance + " Mora");
            }

        } else {
            message.setText("Invalid choice. Please pick a valid option.");
        }

        showMenu();
    }
}
