import javax.swing.*;
import java.awt.Font;

public class Calculator {

    JFrame design;
    JLabel label1;

    double firstNumber = 0;
    double secondNumber = 0;
    String operator = "+";
    boolean enteringSecondNumber = false;

    public Calculator() {

        design = new JFrame("Calculator");
        design.setLayout(null);

        label1 = new JLabel("0");
        label1.setBounds(10, 10, 380, 100);
        label1.setFont(new Font("SansSerif", Font.BOLD, 48));
        label1.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton button0 = new JButton("0");
        button0.setBounds(10, 425, 95, 55);

        JButton button1 = new JButton("1");
        button1.setBounds(10, 365, 95, 55);

        JButton button2 = new JButton("2");
        button2.setBounds(105, 365, 95, 55);

        JButton button3 = new JButton("3");
        button3.setBounds(200, 365, 95, 55);

        JButton button4 = new JButton("4");
        button4.setBounds(10, 305, 95, 55);

        JButton button5 = new JButton("5");
        button5.setBounds(105, 305, 95, 55);

        JButton button6 = new JButton("6");
        button6.setBounds(200, 305, 95, 55);

        JButton button7 = new JButton("7");
        button7.setBounds(10, 245, 95, 55);

        JButton button8 = new JButton("8");
        button8.setBounds(105, 245, 95, 55);

        JButton button9 = new JButton("9");
        button9.setBounds(200, 245, 95, 55);

        JButton buttonAdd = new JButton("+");
        buttonAdd.setBounds(295, 365, 95, 55);

        JButton buttonSubtract = new JButton("-");
        buttonSubtract.setBounds(295, 305, 95, 55);

        JButton buttonMultiply = new JButton("x");
        buttonMultiply.setBounds(295, 245, 95, 55);

        JButton buttonDivide = new JButton("/");
        buttonDivide.setBounds(295, 185, 95, 55);

        JButton buttonEquals = new JButton("=");
        buttonEquals.setBounds(295, 425, 95, 55);

        JButton buttonClear = new JButton("C");
        buttonClear.setBounds(200, 185, 95, 55);

        button0.addActionListener(e -> digitPressed(0));
        button1.addActionListener(e -> digitPressed(1));
        button2.addActionListener(e -> digitPressed(2));
        button3.addActionListener(e -> digitPressed(3));
        button4.addActionListener(e -> digitPressed(4));
        button5.addActionListener(e -> digitPressed(5));
        button6.addActionListener(e -> digitPressed(6));
        button7.addActionListener(e -> digitPressed(7));
        button8.addActionListener(e -> digitPressed(8));
        button9.addActionListener(e -> digitPressed(9));

        buttonAdd.addActionListener(e -> operatorPressed("+"));
        buttonSubtract.addActionListener(e -> operatorPressed("-"));
        buttonMultiply.addActionListener(e -> operatorPressed("x"));
        buttonDivide.addActionListener(e -> operatorPressed("/"));

        buttonEquals.addActionListener(e -> calculation());

        buttonClear.addActionListener(e -> {
            firstNumber = 0;
            secondNumber = 0;
            operator = "+";
            enteringSecondNumber = false;
            label1.setText("0");
        });

        design.add(label1);
        design.add(button0);
        design.add(button1);
        design.add(button2);
        design.add(button3);
        design.add(button4);
        design.add(button5);
        design.add(button6);
        design.add(button7);
        design.add(button8);
        design.add(button9);
        design.add(buttonAdd);
        design.add(buttonSubtract);
        design.add(buttonMultiply);
        design.add(buttonDivide);
        design.add(buttonEquals);
        design.add(buttonClear);

        design.setSize(410, 540);
        design.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        design.setLocationRelativeTo(null);
        design.setVisible(true);
    }

    private void digitPressed(int digit) {
        if (!enteringSecondNumber) {
            firstNumber = digit;
            label1.setText(String.valueOf(digit));
        } else {
            secondNumber = digit;
            label1.setText(format(firstNumber) + " " + operator + " " + format(secondNumber));
        } 
    }

    private void operatorPressed(String op) {
        operator = op;
        enteringSecondNumber = true;
        label1.setText(format(firstNumber) + " " + op + " ");
    }

    private void calculation() {

        double result;

        if (operator.equals("+")) {
            result = firstNumber + secondNumber;
        } else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (operator.equals("x")) {
            result = firstNumber * secondNumber;
        } else {
            if (secondNumber == 0) {
                label1.setText("Error");
                firstNumber = 0;
                secondNumber = 0;
                operator = "+";
                enteringSecondNumber = false;
                return;
            }
            result = firstNumber / secondNumber;
        }

        label1.setText(format(result));

        firstNumber = result;
        secondNumber = 0;
        operator = "+";
        enteringSecondNumber = false;
    }

    private String format(double n) {
    if (n == (long) n) {
        return String.valueOf((long) n);
    }
        return String.valueOf(n);           
    }

}
