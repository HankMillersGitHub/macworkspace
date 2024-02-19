import java.util.PrimitiveIterator;

/**
 * @program: macWorkSpace
 * @ClassName Student
 * @description:
 * @author: HankMiller
 * @create: 2024-02-19 16:43
 * @Version 1.0
 **/
public class Student extends Person{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        /**
         * 以下两者只能出现一个
         * */
//        this("Hank",18);
        super();
        System.out.println("this is Student class constructor");
    }

}
