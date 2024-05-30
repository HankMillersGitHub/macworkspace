package com._03_reflectapply.apply2;

import com._03_reflectapply.data.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/27 10:35
 */
public class MethodsTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        // getMethods() 获取到运行时类本身及其所有的父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        System.out.println("-------------");
        // getDeclaredMethods() 获取当前运行时类中声明的所有的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
        }
    }
    // 注解信息
    // 权限修饰符 返回值类型 方法名(形参类型1 参数1，形参类型2 参数2 ，.....) throws 异常类型1，异常类型2......{}
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            // 1. 获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos){
                System.out.println(a);
            }
            // 2. 权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            // 3. 返回值类型
            System.out.print(m.getReturnType().getName() + "\t");
            // 4. 方法名
            System.out.print(m.getName());
            System.out.println("(");
            // 5. 形参列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for (int i = 0;i < parameterTypes.length; i++){
                    if(i == parameterTypes.length - 1){
                        System.out.println(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.println(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.println(")");
            // 6. 抛出异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }
}
