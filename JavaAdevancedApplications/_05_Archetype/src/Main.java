import org.junit.Test;

import java.util.*;

public class Main {
    // 集合中使用范型之前的场景
    @Test
    public void test(){
        List list = new ArrayList();
        list.add(67);
        list.add(68);
        list.add(69);
        list.add(70);
        for(Object integer : list){
            System.out.println(integer);
        }

    }
    // 集合中使用范型的场景
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(79);
        list.add(80);
        list.add(81);
        list.add(82);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    // 范型在map中使用的区别
    @Test
    public void test2(){
        HashMap<String,Integer> a = new HashMap<>(); // 删除见括号里面的内容 JVM就会进行类型推断，判断应该是什么类型
        a.put("key1",123);
        a.put("key2",123);
        a.put("key3",123);
//        Set<Map.Entry<String,Integer>> entries = a.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        var entries = a.entrySet();
        var iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "--->" + next.getValue());
        }
    }

}