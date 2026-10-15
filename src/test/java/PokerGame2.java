import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame2 {

    static ArrayList<String> poker = new ArrayList<>();
    static HashMap<String, Integer> pokerMap = new HashMap<>();

    // 创建牌
    static {
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for( String s: colors ){
            for (String s2: numbers ){
                poker.add(s + s2);
            }
        }

        poker.add(" 小王");
        poker.add(" 大王");

        // 创建牌面与数字的映射关系
        pokerMap.put("J", 11);
        pokerMap.put("Q", 12);
        pokerMap.put("K", 13);
        pokerMap.put("A", 14);
        pokerMap.put("2", 15);
        pokerMap.put("小王", 50);
        pokerMap.put("大王", 100);

        // 洗牌
        Collections.shuffle(poker);
        dealPoker();
    }

    // 发牌
    public static void dealPoker() {
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> bottom = new ArrayList<>();


        for (int i = 0; i < poker.size(); i++) {
            if (i<3){
                bottom.add(poker.get(i));
            }else if(i % 3 == 0){
                player1.add(poker.get(i));
            }else if(i % 3 == 1){
                player2.add(poker.get(i));
            }else{
                player3.add(poker.get(i));
            }
        }
        printPoker("玩家1", player1);
        printPoker("玩家2", player2);
        printPoker("玩家3", player3);
        printPoker("底牌", bottom);
    }

    //看牌
    public static void printPoker(String name, ArrayList<String> poker) {
        Collections.sort(poker, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1.substring(0,1); // 获取花色
                String s2 = o2.substring(0,1);

                int i1 = getValue(o1); // 获取价值
                int i2 = getValue(o2);

                int i = i1 - i2;

                return i == 0 ? s1.compareTo(s2) : i;
            }
        });
        System.out.println(name + "的牌是：" + poker);
    }


    public static int getValue(String s) { // ♥4
        // 如果存在直接返回价值，不存在则直接返回本身
        String number = s.substring(1);
        if (pokerMap.containsKey(number)){
            return pokerMap.get(number);
        }else {
            return Integer.parseInt(number);
        }
    }
}

