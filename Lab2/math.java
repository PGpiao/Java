import javax.swing.*;
import java.awt.*;

public class math {
    public static void main(String[] args) {
        JFrame jf =new JFrame("Test");
        jf.setSize(800,800);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel =new JPanel();
        JRadioButton jr1 =new JRadioButton("A");
        JRadioButton jr2 = new JRadioButton("B");
        ButtonGroup bg1 =new ButtonGroup();
        bg1.add(jr1);
        bg1.add(jr2);

        jr1.setSelected(true);

        panel.add(jr1);
        panel.add(jr2);

        jf.setContentPane(panel);
        jf.setVisible(true);

        JLabel label1 = new JLabel("X:");
        JTextField textField1 = new JTextField(3);
        JLabel label2 = new JLabel("Y:");
        JTextField textField2 = new JTextField(3);
        JLabel label3 = new JLabel("Z:");
        JTextField textField3 = new JTextField(3);
        JButton button = new JButton("Submit");

        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(button);
        java.awt.event.ActionEvent ea = null;
        ea.getSource().equals(button);

        String x = textField1.getText();//获取输入内容
        String y = textField2.getText();
        String z = textField3.getText();
        System.out.println(x+" "+y+" "+z);
    }

}
