import java.sql.SQLOutput;

/**
 * @program: macWorkSpace
 * @ClassName JDKEight_interface
 * @description:
 * @author: HankMiller
 * @create: 2024-03-25 10:21
 * @Version 1.0
 **/
public class JDKEight_interface {
    public static void main(String[] args) {
        A a = new A();
    }
}
interface Test{
    // 传统的
    // 属性： 声明为 public static final
//    public static final int MIN_HEIGHT = 0;
// 方法：声明为 public abstract
//    public abstract void method1();

    // JDK8 中静态方法
    // 1. 接口中声明的静态方法只能被接口调用，不能使用其实现类进行调用
//    public static void method2(){
//        System.out.println("hello");
//    }

    // JDK8 中的默认方法
    // 1. 接口中声明的默认方法可以被接口的实现类继承，实现类在没有重写此方法的情况下，默认调用接口的默认方法，重写之后默认调用重写之后的方法
    // 2. 类实现了两个接口，而两个接口中定义了同名同参数的默认方法，则实现类在没有重写这两个接口的默认方法的情况下会报错，称为接口冲突，要求实现类必须重写接口中同名同参数的默认方法
    // 3. 子类继承了父类并实现了接口，父类和接口中声明了同名同参数方法(接口中的方法为默认方法),默认情况下子类(实现类)在没有重写此方法的情况下，调用的是父类中的方法--> 类优先原则
    // 4. 如何在实现类中调用父类或接口中被重写的方法
        /*method4(); // 调用自己类中的方法
        super.method4(); // 调用父类中的方法
        method3(); // 调用自己类中的方法
        CompareA.super.method3(); // 调用指定接口中的默认方法
        CompareB.super.method3();// 调用指定接口中的默认方法*/


    // JDK8 以后的私有方法 和 默认方法配合使用
    default void method4(){
        System.out.println("我是接口中的默认方法");
        method5(); // 调用接口中的私有方法
    }
    public abstract void method3();// 接口中的抽象方法
    private void method5(){
        System.out.println("我是接口中的私有方法");
    }
}
class A implements Test{
    public void method3(){
        System.out.println("重写接口中的抽象方法");
    }
}
