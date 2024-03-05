/**
 * @program: macWorkSpace
 * @ClassName Circle
 * @description:
 * @author: HankMiller
 * @create: 2024-03-03 17:23
 * @Version 1.0
 **/
public class Circle extends GeometricObject{
    private double radius;
    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return radius * radius * 3.1415;
    }
}
