package _03_List;

import _02_iterator.Person;
import org.junit.Test;

import javax.swing.*;
import java.util.*;

public class ListTest {
        /*
        *   增
                add(Object obj)
                addAll(Collection collection)

            删
                remove(Object obj)
                remove(int index)

            改
                set(int index,Object obj)

            查
                get(int index)

            插
                add(int index,Object ele)
                addAll(int index,Collection collection)

            长度
                size()

            遍历
                iterator()
                for()
                fori()
        * */
    @Test
    public void test(){
        List<Object> list = new ArrayList<>();
        list.add("aa");
        list.add(128);
        list.add("bb");
        list.add(new Person("tim",19));
        System.out.println(list.toString());
        //add(int index,Object ele)
        list.add(2,"cc");
        System.out.println(list);
        //addAll(int index,Collection collection)
        // 创建新的Collection
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        list.addAll(4,list1);
        System.out.println(list);

    }
    @Test
    public void test1(){
        List<Object> list = new ArrayList<>();
        list.add("aa");
        list.add(128);
        list.add(123);
        list.add(2);
        list.add("bb");
        list.add(new Person("tim",19));
        System.out.println(list);// [aa, 128, 123, 2, bb, _02_iterator.Person@5cbc508c]
        // remove方法默认参数为索引值
        list.remove(2);
        System.out.println(list);// [aa, 128, 2, bb, _02_iterator.Person@5cbc508c]
        // 如果想用remove删除数据2 则需要手动装箱
//        list.remove((Integer)2);
        list.remove(Integer.valueOf(2));
        System.out.println(list);// [aa, 128, bb, _02_iterator.Person@5cbc508c]
    }
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add("aa");
        list.add(128);
        list.add(123);
        list.add(2);
        list.add("bb");
        list.add(new Person("tim",19));
/*        // 遍历方式一 使用迭代器遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // 遍历方式二 使用增强for循环
        for (Object a : list){
            System.out.println(a);
        }
        // 遍历方式三 使用经典for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
    }
}
