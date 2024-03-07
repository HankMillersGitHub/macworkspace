public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Hank",18);
        Person p2 = new Person();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.toString());
    }
}
class Person{
    String name;
    int age;
    int id;
    public Person() {
        this("Hank",18,10001);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name, int age ,int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ",id=" + id + '\'' +
                '}';
    }
}