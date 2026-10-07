import javax.swing.*;

public class WelcomeMessage {

    JFrame frame;
    JTextArea output;

    public WelcomeMessage() {

        frame = new JFrame("Welcome Message");
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
        String message = "Welcome to the internet, have a look around.";
        output.setText(message);
    }
}
