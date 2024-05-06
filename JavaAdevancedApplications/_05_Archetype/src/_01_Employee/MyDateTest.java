package _01_Employee;

import java.util.Comparator;
import java.util.TreeSet;
public class MyDateTest {
    public static void main(String[] args) {
        // 创建MyDate对象
        MyDate birthday1 = new MyDate(1990, 5, 15);
        MyDate birthday2 = new MyDate(1985, 10, 25);
        MyDate birthday3 = new MyDate(1995, 3, 8);
        MyDate birthday4 = new MyDate(1988, 12, 20);
        MyDate birthday5 = new MyDate(1992, 7, 3);

        // 创建Employee对象
        Employee employee1 = new Employee("Alice", 30, birthday1);
        Employee employee2 = new Employee("Bob", 35, birthday2);
        Employee employee3 = new Employee("Charlie", 25, birthday3);
        Employee employee4 = new Employee("David", 32, birthday4);
        Employee employee5 = new Employee("Eve", 29, birthday5);

        // 创建TreeSet并添加Employee对象
        TreeSet<Employee> treeSet1 = new TreeSet<>();
        treeSet1.add(employee1);
        treeSet1.add(employee2);
        treeSet1.add(employee3);
        treeSet1.add(employee4);
        treeSet1.add(employee5);

        // 使用Comparable接口按照name排序并输出
        System.out.println("Sorted by name (using Comparable):");
        for (Employee employee : treeSet1) {
            System.out.println(employee);
        }

        // 创建TreeSet并传入Comparator对象，按照生日日期进行排序
        TreeSet<Employee> treeSet2 = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return emp1.getBirthday().toString().compareTo(emp2.getBirthday().toString());
            }
        });

        // 添加Employee对象到新的TreeSet
        treeSet2.add(employee1);
        treeSet2.add(employee2);
        treeSet2.add(employee3);
        treeSet2.add(employee4);
        treeSet2.add(employee5);

        // 输出按照生日日期排序的结果
        System.out.println("\nSorted by birthday (using Comparator):");
        for (Employee employee : treeSet2) {
            System.out.println(employee);
        }
    }
}
