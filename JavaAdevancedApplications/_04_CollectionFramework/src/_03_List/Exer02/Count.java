package _03_List.Exer02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Count {
    public static int listTest(Collection list , String s){
        int count = 0;
        for (Object obj : list){
            if(obj.toString().equals(s)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 创建集合
        Collection collection = new ArrayList();
        // 存放三十个小写字母
        for (int i = 0; i < 30; i++) {
            int number = new Random().nextInt(26) + 97;
            collection.add((char)number);
        }
        System.out.println(collection);
        // 调用listTest函数确定集合中某字母出现的次数
        System.out.println(listTest(collection, "a"));
        System.out.println(listTest(collection, "b"));
        System.out.println(listTest(collection, "c"));
        System.out.println(listTest(collection, "x"));
    }
}
