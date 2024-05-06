package _03_more;

import org.junit.Test;

import java.util.ArrayList;

public class GenericTest {
    @Test
    public void test(){

    }
    @Test
    public void test1(){
        // 第一种
        Object arr1 = null;
        String arr2 = null;
        arr1 = arr2;
        // 第二种
/*        ArrayList list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("123");
        list1 = list2;
        System.out.println(list1);*/
        // 第三种
//        Person<Object> p1 = new Person<>();
//        Person<String> p2 = new Person<>();
//        p1 = p2;
    }
}
