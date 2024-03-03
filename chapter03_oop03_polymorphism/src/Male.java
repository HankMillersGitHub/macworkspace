/**
 * @program: macWorkSpace
 * @ClassName Male
 * @description:
 * @author: HankMiller
 * @create: 2024-02-29 18:49
 * @Version 1.0
 **/
public class Male extends Person {
    boolean isDrunk;
    int id = 1002;
    @Override
    public void eat() {
        System.out.println("女人少吃，减肥");
    }

    @Override
    public void sleep() {
        System.out.println("女人和男人睡觉");
    }
    public void goShopping(){
        System.out.println("女人喜欢逛街");
    }
}
