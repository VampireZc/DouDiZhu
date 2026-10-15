package game;

import domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameJFrame extends JFrame {
    // 整个页面的容器
    public static Container container = null;

    // 抢地主与不抢的两个按钮
    JButton landlord[] = new JButton[2];

    // 管理出牌与不出牌的两个按钮
    JButton publishCard[] = new JButton[2];

    // 地主标记：记录三个玩家中的哪一个是地主
    int dizhuFlag;

    // 当前回合：记录轮到哪个玩家出牌
    int turn;

    //游戏中地主的图标
    JLabel dizhu;

    //大集合嵌套 (三个玩家出的牌)
    ArrayList<ArrayList<Poker>> currentList = new ArrayList();

    //大集合嵌套（三个玩家的牌，0 是左边玩家 1是中间自己 2是右边玩家）
    ArrayList<ArrayList<Poker>> playerList = new ArrayList<>();

    //牌盒 (所有的牌)
    ArrayList<Poker> pokerList = new ArrayList<>();

    //倒计时
    JTextField time[] = new JTextField[3];

    //用户操作，涉及多线程的知识
    // PlayerOperation po;

    boolean nextPlayer = false;

    public GameJFrame(){
        // 设置图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("image\\dizhu.png"));

        //设置界面
        initJframe();

        //添加组件
        initView();

        //显示页面
        this.setVisible(true);

    }

    public void initJframe() {
        //设置标题
        this.setTitle("斗地主");
        //设置大小
        this.setSize(830, 620);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //获取界面中的隐藏容器，以后直接用无需再次调用方法获取了
        container = this.getContentPane();
        //取消内部默认的居中放置
        container.setLayout(null);
        //设置背景颜色
        container.setBackground(Color.LIGHT_GRAY);
    }

    private void initView() {
    }


}
