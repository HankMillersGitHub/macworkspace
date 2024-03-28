import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Flyable a = new Plane();
    }
}
interface Flyable{
    // 全局常量 public static final
    int MIN_SPEED = 0;
    // 可以省略 public static final
    double MAX_SPEED = 7.9;
    // 方法 可以省略 pubic abstract
    void fly();
}
interface Attackable{
    void attack();
}

class Plane implements Flyable{
    int min_speed = 0;
    double max_speed = 5;
    public void canIFly(){
        if(min_speed >= MIN_SPEED && max_speed <= MAX_SPEED){
            fly();
        }else{
            System.out.println("i can't fly");
        }
    }
    @Override
    public void fly() {
        System.out.println("i am a plane ,i can fly");
    }
}
class Bullet implements Flyable,Attackable{
    @Override
    public void fly() {
        System.out.println("i am a buttlet , i can fly");
    }

    @Override
    public void attack() {
        System.out.println("i am a buttlet , i have Attackable");
    }
}
class Kite implements Flyable{
    @Override
    public void fly() {
        System.out.println("i am a kite ,i can fly");
    }
}
class FireBalloon implements Flyable{
    @Override
    public void fly() {
        System.out.println("i am fireBalloon , i can fly");
    }
}