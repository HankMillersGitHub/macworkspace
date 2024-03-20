public class Test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 3;
        System.out.println("对象.属性之后输出" + p1.age);
    }
}
class Person {
    int age = 1;
    {
        System.out.println(age);
        age = 4;
        System.out.println("代码块修改之后输出" + age);
    }
    public Person(){
        age = 2;
        System.out.println("构造器中修改后输出" + age);
    }
    public Person(int age){
        this.age = age;
    }
}
