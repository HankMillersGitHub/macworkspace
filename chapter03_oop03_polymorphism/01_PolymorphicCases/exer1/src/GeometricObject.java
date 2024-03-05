/**
 * @program: macWorkSpace
 * @ClassName GeometricObject
 * @description:
 * @author: HankMiller
 * @create: 2024-03-03 17:23
 * @Version 1.0
 **/
public class GeometricObject {
    protected String color;
    protected double weight;

    protected GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // 求几何图形的面积
    public double findArea(){
        return 0.0;
    }
}
