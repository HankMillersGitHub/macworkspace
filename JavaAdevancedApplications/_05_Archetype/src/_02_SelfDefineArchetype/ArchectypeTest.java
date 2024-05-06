package _02_SelfDefineArchetype;

import org.junit.Test;

public class ArchectypeTest {
    @Test
    public void test(){
        // 实例化时，就可以指明T指的是什么类型 在实例化时，可以指明范型参数的具体类型，一旦指明了范型的类型，
        // 则在范型类中凡是指明了范型参数的位置，都替换为指定的类型
        Order<Object> stringOrder = new Order<>();
        stringOrder.setOrderId(123);
        stringOrder.setT("这是一个表示字符串的范型T");
        System.out.println(stringOrder);
    }
    @Test
    public void test1(){
//        SubOrder1<String> s1 = new SubOrder1<String>(); // 因为suborder1不是范型类 所以不能这样写
        SubOrder1 subOrder1 = new SubOrder1();
        subOrder1.getT();
    }
    // 测试SubOrder
    @Test
    public void test2(){
        SubOrder2 subOrder2 = new SubOrder2();
        subOrder2.getT();

    }
    // 测试SubOrder3
    @Test
    public void test3(){
        SubOrder3<Integer> integerSubOrder3 = new SubOrder3<>();
        integerSubOrder3.show(12);

    }

    // 测试SubOrder5
    @Test
    public void test4(){
        SubOrder5<Integer, String> integerStringSubOrder5 = new SubOrder5<>();
        integerStringSubOrder5.e = "helloworld";
        System.out.println(integerStringSubOrder5.e);
    }
    @Test
    public void test5(){
        SubOrder5<String, Integer> stringIntegerSubOrder5 = new SubOrder5<>();
        stringIntegerSubOrder5.show(12);
        Integer[] arr = new Integer[]{1,2,23,3,4,5};
        System.out.println(stringIntegerSubOrder5.copyFromArrayToList(arr));
    }
}
