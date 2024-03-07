import javax.crypto.Cipher;

public class Main {
    public static void main(String[] args) {
       Circle c1 = new Circle(10);
       Circle c2 = new Circle(11);
       Circle c3 = new Circle(10);
        System.out.println(c1.equals(c2));
        System.out.println(c3.toString());

    }
}
class GeometricObject{
    protected String color;
    protected double weight;

    protected GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public GeometricObject() {
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
}
class Circle extends GeometricObject{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

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
    public double findArea(){
        return radius * radius * 3.14;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public String toString() {
        return "circle{" +
                "radius=" + radius +
                '}';
    }
}