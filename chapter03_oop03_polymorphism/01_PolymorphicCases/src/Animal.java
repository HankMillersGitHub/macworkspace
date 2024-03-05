/**
 * @program: macWorkSpace
 * @ClassName Animal
 * @description: 多态的使用场景
 * @author: HankMiller
 * @create: 2024-03-03 15:34
 * @Version 1.0
 **/
public class Animal {
    public static void func(Ani ani){
        ani.eat();
        ani.jump();
    }
    public static void main(String[] args){
        Dog dog = new Dog();
        Animal.func(dog);
        Animal.func(new Cat());
    }
}
class Ani{
    public void eat(){
        System.out.println("animal eat food!");
    }
    public void jump(){
        System.out.println("animal jump!");
    }
}
class Dog extends Ani{
    public void eat(){
        System.out.println("dog eat shit!");
    }
    public void jump(){
        System.out.println("dog jump!");
    }
    public void speak() {
        System.out.println("dog wolf wolf");
    }
}
class Cat extends Ani{
    public void eat(){
        System.out.println("Cat eat fish!");
    }
    public void jump(){
        System.out.println("Cat jump!");
    }
}