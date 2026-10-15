import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    static ArrayList<Integer> poker = new ArrayList<>();
    static HashMap<Integer, String> pokerMap = new HashMap<>();

    // 创建牌
    static {
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int index = 1;
        for(String s : numbers){
            for (String s2 : colors){
                pokerMap.put(index, s2 + s);
                poker.add(index);
                index++;
            }
        }

        // 添加大小王
        int king1 = poker.size() + 1;
        int king2 = king1 + 1;
        pokerMap.put(king1, "小王");
        pokerMap.put(king2, "大王");
        poker.add(king1);
        poker.add(king2);

        System.out.println(pokerMap);

        // 洗牌
        Collections.shuffle(poker);
        dealPoker();
    }

    // 发牌
    public static void dealPoker() {
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        TreeSet<Integer> bottom = new TreeSet<>();

        for (int i = 0; i < poker.size(); i++) {
           if (i<3){
               bottom.add(poker.get(i));
           }else if(i % 3 == 0){
               player1.add(poker.get(i));
           }else if(i % 3 == 1){
               player2.add(poker.get(i));
           }else{
               player3.add(poker.get(i))    ;
           }
        }
        printPoker("玩家1", player1);
        printPoker("玩家2", player2);
        printPoker("玩家3", player3);
        printPoker("底牌", bottom);
    }

    //看牌
    public static void printPoker(String name, TreeSet<Integer> poker) {
        // 遍历集合，获取牌
        System.out.print(name + "的牌是：");
        for (Integer i : poker) {
            System.out.print( pokerMap.get(i) + " ");
        }
        System.out.println();

    }
}

