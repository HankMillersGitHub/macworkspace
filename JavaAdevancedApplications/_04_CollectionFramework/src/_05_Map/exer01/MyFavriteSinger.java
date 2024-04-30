package _05_Map.exer01;

import java.util.*;

public class MyFavriteSinger {
    public static void main(String[] args) {
        Singer singer1 = new Singer("许嵩", 39);
        Singer singer2 = new Singer("张杰", 41);
        Singer singer3 = new Singer("张靓颖", 33);
        Set songs1 = new HashSet();
        songs1.add("爱情里流过的眼泪");
        songs1.add("半城烟沙");
        songs1.add("素颜");
        songs1.add("天龙八部之宿敌");
        songs1.add("你若成风");
        Set songs2 = new HashSet();
        songs2.add("逆战");
        songs2.add("我爱你");
        songs2.add("第一夫人");
        songs2.add("战斗");
        songs2.add("你是谁");
        Set songs3 = new HashSet();
        songs3.add("我是张靓颖");
        songs3.add("隐形的翅膀");
        songs3.add("张三李四王五");
        songs3.add("赵六周扒皮");
        songs3.add("七七七");
        HashMap singers = new HashMap();
        singers.put(singer1,songs1);
        singers.put(singer2,songs2);
        singers.put(singer3,songs3);
        //
        Set set = singers.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Singer singer;
            if(entry.getKey() instanceof Singer){
                singer = (Singer) entry.getKey();
            }else{
                throw new RuntimeException("this is not Singer");
            }
            System.out.println("歌手：" + singer.getName() + "--->" + entry.getValue());
        }

    }
}

