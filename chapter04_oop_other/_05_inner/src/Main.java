public class Main {
    public static void main(String[] args) {
        // 提供一个继承与Object类的匿名子类的匿名对象
        new Object(){
            public void test(){
                System.out.println("Hank Miller");
            }
        }.test();
    }
}
