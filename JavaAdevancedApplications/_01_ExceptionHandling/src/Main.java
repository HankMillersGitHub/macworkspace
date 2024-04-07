import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        try{
            File f = new File("abc.java");
            // Unhandled exception: java.io.FileNotFoundException
            FileInputStream fis = new FileInputStream(f);
            // Unhandled exception: java.io.IOException
            int data = fis.read();
            while(data != -1){
                System.out.println((char)data);
                // Unhandled exception: java.io.IOException
                data = fis.read();
            }
            // Unhandled exception: java.io.IOException
            fis.close();
        }catch (IOException e){
            System.out.println("there is IOException");
        }
        System.out.println("exception has been handle");
        */
        /*
         运行时异常开始
        *   ​			|----- ArrayIndexOutOfBoundsException
        *                   int[] a = new int[1];
                            a[1] = 10;

            ​			|----- NullPointerException
                            String str = null;
                            System.out.println(str.length());

            ​			|----- ClassCastException
        *                   Object obj = 10;
                            String i = (String)obj;  // 抛出异常
                            Integer i1 = (Integer)obj;
                            Boolean b = (Boolean)obj; // 抛出异常

            ​			|----- NumberFormatException
        *                   String str = "hello";ß
                            Integer i = Integer.parseInt(str);
                            Double d = Double.parseDouble(str);

            ​			|----- InputMismatchException
        *                   Scanner scan = new Scanner(System.in);
                            System.out.println("输入整数");
                            int a = scan.nextInt();  // 输入其他类型的数据会报错

            ​			|----- ArithmeticException
        *                   int a = 0;
                            int b = 10;
                            System.out.println(b/a);
        *
        运行时异常结束
        * */
        /*
        * 编译时异常 begain
        *   ​			|-----ClassNotFoundException
        *                   // Unhandled exception: java.lang.ClassNotFoundException
                            Class a = Class.forName("java.lang.String");

            ​			|-----FileNotFoundException

            ​			|-----IOException
        *
                            File f = new File("abc.java");
                            // Unhandled exception: java.io.FileNotFoundException
                            FileInputStream fis = new FileInputStream(f);
                            // Unhandled exception: java.io.IOException
                            int data = fis.read();
                            while(data != -1){
                                System.out.println((char)data);
                                // Unhandled exception: java.io.IOException
                                data = fis.read();
                            }
                            // Unhandled exception: java.io.IOException
                            fis.close();
        *   编译时异常 end
        * */
        methdo3();
    }
    @Test
    public void test(){
        try{
            method1();
        }catch(IOException e){
            e.fillInStackTrace();
        }
    }
    public static void methdo3(){
        try{
            method1();
        }catch(IOException e){
            e.fillInStackTrace();
        }
    }
    public static void method1() throws IOException{
        File f = new File("abc.java");
        // Unhandled exception: java.io.FileNotFoundException
        FileInputStream fis = new FileInputStream(f);
        // Unhandled exception: java.io.IOException
        int data = fis.read();
        while(data != -1){
            System.out.println((char)data);
            // Unhandled exception: java.io.IOException
            data = fis.read();
        }
        // Unhandled exception: java.io.IOException
        fis.close();
    }
}
