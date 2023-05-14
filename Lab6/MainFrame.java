import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class MainFrame extends JFrame {
    // 常量，用于设置应用程序窗口的大小，如果它
// 不扩展到全屏
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private JMenuItem pauseMenuItem;
    private JMenuItem resumeMenuItem;
    private JMenuItem pauseFastItem;
    // 一个可以让球弹跳的场地
    private Field field = new Field();
    // 主应用程序窗口构造函数
    public MainFrame() {
        super("Программирование и синхронизация потоков");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
// 将应用程序窗口置于屏幕中央
        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);
//将窗口的初始状态设置为全屏
        setExtendedState(MAXIMIZED_BOTH);
// 创建一个菜单
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu ballMenu = new JMenu("Мячи");
        Action addBallAction = new AbstractAction("Добавить мяч") {
            public void actionPerformed(ActionEvent event) {
                field.addBall();
                if (!pauseMenuItem.isEnabled() &&
                        !resumeMenuItem.isEnabled()) {
// 没有一个菜单项是
//可用 - 使 "暂停 "可用
                    pauseMenuItem.setEnabled(true);
                }
            }
        };
        menuBar.add(ballMenu);
        ballMenu.add(addBallAction);
        JMenu controlMenu = new JMenu("Управление");
        menuBar.add(controlMenu);
        Action pauseAction = new AbstractAction("Приостановить движение"){
            public void actionPerformed(ActionEvent event) {
                field.pause();
                pauseMenuItem.setEnabled(false);
                resumeMenuItem.setEnabled(true);
                pauseFastItem.setEnabled(false);
            }
        };
        pauseMenuItem = controlMenu.add(pauseAction);
        pauseMenuItem.setEnabled(false);
        Action resumeAction = new AbstractAction("Возобновить движение") {
            public void actionPerformed(ActionEvent event) {
                field.resume();
                pauseMenuItem.setEnabled(true);
                resumeMenuItem.setEnabled(false);
                pauseFastItem.setEnabled(true);
            }
        };
        resumeMenuItem = controlMenu.add(resumeAction);
        resumeMenuItem.setEnabled(false);

        // 停止快速球的方法
        Action pauseFast = new AbstractAction("Селективное блокирование зеленых мячей") {
            public void actionPerformed(ActionEvent event) {
                field.pausedtwo();
                pauseMenuItem.setEnabled(true);
                resumeMenuItem.setEnabled(true);
                pauseFastItem.setEnabled(false);
            }
        };
        pauseFastItem = controlMenu.add(pauseFast);
        pauseFastItem.setEnabled(true);


// 在边界布局的中心添加 "场"。
        getContentPane().add(field, BorderLayout.CENTER);
    }
    // 主要应用方法
    public static void main(String[] args) {
// 创建并使主应用程序窗口可见。
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}