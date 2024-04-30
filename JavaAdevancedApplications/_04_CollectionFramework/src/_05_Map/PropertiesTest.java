package _05_Map;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        // 方式一：数据和代码耦合度高，如果修改需要重新编译代码 重新打包发布
        // 以下代码耦合度高，不利于修改
        // 数据
        String name = "Tom";
        String password = "123123";
        // 操作数据的代码
        // ......
    }
    @Test
    public void test() throws IOException { // 注意 ： 因为涉及到流的使用,为了确保流能关闭，建议使用trycatchfinall
        // 方式二：可以将数据封装到具体的配置文件中，在程序中读取配置文件中的信息，实现了数据和代码的解耦，就省去了重新编译和打包的过程
        // 创建文件
        File file = new File("info.properties");
        System.out.println(file.getAbsolutePath());
        // 创建流
        FileInputStream fis = new FileInputStream(file);

        // 将创建好的流放到文件中
        Properties propers = new Properties();
        propers.load(fis); // 加载文件中的数据
        // 读取文件中的数据
        String name = propers.getProperty("name");
        String age = propers.getProperty("age");
        System.out.println(name + ":" + age);
        // 关闭流
        fis.close();
    }
}
