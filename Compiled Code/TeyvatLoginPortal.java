import javax.swing.*;

public class TeyvatLoginPortal {

    JFrame frame;
    JTextField txtName;
    JPasswordField txtPass;
    JPasswordField txtConfirm;
    JTextArea output;

    String regUserName = "";
    String regPassWord = "";
    boolean isLoggedIn = false;
    String loggedInUser = "";

    public TeyvatLoginPortal() {

        frame = new JFrame("Teyvat Login Portal");
        frame.setSize(430, 480);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("| TEYVAT LOGIN PORTAL |");
        lblTitle.setBounds(0, 10, 420, 30);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblName = new JLabel("Traveler Name: ");
        lblName.setBounds(30, 55, 130, 30);
        txtName = new JTextField();
        txtName.setBounds(190, 55, 190, 30);

        JLabel lblPass = new JLabel("Password: ");
        lblPass.setBounds(30, 95, 130, 30);
        txtPass = new JPasswordField();
        txtPass.setBounds(190, 95, 190, 30);

        JLabel lblConfirm = new JLabel("Confirm Password: ");
        lblConfirm.setBounds(30, 135, 150, 30);
        txtConfirm = new JPasswordField();
        txtConfirm.setBounds(190, 135, 190, 30);

        JButton btn1 = new JButton("1 - Create Traveler Account");
        btn1.setBounds(30, 185, 350, 32);

        JButton btn2 = new JButton("2 - Enter Teyvat (Login)");
        btn2.setBounds(30, 225, 350, 32);

        JButton btn3 = new JButton("3 - Leave for Another World (Exit)");
        btn3.setBounds(30, 265, 350, 32);

        output = new JTextArea();
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setBounds(30, 315, 350, 80);

        btn1.addActionListener(e -> register());
        btn2.addActionListener(e -> login());
        btn3.addActionListener(e -> leave());

        frame.add(lblTitle);
        frame.add(lblName);
        frame.add(txtName);
        frame.add(lblPass);
        frame.add(txtPass);
        frame.add(lblConfirm);
        frame.add(txtConfirm);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(output);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void register() {
        String newUser = txtName.getText();
        String newPass = new String(txtPass.getPassword());
        String confirmPass = new String(txtConfirm.getPassword());

        if (!newPass.equals(confirmPass)) {
            output.setText("Your passwords don't resonate with each other. Registration failed.");
        } else if (newUser.trim().isEmpty()) {
            output.setText("A Traveler needs a name! Registration failed.");
        } else {
            regUserName = newUser;
            regPassWord = newPass;
            output.setText("Welcome to Teyvat, Traveler! Registration successful!");
        }
    }

    private void login() {
        String loginUser = txtName.getText();
        String loginPass = new String(txtPass.getPassword());

        if (regUserName.isEmpty()) {
            output.setText("No Traveler found in this world. Please register first.");
        } else if (loginUser.equals(regUserName) && loginPass.equals(regPassWord)) {
            output.setText("Paimon: \"Great, you're finally awake!\" Login successful!");
            isLoggedIn = true;
            loggedInUser = loginUser;
        } else {
            output.setText("The gods of Teyvat do not recognize you. Invalid username or password.");
        }
    }

    private void leave() {
        String msg = "";
        if (isLoggedIn) {
            msg = "| Traveler Profile |\nTraveler Name: " + loggedInUser + "\nVision Password: " + regPassWord + "\n\n";
        }
        msg = msg + "Paimon: \"Byebye~\" You are now leaving Teyvat. Goodbye!";
        JOptionPane.showMessageDialog(frame, msg);
        frame.dispose();
    }
}
