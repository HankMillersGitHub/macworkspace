public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Hank",18);
        Person p2 = new Person("Hank",18);
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(p1.equals(p2));
        System.out.println("p1:" + p1);
        System.out.println("p2:" + p2);
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

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
}