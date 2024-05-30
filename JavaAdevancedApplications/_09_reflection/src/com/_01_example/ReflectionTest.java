package com._01_example;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/25 08:48
 */
public class ReflectionTest {
    @Test
    public void test1(){
        // 1. 创建Person的对象
        com._01_example.Person p = new com._01_example.Person();
        // 2. 调用属性
        p.age = 20;
        System.out.println(p.age);
        // 3. 调用方法
        p.sayhello();

    }
    // 使用反射完成上述操作
    @Test
    public void test2() throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 1. 创建Person类实例
        Class<com._01_example.Person> clazz = com._01_example.Person.class;
        com._01_example.Person p = clazz.newInstance();
        System.out.println(p);
        // 2. 调用属性
        Field age = clazz.getField("age");
        age.set(p,20);
        System.out.println(age.get(p));
        // 3. 调用方法
        Method showNation = clazz.getMethod("sayhello");
        showNation.invoke(p);
    }
    /*
    * 调用Person类中的私有结构
    * */
    @Test
    public void test3() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        // 创建Person实例
        Class<com._01_example.Person> clazz = com._01_example.Person.class;
        Constructor p1 = clazz.getDeclaredConstructor(String.class,int.class);

        // 1. 调用私有构造器
        p1.setAccessible(true); // 将私有方法设置为可访问
        com._01_example.Person p = (com._01_example.Person)p1.newInstance("Hank", 19);
        System.out.println(p);

        // 2. 调用私有属性
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true); // 将私有属性设置为可访问
        nameField.set(p,"Miller");
        System.out.println(p);

        // 3. 调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true); // 将私有方法设置为可访问
        System.out.println(showNation.invoke(p, "USA"));
    }

}
