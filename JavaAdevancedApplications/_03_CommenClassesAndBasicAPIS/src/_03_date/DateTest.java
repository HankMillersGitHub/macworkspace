package _03_date;

import sun.util.BuddhistCalendar;

import java.awt.dnd.DropTarget;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {
    public static void main(String[] args) {
    // 练习1：将java.util.Date转化为java.sql.Date
    /*    java.util.Date date = new java.util.Date();
        System.out.println(date.getTime());
        Date target = new Date(date.getTime());
        System.out.println(target);*/
    // 练习2: 将控制台获取的年月日2024-10-12的字符串数字保存在数据库中，
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("请输入时间：");
        String getTime = scanner.next();
        // 创建SimpleDateFormat的实例用于之后格式化字符串为日期 接受的日期格式为yyyy-MM-dd
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = simpleDateFormat.parse(getTime);   // 将格式化后的日期
            java.util.Date date = new java.util.Date(d.getTime());
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }*/
    }
}
