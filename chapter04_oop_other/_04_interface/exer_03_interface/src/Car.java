/**
 * @program: macWorkSpace
 * @ClassName Car
 * @description:
 * @author: HankMiller
 * @create: 2024-03-25 09:55
 * @Version 1.0
 **/
public class Car extends Vehicle implements IPower{
    private String carNumber;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("油车品牌是：" + getBrand() + ",颜色是：" + getColor() + ",车牌号是：" + getCarNumber());
        power();
    }
    /**
     * Car类的全参构造函数
     * @param brand 品牌
     * @param color 颜色
     * @param carNumber 车牌号
     * @author HankMiller
     * @Description 用来创建Car类的实例对象
     * @data 2024/03/25 10:13
     **/
    public Car(String brand, String color, String carNumber) {

        super(brand, color);
        this.carNumber = carNumber;
    }

    @Override
    public void power() {
        System.out.println("需要加油");
    }
}
