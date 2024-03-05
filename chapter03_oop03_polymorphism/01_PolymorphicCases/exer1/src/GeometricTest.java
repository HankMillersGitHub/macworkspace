public class GeometricTest {
    public static void main(String[] args) {

        Circle c = new Circle("red",2.2,5.3);
        MyRectangle rectangle = new MyRectangle("red",2.3,4,5);
        System.out.println(c.findArea());
        System.out.println(rectangle.findArea());
        System.out.println(equalsArea(c,rectangle));
        displayGeometricObject(c);
        displayGeometricObject(rectangle);

    }
/**
 * 测试两个对象的面积是否相等 参数类型为GeometircTest;
 * @author HankMiller
 * @Description // TODO
 * @data 2024/03/03 17:49
 **/
    public static boolean equalsArea(GeometricObject g1, GeometricObject g2) {
        return g1.findArea() == g2.findArea();

    }
    public static void displayGeometricObject(GeometricObject g){
        System.out.println(g.findArea());
    }
}