package domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {
    //牌的名字
    private String name;
    //是正面还是反面
    private boolean up;
    //是否可以被点击
    private boolean canClick = false;
    //是已经点击
    private boolean clicked = false;


    public Poker(String name, boolean up) {
        this.name = name;
        this.up = up;

        if (this.up){ // 判断是正面还是反面
            //显示正面
            turnFront();
        }else {
            //显示反面
            turnRear();
        }

        this.setSize(71,96);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    public void turnRear() {
        this.setIcon(new ImageIcon("doudizhu\\image\\poker\\rear.png"));
        this.up = false;
    }

    public void turnFront() {
        this.setIcon(new ImageIcon("image\\poker\\" + name + ".png"));
        this.up = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (canClick){
            int step;
            Point location = this.getLocation();
            if (clicked){ // 向下
                step = 20;
            }else { // 向上
                step = -20;
            }

            canClick = !canClick;
            Point to = new Point(location.x,location.y + step);
            this.setLocation(to);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * 设置
     * @param up
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * 获取
     * @return canClick
     */
    public boolean isCanClick() {
        return canClick;
    }

    /**
     * 设置
     * @param canClick
     */
    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    /**
     * 获取
     * @return clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * 设置
     * @param clicked
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String toString() {
        return "Poker{name = " + name + ", up = " + up + ", canClick = " + canClick + ", clicked = " + clicked + "}";
    }

}
