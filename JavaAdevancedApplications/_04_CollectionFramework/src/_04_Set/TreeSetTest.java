package _04_Set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test(){
        TreeSet objects = new TreeSet();
        objects.add("AA");
        objects.add("CC");
        objects.add("DD");
        objects.add("BB");
        objects.add("VV");
        Iterator iterator = objects.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test1(){
        // 自然排序
        User[] users = new User[5];
        users[0] = new User("Hank",19);
        users[1] = new User("Miller",29);
        users[2] = new User("Jerry",39);
        users[3] = new User("Jack",49);
        users[4] = new User("Tony",19);
        TreeSet<User> treeSet = new TreeSet<>();
        treeSet.add(users[0]);
        treeSet.add(users[1]);
        treeSet.add(users[2]);
        treeSet.add(users[3]);
        treeSet.add(users[4]);
        // 遍历
        Iterator<User> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        // 创建comparator对象
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 == o2){
                    return 0;
                }
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    if(u1.age - u2.age == 0){
                        if(u1.name.equals(u2.name)){
                            return 0;
                        }else{
                            return u1.name.compareTo(u2.name);
                        }
                    }else{
                        return u1.age - u2.age;
                    }
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        TreeSet<User> set = new TreeSet<>();
        User u1 = new User("Hank",19);
        User u2 = new User("Jeck",12);
        User u3 = new User("Jerry",29);
        User u4 = new User("Lose",12);
        User u5 = new User("Rose",15);
        set.add(u1);
        set.add(u2);
        set.add(u3);
        set.add(u4);
        set.add(u5);
        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
