/**
 * @program: macWorkSpace
 * @ClassName InterfaceTest
 * @description:
 * @author: HankMiller
 * @create: 2024-03-25 08:53
 * @Version 1.0
 **/
public class InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle();
        ComparableCircle c2 = new ComparableCircle();
        c1.setRadius(10);
        c2.setRadius(10);
        System.out.println(c1.compareTo(c2));
    }

}
interface CompareObject{
    int compareTo(Object o);
}
class Circle{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
class ComparableCircle extends Circle implements CompareObject{

    public ComparableCircle(int radius) {
        super(radius);
    }

    public ComparableCircle() {
    }
    // 根据对象半径的大小比较对象的大小
    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if (o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle)o;
            /*// 错误的写法
//            return this.getRadius() - c.getRadius();
            // 正确的写法1：
            *//*if(this.getRadius() > c.getRadius()){
                return 1;
            }else if(this.getRadius() < c.getRadius()){
                return -1;
            }else{
                return 0;
            }*/
            // 正确的写法2：
            return Integer.compare(c.getRadius(),this.getRadius());
        }else{
            throw new RuntimeException("error");
        }
    }
}