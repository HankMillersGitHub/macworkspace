public class LeafTest {
    public static void main(String[] args) {
        new Leaf();
        System.out.println("Hello world!");
        new Leaf();
    }
}
class Root{
    static{
        System.out.println("Root的静态代码块");
    }
    {
        System.out.println("Root的非静态代码块");
    }
    public Root(){
        System.out.println("Root的构造函数");
    }
}
class Mid extends Root{
    static{
        System.out.println("Mid的静态代码块");
    }
    {
        System.out.println("Mid的非静态代码块");
    }
    public Mid(){
        System.out.println("Mid的无参构造函数");
    }
    public Mid(String msg){
        // 通过this调用同一类中重载的构造器
        this();
        System.out.println("Mid的有参构造函数，参数为：" + msg);
    }
}
class Leaf extends Mid{
    static{
        System.out.println("leaf的静态代码块");
    }
    {
        System.out.println("Leaf的非静态代码块");
    }
    public Leaf(){
        // 通过super调用父类中有一个字符串参数的构造器
        super("Hank");
        System.out.println("Leaf的无参构造器");
    }
}

// 加载口诀： 由父及子，静态先行