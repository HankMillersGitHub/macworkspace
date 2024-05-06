package Exer_Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class PokerTest {
    public static void main(String[] args) {
        // 1. 组成一副扑克牌
        String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] color = {"方片","梅花","黑桃","红桃"};
        ArrayList poker = new ArrayList();
        for (int i = 0;i < color.length;i++){
            for (int j = 0; j < num.length; j++) {
                poker.add(color[i] + num[j]);
            }
        }
        // 添加大小王
        poker.add("大王");
        poker.add("小王");
        // 2，打乱顺序(洗牌)
        Collections.shuffle(poker);
        // 3. 发牌 四个容器 三个玩家一个底牌
        // 3.1 创建三个角色和一个底牌容器
        ArrayList player1 = new ArrayList();
        ArrayList player2 = new ArrayList();
        ArrayList player3 = new ArrayList();
        ArrayList basicPoker = new ArrayList();
        for (int i = 0; i < poker.size(); i++) {
            if(i >= poker.size() - 3){
                basicPoker.add(poker.get(i));
            }else if(i % 3 == 0){
                player1.add(poker.get(i));
            } else if (i % 3 == 1) {
                player2.add(poker.get(i));
            }else{
                player3.add(poker.get(i));
            }
        }
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        // 3.2 遍历显示四个list
        System.out.println("player1"+player1);
        System.out.println("player2"+player2);
        System.out.println("player3"+player3);
        System.out.println(basicPoker);
    }
}
