package _03_stream;

import _02_reference.Employee;
import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/6/2 16:19
 */
public class StreamAPITest1 {
    // 1. 筛选与切片
    @Test
    public void test1() {
        // filter(Predicate p) 接收lambda，从流中排除某些元素
        // 练习： 查询员工表中年龄大于五十的员工信息
        List<Employee> list1 = EmployeeData.getEmployees();
        Stream<Employee> stream1 = list1.stream();
        stream1.filter((employee) -> employee.getAge() > 50).forEach(System.out::println);
        System.out.println("******************************");

        // limit(n) 截断流 使其元素不超过n
        List<Employee> list2 = EmployeeData.getEmployees();
        list2.stream().limit(5).forEach(System.out::println);
        System.out.println("******************************");

        // skip(n) 跳过元素，返回一个扔掉了前n个元素的流，如果流中元素不足n则返回空流
        List<Employee> list3 = EmployeeData.getEmployees();
        list3.stream().skip(10).forEach(System.out::println);
        System.out.println("******************************");

        // distinct() 筛选，通过流所生成元素的hashCode() 和 equals() 去除重复元素
        List<Employee> list4 = EmployeeData.getEmployees();
        list4.stream().distinct().forEach(System.out::println);
    }

    // 2. 映射
    @Test
    public void test2() {
        // map(Function f) 接受一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上
        // 练习，大小写转换
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        // list.stream().map(str -> str.toUpperCase()).forEach(System.out :: println);
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        // 练习： 获取年龄大于六十的员工的信息
        List<Employee> list2 = EmployeeData.getEmployees();
        list2.stream().filter(employee -> employee.getAge() > 60).forEach(System.out::println);

        // 练习：获取年龄大于60的员工的姓名
        List<Employee> list1 = EmployeeData.getEmployees();
        list1.stream().filter(employee -> employee.getAge() > 60).map(Employee::getName).forEach(System.out::println);
    }
    @Test
    public void test3(){
        Integer[] arr1 = {121,232,341,144,175,665};
        String[] arr2 = {"cc","bb","aa","gg","ff","ee"};
        List<Integer> list1 = Arrays.asList(arr1);
        List<String> list2 = Arrays.asList(arr2);
        list1.stream().sorted().forEach(System.out :: println);
        list2.stream().sorted().forEach(System.out :: println);
        list1.stream().sorted((o1,o2) -> o2.compareTo(o1)).forEach(System.out :: println);
        List<Employee> list = EmployeeData.getEmployees();
        list.stream().sorted(((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()))).forEach(System.out :: println);
    }
}
