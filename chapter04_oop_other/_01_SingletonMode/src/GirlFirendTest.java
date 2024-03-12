/**
 * @program: macWorkSpace
 * @ClassName GrilFirendTest
 * @description:
 * @author: HankMiller
 * @create: 2024-03-12 16:33
 * @Version 1.0
 **/
public class GirlFirendTest {
    public static void main(String[] args) {
        GirlFriend g1 = GirlFriend.getGirlFriend();
        GirlFriend g2 = GirlFriend.getGirlFriend();
        System.out.println(g1 == g2);
    }
}
// 懒汉式实现单例模式
class GirlFriend{
    // 1. 类的构造器私有化
    private GirlFriend(){}
    // 2. 声明当前类的实例
    // 4. 当前实例也必须是static
    private static GirlFriend instance = null;
    // 3. 通过getXxx()方法获取当前实例，如果当前实例是null，则在方法内进行创建
    public static GirlFriend getGirlFriend(){
        if(instance == null){
            instance = new GirlFriend();
        }
        return instance;
    }
}
