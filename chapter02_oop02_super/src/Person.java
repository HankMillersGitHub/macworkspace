import java.security.PrivateKey;

/**
 * @program: macWorkSpace
 * @ClassName Person
 * @description:
 * @author: HankMiller
 * @create: 2024-02-19 16:44
 * @Version 1.0
 **/
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        System.out.println("this is Person class constructor");
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
}
