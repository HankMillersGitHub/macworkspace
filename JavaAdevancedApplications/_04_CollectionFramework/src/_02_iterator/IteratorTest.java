package _02_iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class IteratorTest {
    @Test
    public void test(){
        Collection collection = new ArrayList<>();
        collection.add("AA");
        collection.add(128);
        collection.add(new Object());
        Person p = new Person("Tim",28);
        collection.add(p);

        // 获取迭代器对象
        Iterator iterator = collection.iterator();
    /*    // 方式一
        // 有几个元素就只能调几次next方法
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    */
       /* // 方式二
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(iterator.next());
        }*/
        /*// 方式三
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
    }
    @Test
    public void test1(){
        Collection collection = new ArrayList<>();
        collection.add("AA");
        collection.add(128);
        collection.add(new Object());
        Person p = new Person("Tim",28);
        collection.add(p);

        // 获取迭代器对象
        Iterator iterator = collection.iterator();

        // 方式一 错误的遍历
        /*while(iterator.next() != null){
            System.out.println(iterator.next());
        }*/
        // 方式二
        /*// 每次调用iterator方法都会返回一个新的迭代器对象
        while (collection.iterator().hasNext()){
            System.out.println(collection.iterator().next());
        }*/
        // foreach
        for(Object object: collection){
            System.out.println(object);
        }
    }
}
