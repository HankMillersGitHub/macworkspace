package com._04_other.dynamic;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description : 体会反射的动态性
 * @auther mazhonghao
 * @date 2024/5/30 10:13
 */
public class ReflectTest {
    // 静态
    public Person getInstance(){
        return new Person();
    }
    // 动态性
    public <T> T getInstance(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return (T) constructor.newInstance();
    }
    @Test
    public void test1() throws Exception {
        // 静态
        Person p1 = getInstance();
        // 动态
        String className = "com._04_other.dynamic.Person";
        Person p2 = getInstance(className);
        System.out.println(p1);
        System.out.println(p2);
    }
    /*
    *
    * */
    public Object invoke(String className,String methodName) throws Exception {
        // 1. 创建全类名对应的运行时类的对象
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object o = constructor.newInstance();
        // 2. 获取运行时类中指定的方法，并调用
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(o);
    }
    @Test
    public void test2() throws Exception {
        String className = "com._04_other.dynamic.Person";
        invoke(className, "sayhello");
    }
}
