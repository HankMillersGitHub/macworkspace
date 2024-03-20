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
    Person(int age,String name){
        this.name = name;
        this.age = age;
    }
}
class Student extends Person{
    Student(int age ,String name){
        super(age,name);
    }
    public void sayHello(){
        System.out.println("this is Student's sayHello");
    }
}
class Teacher extends Person{
    Teacher(int age,String name){
        super(age,name);
    }
    public void sayHello(){
        System.out.println("this is Teacher's sayHello");
    }
}