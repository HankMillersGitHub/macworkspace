import java.util.Scanner;

public class Person {
    public void sayHello(){
        System.out.println("HELLO");
    }
}

class Student extends Person{
    @Override
    public void sayHello() {
        super.sayHello();
    }
}

interface ThisIsAInterface{
    void speak1();
    void speak2();
    void speak3();
    void speak4();
    void speak5();
    void speak6();
    void speak7();
    void speak8();
}
class Teacher extends Person implements ThisIsAInterface{
    @Override
    public void speak1() {

    }

    @Override
    public void speak2() {

    }

    @Override
    public void speak3() {

    }

    @Override
    public void speak4() {

    }

    @Override
    public void speak5() {

    }

    @Override
    public void speak6() {

    }

    @Override
    public void speak7() {

    }

    @Override
    public void speak8() {

    }
}