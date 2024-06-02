package _02_reference;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/6/2 11:38
 */
public class ConstructorTest {
    @Test
    public void test1() {
        Supplier<Employee> supplier1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        Supplier<Employee> supplier2 = () -> new Employee();
        Supplier<Employee> supplier3 = Employee::new;
        supplier1.get();
        supplier2.get();
        supplier3.get();
    }

    @Test
    public void test2() {
        Function<Integer, Employee> func1 = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer age) {
                return new Employee(age);
            }
        };
        Function<Integer, Employee> func2 = (age) -> new Employee(age);
        // 以下调用的是Employee类中的参数是Integer类型的参数
        Function<Integer, Employee> func3 = Employee::new;
        func1.apply(12);
        func2.apply(12);
        func3.apply(12);
    }

    @Test
    public void test3() {
        BiFunction<String, Integer, Employee> bif = new BiFunction<String, Integer, Employee>() {
            @Override
            public Employee apply(String s, Integer i) {
                return new Employee(s, i);
            }
        };
        // 以下调用的是Employee类中的参数是(String, Integer)类型的参数
        BiFunction<String, Integer, Employee> bif1 = Employee::new;
        System.out.println(bif.apply("Hank", 20));
        System.out.println(bif1.apply("Miller", 20));
    }
    @Test
    public void test4(){
        Function<Integer,Employee[]> func1 = new Function<Integer, Employee[]>() {
            @Override
            public Employee[] apply(Integer len) {
                return new Employee[len];
            }
        };
        Function<Integer,Employee[]> func2 = (i) -> new Employee[i];
        Function<Integer,Employee[]> func3 = Employee[] :: new;
    }
}
