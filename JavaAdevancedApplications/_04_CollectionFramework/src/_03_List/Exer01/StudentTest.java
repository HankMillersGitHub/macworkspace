package _03_List.Exer01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Collection collection = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请录入学生信息");
            System.out.println("1:继续录入，0:结束录入");
            if(scanner.nextInt() == 1){
                System.out.println("请输入学生姓名：");
                String name = scanner.next();
                System.out.println("请输入学生年龄：");
                int age = scanner.nextInt();
                collection.add(new Student(name,age));
            }else{
                System.out.println("遍历学生信息");
                for (Object obj : collection){
                    System.out.println(obj);
                }
                break;
            }
        }
    }
}
