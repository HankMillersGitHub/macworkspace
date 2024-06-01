package _01_lambda;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/6/1 10:25
 */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("i am Hank1");
            }
        };
        r1.run();
        System.out.println("************************");
        // Lambda的写法
        Runnable r2 = () -> {
            System.out.println("i am Hank2");
        };
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com1.compare(1, 2));
        System.out.println("******************************");
        // lambda表达式写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(1, 2));
        System.out.println("******************************");

        // 方法引用
        Comparator<Integer> com3 = Integer :: compare;
        System.out.println(com3.compare(1, 2));
    }
}