import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
//import java.awt.geom.Rectangle2D;

public class BouncingBall implements Runnable {

    private static final int MAX_RADIUS = 40;// 球的最大半径可以是

    private static final int MIN_RADIUS = 10; // 球的最小半径可以是

    private static final int MAX_SPEED = 10;// 球可以飞行的最大速度

    private Field field;

    private int radius;
    private Color color;
    // 球的当前坐标
    private double x;
    private double y;
    // 垂直和水平速度分量
    private int speed;
    private double speedX;
    private double speedY;
    private double redColor;
    private double blueColor;
    private double greenColor;
    // BouncingBall类的构造函数
    public BouncingBall(Field field) {
//有必要对球跳起的球场进行参考、
// 以跟踪弹跳的球出场的情况
//通过getWidth(), getHeight()
        this.field = field;
// 随机大小的球的半径
        radius = (int) (Math.random()*(MAX_RADIUS - MIN_RADIUS)) + MIN_RADIUS;
// 速度的绝对值取决于球的直径、
// 它越大，速度就越慢。
        speed = Double.valueOf(Math.round(5*MAX_SPEED / radius)).intValue();
        if (speed>MAX_SPEED) {
            speed = MAX_SPEED;
        }
//初始速度方向也是随机的、
// 角度在0和2PI之间
        double angle = Math.random()*2*Math.PI;
// 水平和垂直速度分量的计算
        speedX = 3*Math.cos(angle);
        speedY = 3*Math.sin(angle);
        redColor = Math.random() * 0.5 + 0.5;
        greenColor = 0.1+Math.random()*0.6;
        blueColor =  0.1+Math.random()*0.6;
// 球的颜色是随机选择的
        color = new Color((float) redColor, (float) greenColor, (float) blueColor);
// 球的初始位置是随机的
        x = Math.random()*(field.getSize().getWidth()-2*radius) + radius;
        y = Math.random()*(field.getSize().getHeight()-2*radius) + radius;
// 创建一个新的线程实例，其参数为
// 对实现Runnable的类的引用（即对自身的引用）。
        Thread thisThread = new Thread(this);
// 启动流程
        thisThread.start();
    }
    // run()方法是在一个线程中执行的。当它终止时、
// 该线程被终止。
    public void run() {
        try {
// 循环不息，即直到我们被打断、
// 我们并不打算结束
            while(true) {
// 场对象本身上的流量同步化
// 如果允许移动，控制将被
// 返回到方法中
// 否则，活动线程将进入睡眠状态
                field.canMove(this);
                if (x + speedX <= radius) {
//到达左墙，向右弹跳
                    speedX = -speedX;
                    x = radius;
                } else
                if (x + speedX >= field.getWidth() - radius) {
//到达右墙，向左弹跳
                    speedX = -speedX;
                    x=Double.valueOf(field.getWidth()-radius).intValue();
                } else
                if (y + speedY <= radius) {
// 到达顶墙
                    speedY = -speedY;
                    y = radius;
                } else
                if (y + speedY >= field.getHeight() - radius) {
// 到达底层墙壁
                    speedY = -speedY;
                    y=Double.valueOf(field.getHeight()-radius).intValue();
                } else {
//只是换位思考。
                    x += speedX;
                    y += speedY;
                }
//入睡X毫秒，其中X是确定的
//基于速度
// 速度=1（慢），入睡15毫秒。
// 速度=15（快），入睡1毫秒。
                Thread.sleep(16-speed);
            }
        } catch (InterruptedException ex) {
// 如果我们被打断，我们什么都不做
//只是退出（终止）。
        }
    }
    // 一种把自己拉出来的方法
    public void paint(Graphics2D canvas) {
        canvas.setColor(color);
        canvas.setPaint(color);
        Ellipse2D.Double ball = new Ellipse2D.Double(x-radius, y-radius,
                2*radius, 2*radius);
        canvas.draw(ball);
        canvas.fill(ball);
    }


    public int getSpeed(){
        return speed;
    }

    public Color getColor() {
        return color;
    }


}