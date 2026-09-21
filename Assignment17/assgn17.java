import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
class SwingDemo extends JFrame {
    SwingDemo() {
        setTitle("Swing Demo");
        setSize(300, 200);
        setLayout(new FlowLayout());
        JLabel label = new JLabel("Hello Swing");
        JButton button = new JButton("Click Me");
        add(label);
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
public class assgn17 extends Applet {
    public void init() {
        setLayout(new FlowLayout());
        add(new Label("Hello Applet"));
        add(new Button("Click Me"));
    }
    public static void main(String[] args) {
        new SwingDemo();
    }
}

