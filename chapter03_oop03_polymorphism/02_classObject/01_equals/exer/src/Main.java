import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Customer c1 = new Customer(1001,"Hank",18);
        Customer c2 = new Customer(1002,"Hank",18);
        System.out.println(c1.equals(c2));
    }
}
class Account{

}
class Customer{
    int id;
    String name;
    int age ;

    public Customer(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}