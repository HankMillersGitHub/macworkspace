public class Person {
    private String name;
    private int age;
    public String getName() {
        return name;
    }

    public Person() {
    }
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
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
    public void sayMyName(){
        System.out.println("say my name!");
    }
/**
 * 练习复写的案例将被Heisenberg类继承
 * @author HankMiller
 * @data 2024/02/18 17:35
 */
    public void sayHello(){
        System.out.println("hello my name is heisenberg");
    }
}
