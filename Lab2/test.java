import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class test{
    public static void main(String[] args) {
        new calculator();

    }
}
class calculator extends Frame{
    public  calculator() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        //文本框
        TextField numx = new TextField(3);
        TextField numy = new TextField(3);
        TextField numz = new TextField(3);
        TextField nums = new TextField();
        nums.setSize(200, 200);
        //按钮
        Button button = new Button("submit");

        JRadioButton a = new JRadioButton("A");
        JRadioButton b = new JRadioButton("B");

        button.addActionListener(new MycalculatorListener(numx, numy, numz, nums));
        //标签
        Label labelx = new Label("X:");
        Label labely = new Label("Y:");
        Label labelz = new Label("Z:");
        Label labels = new Label("=");
        a = new JRadioButton("A");
        b = new JRadioButton("B");

        ButtonGroup jrg = new ButtonGroup();
        jrg.add(a);
        jrg.add(b);
        a.setSelected(true);

        //布局
        setLayout(new FlowLayout());
//        add(menuBar);


        //创建菜单栏
        MenuBar menuBar = new MenuBar();
        //设置菜单栏
        setMenuBar(menuBar);
        //创建菜单
        Menu m1 = new Menu("文件", true);
        //向菜单栏中添加菜单
        menuBar.add(m1);
        //创建选项
        MenuItem menuItem1 = new MenuItem("新建");
        MenuItem menuItem2 = new MenuItem("打开");
        //向菜单中添加选项
        m1.add(menuItem1);
        m1.add(menuItem2);

        Menu m2 = new Menu("编辑", true);
        menuBar.add(m2);
        MenuItem menuItem3 = new MenuItem("复制");
        MenuItem menuItem4 = new MenuItem("粘贴");
        m2.add(menuItem3);
        m2.add(menuItem4);
        Menu m3 = new Menu("帮助", true);
        menuBar.setHelpMenu(m3);
        MenuItem menuItem5 = new MenuItem("Справка");
        menuItem5.addActionListener(e -> {
        String message = "Автор: Сунь\nГруппа: 8";
        JOptionPane.showMessageDialog(null, message, "О программе", JOptionPane.INFORMATION_MESSAGE);
        });
        MenuItem menuItem6 = new MenuItem("联系我们");
        m3.add(menuItem5);
        m3.add(menuItem6);
        add(labelx);
        add(numx);
        add(labely);
        add(numy);
        add(labelz);
        add(numz);
        add(button);
        add(labels);
        add(nums);
        add(a);
        add(b);
        DefaultTableModel tableModel = new DefaultTableModel();

        // 向表格模型中添加新列
        tableModel.addColumn("多项式", new String[] {});
        tableModel.addColumn("值", new Double[] {});
        tableModel.addColumn("值是否大于零？", new Boolean[] {});

        // 创建表格
        JTable table = new JTable(tableModel);

        // 将第三列的值显示为复选框
//        table.setDefaultRenderer(Boolean.class, new JCheckBox());
        table.setDefaultRenderer(Boolean.class, new DefaultTableCellRenderer());


        // 向表格中添加新行
        tableModel.addRow(new Object[] { "x^2 + 2x + 1", 3.0, true });
        tableModel.addRow(new Object[] { "x^2 - 2x + 1", -1.0, false });
        tableModel.addRow(new Object[] { "x^2 + x + 1", 0.0, false });

        // 创建表格面板
        JScrollPane scrollPane = new JScrollPane(table);

        // 将表格面板添加到窗口中
        add(scrollPane);
        pack();
        setVisible(true);
    }
        }

class MycalculatorListener implements  ActionListener{
    //获取变量
    private  TextField numx,numy,numz,nums;

    private JRadioButton a,b;

    public MycalculatorListener(TextField numx, TextField numy,TextField numz,TextField nums){
        this.numx=numx;
        this.numy=numy;
        this.numz=numz;
        this.nums=nums;


    }

    public MycalculatorListener(JRadioButton a) {
        a=null;
        this.a=a;
        this.b=b;
    }
    @Override
    public void actionPerformed(ActionEvent e){

        //运算操作
        int x=Integer.parseInt(numx.getText());
        int y=Integer.parseInt(numy.getText());
        int z=Integer.parseInt(numz.getText());
        //放到第四个框
        if (x!=0&y!=0&z!=0){
            nums.setText(""+(Math.pow((Math.cos(Math.exp(x))+Math.log(Math.pow((1+y),2))+Math.sqrt(Math.exp(Math.cos(x))+Math.pow((Math.sin(3.14*z)),2))+Math.sqrt(1/x)+Math.pow((Math.cos(y)),2)),Math.sin(z))));
            //清除前三个框
            numx.setText(""+a);
            numy.setText(""+b);
            numz.setText("");
            if(a==null){
                System.out.println("nu");
            }else{
                System.out.println("nou");
            }
        }else{
            nums.setText("0");
            numx.setText(""+a);
            numy.setText(""+b);
            numz.setText("");
        }
        }

}
