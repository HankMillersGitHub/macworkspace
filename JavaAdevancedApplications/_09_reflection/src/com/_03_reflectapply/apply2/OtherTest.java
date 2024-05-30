package com._03_reflectapply.apply2;

import com._03_reflectapply.data.Person;
import com.sun.corba.se.spi.orbutil.threadpool.NoSuchThreadPoolException;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/28 08:57
 */
public class OtherTest {
    // 获取运行时类的内部结构：父类、接口们、包、带范型的父类、父类的范型等
    // 1. 获取运行时类的父类
    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com._03_reflectapply.data.Person");
        System.out.println(clazz.getSuperclass());
    }
    // 2. 获取运行时类实现的接口
    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com._03_reflectapply.data.Person");
        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

    }
    // 3. 获取运行时类所在的包
    @Test
    public void test3() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com._03_reflectapply.data.Person");
        System.out.println(clazz.getPackage());
    }
    // 4. 获取运行时类带范型的父类
    @Test
    public void test4() throws ClassNotFoundException {
        Class clazz = Class.forName("com._03_reflectapply.data.Person");
        System.out.println(clazz.getGenericSuperclass());
    }
    // 5. 获取运行时类父类的范型
    /**
     * 平时写的代码：
     *      类型一：业务逻辑代码 (多关注)
     *      类型二：算法逻辑代码 (多积累)
     * */
    @Test
    public void test5() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com._03_reflectapply.data.Person");
        // 获取带范型的父类 Type是一个接口Class实现了此接口
        Type superClass = clazz.getGenericSuperclass();
        // 如果父类是带范型的，则可以强转伟ParamterizedType
        ParameterizedType paramType = (ParameterizedType) superClass;
        // 调用getActualTypeArguments()获取范型的参数，结果是一个数组，因为可能有多个范型参数
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        for (Type actual : actualTypeArguments){
            // 获取范型参数的名称
            System.out.println(((Class)actual).getName());
        }
    }

}
