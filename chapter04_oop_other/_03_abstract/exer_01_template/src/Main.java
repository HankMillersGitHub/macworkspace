public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Hank h = new Hank();
        h.doSomething();
    }
}
abstract class Account{
    public void takeNumber(){
        System.out.println("排队取号");
    }
    abstract public void something();
    public void goAway(){
        System.out.println("完事出门");
    }
    public void doSomething(){
        takeNumber();
        something();
        goAway();
    }
}
class Hank extends Account{
    @Override
    public void something() {
        System.out.println("我要取1000万");
    }

    @Override
    public void doSomething() {
        super.doSomething();
    }
}