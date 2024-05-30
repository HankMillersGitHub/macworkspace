package com._03_reflectapply.apply3;

import com._03_reflectapply.data.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/29 08:56
 */
public class ReflectTest {
    //******************************如下是调用指定属性******************************//
    @Test
    public void test1() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        // 1. 获取运行时类中指定名的属性
        Field ageField = clazz.getField("age");
        // 2. 获取并设置age的值
        ageField.set(person,100);
        System.out.println(ageField.get(person));

    }
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        // 1. 通过Class调用getDeclaredField(String fieldName)获取运行时类中指定名的属性
        Field nameField = clazz.getDeclaredField("name");
        // 2. setAccessible(true) 确保此属性可以访问
        nameField.setAccessible(true); // 将访问是否非法设置为合法
        // 2. 通过field的实例调用set() get()方法，获取并设置age的值
        nameField.set(person,"Hank");
        System.out.println(nameField.get(person));
    }
    @Test
    public void test3() throws Exception{
        Class<Person> clazz = Person.class;
        // 1. 通过Class调用getDeclaredField(String fieldName)获取运行时类中指定名的属性
        Field infoField = clazz.getDeclaredField("info");
        // 2. setAccessible(true) 确保此属性可以访问
        infoField.setAccessible(true); // 将访问是否非法设置为合法
        // 2. 通过field的实例调用set() get()方法，获取并设置age的值
//        infoField.set(Person.class,"我是一个人");
//        System.out.println(infoField.get(Person.class));
        // 仅限于类变量可以如下使用
        infoField.set(null,"我是一个人");
        System.out.println(infoField.get(null));
    }
    //******************************如下是调用指定方法******************************//
    @Test
    public void test4() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        // 1. 通过Class的实例调用getDeclaredMethod()获取当前运行时类的方法
        Method showNation = clazz.getDeclaredMethod("showNation",String.class,int.class);
        // 2. 保证有调用方法的权限
        showNation.setAccessible(true);
        // 3. 通过method实例调用invoke(实例，参数)方法，即为对method对应的方法的调用
        // invoke的返回值即为method的返回值
        // 特别的：如果method对应的方法的返回值类型为void，则invoke返回值为null
        Object returnValue = showNation.invoke(person, "Chinese", 10);
        System.out.println(returnValue);
    }
    @Test
    public void test5() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        Method showInfo = clazz.getDeclaredMethod("showInfo");
        showInfo.setAccessible(true);
        showInfo.invoke(null);
    }
    //******************************如下是调用指定构造器******************************//
    @Test
    public void test6() throws Exception{
        Class<Person> clazz = Person.class;
        // 1. 通过Class实例调用getDeclaredConstructor(Class...args)获取指定类型参数类型的构造器
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        // 2. 确保此构造器是可以访问的
        constructor.setAccessible(true);
        // 3. 通过constructor实例调用newInstance(Object...objs)返回一个运行时类的实例
        Person person = constructor.newInstance("Hank", 19);
        System.out.println(person);
    }
    /**
     * 使用Constructor的方式替换newInstance的方式创建对象
     * */
    @Test
    public void test7() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
/*        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Person person = constructor.newInstance();
        System.out.println(person);*/
    }
}
