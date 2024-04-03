public class WrapperMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // String -> 包装类、基本数据类型
        // 基本数据类型
            String str1 = "123";
            int a = Integer.parseInt(str1);
        // 包装类
            String str2 = "123";
            Integer b = Integer.parseInt(str2);
        // 包装类、基本数据类型 -> String
        // 基本数据类型
            int i1 = 123;
            String str3 = String.valueOf(i1);
        // 包装类
            Integer i2 = 123;
            String str4 = String.valueOf(i2);
    }
}