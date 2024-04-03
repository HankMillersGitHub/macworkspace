
public class Main {
    public static void main(String[] args) {
        // 自动装箱底层会调用valueOf()
        Integer i = 1;
        Integer j = 1;
        System.out.println(i == j); // ture

        Integer m = 127;
        Integer n = 127;
        System.out.println(m == n); // false
    }
}