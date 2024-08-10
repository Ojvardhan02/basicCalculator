import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class basicCalculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numButton = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton equButton, clrButton, delButton, decButton, negButton;
    JPanel panel;

    double num1 = 0, num2 = 0, res = 0;
    char operator;

    basicCalculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clrButton = new JButton("Clr");
        delButton = new JButton("Del");
        decButton = new JButton(".");
        negButton = new JButton("(-)");


        // buttons edit...
        clrButton.setForeground(Color.RED);
        equButton.setBackground(Color.ORANGE);
        delButton.setBackground(Color.RED);
        addButton.setBackground(Color.GRAY);
        subButton.setBackground(Color.GRAY);
        mulButton.setBackground(Color.GRAY);
        divButton.setBackground(Color.GRAY);
        negButton.setBackground(Color.GRAY);
        decButton.setBackground(Color.GRAY);

        functionButton [0] = addButton;
        functionButton [1] = subButton;
        functionButton [2] = mulButton;
        functionButton [3] = divButton;
        functionButton [4] = decButton;
        functionButton [5] = equButton;
        functionButton [6] = delButton;
        functionButton [7] = clrButton;
        functionButton [8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numButton[i] = new JButton(String.valueOf(i));
            numButton[i].addActionListener(this);
            numButton[i].setFocusable(false); 
        }

        delButton.setBounds(50, 430, 100, 50);
        clrButton.setBounds(150, 430, 100, 50);
        equButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numButton[1]);
        panel.add(numButton[2]);
        panel.add(numButton[3]);
        panel.add(addButton);
        panel.add(numButton[4]);
        panel.add(numButton[5]);
        panel.add(numButton[6]);
        panel.add(subButton);
        panel.add(numButton[7]);
        panel.add(numButton[8]);
        panel.add(numButton[9]);
        panel.add(mulButton);
        panel.add(negButton);
        panel.add(numButton[0]);
        panel.add(decButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(equButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        basicCalculator cal = new basicCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for (int i = 0; i < 10; i++) {
        if (e.getSource() == numButton[i]) {
            textField.setText(textField.getText().concat(String.valueOf(i)));
        }
       }

       if (e.getSource() == decButton) {
        textField.setText(textField.getText().concat("."));
       }

       if (e.getSource() == addButton) {
        num1 = Double.parseDouble(textField.getText());
        operator = '+';
        textField.setText("");
       }

       if (e.getSource() == subButton) {
        num1 = Double.parseDouble(textField.getText());
        operator = '-';
        textField.setText("null");
       }

       if (e.getSource() == mulButton) {
        num1 = Double.parseDouble(textField.getText());
        operator = '*';
        textField.setText("");
       }

       if (e.getSource() == divButton) {
        num1 = Double.parseDouble(textField.getText());
        operator = '/';
        textField.setText("");
       }

       if (e.getSource() == clrButton) {
        textField.setText("");
       }

       if (e.getSource() == delButton) {
        String string = textField.getText();
        textField.setText("");
        for (int i = 0; i < string.length() - 1; i++) {
            textField.setText(textField.getText() + string.charAt(i));
        }
       }

       if (e.getSource() == negButton) {
        double temp = Double.parseDouble(textField.getText());
        temp *= -1;
        textField.setText(String.valueOf(temp));
       }

       if (e.getSource() == equButton) {
        num2 = Double.parseDouble(textField.getText());
        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
        }

        textField.setText(String.valueOf(res));
        num1 = res;

       }
    }
}