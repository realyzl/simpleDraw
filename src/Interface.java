import javax.swing.*;
import java.awt.*;

public class Interface {
    public static void main(String[] args) {
        //类创建一个对象，让对象调用这个UI（）界面方法来显示。
        Interface L = new Interface();
        L.UI();
    }

    public void UI() {

        //窗口设置
        JFrame window = new JFrame();
        window.setTitle("画图");
        window.setSize(400, 500);

        //退出程序
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //创建流式布局，缩放界面时，里面的组件也会随之变化
        FlowLayout flow = new FlowLayout();

        //让窗口应用布局
        window.setLayout(flow);

        //Jbutton按钮组件，创建按钮
        JButton Xiantiao = new JButton("线条");
        JButton Juxing = new JButton("矩形");
        JButton Tuoyuan = new JButton("椭圆");

        //添加按钮到窗口上
        window.add(Xiantiao);
        window.add(Juxing);
        window.add(Tuoyuan);


        window.setVisible(true);


        Graphics b = window.getGraphics();

        //创建监听器
        DrawListener hua = new DrawListener();

        //将监听器添加到窗口
        window.addMouseListener(hua);

        //传递Graphics引用 到监听器中
        hua.b = b;

        //一个监听器可以监听多个组件，如果创建几个新的监听器，他们之中的方法，是各自分开的
        //就比如之前我创建了3个监听器来监听三个按钮，他们之中的btt是各自分开的，与上方监听的窗口的监听器无关。

        //给按钮加上监听
        Xiantiao.addActionListener(hua);
        Juxing.addActionListener(hua);
        Tuoyuan.addActionListener(hua);

    }

}
