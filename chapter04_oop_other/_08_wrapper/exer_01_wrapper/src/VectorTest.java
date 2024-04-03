import java.util.Vector;
import java.util.Scanner;

public class VectorTest {
    public static void main(String[] args) {
        // 1. 创建Vector对象，Vector v = new Vector();
        Vector v = new Vector();
        // 2. 从键盘获取多个学生，存放到v中，负数代表输入结束
        Scanner scan = new Scanner(System.in);
        // 记录最高分
        int max_score = 0;

        while (true) {
            System.out.print("please input score of students(minus means end):");
            int intScore = scan.nextInt();
            if(intScore < 0){
                System.out.println("end of input");
                break;
            }
            // 将整型成绩包装为Integer类型
            Integer score = intScore;
            // 3. 获取学生成绩的最大值
            // 顺便更新最高分
            if(score > max_score){
                max_score = score;
            }

            // 添加学生成绩到v中
            v.addElement(score);
        }


        // 4. 依次获取v中的每个学生成绩，与最高分进行比较，获取学生等级，并输出
        for (int i = 0; i < v.size(); i++) {
            // 拆箱
            Object obj = v.elementAt(i);
//            Integer intnteger = (Integer) obj;
//            int score = integer;
            int score = (Integer)obj;
            // 记录成绩等级
            /*char grade;
            if(max_score - score < 10){
                grade = 'A';
            }else if(max_score - score <= 20){
                grade = 'B';
            }else if(max_score - score <= 30){
                grade = 'C';
            }else if(max_score - score <= 40){
                grade = 'D';
            }else if(max_score - score <= 50){
                grade = 'E';
            }*/
            // 精简代码 之后会有一点小问题
            char grade = (char) ('A' + Math.min(5, Math.floorDiv(max_score - score, 10)));
            // 打印成绩和等级
            System.out.println("student " + i + " score is " + score + " grade is " + grade);
        }
        scan.close();
    }
}
