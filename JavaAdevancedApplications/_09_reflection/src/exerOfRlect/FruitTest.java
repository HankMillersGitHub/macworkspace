package exerOfRlect;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/6/1 09:30
 */
public class FruitTest {
    @Test
    public void test1() throws Exception{
        // 1. 读取配置文件信息，获取全类名
        // 使用File的方式读取文件信息
        File file = new File("src/config.properties");
        FileInputStream fis = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fis);
        String fruitName = properties.getProperty("fruitName");
        // 2. 通过反射创建指定全类名对应的类的实例
        Class<?> clazz = Class.forName(fruitName);
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Fruit f = (Fruit) constructor.newInstance();
        // 3. 通过榨汁机对象调用run方法
        Juicer juicer = new Juicer();
        juicer.run(f);

    }
}
