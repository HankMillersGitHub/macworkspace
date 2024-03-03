/**
 * @program: macWorkSpace
 * @ClassName Man
 * @description:
 * @author: HankMiller
 * @create: 2024-02-29 18:49
 * @Version 1.0
 **/
public class Man extends Person
{
    boolean isSmoking;

    @Override
    public void eat() {
        System.out.println("男人喝枸杞");
    }

    @Override
    public void sleep() {
        System.out.println("男人和女人睡觉");
    }
    public void earnMoney(){
        System.out.println("男人需要挣钱");
    }
}
