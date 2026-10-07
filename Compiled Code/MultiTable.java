import javax.swing.*;

public class MultiTable {

    JFrame frame;
    JTextArea output;

    public MultiTable() {

        frame = new JFrame("Multiplication Table");
        frame.setSize(420, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        output = new JTextArea();
        output.setEditable(false);

        JScrollPane scroll = new JScrollPane(output);
        scroll.setBounds(20, 20, 370, 300);

        JButton btnRun = new JButton("Run");
        btnRun.setBounds(155, 340, 110, 35);

        btnRun.addActionListener(e -> run());

        frame.add(scroll);
        frame.add(btnRun);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void run() {

        int[][] table = new int[20][20];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        String text = "";

        for (int i = 0; i < 20; i++) {
            text = text + "Multiplication of " + (i + 1) + "\n";

            for (int j = 0; j < 20; j++) {
                text = text + (i + 1) + " x " + (j + 1) + " = " + table[i][j] + "\n";
            }

            text = text + "\n";
        }

        text = text + "Computation done.";
        output.setText(text);
        output.setCaretPosition(0);
    }
}
