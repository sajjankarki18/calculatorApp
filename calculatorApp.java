import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculatorApp {
    public static void main(String[] args) {
        new calculatorAppDemo();
    }
}
class calculatorAppDemo implements ActionListener{
    JTextField textField;
    JPanel panel;
    JButton [] numberButtons   = new JButton[10];
    JButton [] functionButton = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equaButton, delButton, clrButton;
    double num1 = 0, num2 = 0, result = 0;
    Font myFont = new Font("Monospaced",Font.PLAIN, 30);
    char opr;
    calculatorAppDemo(){
        ImageIcon calImg = new ImageIcon("calculator.jpg");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,530);
        frame.setTitle("Calculator App");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(calImg.getImage());
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equaButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("clr");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equaButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;

        for(int i=0;i<functionButton.length;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
            functionButton[i].setFont(myFont);
        }
        for(int i=0;i<numberButtons.length;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        panel = new JPanel();
        panel.setBounds(50,90,300,300);
        panel.setLayout(new GridLayout(4,4,3,3));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equaButton);
        panel.add(divButton);

        delButton.setBounds(50,410,145,50);
        clrButton.setBounds(205,410,145,50);

        frame.add(textField);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<numberButtons.length;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==delButton){
           String str = textField.getText();
           textField.setText("");
           for(int i=0;i<str.length()-1;i++){
               textField.setText(textField.getText()+str.charAt(i));
            }
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            opr = '+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            opr = '-';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            opr = '*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            opr = '/';
            textField.setText("");
        }
        if(e.getSource()==equaButton){
            num2 = Double.parseDouble(textField.getText());

            switch (opr){
                case '+':
                    result = num1+num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1*num2;
                    break;

                case '/':
                    result= num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }
    }
}
