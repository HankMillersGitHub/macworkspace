package _03_stream;

import _02_reference.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/6/2 16:01
 */
public class StreamAPITest {
    // 创建Stream方式一：通过集合
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        // default Stream<E> stream() ： 返回一个顺序流
        Stream<Employee> stream = list.stream();
        // default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> stream1 = list.parallelStream();
    }
    // 创建Stream方式二：通过数组
    @Test
    public void test2(){
        Integer[] list = {1,2,3,4,5};
        Stream<Integer> stream = Arrays.stream(list);

        int[] list1 = {1,2,3,4,5};
        IntStream stream1 = Arrays.stream(list1);
    }
    // 创建Stream方式三：通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 43, 4, 5, 6, 7);
    }
}
