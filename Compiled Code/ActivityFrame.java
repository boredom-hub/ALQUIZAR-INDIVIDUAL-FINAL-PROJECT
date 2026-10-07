import javax.swing.*;
import java.awt.Dimension;

public class ActivityFrame {

    JFrame frame;

    String[] activityNames = {
        "Aug 17 - Hello, Java!",
        "Aug 17 - Name and Age",
        "Aug 17 - Data Types",
        "Aug 18 - Item Price + Shipping",
        "Aug 18 - Welcome Message",
        "Aug 20 - Age Check",
        "Aug 24 - Teyvat Login Portal",
        "Aug 29 - Age Finder",
        "Aug 29 - Number Lister",
        "Aug 29 - Highest and Lowest",
        "Aug 29 - Multiplication Table",
        "Aug 29 - Vending Draft",
        "Aug 29 - Teyvat Vending Machine",
        "Sep 8 - Grade Calculator",
        "Calculator"
    };

    public ActivityFrame() {

        frame = new JFrame("Activity Frame");
        frame.setSize(440, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblTitle = new JLabel("Activities this term");
        lblTitle.setBounds(0, 10, 430, 30);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(370, activityNames.length * 45 + 10));

        for (int i = 0; i < activityNames.length; i++) {
            JButton btn = new JButton(activityNames[i]);
            btn.setBounds(10, 10 + i * 45, 340, 35);
            final int number = i;
            btn.addActionListener(e -> openActivity(number));
            panel.add(btn);
        }

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBounds(15, 50, 395, 440);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(15, 505, 395, 35);

        btnLogout.addActionListener(e -> {
            frame.dispose();
            new MainFrame();
        });

        frame.add(lblTitle);
        frame.add(scroll);
        frame.add(btnLogout);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void openActivity(int number) {
        if (number == 0) {
            new codechallenge1();
        } else if (number == 1) {
            new codechallenge2();
        } else if (number == 2) {
            new codechallenge3();
        } else if (number == 3) {
            new ShippingCost();
        } else if (number == 4) {
            new WelcomeMessage();
        } else if (number == 5) {
            new AgeCheck();
        } else if (number == 6) {
            new TeyvatLoginPortal();
        } else if (number == 7) {
            new Agefinder();
        } else if (number == 8) {
            new NumberList();
        } else if (number == 9) {
            new HighandLowVAL();
        } else if (number == 10) {
            new MultiTable();
        } else if (number == 11) {
            new vendingdraft1();
        } else if (number == 12) {
            new genshinvendinglol();
        } else if (number == 13) {
            new AlquizarGradeCalculatorUI();
        } else if (number == 14) {
            new Calculator();
        }
    }
}
