import javax.swing.*;

public class ShippingCost {

    JFrame frame;
    JTextArea output;

    public ShippingCost() {

        frame = new JFrame("Item Price + Shipping");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        output = new JTextArea();
        output.setEditable(false);
        output.setBounds(20, 20, 345, 140);

        JButton btnRun = new JButton("Run");
        btnRun.setBounds(135, 180, 110, 35);

        btnRun.addActionListener(e -> run());

        frame.add(output);
        frame.add(btnRun);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void run() {
        int itemPrice = 200;
        int shippingCost = 50;
        int sum = itemPrice + shippingCost;

        output.setText("Total: " + sum);
    }
}
