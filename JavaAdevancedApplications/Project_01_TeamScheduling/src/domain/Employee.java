package domain;

public class Employee {
    private int id;
    private int age;
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }
    protected String getDetail(){
        return id + "\t" + name + "\t" + age + "\t" + salary + "\t";
    }
    @Override
    public String toString() {
        return getDetail();
    }
    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

}
