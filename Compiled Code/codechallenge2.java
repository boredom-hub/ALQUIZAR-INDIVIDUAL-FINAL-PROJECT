import javax.swing.*;

public class codechallenge2 {

    JFrame frame;
    JTextArea output;

    public codechallenge2() {

        frame = new JFrame("Name and Age");
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
        String name = "John Dominique Alquizar";
        int age = 18;

        output.setText(name + "\n" + age);
    }
}
