package com._03_reflectapply.apply2;

import com._03_reflectapply.data.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/27 08:53
 */
public class FieldsTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        // getFields() 获取到运行时类本身及其所有的父类中生命为public权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields){
            System.out.println(f);
        }
        System.out.println(".........");
        // getDeclaredFields() 获取当前运行时类中声明的所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }
    }
    @Test
    public void test2() {
        Class<Person> calzz = Person.class;
        Field[] declaredFields = calzz.getDeclaredFields();
        for (Field f : declaredFields){
            // 1. 权限修饰符
            /*
            * 0x 十六进制
            * PUBLIC            = 0x00000001    1        1
            * PRIVATE           = 0x00000002    2       10
            * PROTECTED         = 0x00000004    4      100
            * STATIC            = 0x00000008    8     1000
            * FINAL             = 0x00000016    16   10000
            * ...
            * */
            int modifier = f.getModifiers();
            System.out.print(modifier + ":" + Modifier.toString(modifier) + "\t");
            // 2. 数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");
            // 3. 变量名
            String name = f.getName();
            System.out.print(name);
            System.out.println();
        }
    }
}
