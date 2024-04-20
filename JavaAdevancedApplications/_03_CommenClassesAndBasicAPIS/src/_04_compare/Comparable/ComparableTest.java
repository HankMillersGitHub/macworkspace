package _04_compare.Comparable;

import _04_compare.Product;

import java.util.Arrays;

public class ComparableTest {
    public static void main(String[] args) {
        String[] strs = new String[]{"Hank","Jack","Lili","Lucy"};
        Product p1 = new Product("炼狱狂蛇",799);
        Product p2 = new Product("北海巨妖",399);
        Product p3 = new Product("黑曼巴",299);
        Product p4 = new Product("proclick",1299);
        Product[] products = new Product[]{p1,p2,p3,p4};
        Arrays.sort(products);
        for (Product product : products) {
            System.out.println(product);

        }
    }
}
