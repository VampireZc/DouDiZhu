package game;

import domain.Poker;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Common {

    // 发牌动画
    public static void move(Poker poker, Point from, Point to) {
        if (to.x != from.x) {
            double k = (1.0) * (to.y - from.y) / (to.x - from.x);
            double b = to.y - to.x * k;
            int flag = 0;
            if (from.x < to.x)
                flag = 20;
            else {
                flag = -20;
            }
            for (int i = from.x; Math.abs(i - to.x) > 20; i += flag) {
                double y = k * i + b;

                poker.setLocation(i, (int) y);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        poker.setLocation(to);
    }

    //重新摆放牌
    public static void rePosition(GameJFrame m, ArrayList<Poker> list, int flag) {
        Point p = new Point();
        if (flag == 0) {
            p.x = 50;
            p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
        }
        if (flag == 1) {
            p.x = (800 / 2) - (list.size() + 1) * 21 / 2;
            p.y = 450;
        }
        if (flag == 2) {
            p.x = 700;
            p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
        }
        int len = list.size();
        for (int i = 0; i < len; i++) {
            Poker poker = list.get(i);
            Common.move(poker, poker.getLocation(), p);
            m.container.setComponentZOrder(poker, 0);
            if (flag == 1)
                p.x += 21;
            else
                p.y += 15;
        }
    }

    public static void order(ArrayList<Poker> list){
        //计算价值排序
        Collections.sort(list, new Comparator<Poker>() {
            @Override
            public int compare(Poker o1, Poker o2) {
                int c1 = Integer.parseInt(o1.getName().substring(0,1));
                int v1 = getValue(o1);

                int c2 = Integer.parseInt(o2.getName().substring(1));
                int v2 = getValue(o2);

                // 牌是倒着放的 所以v2-v1
                int flag = v2 - v1;

                if (flag == 0){
                    return c2 - c1;
                }else {
                    return flag;
                }
            }
        });

    }

    public static int getValue(Poker p){
        String name = p.getName();
        int color = Integer.parseInt(name.substring(0,1));
        int value = Integer.parseInt(name.substring(1));

        // 1-5 1代表花色 5代表数字
        if (color == 5){ //大王
            return value += 100;
        }

        if (value == 1){
            return value += 20;
        }

        if (value == 2){
            return value += 30;
        }
        return value;
    }
}
