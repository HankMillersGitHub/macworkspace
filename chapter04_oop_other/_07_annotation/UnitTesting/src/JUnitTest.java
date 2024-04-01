import org.junit.Test;

import java.util.Scanner;

public class JUnitTest { // 单元测试类
    public static void main(String[] args) {
        System.out.println(1);
    }
    @Test
    public void test1(){ // 单元测试方法
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("this is test2");
        test1();
    }
    @Test
    public void test3(){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println(a);
    }
    @Test
    public void test4(){
        System.out.println("this is unit testing");
    }
}