public class StaticBlock {
    public static void main(String[] args) {
        Person p1 = new Person("hank",19);

    }
}
class Person{
    int age;
    String name;
    Person(){

    }
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    // 静态代码块
    static{
        System.out.println("静态代码块执行");
    }
    // 非静态代码块
    {
        System.out.println("非静态代码块执行");
    }
}