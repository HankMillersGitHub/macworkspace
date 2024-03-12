public class BankTest {
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);
    }
}
// 饿汉式实现单例模式
class Bank{
    // 1. 类的构造器私有化
    private Bank(){}
    // 2. 在类的内部创建当前类的实例
    // 4. 此属性也必须声明为静态
    private static Bank instance = new Bank();
    // 3. 使用getAxxx()方法获取当前类的实例，必须声明为static
    public static Bank getInstance(){
        return instance;
    }
}