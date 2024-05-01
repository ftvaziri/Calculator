import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numButton = new JButton[10];
    JButton[] funcButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton;
    JButton delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Charter", Font.PLAIN, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //Text Field
        textField = new JTextField();
        textField.setBounds(60, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //Function Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("del");
        clrButton = new JButton("clr");
        negButton = new JButton("neg");

        funcButton[0] = addButton;
        funcButton[1] = subButton;
        funcButton[2] = mulButton;
        funcButton[3] = divButton;
        funcButton[4] = decButton;
        funcButton[5] = equButton;
        funcButton[6] = delButton;
        funcButton[7] = clrButton;
        funcButton[8] = negButton;

        for (int i = 0; i < 9; i++){
            funcButton[i].addActionListener(this);
            funcButton[i].setFont(myFont);
            funcButton[i].setFocusable(false);
        }

        delButton.setBounds(60, 430, 92, 50);
        clrButton.setBounds(164, 430, 92, 50);
        negButton.setBounds(266, 430, 92, 50);

        //Number Buttons
        for (int i = 0; i < 10; i++){
            numButton[i] = new JButton(String.valueOf(i));
            numButton[i].addActionListener(this);
            numButton[i].setFont(myFont);
            numButton[i].setFocusable(false);
        }

        //Panel
        panel = new JPanel();
        panel.setBounds(60, 100, 300, 300);
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
        panel.add(decButton);
        panel.add(numButton[0]);
        panel.add(equButton);
        panel.add(divButton);


//        panel.setBackground(Color.red);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Numbers Buttons Action
        for (int i = 0; i < 10; i++){
            if (e.getSource() == numButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //Function Buttons Action
        if (e.getSource() == decButton){
            textField.setText((textField.getText().concat(String.valueOf("."))));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+' :
                    result = num1 + num2;
                    break;
                case '-' :
                    result = num1 - num2;
                    break;
                case '*' :
                    result = num1 * num2;
                    break;
                case '/' :
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == clrButton){
            textField.setText("");
        }
        if (e.getSource() == negButton){
            double temp = -1 * Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(temp));
        }
    }
}