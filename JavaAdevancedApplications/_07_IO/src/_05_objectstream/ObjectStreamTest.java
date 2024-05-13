package _05_objectstream;

import org.junit.Test;

import java.io.*;

public class ObjectStreamTest {
    @Test
    public void test() throws IOException {
        // 序列化过程
        // 1. 创建流
        File file = new File("Object.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        // 写出数据就是序列化的过程
        oos.writeUTF("江山如此多娇，引无数英雄竞折腰");
        oos.flush();
        oos.writeObject("轻轻的我将离开你，请将眼角的泪拭去");
        oos.flush();
        oos.close();
    }
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        // 反序列化
        File file = new File("Object.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        // 反序列化的过程
        String str = ois.readUTF();
        System.out.println(str);
        String str1 = (String) ois.readObject();
        System.out.println(str1);
        ois.close();
    }
    @Test
    public void test3() throws IOException {
        File file = new File("object1.dat");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Person p1 = new Person(12,"张三");
        oos.writeObject(p1);
        oos.flush();
        oos.close();
    }
    @Test
    public void test4() throws IOException, ClassNotFoundException {
        File file = new File("object1.dat");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person p = (Person) ois.readObject();
        System.out.println(p.age + "---" + p.name);
        ois.close();
    }
}
