import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventExample extends JFrame implements MouseListener {
    private JLabel label;

    public MouseEventExample() {
        label = new JLabel("No mouse events detected");
        add(label);

        // 为框架添加鼠标监听器
        addMouseListener(this);
        //窗口设置
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventExample();
    }

    // MouseListener 的5个方法：点击、按住、释放、进入、退出
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mousePressed(MouseEvent e) {
        label.setText("Mouse pressed at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse released at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse entered frame");
    }

    public void mouseExited(MouseEvent e) {
        label.setText("Mouse exited frame");
    }
}
