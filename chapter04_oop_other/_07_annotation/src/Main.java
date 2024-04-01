public class Main {
    public static void main(String[] args) {
        Person p1 = new Student();
        p1.eat();
    }
}
@ThisIsAAnnotation
class Person {
    public void eat(){

    }
}
class Student extends Person {
    @Override
    public void eat() {
        @SuppressWarnings("unused") int age = 10;
        System.out.println("student eat food");
        @ThisIsAAnnotation("unused")
        @SuppressWarnings("unused") int id = 1001;
    }
}