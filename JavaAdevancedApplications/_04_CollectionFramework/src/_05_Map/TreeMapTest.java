package _05_Map;

import _02_iterator.Person;
import _04_Set.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    @Test
    public void tes1(){
        TreeMap treeMap = new TreeMap();
        treeMap.put("Person1",new Person("Hank1",10));
        treeMap.put("Person2",new Person("Hank2",10));
        treeMap.put("Person3",new Person("Hank3",10));
        treeMap.put("Person4",new Person("Hank4",10));
    }
    @Test
    public void test2(){
        User u0 = new User("Hank",18);
        User u1 = new User("Miller",18);
        User u2 = new User("Jerry",48);
        User u3 = new User("Bolong",14);
        User u4 = new User("Bush",19);
        TreeMap treemap = new TreeMap();
        treemap.put(u0,78);
        treemap.put(u1,66);
        treemap.put(u2,78);
        treemap.put(u3,78);
        treemap.put(u4,78);
        // 自然排序
        Set entrySet = treemap.entrySet();
        for (Object entry:entrySet){
            System.out.println(entry);
        }

    }

    @Test
    public void test3(){
        // 定制排序
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    int value = u1.getName().compareTo(u2.getName());
                    if(value != 0){
                        return value;
                    }
                    return u1.getAge() - u2.getAge();
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        TreeMap treemap = new TreeMap(comparator);
        User u1 = new User("Hank",18);
        User u2 = new User("Miller",18);
        User u3 = new User("Jerry",48);
        User u4 = new User("Bolong",14);
        User u5 = new User("Bush",19);
        treemap.put(u1,78);
        treemap.put(u2,66);
        treemap.put(u3,78);
        treemap.put(u4,78);
        treemap.put(u5,78);
        Set entrySet = treemap.entrySet();
        for (Object entry:entrySet){
            System.out.println(entry);
        }
    }
}
