package _04_compare.Comparator;

import _04_compare.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Product("iphone15ProMax",9999);
        products[1] = new Product("HuaWeiMate60Pro",8999);
        products[2] = new Product("XiaoMi21Pro",6999);
        products[3] = new Product("Samsung",7999);
        // 创建一个实现了Comparator接口的实现类的对象
        Comparator comparator = new Comparator() {
            // 如何判断两个对象的大小，其标准就是此方法的方法体要编辑的逻辑
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Product && o2 instanceof Product){
                    Product c1 = (Product) o1;
                    Product c2 = (Product) o2;
                    return Integer.compare(c1.getPrice(),c2.getPrice());
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        Arrays.sort(products,comparator);
        for (Product product : products){
            System.out.println(product);
        }
    }
}