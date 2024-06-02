package _02_reference;

import org.junit.Test;

import javax.crypto.spec.PSource;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/6/2 09:45
 */
public class MethodTest {
    /**
     * 对象  ::  实例方法
     */
    @Test
    public void test1() {
        // 1.
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        // 2. lambda表达式
        Consumer<String> con2 = s -> System.out.println(s);
        // 3. 方法引用
        Consumer<String> con3 = con2::accept;
        PrintStream ps = System.out;
        Consumer<String> con4 = ps::println;
        con3.accept("你好");
        con2.accept("你不好");
        con1.accept("你好得很");
        con4.accept("打印流");
    }

    /**
     * Supplier中的 T get()
     * Employee中String getName()
     */
    @Test
    public void test2() {
        // 1.
        Employee employee = new Employee("Hank", 19);
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return employee.getName();
            }
        };
        // 2. lambda
        Supplier<String> supplier2 = () -> employee.getName();
        supplier2.get();
        // 3.
        Supplier<String> supplier3 = employee::getName;
        supplier3.get();

    }

    @Test
    public void test3() {
        // 1.
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        // 2.
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        // 3.
        Comparator<Integer> com3 = Integer::compare;
        System.out.println(com1.compare(12, 2));
        System.out.println(com2.compare(12, 12));
        System.out.println(com3.compare(12, 12));
    }

    @Test
    public void test4() {
        Function<Double, Long> fun1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        Function<Double, Long> fun2 = aDouble -> Math.round(aDouble);
        Function<Double, Long> fun3 = Math::round;
        System.out.println(fun1.apply(3.1415926));
        System.out.println(fun2.apply(3.1415926));
        System.out.println(fun3.apply(3.1415926));
    }

    /**
     * 情况三： 类 :: 实例方法
     */
    @Test
    public void test5() {
        Comparator<String> com1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Comparator<String> com2 = (o1, o2) -> o1.compareTo(o2);
        Comparator<String> com3 = String::compareTo;
        System.out.println(com1.compare("Hank", "hank"));
        System.out.println(com2.compare("Hank", "hank"));
        System.out.println(com3.compare("Hank", "hank"));
    }

    @Test
    public void test6() {
        BiPredicate<String, String> bip1 = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s1, String s2) {
                return s1.equals(s2);
            }
        };
        BiPredicate<String, String> bip2 = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> bip3 = String::equals;
        System.out.println(bip1.test("Hank", "hank"));
        System.out.println(bip2.test("Hank", "hank"));
        System.out.println(bip3.test("Hank", "hank"));
    }

    @Test
    public void test7() {
        Employee emp = new Employee("Hank",29);
        Function<Employee, String> func1 = new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        };
        Function<Employee, String> func2 = employee -> employee.getName();
        Function<Employee, String> func3 = Employee :: getName;
        System.out.println(func1.apply(emp));
        System.out.println(func2.apply(emp));
        System.out.println(func3.apply(emp));
    }
}
