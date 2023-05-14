import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Field extends JPanel {
    // 悬浮运动的旗帜
    private boolean paused;
    private boolean pausedtwo;
    // 动态的弹跳球列表
    private ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>(10);
    // 计时器类负责定期生成ActionEvent事件。
    // 在创建其实例时使用一个匿名类、
    // 实现ActionListener接口
    private Timer repaintTimer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            // ActionEvent处理程序的任务是重新绘制窗口。
            repaint();
        }
    });

    // BouncingBall类的构造函数
    public Field() {
        // 将背景颜色设为白色
        setBackground(Color.WHITE);
        // 启动定时器
        repaintTimer.start();
    }

    // 继承自Jpanel的重绘组件的方法。
    public void paintComponent(Graphics g) {
        //调用从祖先那里继承的方法的版本
        super.paintComponent(g);
        Graphics2D canvas = (Graphics2D) g;
        // 依次请求从列表中的所有球中绘图。
        for (BouncingBall ball : balls) {
            ball.paint(canvas);
        }
    }
    // 将一个新球添加到列表中的方法
    public void addBall() {
        //在列表中添加一个新的BouncingBal的实例
        //所有位置、速度、大小、颜色的初始化。
        //在构造函数中对BouncingBall本身进行初始化
        balls.add(new BouncingBall(this));
    }
    // 该方法是同步的，也就是说，只有一个线程能够
    //同时出现在
    public synchronized void pause() {
        // 激活暂停模式
        paused = true;
    }
    public synchronized void pausedtwo() {
        // 启用绿色的暂停模式
        pausedtwo = true;
    }
    // 该方法是同步的，也就是说，只有一个线程能够
    //同时出现在
    public synchronized void resume() {
        // 关掉暂停模式
        paused = false;
        pausedtwo = false;
        // 唤醒所有挂起的数据流
        notifyAll();
    }
    // 检查球是否能移动的同步方法
    // (暂停模式没有开启吗？)
    public synchronized void canMove(BouncingBall ball) throws 
    InterruptedException {
        if (paused) {
//            System.out.print("\n");
//            System.out.print("Green:"+ball.getColor().getGreen()+"  2*(Red+Blue):"+ 2*(ball.getColor().getRed()+ball.getColor().getBlue())+"\n");
            wait();
        }
        if (pausedtwo &&ball.getColor().getRed() > (ball.getColor().getGreen()+ball.getColor().getBlue())) {
            wait();
        }

//        if (pausedtwo && ball.getColor().getGreen() > 2 * (ball.getColor().getRed() + ball.getColor().getBlue())) {
//            System.out.print("\n");
//            System.out.print("Green:"+ball.getColor().getGreen()+"  2*(Red+Blue):"+ 2*(ball.getColor().getRed()+ball.getColor().getBlue())+"\n");
//            wait();
//        }
        // else{
        //     System.out.print("Green:"+ball.getColor().getGreen()+"\n"+"2*(Red+Blue):"+ 2*(ball.getColor().getRed()+ball.getColor().getBlue()));          
        // }

    }

}