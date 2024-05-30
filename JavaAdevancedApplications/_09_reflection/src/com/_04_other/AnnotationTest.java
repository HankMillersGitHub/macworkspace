package com._04_other;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/30 09:59
 */
public class AnnotationTest {
    /*
    * 获取类声明上的注解
    * */
    @Test
    public void test1(){
        Class<Customer> clazz = Customer.class;
        Table annotation = clazz.getDeclaredAnnotation(Table.class);
        System.out.println(annotation.value());
    }

    /*
    * 获取属性声明上的注解
    * */
    @Test
    public void test2() throws NoSuchFieldException {
        Class<Customer> clazz = Customer.class;
        Field nameField = clazz.getDeclaredField("name");
        Colum annotation = nameField.getDeclaredAnnotation(Colum.class);
        System.out.println(annotation.columName());
        System.out.println(annotation.columType());

    }
}
