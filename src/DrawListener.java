import java.awt.*;
import java.awt.event.*;

public class DrawListener implements MouseListener, ActionListener {
    int x1, y1, x2, y2;//储存起始坐标和最终坐标
    String btt;

    //Xian.java中的画布b传过来。
    Graphics b;

    //点击监听
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击");
    }

    //鼠标按下状态的监听，按下获取第一个点的坐标
    public void mousePressed(MouseEvent e) {
        System.out.println("按下");
        x1 = e.getX();
        y1 = e.getY();

    }

    //按钮处理事件
    public void actionPerformed(ActionEvent e) {

        //这一串会输出按钮上的信息
        btt = e.getActionCommand();
        System.out.println(btt);

    }

    //释放鼠标键的监听，再次获取结束坐标。
    public void mouseReleased(MouseEvent e) {
        System.out.println("释放");
        x2 = e.getX();
        y2 = e.getY();


        //画直线，如果获取到的btt是“线条”
        if ("线条".equals(btt)) {
            b.drawLine(x1, y1, x2, y2);

        }

        //  取坐标最小值     ///取宽高绝对值///为什么？因为从左上角开始画。
        //画矩形，如果获取到的btt是“矩形”
        if ("矩形".equals(btt)) {
            b.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }


        //椭圆
        if ("椭圆".equals(btt)) {
            b.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        } else {
            return;
        }

    }

    //鼠标进入窗口的监听
    public void mouseEntered(MouseEvent e) {
        System.out.println("进入");
    }

    //鼠标离开窗口的监听
    public void mouseExited(MouseEvent e) {
        System.out.println("离开");
    }

}
