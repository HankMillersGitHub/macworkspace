<<<<<<< HEAD
import org.junit.Test;

import static java.lang.Integer.valueOf;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int b = 10;
    }
    @Test
    public void test(){
        // 基本数据类型转包装类
        int a = 10;
        // 自动装箱
        Integer aa = Integer.valueOf(a);

        float b = 10.1F;
        // 自动装箱
        Float bb = b;

        boolean c = true;
        // 自动装箱
        Boolean cc = c;

        System.out.println(aa.equals(bb));

        // 包装类转基本数据类型
        Integer aaa = 10;
        int aaaa = aaa.intValue();
        // 自动拆箱
        int aaaaa = aaa;
        System.out.println(aaaaa);

        Double d = 10.2;
        double dd = d.doubleValue();
        System.out.println(dd);

    }

=======
public class Main {
    public static void main(String[] args) {
        // 自动装箱底层会调用valueOf()
        Integer i = 1;
        Integer j = 1;
        System.out.println(i == j); // ture

        Integer m = 127;
        Integer n = 127;
        System.out.println(m == n); // false
    }
>>>>>>> 9f68438 (2023.4.1 commit)
}