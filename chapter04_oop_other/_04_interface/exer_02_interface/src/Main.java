public class Main {
    public static void main(String[] args) {
        Eatable[] eatables = new Eatable[]{new American(), new Chinese(), new Indian()}; // 多态性
        for (Eatable eatable : eatables) {
            eatable.eat();
        }
    }
}
interface Eatable{
    void eat();
}
class Chinese implements Eatable{
    @Override
    public void eat() {
        System.out.println("Eating with chopsticks");
    }
}
class American implements Eatable{
    @Override
    public void eat() {
        System.out.println("Eating with knives and forks");
    }
}
class Indian implements Eatable{
    @Override
    public void eat() {
        System.out.println("Eating hand grabbed rice");
    }
}