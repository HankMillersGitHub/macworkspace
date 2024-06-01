package com._02_Class;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/26 09:55
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        // 1. 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2
        // 2. 获取扩展类加载器
        ClassLoader parent = systemClassLoader.getParent(); // sun.misc.Launcher$ExtClassLoader@1f32e575
        // 3. 获取引导类加载器：失败
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1); // null
    }
    @Test
    public void test2() throws ClassNotFoundException {
        // 用户自定义类使用系统类加载器加载
        Class<User> clazz = User.class;
        ClassLoader classLoader = clazz.getClassLoader(); // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);
        // 对于java的核心api使用引导类加载器加载
        Class<?> aClass = Class.forName("java.lang.String");
        ClassLoader classLoader1 = aClass.getClassLoader(); // null
        System.out.println(classLoader1);
    }
    /*
    * 需求，通过ClassLoader获取配置文件
    */
    @Test
    public void test3() throws IOException {
        Properties pros = new Properties();
        // 通过类加载器获取的文件的路径在当前module下的src下
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
        pros.load(is);
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println(name + ":" + password);
    }
    @Test
    public void test4() throws IOException {
        // 通过properties获取配置文件
        Properties pros = new Properties();
        // 文件的路径在当前module下
        FileInputStream fis = new FileInputStream(new File("config.properties"));
        pros.load(fis);
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println(name + ":" + password);
    }
}
