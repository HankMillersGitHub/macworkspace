public class Main {
    public static void main(String[] args) {
        Student s = new Student(20,"Miller");
        s.sayHello();
        Teacher t = new Teacher(30,"MZH");
        t.sayHello();
        Person p = new Person(18,"Hank") {
            @Override
            public void sayHello() {
                System.out.println("override Person's sayHello method");
            }
            public void sleep(){
                System.out.println("Person need sleep");
            }
        };
        p.sayHello();
    }
}
// this is abstract class
abstract class Person{
    int age ;
    String name;
    // this is abstract method
    abstract public void sayHello();
    abstract public void sleep();
    Person(int age,String name){
        this.name = name;
        this.age = age;
    }
}
// 以下两个类是Person类的子类
class Student extends Person{
    /**
     * Student的全参构造函数
     * @author HankMiller
     * @Description // TODO
     * @data 2024/03/20 20:46
     **/
    Student(int age ,String name){
        super(age,name);
    }
    public void sayHello(){
        System.out.println("this is Student's sayHello");
    }
    public void sleep(){
        System.out.println("Student need sleep");
    }
}
class Teacher extends Person{
    Teacher(int age,String name){
        super(age,name);
    }
    public void sayHello(){
        System.out.println("this is Teacher's sayHello");
    }
    public void sleep(){
        System.out.println("Teacher need sleep too");
    }
}