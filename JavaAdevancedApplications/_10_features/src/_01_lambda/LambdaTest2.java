package _01_lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/6/1 12:38
 */
public class LambdaTest2 {
    // 语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        r1.run();
        System.out.println("************************");
        Runnable r2 = () -> {
            System.out.println("hello Hank");
        };
        r2.run();
    }
    // 语法格式二： lambda需要一个参数但是没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("你是谁");
        System.out.println("*********************************************");
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("你好世界");
    }
    // 语法格式三：数据类型可以省略，因为可由编译器推断得出，成为类型推断
    @Test
    public void test3(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("nihaoshijie");
        // 省略数据类型
        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("nihaoshijie");
    }
    // 语法格式四：如果lambda只有一个参数，那么小括号也可以省略
    @Test
    public void test4(){
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con1.accept("shijienihao");
        con2.accept("shijienihao");
    }
    // 语法格式五：lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(1,2));
        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(1, 2));
    }
    // 语法格式六：当lambda体只有一条语句时，return与大括号若有都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(1, 2));
        System.out.println("************************************************");
        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(1, 2));
    }
}
