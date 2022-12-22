package mainPackage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;

public class MainFrame {
    //忽略警告
    @SuppressWarnings("serial")
    public static void main(String[] args) {
        XYSeries series = new XYSeries("xySeries"); //声明存储一个XYSeries对象，数列的名称xySeries
        for (int x = -100; x < 100; x++) {
            int y = x * x;
            series.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();//声明对象，存储数据写入
        dataset.addSeries(series);//写入
        JFreeChart chart = ChartFactory.createXYLineChart(  //创建
                "y = x^2",//图标标题
                "x",//X轴标题
                "x^2",//Y轴标题
                dataset,//数据集
                PlotOrientation.VERTICAL,//方向
                false,//图例显示
                false,//工具提示
                false//URL链接
        );
        ChartFrame frame = new ChartFrame("My picture", chart);//创建对象显示框架
        frame.pack();//大小调整
        frame.setVisible(true);//可见性
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭操作


    }
}