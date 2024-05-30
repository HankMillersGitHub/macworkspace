package com._02_Class;

import com._02_Class.User;
import org.junit.Test;

import javax.swing.text.Element;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/26 09:01
 */
public class ClassTest {
    /*
    * 获取Class实例的几种方式
    * */
    @Test
    public void test1() throws ClassNotFoundException {
        // 1. 调用运行时类的静态属性
        Class<User> clazz1 = com._02_Class.User.class;
        // 2. 调用运行时类的对象的getClass()
        com._02_Class.User user = new com._02_Class.User();
        Class clazz2 = user.getClass();
        // 3. 调用Class的静态方法forName(String className)
        Class<?> clazz3 = Class.forName("com._02_Class.User");// 全类名
        // 4. 使用类的加载器的方式(了解)
        Class<?> clazz4 = ClassLoader.getSystemClassLoader().loadClass("com._02_Class.User");
        System.out.println(clazz1 == clazz4); // true

    }
    @Test
    public void test2(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = Element.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一致，就是同一个Class
        System.out.println(c10 == c11);
    }
}
