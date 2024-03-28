public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Hank",18,Staus.BUSY);
        Employee e2 = new Employee("Hank",18,Staus.FREE);
        Employee e3 = new Employee("Hank",18,Staus.VOCATION);
        Employee e4 = new Employee("Hank",18,Staus.DIMISSION);
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());
        System.out.println(e4.toString());
    }
}
class Employee{
    private String name;
    private int age;
    private Staus staus;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", staus=" + staus +
                '}';
    }

    public Employee(String name, int age, Staus staus) {
        this.name = name;
        this.age = age;
        this.staus = staus;
    }

    public Employee() {
    }

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

    public Staus getStaus() {
        return staus;
    }

    public void setStaus(Staus staus) {
        this.staus = staus;
    }
}
enum Staus{
    BUSY,FREE,VOCATION,DIMISSION
}