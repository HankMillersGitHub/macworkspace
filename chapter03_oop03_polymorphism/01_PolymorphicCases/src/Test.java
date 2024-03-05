/**
 * @program: macWorkSpace
 * @ClassName Test
 * @description:
 * @author: HankMiller
 * @create: 2024-03-03 17:04
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Ani ani = new Cat();
        Dog dog;
        if(ani instanceof Dog){
            dog = (Dog) ani;
        }else{
            System.out.println("猫不是狗");
        }
    }
}
