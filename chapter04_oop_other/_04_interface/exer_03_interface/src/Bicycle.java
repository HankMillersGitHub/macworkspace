/**
 * @program: macWorkSpace
 * @ClassName Bicycle
 * @description:
 * @author: HankMiller
 * @create: 2024-03-25 09:54
 * @Version 1.0
 **/
public class Bicycle extends Vehicle{
    public Bicycle(String brand,String color) {
        super(brand,color);
    }

    @Override
    public void run() {
        System.out.println("自行车品牌是：" + getBrand() + ",颜色是：" + getColor());
    }
}
