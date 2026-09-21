import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class assgn18 extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    assgn18() {
        setTitle("Button Click Event");
        setSize(300, 200);
        setLayout(new FlowLayout());
        label = new JLabel("Click the button");
        button = new JButton("Click Me");
        button.addActionListener(this);
        add(label);
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        label.setText("Button Clicked!");
    }
    public static void main(String[] args) {
        new assgn18();
    }
}