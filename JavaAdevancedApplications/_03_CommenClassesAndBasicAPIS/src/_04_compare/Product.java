package _04_compare;

// 商品类
public class Product implements Comparable {
    private String name;
    private int price;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /*
     * 当前类需要实现Comparable中的抽象方法
     * 在此方法中指明如何判断当前累的对象的大小
     * */
    @Override
    public int compareTo(Object o) {
        if (o == this) {
            return 0;
        }
        if (o instanceof Product) {
            Product p = (Product) o;
            return Integer.compare(this.price, p.price);
        }
        throw new RuntimeException("数据不匹配");
    }
}
