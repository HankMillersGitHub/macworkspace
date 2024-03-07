import java.io.ObjectStreamException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Hank",18);
        Person p2 = new Person("Hank",18);
//         String str1 = new String("hello");
//         String str2 = new String("hello");

        System.out.println(p1.equals(p2));
        System.out.println("p1:" + p1);
        System.out.println("p2:" + p2);
        // System.out.println(str1 == str2);
//         System.out.println(str1.equals(str2));

    }
}
class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 手动重写equals方法

/*    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Person obj1){
            return Objects.equals(obj1.name, this.name) && obj1.age == this.age;
        }
        return false;

    }*/

    // idea自动重写equals方法


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}