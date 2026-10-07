import javax.swing.*;

public class AlquizarGradeCalculatorUI {

    JFrame frame;
    JTextField txtName;
    JTextField txtExam1;
    JTextField txtExam2;
    JTextField txtExam3;
    JTextField txtExam4;
    JTextField txtWritten;
    JTextArea output;

    public AlquizarGradeCalculatorUI() {

        frame = new JFrame("Grade Calculator");
        frame.setSize(450, 540);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("=== Grade Calculator (Base-15 Grading) ===");
        lblTitle.setBounds(0, 10, 440, 30);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblName = new JLabel("Enter student name: ");
        lblName.setBounds(20, 55, 200, 30);
        txtName = new JTextField();
        txtName.setBounds(230, 55, 190, 30);

        JLabel lbl1 = new JLabel("Exam 1 score (10%): ");
        lbl1.setBounds(20, 95, 200, 30);
        txtExam1 = new JTextField();
        txtExam1.setBounds(230, 95, 190, 30);

        JLabel lbl2 = new JLabel("Exam 2 score (10%): ");
        lbl2.setBounds(20, 135, 200, 30);
        txtExam2 = new JTextField();
        txtExam2.setBounds(230, 135, 190, 30);

        JLabel lbl3 = new JLabel("Exam 3 score (10%): ");
        lbl3.setBounds(20, 175, 200, 30);
        txtExam3 = new JTextField();
        txtExam3.setBounds(230, 175, 190, 30);

        JLabel lbl4 = new JLabel("Exam 4 score (40%): ");
        lbl4.setBounds(20, 215, 200, 30);
        txtExam4 = new JTextField();
        txtExam4.setBounds(230, 215, 190, 30);

        JLabel lbl5 = new JLabel("Written Works score (30%): ");
        lbl5.setBounds(20, 255, 200, 30);
        txtWritten = new JTextField();
        txtWritten.setBounds(230, 255, 190, 30);

        JButton btnCalc = new JButton("Calculate");
        btnCalc.setBounds(150, 305, 140, 35);

        output = new JTextArea();
        output.setEditable(false);
        output.setBounds(20, 360, 400, 125);

        btnCalc.addActionListener(e -> calculate());

        frame.add(lblTitle);
        frame.add(lblName);
        frame.add(txtName);
        frame.add(lbl1);
        frame.add(txtExam1);
        frame.add(lbl2);
        frame.add(txtExam2);
        frame.add(lbl3);
        frame.add(txtExam3);
        frame.add(lbl4);
        frame.add(txtExam4);
        frame.add(lbl5);
        frame.add(txtWritten);
        frame.add(btnCalc);
        frame.add(output);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void calculate() {
        String name = txtName.getText().trim();
        double exam1, exam2, exam3, exam4, writtenWorks;

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter the student name.");
            return;
        }

        try {
            exam1 = Double.parseDouble(txtExam1.getText().trim());
            exam2 = Double.parseDouble(txtExam2.getText().trim());
            exam3 = Double.parseDouble(txtExam3.getText().trim());
            exam4 = Double.parseDouble(txtExam4.getText().trim());
            writtenWorks = Double.parseDouble(txtWritten.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Scores must be numbers.");
            return;
        }

        if (exam1 < 0 || exam1 > 100 || exam2 < 0 || exam2 > 100 || exam3 < 0 || exam3 > 100
                || exam4 < 0 || exam4 > 100 || writtenWorks < 0 || writtenWorks > 100) {
            JOptionPane.showMessageDialog(frame, "Input score 0-100 only.");
            return;
        }

        AlquizarGradeCalculator student = new AlquizarGradeCalculator(name, exam1, exam2, exam3, exam4, writtenWorks);

        double examGrade = student.calculateExamGrade();
        double writtenWorksGrade = student.calculateWrittenWorksGrade();
        double rawScore = student.calculateRawScore();
        double finalGrade = student.calculateFinalGrade();

        output.setText("--- Result ---\n"
                + "Student: " + student.retriveStudentName() + "\n"
                + "Exam Grade (70%): " + examGrade + "\n"
                + "Written Works Grade (30%): " + writtenWorksGrade + "\n"
                + "Raw Score: " + rawScore + "\n"
                + "Final Grade (Base-15): " + finalGrade);
    }
}
