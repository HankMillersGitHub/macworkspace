/**
 * @program: macWorkSpace
 * @ClassName ElectricVehicle
 * @description:
 * @author: HankMiller
 * @create: 2024-03-25 09:57
 * @Version 1.0
 **/
public class ElectricVehicle extends Vehicle implements IPower{

    @Override
    public void power() {
        System.out.println("需要充电");
    }

    @Override
    public void run() {
        System.out.println("电动车品牌是：" + getBrand() + ",颜色是：" + getColor());
        power();
    }

    public ElectricVehicle(String brand, String color) {
        super(brand, color);
    }
}
