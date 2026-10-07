import javax.swing.*;

public class codechallenge3 {

    JFrame frame;
    JTextArea output;

    public codechallenge3() {

        frame = new JFrame("Data Types");
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
        int studentID = 565306;
        double score = 99.67;
        char grade = 'A';

        output.setText(studentID + "\n" + score + "\n" + grade);
    }
}
