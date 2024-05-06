package _01_Employee;

// 定义Employee类
public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private MyDate birthday;

    // 构造函数
    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    // getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Birthday: " + birthday;
    }

    // 实现Comparable接口，按照name排序
    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.getName());
    }
}

